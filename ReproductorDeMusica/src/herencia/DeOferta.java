package herencia;

// Clase derivada de la super clase Producto

public class DeOferta extends Producto{
    private int descuento;
    
    public DeOferta(){
        
    }
    
    public DeOferta(int precio, String imagen, int descuento){
        super(precio, imagen);
        this.descuento = descuento;
    }
    
    public void setDescuento(int descuento){
        this.descuento = descuento;
    }
    
    public int getDescuento(){
        return descuento;
    }
    
    public float calcularPrecio(){
        return super.getPrecio() * (100 - descuento) / 100.0f;
    }
}
