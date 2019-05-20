package enciptado.rsa;

import java.util.ArrayList;

/**
 *
 * @author Kevin Garcia
 */
public class RSA {

    int clavePrivada, fi, z, p, q, n, t;
    long s;
    int bits[];
    long potenciaMod[];
    ArrayList<Integer> binario = new ArrayList<>();

    public void RSA1(int p, int q, int n, int t) {
        this.p = p;
        this.q = q;
        this.n = n;
        this.t = t;
        encontrarClave();
        encontrarBits();
        encontrarPotencias();
    }
    
    

    public void encontrarClave() {
        fi = (p - 1) * (q - 1);
        z = p * q;
        s = 2;

        while (true) {
            if ((n * s) % fi == 1) {
                break;
            } else {
                s++;
                
            }
        }
    }

    public void encontrarBits() {
        int resto, numero;
        numero = n;
        do {
            
            binario.add(numero%2);
            numero = numero / 2;
            
        } while (numero >= 2);

        binario.add(numero);

        bits = new int[binario.size()];

        for (int i = 0; i < binario.size(); i++) {
            bits[i] = binario.get(i);
        }    
    }
    
    public void encontrarPotencias(){
        long aux=0;
        aux=t;
        potenciaMod = new long[bits.length];   
        potenciaMod[0]=t;
        for(int i = 1; i<potenciaMod.length; i++){
            potenciaMod[i]=(long)(Math.pow(aux, 2))%z;
            
            aux = potenciaMod[i];
            
        }   
        
    }
    
    public long encriptar(){
        long  aux=1;
        for(int i=0; i<potenciaMod.length; i++){
            if(bits[i]==1){
                aux = (aux*potenciaMod[i])%z;
                
            }
        }
        return aux;
    }
    
    public void borrar(){
        for(int i=0; i<potenciaMod.length; i++){
            potenciaMod[i]=0;
        }
        binario.clear();
    }
}
