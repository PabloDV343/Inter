package herencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class Dibujo extends JApplet {

    public void init() {
        //this.setSize(500, 500);
    }
    
    public void paint(Graphics plumon){
        
        Image img;
        img = new ImageIcon("src/herencia/Jugo2.png").getImage();
        
        plumon.setColor(Color.BLACK);
        plumon.fillRect(10, 100, 200, 20);
        
        plumon.setColor(Color.BLUE);
        plumon.fillRect(200, 100, 60, 100);
        
        plumon.setColor(Color.WHITE);
        plumon.setFont(new Font("Arial", Font.BOLD, 12));
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
        
        for(int y = 10; y < 100; y+=5){
            plumon.drawImage(img, 210, y, this);
            
            plumon.setColor(Color.BLUE);
            plumon.fillRect(200, 100, 60, 100);
        }
    }
}
