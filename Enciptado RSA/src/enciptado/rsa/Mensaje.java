package enciptado.rsa;

import java.util.ArrayList;

public class Mensaje {
    
    ArrayList<Integer> caracteres = new ArrayList<>();
    char aux;
    
    public void separarCaracteres(String mensaje){
        for(int i = 0; i < mensaje.length(); i++){           
            caracteres.add((int) mensaje.charAt(i));
            System.out.println(caracteres.get(i));
            
        }
    }
    
}
