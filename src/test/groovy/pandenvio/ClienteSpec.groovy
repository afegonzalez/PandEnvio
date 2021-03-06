package pandenvio

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification

class ClienteSpec extends Specification implements DomainUnitTest<Cliente> {

    @Shared int id

    void "test basic persistence mocking"() {
        setup:
            new Cliente(nombre: 'Pepe', apellido:'Argento', mail: 'pepe.argento@gmail.com', ubicacion: new Ubicacion(), telefono: new Telefono()).save()
            new Cliente(nombre: 'Moni', apellido: 'Argento',  mail: 'moni.argento@gmail.com', ubicacion: new Ubicacion(), telefono: new Telefono()).save()
        expect:
            Cliente.count() == 2
    }

    void "test domain instance"() {
        setup:
            id = System.identityHashCode(domain)

        expect:
            domain != null
            domain.hashCode() == id

        when:
            domain.nombre = 'Robert'

        then:
            domain.nombre == 'Robert'
    }

    void "test we get a new domain"() {
        expect:
            domain != null
            domain.nombre == null
            System.identityHashCode(domain) != id
    }

    void "test nombre completo del cliente"() {
        when:
            Cliente pepeArgento = new Cliente(nombre: 'Pepe', apellido: 'Argento')
            String nombreCompleto = pepeArgento.nombreCompleto()
        then:
            nombreCompleto.equals("Pepe Argento")
    }
}
