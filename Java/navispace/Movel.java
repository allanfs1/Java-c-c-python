/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.Image;

/**
 *
 * @author allan
 */
public abstract class Movel {
    
    
    protected int altura;
    
    protected int largura;
    
    protected int VelocidadeX;
    
    protected int VelocidadeY;
    
    protected boolean visible;
    
 
    public abstract void  setx (int x);
    
    public abstract void  setY (int y);
    
    public abstract Image getImage ();
    
    public abstract int   getx ();
    
    public abstract int   getY ();
    
    
   public abstract void setVisible(boolean visible); 
    
   public abstract boolean getVisible();
     
 
}
