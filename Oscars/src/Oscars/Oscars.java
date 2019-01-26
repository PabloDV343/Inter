package Oscars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Oscars {

    JFrame window;
    int width = 500, height = 500;
    JPanel panel;
    JRadioButton [] radiosButtons;
    JButton showButton;
    ArrayList<Category> categories;
    
    public Oscars(){
        window = new JFrame();
        panel = new JPanel();
        categories = Category.createCategories("src/resources/Movies.txt");
        radiosButtons = new JRadioButton[categories.size()];
        showButton =  new JButton();
    }
    
    private void conf(){
        window.setTitle("Oscars nominees");
        window.setResizable(false);
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int widthButton = 100;
        showButton.setText("Show");
        showButton.addActionListener(new Control());
        showButton.setBounds((window.getWidth() - widthButton) / 2, 50, widthButton, 20);
        showButton.setVisible(true);
        
        panel.setLayout(null);
        
        int widthRadio = 100, heightRadio = 20, initY = 100;
        for(int i = 0; i < radiosButtons.length; i++){
            radiosButtons[i] = new JRadioButton();
            
            radiosButtons[i].setText(categories.get(i).getName());
            
            radiosButtons[i].setBounds((window.getWidth() - widthRadio) / 2,
                                        initY + heightRadio * i, widthRadio,
                                        heightRadio);
        }
        
        for(JRadioButton radio: radiosButtons){
            panel.add(radio);
        }
        panel.add(showButton);
        
        window.getContentPane().add(panel);
        window.setVisible(true);
    }
    
    class Control implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            ArrayList<String> selected = new ArrayList();
            
            if(ae.getSource() == showButton){
                for(JRadioButton radio: radiosButtons){
                    if(radio.isSelected()){
                        selected.add(radio.getText());
                    }
                }
                
                for(Category c: categories){
                    if(selected.contains(c.getName())){
                        for(Movie m:c.getMovies()){
                            JOptionPane.showMessageDialog(null,
                                    "Actor: " + m.getActor(),
                                    c.getName(), JOptionPane.PLAIN_MESSAGE,
                                    new ImageIcon("src/img/" + m.getName() + ".png"));
                        }
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        new Oscars().conf();
    }
    
}