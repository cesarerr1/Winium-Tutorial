# language: es

@cotizaciones
Característica: Cotizaciones


  @registrarCotizacion
  Esquema del escenario: Registrar una cotización
    Dado que uso el atajo de teclas "ALT" + "C"
    Y escribo las credenciales de RF "<usuarioRF>" "<passwordRF>"
    Y doy click en "Aceptar"
    Y doy click en cancelar monedero
    Y escribo el SKU "<SKU>" del producto
    Y se muestra el producto "<producto>"
    Y escribo el cliente prospecto "Alfredo"
    Y presiono la tecla "F10"
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"
    Y doy click en "Cancelar"

    Ejemplos:
      | SKU | producto | usuarioRF | passwordRF | 
      | 7501834000103 | ESTROPAJO NAT C/TOALLA Y ESPONJA RED BSA 0103 | 00030120 | ZZ*12345 | 
