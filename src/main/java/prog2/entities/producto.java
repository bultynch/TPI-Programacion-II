package prog2.entities;

public class producto extends base{

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;
    private categoria categoria;

    public producto(){
    }

    public producto(Long id, String nombre, Double precio, String descripcion,
                    int stock, String imagen,
                    boolean disponible, categoria categoria){

        super(id);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
        this.categoria = categoria;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String getImagen(){
        return imagen;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }

    public boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(categoria categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria.getNombre() + '}';
    }
}