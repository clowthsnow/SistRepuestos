/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Categoria;
import controlador.CategoriaDAO;
import junit.framework.Assert;

/**
 *
 * @author Liliana
 */
public class CategoriaTest {
    
    public CategoriaTest() {
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
    public void insertarCategoria(){
        String mensaje = "Modificación exitosa.";
        Categoria categoria = new Categoria("001", "Motores");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Assert.assertEquals(mensaje, categoriaDAO.agregarCategoria(categoria));
       // Assert.assertTrue(marcaDAO.insertarMarca(marca));
        
    }
}
