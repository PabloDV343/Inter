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
    
    public int llenar(String[] lista){
        int cantidad = (int) (Math.random() * 5) + 1;
        
        for(int i = 0; i < cantidad; i++){
            if((int) (Math.random() * 3) == 1){
                int precio = (int) (Math.random() * 501);
                
                echar(new Producto(precio, "src/herencia/" +
                      lista[(int) (Math.random() * lista.length)]));
            }
            else{
                int precio = (int) (Math.random() * 501);
                int descuento = (int) (Math.random() * 101);
                
                echar(new DeOferta(precio, "src/herencia/" +
                      lista[(int) (Math.random() * lista.length)],
                      descuento));
            }
        }
        return cantidad;
    }
}
