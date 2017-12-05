/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class LoginTest {
    
    public LoginTest() {
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
    @Test
    public void testLoginOk() {
        Usuario user = new Usuario("1", "admin");
        UsuarioDAO u=new UsuarioDAO();
        u.verificarUsuario(user.getCodigo(), user.getContraseña());
        Assert.assertTrue(u != null);
        Assert.assertTrue("1".equals(user.getCodigo()));
        Assert.assertTrue("admin".equals(user.getContraseña()));
    }   
}
