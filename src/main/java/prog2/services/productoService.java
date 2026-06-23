package prog2.services;
import prog2.entities.categoria;
import prog2.entities.producto;
import prog2.exception.entidadNoEncontradaException;
import prog2.exception.stockInvalidoException;
import java.util.ArrayList;

public class productoService{

    private ArrayList<producto> productos;
    private Long contadorId;

    public productoService(){

        productos = new ArrayList<>();
        contadorId = 1L;

    }

    public void crear(String nombre,
                      Double precio,
                      String descripcion,
                      int stock,
                      String imagen,
                      boolean disponible,
                      categoria categoria)
            throws stockInvalidoException{

        if (precio < 0){
            throw new stockInvalidoException("Precio inválido");
        }

        if (stock < 0){
            throw new stockInvalidoException("Stock inválido");
        }

        producto producto = new producto(
                contadorId++,
                nombre,
                precio,
                descripcion,
                stock,
                imagen,
                disponible,
                categoria
        );

        productos.add(producto);

    }

    public ArrayList<producto> listar(){

        ArrayList<producto> lista = new ArrayList<>();

        for (producto producto : productos){

            if (!producto.isEliminado()){

                lista.add(producto);

            }

        }

        return lista;

    }

    public producto buscarPorId(Long id) throws entidadNoEncontradaException{

        for (producto producto : productos){

            if (producto.getId().equals(id) && !producto.isEliminado()){

                return producto;

            }

        }

        throw new entidadNoEncontradaException("Producto inexistente");

    }

    public void eliminar(Long id) throws entidadNoEncontradaException{

        producto producto = buscarPorId(id);
        producto.setEliminado(true);

    }
    
    public void editar(Long id,
                        String nombre,
                        Double precio,
                        String descripcion,
                        int stock,
                        String imagen,
                        boolean disponible,
                        categoria categoria)
            throws entidadNoEncontradaException,
            stockInvalidoException{

        if (precio < 0){
            throw new stockInvalidoException("Precio invalido");
        }

        if (stock < 0){
            throw new stockInvalidoException("Stock invalido");
        }

        producto producto = buscarPorId(id);

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setStock(stock);
        producto.setImagen(imagen);
        producto.setDisponible(disponible);
        producto.setCategoria(categoria);

    }

}