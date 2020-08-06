package pandenvio

interface Producto {
    BigDecimal getPrecio()
    boolean admiteA(CuponDescuento descuento)
    boolean admiteA(CuponDescuentoNulo descuento)
    boolean admiteA(CuponDescuentoPorcentual descuento)
}
