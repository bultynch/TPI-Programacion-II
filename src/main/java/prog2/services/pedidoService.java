package prog2.services;
import prog2.entities.pedido;
import prog2.entities.usuario;
import prog2.enums.estado;
import prog2.enums.formaPago;
import prog2.exception.entidadNoEncontradaException;
import java.time.LocalDate;
import java.util.ArrayList;

public class pedidoService{

    private ArrayList<pedido> pedidos;
    private Long contadorId;

    public pedidoService(){

        pedidos = new ArrayList<>();
        contadorId = 1L;
    }

    public pedido crear(usuario usuario, formaPago formaPago) {

        if (usuario == null) {

            return null;

        }

        pedido pedido = new pedido(
                contadorId++,
                LocalDate.now(),
                estado.PENDIENTE,
                formaPago,
                usuario
        );

        pedidos.add(pedido);
        return pedido;

    }

    public ArrayList<pedido> listar(){

        ArrayList<pedido> lista = new ArrayList<>();

        for (pedido pedido : pedidos){

            if (!pedido.isEliminado()){
                lista.add(pedido);
            }

        }

        return lista;

    }

    public pedido buscarPorId(Long id)
            throws entidadNoEncontradaException{

        for (pedido pedido : pedidos){

            if (pedido.getId().equals(id) && !pedido.isEliminado()){

                return pedido;

            }

        }

        throw new entidadNoEncontradaException(
                "Pedido inexistente"
        );

    }

    public void eliminar(Long id)
            throws entidadNoEncontradaException{

        pedido pedido = buscarPorId(id);
        pedido.setEliminado(true);

    }
    
    public void actualizarEstado(Long id, estado estado)
            throws entidadNoEncontradaException{

        pedido pedido = buscarPorId(id);
        pedido.setEstado(estado);

    }
    
    public void actualizarFormaPago(Long id, formaPago formaPago)
        throws entidadNoEncontradaException{

    pedido pedido = buscarPorId(id);
    pedido.setFormaPago(formaPago);

    }

}