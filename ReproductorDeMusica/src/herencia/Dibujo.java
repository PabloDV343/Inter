package herencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class Dibujo extends JApplet {

    Bolsa bolsa;
    ArrayList<String> subTotal;
    
    @Override
    public void init() {
        //this.setSize(500, 500);
        bolsa = new Bolsa();
        
        for(int i = 0; i < 5; i++){
            if((int) Math.random() * 3 < 1){
                int precio = (int) Math.random() * 501;
                
                bolsa.echar(new Producto(precio, "src/herencia/Jugo2.png"));
            }
            else{
                int precio = (int) Math.random() * 501;
                int descuento = (int) Math.random() * 101;
                
                bolsa.echar(new DeOferta(precio, "src/herencia/Jugo2.png",
                            descuento));
            }
        }
    }
    
    @Override
    public void paint(Graphics plumon){
        
        for(Producto p : bolsa.dameTodos())
            System.out.println(p.getImagen());
        
        for(Producto producto : bolsa.dameTodos()){
            
            int d = 0;
            int p = producto.getPrecio();
            String imagen = producto.getImagen();
            
            if(producto instanceof DeOferta){
                d = ((DeOferta) producto).getDescuento();
            }
            
            subTotal.add(imagen + " $" + String.valueOf(p) + " $" + String.valueOf(d));
            
            Image img;
            img = new ImageIcon(producto.getImagen()).getImage();

            plumon.setColor(Color.BLACK);
            plumon.fillRect(10, 100, 200, 20);

            plumon.setColor(Color.BLUE);
            plumon.fillRect(200, 100, 60, 100);

            plumon.setColor(Color.WHITE);
            plumon.setFont(new Font("Arial", Font.ITALIC, 12));
            plumon.drawString("Gual*Mart", 200, 150);

            for(int i = 1, x = 10; i <= 40; i++, x+=5){
                
    //            plumon.setColor(Color.YELLOW);
    //            plumon.fillRect(x, 10, 45, 75);
    //            plumon.setColor(Color.WHITE);
    //            plumon.drawString("Jugo", x + 7, 25);
    //            plumon.drawLine(x, 35, x + 45, 35);
    //            plumon.setColor(Color.ORANGE);
    //            plumon.fillOval(x + 15, 50, 20, 20);

                plumon.drawImage(img, x, 10, this);

                try{
                    Thread.sleep(190);
                }catch(Exception e){
                }

                plumon.setColor(Color.WHITE);
                plumon.fillRect(x - 1, 10, 47, 90);
            }


            //Applet.newAudioClip(Dibujo.class.getResource());


            for(int y = 10; y < 100; y+=5){
                
                plumon.setColor(Color.BLUE);
                for(String s : subTotal){
                    System.out.println(s);
                }
                
                plumon.drawImage(img, 210, y, this);

                plumon.setColor(Color.BLUE);
                plumon.fillRect(200, 100, 60, 100);

                plumon.setColor(Color.WHITE);
                plumon.setFont(new Font("Arial", Font.ITALIC, 12));
                plumon.drawString("Gual*Mart", 200, 150);

                try{
                    Thread.sleep(190);
                }catch(Exception ex){
                    System.err.println(ex.getMessage());
                }
                plumon.setColor(Color.WHITE);
                plumon.fillRect( 209, y-1, 47, 91-y);
            }
        }
    }
}
