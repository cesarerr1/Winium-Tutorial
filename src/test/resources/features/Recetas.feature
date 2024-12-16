# language: es

@Recetas
Característica: Recetas

  @agregarDoctor
  Esquema del escenario: : Registrar cirujano
    Dado que doy click en recetas
    Y doy click en "Agregar/Editar Doctor"
    Y escribo la cedula "<cedula>"
    Y elijo "<ocupacion>"
    Y escribo "<nombre>" "<apellidoPaterno>" "<apellidoMaterno>"
    Y escribo los moviles "<movil1>" "<movil2>"
    Y registro "<registro>"
    Y sin comentarios
    Y escribo la "<direccion>" "<colonia>" "<ciudad>" "<estado>" "<codigoPostal>" "<telefono>"
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"
    Y cierro la ventana de Captura de Receta Médica
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"

    Ejemplos:
      | cedula | ocupacion | nombre | apellidoPaterno | apellidoMaterno | movil1 | movil2 | registro | direccion | colonia | ciudad | estado | codigoPostal | telefono | 
      | 2516793485 | Cirujano | Alfredo | Vazquez | Dominguez | 33459862 | 23957856 | 5648 | principal #20 | El Olmo | xalapa | veracruz | 91194 | 2285783564 | 
