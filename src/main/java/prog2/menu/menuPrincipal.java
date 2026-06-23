package prog2.menu;
import prog2.services.categoriaService;
import prog2.services.pedidoService;
import prog2.services.productoService;
import prog2.services.usuarioService;
import prog2.entities.categoria;
import prog2.entities.producto;
import prog2.entities.usuario;
import prog2.entities.pedido;
import prog2.exception.entidadNoEncontradaException;
import prog2.exception.emailDuplicadoException;
import prog2.exception.stockInvalidoException;
import prog2.enums.rol;
import prog2.enums.estado;
import prog2.enums.formaPago;
import java.util.Scanner;

public class menuPrincipal{

    private Scanner scanner;
    private categoriaService categoriaService;
    private productoService productoService;
    private usuarioService usuarioService;
    private pedidoService pedidoService;

    public menuPrincipal(){

        scanner = new Scanner(System.in);
        categoriaService = new categoriaService();
        productoService = new productoService();
        usuarioService = new usuarioService();
        pedidoService = new pedidoService();

    }

    public void iniciar(){

        int opcion;
        do {

            System.out.println("\n=== FOOD STORE ===");
            System.out.println("1 - Categorias");
            System.out.println("2 - Productos");
            System.out.println("3 - Usuarios");
            System.out.println("4 - Pedidos");
            System.out.println("0 - Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:
                    menuCategorias();
                    break;

                case 2:
                    menuProductos();
                    break;

                case 3:
                    menuUsuarios();
                    break;

                case 4:
                    menuPedidos();
                    break;

                case 0:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }

        } while (opcion != 0);

    }
    
//-------------------------------------------------------------------------------
    
