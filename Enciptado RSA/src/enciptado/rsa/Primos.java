package enciptado.rsa;


public class Primos {
    public boolean veracidadPrimo(int p){
        for(int i = 2; i < p; i++){
            if(p%i==0){
               return false; 
            }
        }
        return true;
    }
}
