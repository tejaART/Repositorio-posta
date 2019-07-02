/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopostafinal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author TejaART
 */
public class EjercicioPostaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
       DateFormat formatoDia = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                 Date dia = new Date();
                 
        
        LectorArchivo lector = new LectorArchivo();
        
       
         ConexionMail.send("arielrodrigotejada@gmail.com","sakgohyxcuajdrhr","maximilianotejada@gmail.com","Resumen de Proceso; Pagos de Pagos CAFÉ",
                 " Resumen de Proceso:\n Dia:"+formatoDia.format(dia)+"\n Medio de Pago : PAGOFACIL\n\n "+ConexionBaseDeDatos.hacemeInsertDePagos(lector.leemeElArchivo("C:/Users/MaxiPC/Desktop/proyecto lalala/cafeconlechefile.txt")));  
      
                 
         
       
    }
    
}