    private void menuCategorias(){

        int opcion;
        do {

            System.out.println("\n=== CATEGORIAS ===");
            System.out.println("1 - Listar");
            System.out.println("2 - Crear");
            System.out.println("3 - Editar");
            System.out.println("4 - Eliminar");
            System.out.println("0 - Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:

                    if (categoriaService.listar().isEmpty()){

                        System.out.println("No hay categorias");

                    } else {

                        for (categoria categoria : categoriaService.listar()){

                            System.out.println(categoria);

                        }

                    }

                    break;

                case 2:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();

                    categoriaService.crear(nombre, descripcion);

                    System.out.println("Categoria creada");

                    break;
                    
                    
                case 3:

                    try {

                        for (categoria categoria : categoriaService.listar()) {

                            System.out.println(categoria);

                        }

                        System.out.print("Id categoria: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Nuevo nombre: ");
                        String name = scanner.nextLine();

                        System.out.print("Nueva descripción: ");
                        String description = scanner.nextLine();

                        categoriaService.editar(
                                id,
                                name,
                                description
                        );

                        System.out.println("Categoria modificada");

                    } catch (entidadNoEncontradaException e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 4:

                    try {

                        for (categoria categoria : categoriaService.listar()){

                            System.out.println(categoria);

                        }

                        System.out.print("Ingrese id: ");
                        Long id = scanner.nextLong();

                        categoriaService.eliminar(id);

                        System.out.println("Categoria eliminada");

                    } catch (entidadNoEncontradaException e){

                        System.out.println(e.getMessage());

                    }

                    break;

                case 0:
                    break;

                default:

                    System.out.println("Opcion invalida");

            }

        } while (opcion != 0);

    }
    
//-------------------------------------------------------------------------------
    
    private void menuProductos(){

        int opcion;
        do{

            System.out.println("\n=== PRODUCTOS ===");
            System.out.println("1 - Listar");
            System.out.println("2 - Crear");
            System.out.println("3 - Editar");
            System.out.println("4 - Eliminar");
            System.out.println("0 - Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:
                    
   

                    for (producto producto : productoService.listar()){

                        System.out.println(producto);

                    }

                    break;

                case 2:

                    try{

                        if (categoriaService.listar().isEmpty()){

                            System.out.println("Primero debe crear una categoria");
                            break;

                        }

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        Double precio = scanner.nextDouble();

                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Descripcion: ");
                        String descripcion = scanner.nextLine();

                        System.out.print("Imagen: ");
                        String imagen = scanner.nextLine();

                        System.out.println("Categorias:");

                        for (categoria categoria : categoriaService.listar()){

                            System.out.println(categoria);

                        }

                        System.out.print("Id categoria: ");
                        Long idCategoria = scanner.nextLong();

                        categoria categoria =
                                categoriaService.buscarPorId(idCategoria);

                        productoService.crear(
                                nombre,
                                precio,
                                descripcion,
                                stock,
                                imagen,
                                true,
                                categoria
                        );

                        System.out.println("Producto creado");

                    } catch (entidadNoEncontradaException | stockInvalidoException e){

                        System.out.println(e.getMessage());

                    }

                    break;
                                     
                    
                    
                case 3:

                    try {

                        for (producto producto : productoService.listar()) {

                            System.out.println(producto);

                        }

                        System.out.print("Id producto: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Nuevo nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        Double precio = scanner.nextDouble();

                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Descripcion: ");
                        String descripcion = scanner.nextLine();

                        System.out.print("Imagen: ");
                        String imagen = scanner.nextLine();

                        for (categoria categoria : categoriaService.listar()) {

                            System.out.println(categoria);

                        }

                        System.out.print("Id categoria: ");
                        Long idCategoria = scanner.nextLong();

                        categoria categoria = categoriaService.buscarPorId(idCategoria);

                        productoService.editar(
                                id,
                                nombre,
                                precio,
                                descripcion,
                                stock,
                                imagen,
                                true,
                                categoria
                        );

                        System.out.println("Producto modificado");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                    
                case 4:

                    try {

                        for (producto producto : productoService.listar()){

                            System.out.println(producto);

                        }

                        System.out.print("Id producto: ");
                        Long id = scanner.nextLong();

                        productoService.eliminar(id);

                        System.out.println("Producto eliminado");

                    } catch (entidadNoEncontradaException e){

                        System.out.println(e.getMessage());

                    }

                    break;

            }

        } while (opcion != 0);

    }
    
//-------------------------------------------------------------------------------

    private void menuUsuarios(){

        int opcion;
        do {

            System.out.println("\n=== USUARIOS ===");
            System.out.println("1 - Listar");
            System.out.println("2 - Crear");
            System.out.println("3 - Editar");
            System.out.println("4 - Eliminar");
            System.out.println("0 - Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:

                    for (usuario usuario : usuarioService.listar()){

                        System.out.println(usuario);

                    }

                    break;

                case 2:

                    try {

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Mail: ");
                        String mail = scanner.nextLine();

                        System.out.print("Celular: ");
                        String celular = scanner.nextLine();

                        System.out.print("Contraseña: ");
                        String contrasenia = scanner.nextLine();

                        usuarioService.crear(
                                nombre,
                                apellido,
                                mail,
                                celular,
                                contrasenia,
                                rol.USUARIO
                        );

                        System.out.println("Usuario creado");

                    } catch (emailDuplicadoException e){

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                    
                    
                    
                case 3:

                    try {

                        for (usuario usuario : usuarioService.listar()) {

                            System.out.println(usuario);

                        }

                        System.out.print("Id usuario: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Mail: ");
                        String mail = scanner.nextLine();

                        System.out.print("Celular: ");
                        String celular = scanner.nextLine();

                        System.out.print("Contraseña: ");
                        String contrasenia = scanner.nextLine();

                        usuarioService.editar(
                                id,
                                nombre,
                                apellido,
                                mail,
                                celular,
                                contrasenia,
                                rol.USUARIO
                        );

                        System.out.println("Usuario modificado");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                    

                case 4:

                    try {

                        for (usuario usuario : usuarioService.listar()){

                            System.out.println(usuario);

                        }

                        System.out.print("Id usuario: ");
                        Long id = scanner.nextLong();

                        usuarioService.eliminar(id);

                        System.out.println("Usuario eliminado");

                    } catch (entidadNoEncontradaException e){

                        System.out.println(e.getMessage());

                    }

                    break;

            }

        } while (opcion != 0);

    }

//-------------------------------------------------------------------------------
    
    private void menuPedidos(){

        int opcion;

        do {

            System.out.println("\n=== PEDIDOS ===");
            System.out.println("1 - Listar");
            System.out.println("2 - Crear");
            System.out.println("3 - Actualizar estado");
            System.out.println("4 - Actualizar forma de pago");
            System.out.println("5 - Eliminar");
            System.out.println("0 - Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    for (pedido pedido : pedidoService.listar()){

                        System.out.println(pedido);

                    }

                    break;

                case 2:

                    try {

                        if (usuarioService.listar().isEmpty()){

                            System.out.println("No hay usuarios");
                            break;

                        }

                        for (usuario usuario : usuarioService.listar()){

                            System.out.println(usuario);

                        }

                        System.out.print("Id usuario: ");
                        Long idUsuario = scanner.nextLong();

                        usuario usuario = usuarioService.buscarPorId(idUsuario);

                        pedido pedido = pedidoService.crear(usuario, formaPago.EFECTIVO);
                        
                        int continuar;
                        
                        do {
                            
                            for (producto producto : productoService.listar()){
                                System.out.println(producto);
                            }
                        
                        
                        System.out.print("Id producto: ");
                        Long idProducto = scanner.nextLong();
                        
                        producto producto = productoService.buscarPorId(idProducto);
                        
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
    
                        pedido.addDetallePedido(
                                cantidad,
                                producto
                        );
                        
                        producto.setStock(producto.getStock() - cantidad);
                        
                        System.out.println("Agregar otro producto?");
                        System.out.println("1-Si");
                        System.out.println("0-No");
                        
                        continuar = scanner.nextInt();
                        
                        } while (continuar == 1);

                        pedido.calcularTotal();

                        System.out.println("Pedido creado");

                    } catch (entidadNoEncontradaException e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                case 3:

                    try {

                        for (pedido pedido : pedidoService.listar()) {

                            System.out.println(pedido);

                        }

                        System.out.print("Id pedido: ");
                        Long idPedido = scanner.nextLong();

                        pedidoService.actualizarEstado(
                                idPedido,
                                estado.CONFIRMADO
                        );

                        System.out.println("Estado actualizado");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                    
                case 4:

                    try {

                        for (pedido pedido : pedidoService.listar()) {

                            System.out.println(pedido);

                        }

                        System.out.print("Id pedido: ");
                        Long idPedido = scanner.nextLong();

                        pedidoService.actualizarFormaPago(
                                idPedido,
                                formaPago.TRANSFERENCIA
                        );

                        System.out.println("Forma de pago actualizada");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                    
                    
                case 5:

                    try {

                        for (pedido pedido : pedidoService.listar()){

                            System.out.println(pedido);

                        }

                        System.out.print("Id pedido: ");
                        Long id = scanner.nextLong();

                        pedidoService.eliminar(id);

                        System.out.println("Pedido eliminado");

                    } catch (entidadNoEncontradaException e){

                        System.out.println(e.getMessage());

                    }

                    break;

            }

        } while (opcion != 0);

    }
}