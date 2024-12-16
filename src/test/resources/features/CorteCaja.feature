# language: es

@caja
Característica: Corte de caja


  @corteCaja
  Esquema del escenario: Realizar corte de turno
    Dado que uso el atajo de teclas "ALT" + "X"
    Y escribo las credenciales de MF "<usuarioMF>" "<passwordMF>"
    Y doy click en aceptar en la ventana
    Y doy click en procesar
    Y escribo las credenciales de RF "<usuarioRF>" "<passwordRF>"
    Y doy click en aceptar la autorizacion
    Y doy click en aceptar en la notificacion
    Y se muestra el login

    Ejemplos:
      | usuarioRF | passwordRF | usuarioMF | passwordMF | 
      | 00030120 | ZZ*12345 | 00002641 | ZZ*12345 | 


