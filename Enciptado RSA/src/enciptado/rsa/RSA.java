package enciptado.rsa;

import java.util.ArrayList;

/**
 *
 * @author Kevin Garcia
 */
public class RSA {

    int clavePrivada, fi, z, s;
    int bits[];
    ArrayList<Integer> binario = new ArrayList<>();

    public void encontrarClave(int p, int q, int n) {
        fi = (p - 1) * (q - 1);
        z = p * q;
        s = n + 1;

        while (true) {
            if ((n * s) % fi == 1) {
                break;
            } else {
                s++;
            }
        }
        clavePrivada = s;
    }

    public void encontrarBits(int n) {
        int resto, numero;
        numero = n;
        do {
            binario.add(numero%2);
            numero = numero / 2;
            
        } while (numero >= 2);

        binario.add(numero);

        bits = new int[binario.size()];

        for (int i = binario.size() - 1; i >= 0; i--) {
            bits[(binario.size()-1)- i] = binario.get(i);
            System.out.print(binario.get(i));
        }
        System.out.println("");
        for(int i = 0; i<bits.length; i++){
            System.out.print(bits[i]);
        }

    }
}
