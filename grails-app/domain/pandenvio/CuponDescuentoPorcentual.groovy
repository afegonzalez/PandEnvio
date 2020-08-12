package pandenvio

class CuponDescuentoPorcentual extends CuponDescuento {

    //TODO add constraints to  only allow 0 < porcentaje < 100
    BigDecimal porcentaje

    @Override
    BigDecimal aplicarDescuento(BigDecimal precio) throws CuponYaUtilizadoException {
        if (!this.activo){
            throw new CuponYaUtilizadoException()
        }
        this.activo = false;
        return precio * (1-(porcentaje/100))
    }
}
