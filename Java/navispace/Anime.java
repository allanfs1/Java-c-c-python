/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author allan
 */
public class  Anime extends JPanel implements ActionListener{
private Timer tempoGifs;
private int  delay=50,FrameTotal=31,FrameCurrent=0;
private ImageIcon []arrayGifs;
  
    Anime(){
        
      
   arrayGifs = new ImageIcon[FrameTotal]; 
   for(int i=1;i<arrayGifs.length;i++){
       arrayGifs[i] = new ImageIcon (getClass().getResource("\\gifsSet\\"+"terra"+i+".gif"));  
      //System.out.println(arrayGifs[i]);
   }
     
     tempoGifs = new Timer(delay,this);
     tempoGifs.start();
      
    }
    
 
 public void  paintComponent(Graphics ge){
                    super.paintComponent(ge);
                    
                    if(FrameCurrent >= arrayGifs.length)
                     FrameCurrent =0;   
  
                     FrameCurrent++; 
                     arrayGifs[FrameCurrent].paintIcon(this, ge,-100, 0);
                    // ge.drawImage(arrayGifs[FrameCurrent].getImage(), 0, 0, this);
                    
                 }

    @Override
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
           
    
    
    
    
    
    
    
    
    
}
