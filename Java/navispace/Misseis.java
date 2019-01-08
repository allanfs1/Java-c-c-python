/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



public class Misseis {
private int x,y;  
private Image img;
private boolean visible;
public static int TAMANHOTELA = NaviSpace.TAMANHO;
protected int  VELOCIDADE = 1;
private int largura,altura;
   
    Misseis(int x,int y){
        
                  this.x = x;
                  this.y = y;
                  ImageIcon iconMisse = new ImageIcon(NaviSpace.class.getResource("Missel.gif"));    
                  img = iconMisse.getImage(); 
                   visible = true; 
                    this.largura =  img.getWidth(null);
                    this.altura = img.getHeight(null);
                   
    }
    
    
    
    
    
    public void mexerMiss(){
        this.x += VELOCIDADE;
       if(this.x > TAMANHOTELA)
           visible = false;          
  
     else
           visible = true; 
     
    }
    
    
    
     public  Image getImage(){
             return img;
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
    
            
            
           public  boolean getvisible(){
             return visible;
         }
    
           public Rectangle getBlondsMisseis(){
           return new Rectangle(x,y,largura,altura);
}
           
    
}
