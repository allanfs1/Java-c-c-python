/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author allan
 */
public class InimigoBravo  extends Movel{
    
private Image img;
private int VelocidadeX = DIFICULT;
public static int DIFICULT =  2;
private boolean visible = false;
private int x,y;
private static int cont=0;


private ImageIcon icon;   
    InimigoBravo(int x,int y){
        this.x = y;
        this.y = y;
        cont++;
        
     if(cont % 2 == 0)
          icon = new ImageIcon(NaviSpace.class.getResource("InimigoAlpha.png"));
   
         else
            icon = new ImageIcon(NaviSpace.class.getResource("InimigoBravo.png"));
     
         
        img = icon.getImage();
        
        this.largura =  img.getWidth(null);
        this.altura = img.getHeight(null);
        
        this.visible=true;
    }
    
   
    
    public void mexerBravo(){
  
      if(this.x < -100)
          this.x = NaviSpace.TAMANHO;
      
        else
           x -= VelocidadeX; 
          
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
    public Image getImage() {
     return img;
    }

    @Override
    public int getx() {
      return x; 
    }

    @Override
    public int getY() {
       return y;
    }

   
@Override
    public void setVisible(boolean visible) {
      this.visible = visible;
    }
    
    
    
    @Override
    public boolean getVisible() {
      return this.visible;
    }

 public Rectangle getBlondsInimigoBR(){
    return new Rectangle(x,y,largura,altura);
}

   
   
    
}
