package pandenvio

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CuponDescuentoPorcentualSpec extends Specification implements DomainUnitTest<CuponDescuentoPorcentual> {

    void "test Cupon Descuento Porcentual activo aplica descuento porcentual correctamente y deja de estar activo"() {
        when:
            CuponDescuentoPorcentual cuponPorcentualActivo = new CuponDescuentoPorcentual(fecha: new Date(), activo: true, codigo: 'ABC', porcentaje: 10)
            BigDecimal precio = cuponPorcentualActivo.aplicarDescuento(100)
        then:
            precio == 90
            !cuponPorcentualActivo.estoyActivo()
    }


    void "test Cupon Descuento Porcentual NO activo intenta aplicar descuento porcentual y lanza excepcion"() {
        when:
            CuponDescuentoPorcentual cuponPorcentualActivo = new CuponDescuentoPorcentual(fecha: new Date(), activo: false, codigo: 'ABC', porcentaje: 15)
            cuponPorcentualActivo.aplicarDescuento(100)
        then:
            thrown CuponYaUtilizadoException
    }

}
