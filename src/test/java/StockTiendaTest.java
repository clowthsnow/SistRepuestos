/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.StockTiendaDAO;
import controlador.UsuarioDAO;
import java.util.ArrayList;
import modelo.StockTienda;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mario-Snow
 */
public class StockTiendaTest {

    public StockTiendaTest() {
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
//    public void insertar() {
//        StockTienda st = new StockTienda("0001", "00001", "20", "A");
//        StockTiendaDAO control = new StockTiendaDAO();
//        Assert.assertTrue(control.insertarStockTienda(st));
//
//    }

    @Test
    public void modificarStock() {
        StockTienda st = new StockTienda("0001", "00001", "15", "A");
        StockTiendaDAO control = new StockTiendaDAO();
        Assert.assertTrue(control.modificarStockTienda(st));
    }


    @Test
    public void listar() {
        
        ArrayList<StockTienda> listaStockTiendas = new ArrayList<StockTienda>();
       StockTiendaDAO stDao= new StockTiendaDAO();
        Assert.assertNotNull(stDao.listarStockTienda());
    }
    
    

}
