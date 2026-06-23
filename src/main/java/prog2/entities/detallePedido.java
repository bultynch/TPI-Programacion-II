package prog2.entities;

public class detallePedido extends base{

    private int cantidad;
    private Double subtotal;
    private producto producto;

    public detallePedido(){
    }

    public detallePedido(Long id, int cantidad, Double subtotal, producto producto){
        super(id);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public Double getSubtotal(){
        return subtotal;
    }

    public void setSubtotal(Double subtotal){
        this.subtotal = subtotal;
    }

    public producto getProducto(){
        return producto;
    }

    public void setProducto(producto producto){
        this.producto = producto;
    }

    @Override
    public String toString(){
        return "DetallePedido{" + "producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }

}