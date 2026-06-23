package prog2.services;
import prog2.entities.categoria;
import prog2.exception.entidadNoEncontradaException;
import java.util.ArrayList;

public class categoriaService{

    private ArrayList<categoria> categorias;
    private Long contadorId;

    public categoriaService(){
        categorias = new ArrayList<>();
        contadorId = 1L;
    }

    public void crear(String nombre, String descripcion){

        for (categoria categoria : categorias){
            if (!categoria.isEliminado() && categoria.getNombre().equalsIgnoreCase(nombre)){

                System.out.println("Ya existe una categoría con ese nombre");
                return;
            }
        }

        categoria categoria = new categoria(contadorId++, nombre, descripcion);
        categorias.add(categoria);

    }

    public ArrayList<categoria> listar(){

        ArrayList<categoria> resultado = new ArrayList<>();

        for (categoria categoria : categorias){

            if (!categoria.isEliminado()){
                resultado.add(categoria);
            }

        }

        return resultado;
    }

    public categoria buscarPorId(Long id) throws entidadNoEncontradaException{

        for (categoria categoria : categorias){

            if (categoria.getId().equals(id) && !categoria.isEliminado()){

                return categoria;
            }

        }

        throw new entidadNoEncontradaException("Categoría inexistente");
    }

    public void eliminar(Long id) throws entidadNoEncontradaException{

        categoria categoria = buscarPorId(id);
        categoria.setEliminado(true);

    }
    
    public void editar(Long id, String nombre, String descripcion)
            throws entidadNoEncontradaException {

        categoria categoria = buscarPorId(id);

        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

    }

}