/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author allan
 */
public class Navi extends JPanel implements ActionListener{  

    private Navi navi;
    private Image imagen;
    private Timer tempo;
    private Timer TempoTiro;
    private int x,y;
    private int dx,dy;
    private static float velocidadeX = 1.6f;
    private List<Misseis> missel;
    private int millis = 1000;
    private boolean ativaTempo = false;
    private int largura,altura;
    private boolean visible;
    
    /////audio////
    private String audio = "laser_x";
    
            Navi(){
                 
                  visible = true;
                  ImageIcon icnavi = new ImageIcon(NaviSpace.class.getResource("nave.gif"));    
                  imagen = icnavi.getImage();
                  this.x =10;
                  this.y = 250;   
                  missel = new ArrayList<Misseis>();
                  
                   TempoTiro = new Timer(millis,this);
                   TempoTiro.start();
                   
                    this.largura =  imagen.getWidth(null);
                    this.altura = imagen.getHeight(null);
                   
            }
            
            
                        /////Classes para execultar o audio///
       public void somAdioclip(String audio){
        URL url = NaviSpace.class.getResource(audio+".wav");
        AudioClip audioclip = Applet.newAudioClip(url);
        audioclip.play();
    }
      
            
  public void mexer(){
 //System.out.println("x=" +x +"\t" + "y=" +y);  
 
     this.x += dx;
     this.y += dy;
       
   if(this.x < 0)
    this.x =  5;   
      
  if(this.x  > 720)
   this.x = 720;  
   
  if(this.y < 0 )
    this.y = 1;
  
 if(this.y > 400)
    this.y = 400;  
 
     
 
 
  }

  
   @Override
    public void actionPerformed(ActionEvent e) {
       ativaTempo = true;
        
    }
          
  
  ///Logica Para Tempo do Tiro////
 public void atirar(){
    this.missel.add(new Misseis(this.x+40,this.y-10));
 } 
  
    public void keyPressed(KeyEvent e){

      if(e.getKeyCode() == KeyEvent.VK_SPACE){     
       if(ativaTempo == true){
        atirar(); 
        ativaTempo = false;
        somAdioclip(audio);
        }

       }
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
           dy+=velocidadeX; 
       }
        if(e.getKeyCode() == KeyEvent.VK_UP){
         
           dy-=velocidadeX;      
       }
       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           dx +=velocidadeX;
       }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
          dx -=velocidadeX;
       }
     //---------------------------------------------------------------------
    }

 
       public void keyReleased(KeyEvent e)  {
         //ply.setIcon(gif_1);
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
      
       }
          
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
          dy =0; 
              
       }
        if(e.getKeyCode() == KeyEvent.VK_UP){
           dy =0; 
       }
        
       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            dx =0; 
       }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            dx =0;
       }  
       
     //----------------------------------------------------------------------    
    } 

         public  Image getImage(){
             return imagen;
         }
         
          public  int getY(){
             return y;
         }
          
            public  int getX(){
             return x;
         }
               
            
       public void  setVisible(boolean visible) {
        this.visible = visible;
       }
    
    
    public boolean getVisible() {
       return this.visible;
      }
    
               
            
           public  List<Misseis> getMissel(){
             return missel;
         }

           
           public Rectangle getBlondsNavis(){
           return new Rectangle(x,y,largura,altura);
          }
           
     
    
}
