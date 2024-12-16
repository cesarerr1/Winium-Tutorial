# language: es

@producto
Característica: Productos


  @demandaArticulos
  Esquema del escenario: Demanda de articulos
    Dado que uso el atajo de teclas "ALT" + "N"
    Y doy click en filtrar por "SKU"
    Y escribo el sku "<SKU>"
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"
    Y se muestra el stock del producto

    Ejemplos:
      | SKU | 
      | 7501834000103 | 



  @venta
  Esquema del escenario: Realizar una venta
    Dado que busco el producto "<SKU>"
    Y doy click en cancelar monedero
    Y se muestra el producto "<producto>"
    Y presiono "F10"
    Y doy click en "Cancelar"
    Y cancelar donativo
    Y escribo "33" de efectivo
    Y presiono "F11" para procesar el pago
    Y se muestran los detalles de la venta

    Ejemplos:
      | SKU | producto | 
      | 7501834000103 | ESTROPAJO NAT C/TOALLA Y ESPONJA RED BSA 0103 | 



  @ventaMetodoPagoMixto
  Esquema del escenario: Relizar una venta por dos metodos de pago
    Dado que busco el producto "<SKU2>"
    Y doy click en cancelar monedero
    Y se muestra el producto "<producto2>"
    Y presiono "F10"
    Y doy click en "Cancelar"
    Y cancelar donativo
    Y escribo "50" de efectivo
    Y presiono "Q" para pagar por vales
    Y escribo "52" de pago en vales
    Y selecciono "EFECTIVALE", escribo "EFECTIVAL" y "12345"
    Y presiono "F11" para procesar el pago
    Y se muestran los detalles de la venta

    Ejemplos:
      | SKU2 | producto2 | 
      | 026169050830 | BOD MAN DARK ICE FRAGANCIA 236 ML 0830 | 


  @cancelarVenta
  Esquema del escenario: Cancelar una venta
    Dado que busco el producto "<SKU>"
    Y doy click en cancelar monedero
    Y se muestra el producto "<producto>"
    Y agrego el producto con SKU "<SKU2>"
    Y se muestra el producto "<producto2>"
    Y presiono "ESC"
    Y doy click en "Aceptar"
    Y escribo las credenciales de RF "<usuarioRF>" "<passwordRF>"
    Y selecciono el motivo "El cliente reclama precio alto"
    Y doy click en "Aceptar"
    Y doy click en "Aceptar"

    Ejemplos:
      | SKU | producto | SKU2 | producto2 | usuarioRF | passwordRF | 
      | 7501834000103 | ESTROPAJO NAT C/TOALLA Y ESPONJA RED BSA 0103 | 026169050830 | BOD MAN DARK ICE FRAGANCIA 236 ML 0830 | 00030120 | ZZ*12345 | 
      
