package pandenvio

class CuponDescuentoPorcentual extends CuponDescuento {

    BigDecimal porcentaje

    @Override
    BigDecimal aplicarDescuento(BigDecimal precio) {
        return precio * (1-porcentaje)
    }
}
