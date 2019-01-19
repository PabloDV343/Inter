package herencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class Dibujo extends JApplet {

    Bolsa bolsa;
    String[] lista;

    @Override
    public void init() {
        this.setSize(450, 200);

        lista = new String[]{"Jugo2.png"};

        bolsa = new Bolsa();
        System.out.println("Numero de articulos: " + bolsa.llenar(lista));
    }

    public void drawLine(Graphics plumon) {
        plumon.setColor(Color.BLACK);
        plumon.fillRect(10, 100, 200, 20);
    }

    public void drawBag(Graphics plumon) {
        plumon.setColor(Color.BLUE);
        plumon.fillRect(200, 100, 60, 100);

        plumon.setColor(Color.WHITE);
        plumon.setFont(new Font("Arial", Font.ITALIC, 12));
        plumon.drawString("Gual*Mart", 200, 150);
    }

    public float drawPrice(Graphics plumon, Producto p, float total) {
        plumon.setColor(Color.WHITE);
        plumon.fillRect(280, 0, 170, 100);

        plumon.setColor(Color.BLACK);
        plumon.drawString(p.getImagen().substring(p.getImagen().lastIndexOf("/") + 1, p.getImagen().length() - 4), 280, 15);
        
        System.out.print(p.getImagen().substring(p.getImagen().lastIndexOf("/") + 1, p.getImagen().length() - 4) + " ");
        
        plumon.setColor(Color.RED);
        plumon.drawString("Costo: $"
                + String.valueOf(p.getPrecio()), 280, 30);
        
        System.out.print("$" + p.getPrecio() + " ");

        if (p instanceof DeOferta) {
            plumon.setColor(Color.GREEN);
            
            plumon.drawString("Descuento: " + ((DeOferta) p).getDescuento() + "%",
                    280, 45);
            
            plumon.drawString("Precio final: $" + ((DeOferta) p).calcularPrecio(),
                    280, 60);
            
            System.out.println("- $" + (p.getPrecio() - ((DeOferta) p).calcularPrecio()) + "\t= $" + ((DeOferta) p).calcularPrecio());
            
            plumon.setColor(Color.BLACK);
            plumon.drawString("Total: $" + String.valueOf(total + ((DeOferta) p).calcularPrecio()), 280, 80);
        
        }

        
        if(p instanceof DeOferta) return ((DeOferta) p).calcularPrecio();
        
        plumon.setColor(Color.BLACK);
        plumon.drawString("Total: $" + String.valueOf(total + p.getPrecio()), 280, 80);
        System.out.println();
        return p.getPrecio();
    }

    public void drawMaualJuice(Graphics plumon, int x) {
        //dibujo manual
        plumon.setColor(Color.YELLOW);
        plumon.fillRect(x, 10, 45, 75);
        plumon.setColor(Color.WHITE);
        plumon.drawString("Jugo", x + 7, 25);
        plumon.drawLine(x, 35, x + 45, 35);
        plumon.setColor(Color.ORANGE);
        plumon.fillOval(x + 15, 50, 20, 20);
    }

    @Override
    public void paint(Graphics plumon) {

        float total = 0;

        for (Producto producto : bolsa.dameTodos()) {

            Image img;
            img = new ImageIcon(producto.getImagen()).getImage();

            drawLine(plumon);
            drawBag(plumon);

            for (int i = 1, x = 10; i <= 40; i++, x += 5) {

                plumon.drawImage(img, x, 10, this);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                plumon.setColor(Color.WHITE);
                plumon.fillRect(x - 1, 10, 47, 90);
            }

            //Applet.newAudioClip(Dibujo.class.getResource());
            total += drawPrice(plumon, producto, total);

            for (int y = 10; y < 100; y += 5) {

                plumon.drawImage(img, 210, y, this);

                drawBag(plumon);
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

                plumon.setColor(Color.WHITE);
                plumon.fillRect(209, y - 1, 47, 91 - y);
            }
        }
        
        System.out.println("Total: $" + total);
    }
}
