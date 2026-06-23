package prog2.services;
import prog2.entities.usuario;
import prog2.enums.rol;
import prog2.exception.emailDuplicadoException;
import prog2.exception.entidadNoEncontradaException;

import java.util.ArrayList;

public class usuarioService{

    private ArrayList<usuario> usuarios;
    private Long contadorId;

    public usuarioService(){

        usuarios = new ArrayList<>();
        contadorId = 1L;

    }

    public void crear(String nombre,
                      String apellido,
                      String mail,
                      String celular,
                      String contrasenia,
                      rol rol)
            throws emailDuplicadoException{

        for (usuario usuario : usuarios){

            if (!usuario.isEliminado() && usuario.getMail().equalsIgnoreCase(mail)){

                throw new emailDuplicadoException(
                        "El mail ya existe"
                );

            }

        }

        usuario usuario = new usuario(
                contadorId++,
                nombre,
                apellido,
                mail,
                celular,
                contrasenia,
                rol
        );

        usuarios.add(usuario);

    }

    public ArrayList<usuario> listar(){

        ArrayList<usuario> lista = new ArrayList<>();

        for (usuario usuario : usuarios){

            if (!usuario.isEliminado()){

                lista.add(usuario);

            }

        }

        return lista;

    }

    public usuario buscarPorId(Long id)
            throws entidadNoEncontradaException{

        for (usuario usuario : usuarios){

            if (usuario.getId().equals(id) && !usuario.isEliminado()){

                return usuario;

            }

        }

        throw new entidadNoEncontradaException(
                "Usuario inexistente"
        );

    }

    public void eliminar(Long id)
            throws entidadNoEncontradaException{

        usuario usuario = buscarPorId(id);
        usuario.setEliminado(true);

    }
    
    public void editar(Long id,
                        String nombre,
                        String apellido,
                        String mail,
                        String celular,
                        String contrasenia,
                        rol rol)
            throws entidadNoEncontradaException,
            emailDuplicadoException{

        usuario usuario = buscarPorId(id);

        for (usuario u : usuarios){

            if (!u.getId().equals(id) && !u.isEliminado() && u.getMail().equalsIgnoreCase(mail)){

                throw new emailDuplicadoException(
                        "Mail ya existente"
                );
            }
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setCelular(celular);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);

    }

}