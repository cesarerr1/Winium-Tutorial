# language: es

@producto
Característica: Productos
  
  
  @demandaArticulos
  Escenario: Demanda de articulos
    Dado que uso el atajo de teclas "ALT" + "N"
    Y doy click en filtrar por "SKU"
    Y escribo el sku "7501834000103"
    Y doy click en aceptar demanda
    Y se muestra el stock del producto
    

  @venta
  Escenario: Realizar una venta
    Dado que busco el producto "7501834000103"
    Y doy click en cancelar monedero
    Y presiono "F10"
    Y doy click en cancelar informacion del medico
    Y cancelar donativo
    Y escribo "50" de efectivo
    Y presiono "F11" para procesar el pago
    Y se muestran los detalles de la venta


  @ventaMetodoPagoMixto
  Escenario: Relizar una venta por dos metodos de pago
    Dado que busco el producto "026169050830"
    Y doy click en cancelar monedero
    Y presiono "F10"
    Y doy click en cancelar informacion del medico
    Y cancelar donativo
    Y escribo "50" de efectivo
    Y presiono "Q" para pagar por vales
    Y escribo "52" de pago en vales
    Y selecciono "EFECTIVALE", escribo "EFECTIVAL" y "12345"
    Y presiono "F11" para procesar el pago
    Y se muestran los detalles de la venta
