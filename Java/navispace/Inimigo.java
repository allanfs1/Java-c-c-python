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
import java.net.URL;

/**
 *
 * @author allan
 */

public class Inimigo  extends Movel{
private Image img;
private double VelocidadeX = DIFICULT;
public static int DIFICULT =  1;
private int x,y;
private int largura,altura;
public static int cont = 1;
private String arquivo = "Inimigo.png"; 
private ImageIcon icon;
/////audio////
public String audio = "jet_doppler2";
public AudioClip audioclip;

    Inimigo(int x,int y){
         
          this.x = x;
          this.y = y;
          
          cont++;
          if(cont % 2 == 0)
          icon = new ImageIcon(NaviSpace.class.getResource(arquivo));
         
       
         else{
            arquivo = "InimigoOmega.png";  
            icon = new ImageIcon(NaviSpace.class.getResource(arquivo));
         }
          img = icon.getImage();
          
          visible = true;
          
          this.largura =  img.getWidth(null);
          this.altura = img.getHeight(null);
  
    }
                 /////Classes para execultar o audio///
       public void somAdioclip(String audio){ 
        URL url = NaviSpace.class.getResource(audio+".wav");
        audioclip = Applet.newAudioClip(url); 
        
        if(Fundo.pararSFX == true)
           audioclip.play();
        
        else
            audioclip.stop();
        
         
    }
       
  
    public void mexerInimigo(){
        
        if(this.x < -50){
             this.x =NaviSpace.TAMANHO+x;
             VelocidadeX =  Math.abs(Math.ceil(Math.random()*DIFICULT));
            //  somAdioclip(audio);
             
        }
        
        else {
          
            
            this.x -= VelocidadeX ;
        }
    
    }
    
  
    @Override
    public void setx(int x) {
      this.x = x;
    }

    @Override
    public void setY(int y) {
       this.y = y; 
    }

    @Override
    public Image  getImage() {
      return img;
    }

    @Override
    public int getx() {
      return this.x; 
    }

    @Override
    public int getY() {
       return this.y;
    }
    
    
   @Override
    public void  setVisible(boolean visible) {
       this.visible = visible;
    }
    
    
    public boolean getVisible() {
       return this.visible;
    }
    

public Rectangle getBlondsInimigo(){
    return new Rectangle(x,y,largura,altura);
}

    
   
}
