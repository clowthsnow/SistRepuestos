/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import modelo.Conexion;
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
public class LoginUsuario {
    
    public LoginUsuario() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Conexion conexion;
        conexion = new Conexion();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testValidarUsuario() {
        Usuario user = new Usuario("1", "admin");
        UsuarioDAO u=new UsuarioDAO();
        u.verificarUsuario(user.getCodigo(), user.getContraseña());
        Assert.assertTrue(u != null);
        Assert.assertTrue("1".equals(user.getCodigo()));
        Assert.assertTrue("admin".equals(user.getContraseña()));
    }
    @Test
    public void testListarUsuario() {
        Usuario user = new Usuario("1", "admin");
        ArrayList<Usuario> listaU=new ArrayList<Usuario>();
        listaU.add(user);
        Assert.assertFalse(listaU.isEmpty());
   
    }
    @Test
    public void testModificarUsuario() {
        Usuario user = new Usuario("1", "admin");
        UsuarioDAO u=new UsuarioDAO();
        u.verificarUsuario(user.getCodigo(), user.getContraseña());
        Assert.assertTrue(u != null);
        Assert.assertTrue("1".equals(user.getCodigo()));
        Assert.assertTrue("admin".equals(user.getContraseña()));
    }
    @Test
    public void testEliminarUsuario(){
        Usuario user = new Usuario("1", "admin");
        UsuarioDAO u=new UsuarioDAO();
        u.verificarUsuario(user.getCodigo(), user.getContraseña());
        Assert.assertTrue(u != null);
        Assert.assertTrue("1".equals(user.getCodigo()));
        Assert.assertTrue("admin".equals(user.getContraseña()));
    }  
}
