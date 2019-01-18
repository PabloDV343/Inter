package herencia;

import java.util.ArrayList;

public class Bolsa {
    ArrayList<Producto> cuenta;
    
    public Bolsa(){
        cuenta = new ArrayList();
    }
    
    public void echar(Producto p){
        cuenta.add(p);
    }
    
    public Producto quitar(int n){
        if(n < cuenta.size())
            return cuenta.get(n);
        return null;
    }
    
    public ArrayList<Producto> dameTodos(){
        return cuenta;
    }
}
