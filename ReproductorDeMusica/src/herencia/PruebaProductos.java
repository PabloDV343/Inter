package herencia;

public class PruebaProductos {

    public static void main(String[] args) {
        Bolsa bolsa = new Bolsa();
        
        Producto p = new Producto(25000, "src/herencia/Jugo2.png");
        DeOferta o = new DeOferta(8500, "src/herencia/Jugo2.png", 90);
        
        bolsa.echar(p);
        bolsa.echar(o);
        
        for(Producto x : bolsa.dameTodos()){
            System.out.println("Precio de lista $" + x.getPrecio());
            if(x instanceof DeOferta)
                System.out.println("\t Precio de oferta $"  + ((DeOferta) x).calcularPrecio());
            else System.out.println();
        }
    }
}
