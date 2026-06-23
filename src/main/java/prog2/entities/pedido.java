package prog2.entities;
import prog2.enums.estado;
import prog2.enums.formaPago;
import prog2.interfaces.calculable;
import java.time.LocalDate;
import java.util.ArrayList;

public class pedido extends base implements calculable{

    private LocalDate fecha;
    private estado estado;
    private Double total;
    private formaPago formaPago;
    private usuario usuario;
    private ArrayList<detallePedido> detalles;

    public pedido(){
        detalles = new ArrayList<>();
    }

    public pedido(Long id, LocalDate fecha, estado estado, formaPago formaPago, usuario usuario){

        super(id);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.total = 0.0;
        this.detalles = new ArrayList<>();
    }

    public void addDetallePedido(int cantidad, producto producto){

        Double subtotal = cantidad * producto.getPrecio();

        Long idDetalle = (long) (detalles.size() + 1);

        detallePedido detalle = new detallePedido(
                idDetalle,
                cantidad,
                subtotal,
                producto
        );

        detalles.add(detalle);

    }

    public detallePedido findDetallePedidoByProducto(producto producto){

        for (detallePedido detalle : detalles){
            if (detalle.getProducto().equals(producto)){
                return detalle;
            }
        }

        return null;
    }

    public void deleteDetallePedidoByProducto(producto producto){

        detalles.removeIf(detalle -> detalle.getProducto().equals(producto));

    }

    @Override
    public void calcularTotal(){ //----------------------------------------------

        total = 0.0;

        for (detallePedido detalle : detalles){

            total += detalle.getSubtotal();

        }

    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public estado getEstado(){
        return estado;
    }

    public void setEstado(estado estado){
        this.estado = estado;
    }

    public Double getTotal(){
        return total;
    }

    public formaPago getFormaPago(){
        return formaPago;
    }

    public void setFormaPago(formaPago formaPago){
        this.formaPago = formaPago;
    }

    public usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(usuario usuario){
        this.usuario = usuario;
    }

    public ArrayList<detallePedido> getDetalles(){
        return detalles;
    }

    public void setDetalles(ArrayList<detallePedido> detalles){
        this.detalles = detalles;
    }

    @Override
    public String toString(){
        return "Pedido{" + "id=" + id + ", usuario=" + usuario.getNombre() + ", estado=" + estado + ", formaPago=" + formaPago + ", total=" + total + ", fecha=" + fecha + '}';
    }

}