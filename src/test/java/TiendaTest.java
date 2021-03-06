/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.TiendaDAO;
import java.util.ArrayList;
import modelo.Tienda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlos
 */
public class TiendaTest {
    
    public TiendaTest() {
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
    public void prospecto() {
        String id="0001";
	String descripcion="Jose";
        String estado = "A";        
        Tienda tienda = new Tienda(id,descripcion, estado);
		
	assertTrue(tienda.getTiendaId().equals(id));
	assertTrue(tienda.getTiendaDescripcion().equals(descripcion));
	assertTrue(tienda.getTiendaEstReg().equals(estado));
	}
//    @Test
//    public void insertarTienda(){
//        Tienda tienda = new Tienda ("12345","LIma", "A");
//	TiendaDAO tiendaDAO = new TiendaDAO();
//        
//        Assert.assertTrue(tiendaDAO.insertarTienda(tienda));
//    }
    @Test
    public void modificarTienda(){
        Tienda tienda = new Tienda ("12346","Luma", "A");
	TiendaDAO tiendaDAO = new TiendaDAO();
        
        
        if(tiendaDAO.buscarTienda(tienda.getTiendaId())!=null){
           String nuevoValor="12345678";
           Assert.assertTrue(tiendaDAO.modificarTienda(tienda));
        }else{
           System.out.println("No existe el usuario");
        }
    }
//    @Test
//    public void eliminarTienda(){
//        Tienda tienda = new Tienda ("003","LIma", "A");
//	TiendaDAO tiendaDAO = new TiendaDAO();
//        tiendaDAO.insertarTienda(tienda);
//        Assert.assertTrue(tiendaDAO.eliminarTienda2(tienda));
//    }
    @Test
    public void listarTiendas(){
        
        TiendaDAO tiendaDAO = new TiendaDAO();
        //try{
            ArrayList<Tienda> tiendas = tiendaDAO.listarTienda();
            assertFalse(tiendas.size()>0);
        //}catch(Exception e){
        //    Assert.fail("Falló el listado: " + e.getMessage());
        //}
    }
    public void estavacio(){
        ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
        Assert.assertNotNull(tiendas);
    }
}
