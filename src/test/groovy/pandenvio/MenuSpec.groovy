package pandenvio

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MenuSpec extends Specification implements DomainUnitTest<Menu> {

    Menu menu = new Menu(nombre: 'Viernes', precio: 300)

    void "test Menu admite un cupon de descuento Nulo "() {
        when:
            boolean admite = menu.admiteA(new CuponDescuentoNulo())
        then:
            admite
    }


    void "test Menu No admite un cupon de descuento Porcentual "() {
        when:
            boolean admite = menu.admiteA(new CuponDescuentoPorcentual(porcentaje: 10))
        then:
         !admite
    }


    void "test Menu deberia tener precio fijo "() {
        when:
        BigDecimal precio = menu.getPrecio()
        then:
        precio == 300
    }

    void "test Menu tiene 2 platos, precio deberia seguir  fijo "() {
        when:
            Menu menuConPLatos = new Menu(nombre: 'Viernes', precio: 400)
            menuConPLatos.addToProductos(new Plato(nombre:'Milanesa con pure', precio: 350, categoria: CategoriaPlato.PLATO))
            menuConPLatos.addToProductos(new Plato(nombre:'Flan Mixto con pure', precio: 150, categoria: CategoriaPlato.POSTRE))
            BigDecimal precio = menuConPLatos.getPrecio()
        then:
            precio == 400
    }
}
