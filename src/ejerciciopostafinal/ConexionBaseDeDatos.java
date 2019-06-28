/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopostafinal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TejaART
 */
public class ConexionBaseDeDatos {

    static Connection contacto = null;
    public static boolean status = false;

    public static Connection getConexion() {
        status = false;
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=proyecto1";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        try {
            contacto = DriverManager.getConnection(url, "sa", "goku2000");
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }

    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();

            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
    
    public static void  ConsultaInsertOUpdate(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();

            declara.execute(consulta);
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        

    }

    

    public static void hacemeUnSelectAtablaUsuario() throws SQLException {
        ResultSet resultado = ConexionBaseDeDatos.Consulta("select * from Usuario");

        while (resultado.next()) {
            System.out.print(resultado.getString(1) + " -- ");
            System.out.print(resultado.getString(2) + " -- ");
            System.out.print(resultado.getString(3) + "\n");
        }
    }

    public static void hacemeInsertDePagos(ArrayList<Pago> arrayLoca) throws IOException, SQLException {

        

        for (int i = 0; i < arrayLoca.size(); i++) {
             
            String pay_instrument = "'" + arrayLoca.get(i).getPay_instrument() + "'";
            String barcode = "'" + arrayLoca.get(i).getBarcode() + "'";
            String terminal_seq_number = "'" + arrayLoca.get(i).getTerm_Seq_Number() + "'";
            String terminal = "'" + arrayLoca.get(i).getTerminal() + "'";
            String Currency_code = "'" + arrayLoca.get(i).getCurrency_code() + "'";
            String payment_date = "'" + arrayLoca.get(i).getPayment_date() + "'";
            String transaction_code = "'" + arrayLoca.get(i).getTransaction_code() + "'";
            int amount = arrayLoca.get(i).getAmount();
            System.out.println("buscando usuario con codigo de credencial "+barcode );
            ResultSet resultado = ConexionBaseDeDatos.Consulta("select id_Us from Usuario where cod_Cred = " + barcode + ";");
            
            if (resultado.next()) {
               ResultSet pagosUnivocos = ConexionBaseDeDatos.Consulta("select dia_pago,terminal,num_sec_term from Pago where cod_bar = "+barcode+";");
                if(!pagosUnivocos.next()){
                ConexionBaseDeDatos.ConsultaInsertOUpdate("insert into Pago(cod_trans,dia_pago,cod_moneda,monto,terminal,num_sec_term,cod_bar,inst_pago,ID_Usuario) values(" + transaction_code + "," + payment_date + "," + Currency_code + "," + amount + "," + terminal + "," + terminal_seq_number + "," + barcode + "," + pay_instrument + "," + resultado.getString(1) + ");");
                
                ResultSet idDePago = ConexionBaseDeDatos.Consulta("select id_pago from Pago where cod_bar = "+barcode+";");
                idDePago.next();
                System.out.println( "El pago "+idDePago.getString(1)+" ha sido vinculado con exito al usuario "+resultado.getString(1));
                }else{
                    System.out.println("Pago con terminal "+pagosUnivocos.getString(2)+", y numero de secuencia "+pagosUnivocos.getString(3)+" ya existente");
                }
                

            }else{
                System.out.println("No se encontro un usuario con ese codigo de credencial, no se inserta el pago");
            }
        }
    }
    

}
