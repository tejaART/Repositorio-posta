/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopostafinal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author MaxiPC
 */
public class LectorArchivo {

    private ArrayList<String> arrayDelArchivo;

    public LectorArchivo() {
        this.arrayDelArchivo = new ArrayList<String>();
    }

    public ArrayList<String> getArrayDelArchivo() {
        return arrayDelArchivo;
    }

    public void setArrayDelArchivo(ArrayList<String> arrayDelArchivo) {
        this.arrayDelArchivo = arrayDelArchivo;
    }

    public  ArrayList<Pago> leemeElArchivo(String archivo) throws FileNotFoundException, IOException {
        ArrayList<Pago> arrayDePagos = new ArrayList<Pago>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            if (cadena.startsWith("5")) {
                this.arrayDelArchivo.add(cadena);
            } else if (cadena.startsWith("6")) {
                this.arrayDelArchivo.add(cadena);
            } else if (cadena.startsWith("7")) {
                this.arrayDelArchivo.add(cadena);
                Pago pago = new Pago(arrayDelArchivo);
                arrayDePagos.add(pago);
                arrayDelArchivo.removeAll(arrayDelArchivo);
            }
        }
        b.close();

        return arrayDePagos;
    }

}
