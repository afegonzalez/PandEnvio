package pandenvio

abstract class CuponDescuento {
    Date fecha;
    Boolean activo;
    String codigo;

    abstract BigDecimal aplicarDescuento(BigDecimal precio)

    void permitirEn(Producto producto) {
        producto.admiteA(this)
    }
}
