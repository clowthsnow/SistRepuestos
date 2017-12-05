/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Conexion;
import java.util.ArrayList;
import modelo.Usuario;
import controlador.UsuarioDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void insertar(){
//        Usuario usuario = new Usuario("5","rodrigo","rodrigo","72148783","1","A");
//	UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Assert.assertTrue(usuarioDAO.insertUsuario(usuario));
//       
//    }
//    /*@Test
//    public void modificarContraseña(){
//        Usuario usuario = new Usuario("1","rodrigo","rodrigo","72148783","1","A");
//	UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Assert.assertTrue(usuarioDAO.modificarContraseña(usuario,"contraAntigua","contraNueva"));
//    }
//    */
//    @Test
//    public void modificarUsuario(){
//        Usuario usuario = new Usuario("1","rodrigo","rodrigo","72148783","1","A");
//	UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Assert.assertTrue(usuarioDAO.modificarUsuario(usuario));
//    }
//    
//    @Test
//    public void eliminar(){
//        Usuario usuario = new Usuario("2","rodrigo","rodrigo","72148783","1","A");
//	UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Assert.assertTrue(usuarioDAO.eliminarUsuario(usuario));
//    }
//    @Test
//    public void listar(){
//        Usuario usuario = new Usuario("1","rodrigo","rodrigo","72148783","1","A");;
//        ArrayList<Usuario> users=new ArrayList<Usuario>();
//        users.add(usuario);
//        Assert.assertNotNull(users);
//    }
}
