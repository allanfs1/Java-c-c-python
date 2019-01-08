/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author allan
 */
public class Deriva extends JPanel  {
 
  Deriva(){
    setFocusable(true);
    setDoubleBuffered(true);
    addKeyListener(new TecladoAdapter()); 
    
    
            
  }
  

     
     
     private  class TecladoAdapter extends KeyAdapter{      
        public void KeyPressed(KeyEvent e){
          
              //System.out.println("Precionar");
              
            }
                
               public void keyReleased(KeyEvent e){
             
                  // System.out.println("Soutar");
                }
                
           }
    
    
    //
}
