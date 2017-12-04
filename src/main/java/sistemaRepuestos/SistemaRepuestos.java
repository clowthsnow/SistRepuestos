/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaRepuestos;

import controlador.UsuarioDAO;
import vista.FormLogin;



/**
 *
 * @author Rodrigo
 */
public class SistemaRepuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
         //String name = UIManager.getSystemLookAndFeelClassName();
         //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception e) {
         e.printStackTrace();
      }
        
        FormLogin vistaL = new FormLogin();
        UsuarioDAO modeloL = new UsuarioDAO();
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
    }
   
}
