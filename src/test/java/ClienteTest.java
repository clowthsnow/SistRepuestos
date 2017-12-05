/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modelo.Cliente;
import controlador.ClienteDAO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liliana
 */
public class ClienteTest {
    
    public ClienteTest() {
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
     //@Test
    public void prospecto() {
        String dni="0";
	String nombre="jose";
        String direccion="SMP";
	String correo="libra5100@hotmail.com";
	String telefono="5342031";

	Cliente cliente = new Cliente(dni, nombre, direccion, correo, telefono);
	
		
	assertTrue(cliente.getDni().equals(dni));
	assertTrue(cliente.getDni().equals(nombre));
	assertTrue(cliente.getDireccion().equals(direccion));
	assertTrue(cliente.getCorreo().equals(correo));
	assertTrue(cliente.getTelefono().equals(telefono));;
	}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertarCliente(){
        Cliente cliente = new Cliente("88888","aqp","direccion","aqp@gmail.com","123456");
        ClienteDAO clienteDAO = new ClienteDAO();
        assertTrue(clienteDAO.agregarCliente(cliente));
	
    }
    
  
    @Test
    public void eliminarCliente(){
        Cliente cliente = new Cliente("88888","aqp","direccion","aqp@gmail.com","123456");
        ClienteDAO clienteDAO = new ClienteDAO();
        assertTrue(clienteDAO.eliminarCliente(cliente));

    }
    
}
