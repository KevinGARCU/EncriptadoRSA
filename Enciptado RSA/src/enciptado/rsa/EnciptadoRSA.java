/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enciptado.rsa;

/**
 *
 * @author Kevin Garcia
 */
public class EnciptadoRSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mensaje c= new Mensaje();
        Primos p = new Primos();
        RSA r  = new RSA();
        r.encontrarBits(5);
        p.veracidadPrimo(5);
        c.separarCaracteres("f");
    }
    
}