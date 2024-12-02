# language: es

@Recetas
Característica: Recetas

  @agregarDoctor
  Esquema del escenario: : Registrar cirujano
    Dado que doy click en recetas
    Y doy click en agregar o editar doctor
    Y escribo la cedula "03430867935345"
    Y elijo "Cirujano"
    Y escribo "Alfredo" "Vazquez" "Dominguez"
    Y escribo los moviles "33459862" "23957856"
    Y registro "5648"
    Y sin comentarios
    Y escribo la "<direccion>" "<calle>" "<ciudad>" "<estado>" "<codigoPostal>" "<telefono>"
    Y doy click en aceptar en la ventana de doctores

    Ejemplos:
      | direccion | calle | ciudad | estado | codigoPostal | telefono |
      |principal #20     |fresno |xalapa  |veracruz|91194         |228961462 |