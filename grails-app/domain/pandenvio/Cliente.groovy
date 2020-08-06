package pandenvio

class Cliente {
    String nombre;
    String apellido;
    String mail;
    Ubicacion ubicacion;
    Telefono telefono;

    String nombreCompleto() {
        return nombre + " " + apellido
    }
}
