import os
import re

DIRECTORIO_FEATURES = "src/test/resources/features"
DIRECTORIO_RUNNERS = "src/test/java/runner"
ARCHIVO_TEST_RUNNER = os.path.join(DIRECTORIO_RUNNERS, "TestRunner.java")

def crear_directorio(path):
    if not os.path.exists(path):
        os.makedirs(path)
        print(f"Directorio {path} creado.")
    else:
        print(f"El directorio {path} ya existe.")

def crear_runner(archivo_feature):
    nombre_feature = os.path.splitext(archivo_feature)[0]
    nombre_runner = nombre_feature + "Runner"
    archivo_runner = os.path.join(DIRECTORIO_RUNNERS, nombre_runner + ".java")
    print(f"Generando Runner para: {nombre_runner}")
    contenido_runner = f"""
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/{archivo_feature}",
    glue = {{"steps"}},
    monochrome = true,
    plugin = {{"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}},
    tags = ""
)
public class {nombre_runner} extends AllureJunit4 {{
}}
"""

    with open(archivo_runner, 'w') as f:
        f.write(contenido_runner.strip())

    print(f"Archivo {nombre_runner}.java sobrescrito con éxito.")


def crear_test_runner():
    print("Generando TestRunner.java...")

    runners = [
        f"{os.path.splitext(f)[0]}"  # Solo obtenemos el nombre base sin ".java"
        for f in os.listdir(DIRECTORIO_RUNNERS)
        if f.endswith("Runner.java") and f != "TestRunner.java"  # Excluir TestRunner.java
    ]

    print("Clases generadas: ")
    for i, runner in enumerate(runners, 1):
        print(f"{i}. {runner}")

    while True:
        print("\033c", end="")
        print("Clases generadas: ")
        for i, runner in enumerate(runners, 1):
            print(f"{i}. {runner}")

        orden_input = input("¿Quieres ingresar un orden específico para las clases? (s/n): ").strip().lower()
        if orden_input == "s":
            print("Ingresa los números de las clases en el orden deseado, separados por comas, puedes omitir los que desees (ej. 1, 3, 2):")
            orden = input().strip()
            if orden:
                try:
                    indices_orden = list(map(int, orden.split(",")))
                    runners_ordenados = [runners[i-1] for i in indices_orden]
                    break
                except ValueError:
                    print("Entrada no válida. Por favor, ingresa los números correctamente.")
            else:
                runners_ordenados = runners
                break
        elif orden_input == "n":
            runners_ordenados = runners
            break
        else:
            print("Opción inválida. Por favor, ingresa 's' para sí o 'n' para no.")

    clases_runners = ', '.join([f"{runner}.class" for runner in runners_ordenados])

    contenido_test_runner = f"""
package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({{
    {clases_runners}
}})
public class TestRunner {{

}}
"""
    with open(ARCHIVO_TEST_RUNNER, 'w') as f:
        f.write(contenido_test_runner.strip())

    print("TestRunner.java sobrescrito con éxito.")

def obtener_archivo_feature_para_runner(clase_runner):
    archivo_feature = clase_runner.replace("Runner", "") + ".feature"
    ruta_feature = os.path.join(DIRECTORIO_FEATURES, archivo_feature)

    if os.path.exists(ruta_feature):
        return ruta_feature
    else:
        return None

def extraer_tags_de_feature(archivo_feature):
    tags = []

    with open(archivo_feature, 'r', encoding='utf-8') as f:
        contenido = f.read()

        tags_encontrados = re.findall(r'@(\w+)', contenido)

        for i, tag in enumerate(tags_encontrados):
            if tag.lower() not in ["inicio", "feature"]:
                if i != 0:
                    tags.append(tag)

    return tags

def obtener_tags_para_test_runner():
    todos_los_tags = {}

    if os.path.exists(ARCHIVO_TEST_RUNNER):
        with open(ARCHIVO_TEST_RUNNER, 'r', encoding='utf-8') as f:
            contenido = f.read()

        runners = re.findall(r'(\w+Runner)\.class', contenido)

        for runner in runners:
            archivo_feature = obtener_archivo_feature_para_runner(runner)
            if archivo_feature:
                tags = extraer_tags_de_feature(archivo_feature)
                todos_los_tags[runner] = tags

    return todos_los_tags

# Función para permitir la selección de tags a ejecutar
def seleccionar_tags_a_ejecutar(tags, clase_runner):
    print("\033c", end="")
    print(f"Tag de {clase_runner}")
    print("¿Qué escenario deseas ejecutar?")
    print()
    for i, tag in enumerate(tags, 1):
        print(f"{i}.- {tag}")
    print()
    entrada_tags_seleccionados = input("Ingresa los números de los tags(escenarios) a ejecutar, separados por comas (ej. 1, 2): ").strip()

    if entrada_tags_seleccionados:
        indices_tags_seleccionados = list(map(int, entrada_tags_seleccionados.split(',')))
        tags_seleccionados = [tags[i-1] for i in indices_tags_seleccionados]

        # Generamos la parte de tags para excluir los no seleccionados
        excluir_tags = [f"not @{tag}" for tag in tags if tag not in tags_seleccionados]
        expresion_tags = " and ".join(excluir_tags)

        return expresion_tags
    else:
        return ""

# Función principal para recorrer los archivos .feature y generar los runners
def generar_runners():
    crear_directorio(DIRECTORIO_RUNNERS)
    for archivo_feature in os.listdir(DIRECTORIO_FEATURES):
        if archivo_feature.endswith(".feature"):
            crear_runner(archivo_feature)

    crear_test_runner()

    tags_runners = obtener_tags_para_test_runner()

    for clase_runner, tags in tags_runners.items():
        if len(tags) > 1:
            # Solo si tiene más de un tag, preguntar al usuario qué ejecutar
            expresion_tags = seleccionar_tags_a_ejecutar(tags, clase_runner)

            archivo_feature = obtener_archivo_feature_para_runner(clase_runner)
            if archivo_feature:
                nombre_runner = os.path.splitext(os.path.basename(archivo_feature))[0] + "Runner"
                archivo_runner = os.path.join(DIRECTORIO_RUNNERS, nombre_runner + ".java")
                with open(archivo_runner, 'r', encoding='utf-8') as f:
                    contenido_runner = f.read()

                if expresion_tags:
                    contenido_runner = contenido_runner.replace(
                        'tags = ""',
                        f'tags = "{expresion_tags}"'
                    )

                with open(archivo_runner, 'w', encoding='utf-8') as f:
                    f.write(contenido_runner)
    print()
    print("Runners generados con éxito.")

if __name__ == "__main__":
    generar_runners()
