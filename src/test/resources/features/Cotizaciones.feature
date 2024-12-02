# language: es

@cotizaciones
Característica: Cotizaciones


  @registrarCotizacion
  Escenario: Registrar una cotización
    Dado que uso el atajo de teclas "ALT" + "C"
    Y escribo las credenciales de RF "00030120" "ZZ*12345"
    Y doy click en aceptar autorización
    Y doy click en cancelar monedero
    Y escribo el SKU "7501834000035" del producto
    Y escribo el cliente prospecto "Alfredo"
    Y presiono la tecla "F10"
    Y doy click en aceptar confirmación
    Y doy click en cancelar impresión

    

