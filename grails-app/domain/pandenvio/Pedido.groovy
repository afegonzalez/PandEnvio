package pandenvio

class Pedido {

    Date fecha;
    CuponDescuento cuponDeDescuento;
    Cliente cliente;
    List<Producto> productos;


    void agregar(Producto producto){
        productos.Add(producto);
    }
}
