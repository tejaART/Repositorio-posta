/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopostafinal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TejaART
 */
public class EjercicioPostaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
       
        LectorArchivo lector = new LectorArchivo();
        
        ConexionBaseDeDatos.hacemeInsertDePagos(lector.leemeElArchivo("C:/Users/MaxiPC/Desktop/proyecto lalala/cafeconlechefile.txt"));
      
        
       
        
         
       
    }
    
}
