package herencia;

// -- Super Clase producto

public class Producto {
    private int precio;
    private String imagen;
    
    public Producto(){
        
    }
    
    public Producto(int precio, String imagen){
        this.precio = precio;
        this.imagen = imagen;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public String getImagen(){
        return imagen;
    }
}
