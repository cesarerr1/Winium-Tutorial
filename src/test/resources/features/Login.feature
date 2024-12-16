# language: es

@Inicio
Característica: Login


  @login
  Esquema del escenario: Aperturar turno
    Dado que me encuentro en la aplicación FarMax
    Y escribo las credenciales del perfil MF "<usuarioMF>" "<passwordMF>"
    Y doy click en "Aceptar"
    Y se muestran los detalles de la caja
    Y doy click en "Continuar"
    Y te atiende "<nombreRF>"



    Ejemplos:
      | nombreRF | usuarioMF | passwordMF | 
      | MARIA MARTINA | 00002641 | ZZ*12345 | 
