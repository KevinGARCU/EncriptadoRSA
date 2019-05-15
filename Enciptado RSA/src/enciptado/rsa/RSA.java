package enciptado.rsa;

import java.util.ArrayList;

/**
 *
 * @author Kevin Garcia
 */
public class RSA {

    int clavePrivada, fi, z, s, p, q, n, t;
    int bits[],potenciaMod[];
    ArrayList<Integer> binario = new ArrayList<>();

    public RSA(int p, int q, int n, int t) {
        this.p = p;
        this.q = q;
        this.n = n;
        this.t = t;
    }
    
    

    public void encontrarClave() {
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
            System.out.print(binario.get(i));
        }
        System.out.println("");
        for(int i = 0; i<bits.length; i++){
            System.out.print(bits[i]);
        }
        System.out.println("");
        
    }
    
    public void encontrarPotencias(){
        int aux=t;
        potenciaMod = new int[bits.length];
        System.out.println(n);    
        potenciaMod[0]=t;
        for(int i = 1; i<potenciaMod.length; i++){
            potenciaMod[i]=(int)(Math.pow(aux, 2))%z;
            
            aux = potenciaMod[i];
            System.out.println(aux);
            
        }
        for(int i = 0; i<potenciaMod.length; i++){
            System.out.print(potenciaMod[i]+" ");
        }
        
        
    }
    
    public void encriptar(){
        int aux=1;
        for(int i=0; i<potenciaMod.length; i++){
            if(bits[i]==1){
                System.out.println(aux);
                aux = (aux*potenciaMod[i])%z;
                
            }
        }
        System.out.println(aux);
    }
}
