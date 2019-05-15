package enciptado.rsa;


public class Primos {
    public boolean veracidadPrimo(int p){
        for(int i = 2; i < p; i++){
            if(p%i==0){
                System.out.println("no primo "+p);
               return false; 
            }
        }
        System.out.println("primo " + p);
        return true;
    }
}
