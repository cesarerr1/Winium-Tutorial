package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActualizarFeature {

    public static void actualizarFeatureConCSV(String rutaCSV, String rutaFeature) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(rutaCSV), StandardCharsets.UTF_8))) {
            List<String[]> datosCSV = csvReader.readAll();

            if (datosCSV.isEmpty()) {
                throw new IllegalArgumentException("El archivo CSV está vacío.");
            }
            String[] headers = datosCSV.get(0);
            List<String> lineasFeature = Files.readAllLines(Paths.get(rutaFeature), StandardCharsets.UTF_8);
            StringBuilder nuevoContenido = new StringBuilder();
            boolean enExamples = false;

            for (int i = 0; i < lineasFeature.size(); i++) {
                String linea = lineasFeature.get(i);

                if (linea.trim().startsWith("Ejemplos:")) {
                    enExamples = true;
                    Set<String> columnasUsadas = obtenerColumnasUsadas(lineasFeature, i);
                    nuevoContenido.append(linea).append("\n");
                    nuevoContenido.append("      | ");
                    for (String header : headers) {
                        if (columnasUsadas.contains(header)) {
                            nuevoContenido.append(header).append(" | ");
                        }
                    }
                    nuevoContenido.append("\n");
                    for (int j = 1; j < datosCSV.size(); j++) {
                        String[] fila = datosCSV.get(j);
                        nuevoContenido.append("      | ");
                        for (int k = 0; k < headers.length; k++) {
                            if (columnasUsadas.contains(headers[k])) {
                                nuevoContenido.append(fila[k]).append(" | ");
                            }
                        }
                        nuevoContenido.append("\n");
                    }
                    while (i + 1 < lineasFeature.size() && lineasFeature.get(i + 1).trim().startsWith("|")) {
                        i++;
                    }

                } else {
                    nuevoContenido.append(linea).append("\n");
                    enExamples = false;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaFeature), StandardCharsets.UTF_8))) {
                writer.write(nuevoContenido.toString());
            }

            System.out.println("Archivo .feature actualizado con los datos del CSV: " + rutaFeature);
        }
    }

    private static Set<String> obtenerColumnasUsadas(List<String> lineasFeature, int indiceEjemplo) {
        Set<String> columnas = new HashSet<>();
        Pattern pattern = Pattern.compile("<(.*?)>");
        for (int i = indiceEjemplo - 1; i >= 0; i--) {
            String linea = lineasFeature.get(i);
            Matcher matcher = pattern.matcher(linea);
            while (matcher.find()) {
                columnas.add(matcher.group(1));
            }
            if (linea.trim().startsWith("Escenario") || linea.trim().startsWith("Esquema del escenario")) {
                break;
            }
        }

        return columnas;
    }


    public static void main(String[] args) {
        if (args.length % 2 != 0) {
            System.err.println("Uso: Actualizar Feature <rutaCSV> <rutaFeature> [<rutaCSV> <rutaFeature> ...]");
            System.exit(1);
        }

        for (int i = 0; i < args.length; i += 2) {
            String rutaCSV = args[i];
            String rutaFeature = args[i + 1];

            try {
                actualizarFeatureConCSV(rutaCSV, rutaFeature);
            } catch (IOException | CsvException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
