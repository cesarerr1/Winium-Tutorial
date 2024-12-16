package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncionesAuxiliares {

    private static Map<String,Integer> keyMap = createKeyMap();

    private static Map<String,Integer> createKeyMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("ALT", KeyEvent.VK_ALT);
        map.put("F4", KeyEvent.VK_F4);
        map.put("CTRL", KeyEvent.VK_CONTROL);
        map.put("SHIFT", KeyEvent.VK_SHIFT);
        map.put("F1", KeyEvent.VK_F1);
        map.put("V",KeyEvent.VK_V);
        map.put("C",KeyEvent.VK_C);
        map.put("X",KeyEvent.VK_X);
        map.put("ENTER",KeyEvent.VK_ENTER);
        map.put("TAB",KeyEvent.VK_TAB);
        map.put("F9",KeyEvent.VK_F9);
        map.put("F10",KeyEvent.VK_F10);
        map.put("F11",KeyEvent.VK_F11);
        map.put("E",KeyEvent.VK_E);
        map.put("ESC",KeyEvent.VK_ESCAPE);
        map.put("N",KeyEvent.VK_N);
        map.put("Q",KeyEvent.VK_Q);
        return map;

    }

    public void click(WiniumDriver driver,By locator,int  waitTime){
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            throw new TimeoutException("El elemento no se volvió clickeable en el tiempo especificado.");
        }
    }

    public boolean esperarElemento(WiniumDriver driver, By locator,int waitTime){
        boolean presente = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver,waitTime);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            presente = true;

        }catch(TimeoutException e){
            throw new TimeoutException("El elemento no esta presente en el tiempo especificado.");
        }
        return presente;
    }

    public void enviarDatos(WiniumDriver driver,By locator,String datos,int  waitTime){
        try{
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(datos);
        }catch (TimeoutException e){
            throw new TimeoutException("El elemento no esta presente en el tiempo especificado.");
        }
    }

    public void atajoTeclas(String... keys) {
        try {
            Robot robot = new Robot();
            for (String key : keys) {
                Integer keyCode = keyMap.get(key);
                if (keyCode != null) {
                    robot.keyPress(keyCode);
                }
            }
            for (String key : keys) {
                Integer keyCode = keyMap.get(key);
                if (keyCode != null) {
                    robot.keyRelease(keyCode);
                }
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirTexto(String texto) {
        try {
            Robot robot = new Robot();
            for (char c : texto.toCharArray()) {
                int keyCode = getKeyCodeForChar(c);
                if (keyCode != -1) {
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                }
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    private int getKeyCodeForChar(char c) {
        if (Character.isUpperCase(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        } else if (Character.isLowerCase(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        } else if (Character.isDigit(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        }
        return -1;
    }

    public float recuperarCaja() throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get("src/test/resources/data/Caja.txt")));
        String regex = "-?\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contenido);
        if (matcher.find()) {
            return Float.parseFloat(matcher.group());
        }
        throw new IllegalArgumentException("No se encontró ningún número flotante en el archivo.");
    }

    public void modificarCaja(Float caja) throws IOException {
        String contenidoNuevo = caja.toString();
        Files.write(Paths.get("src/test/resources/data/Caja.txt"), contenidoNuevo.getBytes());
    }

    public void actualizarCaja(String dinero) throws  IOException{
        Float caja = recuperarCaja();
        caja = caja + Float.parseFloat(dinero);
        String contenidoNuevo = caja.toString();
        Files.write(Paths.get("src/test/resources/data/Caja.txt"), contenidoNuevo.getBytes());
    }

    public void cerrarApp(){
        String nombreProceso = "PrimoPDF";
        boolean encontrado = true;

        while (true) {
            try {
                Thread.sleep(5000);
                Process proceso = Runtime.getRuntime().exec("tasklist");
                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;
                encontrado = false;
                while ((linea = reader.readLine()) != null) {
                    if (linea.contains(nombreProceso)) {
                        encontrado = true;
                        break;
                    }
                }
                proceso.waitFor();
                if (encontrado) {
                    System.out.println("El proceso '" + nombreProceso + "' está en ejecución.");
                    detenerApp();
                } else {
                    System.out.println("El proceso '" + nombreProceso + "' no se está ejecutando.");
                    break;
                }


            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void detenerApp() {
        try {
            String comando = "powershell Get-Process PrimoPDF | Stop-Process -Force";
            Process proceso = Runtime.getRuntime().exec(comando);
            proceso.waitFor();
            System.out.println("PrimoPDF cerrado exitosamente.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error al intentar cerrar PrimoPDF.");
        }
    }

}
