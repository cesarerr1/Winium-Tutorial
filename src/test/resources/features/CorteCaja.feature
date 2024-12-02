# language: es

@caja
Característica: Corte de caja


  @corteCaja
  Escenario: Realizar corte de turno
    Dado que uso el atajo de teclas "ALT" + "X"
    Y escribo las credenciales de MF "00002641" "ZZ*12345"
    Y doy click en aceptar en la ventana
    Y doy click en procesar
    Y escribo las credenciales de RF "00030120" "ZZ*12345"
    Y doy click en aceptar la autorizacion
    Y doy click en aceptar en la notificacion
    Y se muestra el login
