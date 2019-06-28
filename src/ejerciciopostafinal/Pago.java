/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopostafinal;

import java.util.ArrayList;

/**
 *
 * @author MaxiPC
 */
public class Pago {

    private String Transaction_code;
    private String Payment_date;
    private String Currency_code;
    private int Amount;
    private String Terminal;
    private String Term_Seq_Number;
    private String Barcode;
    private String Pay_instrument;

    public Pago(ArrayList<String> array_de_linea_Archivo) {
        this.Transaction_code = array_de_linea_Archivo.get(0).substring(6, 8);
        this.Payment_date = array_de_linea_Archivo.get(0).substring(64, 72);
        this.Currency_code = array_de_linea_Archivo.get(0).substring(45, 48);
        this.Amount = Integer.parseInt(array_de_linea_Archivo.get(0).substring(49, 58));
        this.Terminal = array_de_linea_Archivo.get(0).substring(58, 64);
        this.Term_Seq_Number = array_de_linea_Archivo.get(0).substring(76, 80);
        this.Barcode = array_de_linea_Archivo.get(1).substring(1, 81).trim();
        this.Pay_instrument = array_de_linea_Archivo.get(2).substring(4, 5);

    }

    public String getTransaction_code() {
        return Transaction_code;
    }

    public void setTransaction_code(String Transaction_code) {
        this.Transaction_code = Transaction_code;
    }

    public String getPayment_date() {
        return Payment_date;
    }

    public void setPayment_date(String Payment_date) {
        this.Payment_date = Payment_date;
    }

    public String getCurrency_code() {
        return Currency_code;
    }

    public void setCurrency_code(String Currency_code) {
        this.Currency_code = Currency_code;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getTerminal() {
        return Terminal;
    }

    public void setTerminal(String Terminal) {
        this.Terminal = Terminal;
    }

    public String getTerm_Seq_Number() {
        return Term_Seq_Number;
    }

    public void setTerm_Seq_Number(String Term_Seq_Number) {
        this.Term_Seq_Number = Term_Seq_Number;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String getPay_instrument() {
        return Pay_instrument;
    }

    public void setPay_instrument(String Pay_instrument) {
        this.Pay_instrument = Pay_instrument;
    }

    public String toString() {

        return this.Transaction_code.toString() + ":"
                + this.Payment_date.toString() + ":"
                + this.Currency_code.toString() + ":"
                + Integer.toString(this.Amount) + ":"
                + this.Terminal.toString() + ":"
                + this.Term_Seq_Number.toString() + ":"
                + this.Barcode.toString() + ":"
                + this.Pay_instrument.toString();
    }

}
