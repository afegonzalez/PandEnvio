package pandenvio

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MenuSpec extends Specification implements DomainUnitTest<Menu> {

    void "test Menu admite un cupon de descuento Nulo "() {
        when:
            Menu menu = new Menu(nombre: 'Viernes', precio: 300)
            boolean admite = menu.admiteA(new CuponDescuentoNulo())
        expect:
        admite
    }
}
