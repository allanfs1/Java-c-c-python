/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author allan
 */

public class Chonometro  extends JPanel implements ActionListener{
  private Timer tempo;
  private int segundos=0;
  private int minutos=0;
  
    Chonometro(){
           tempo = new Timer(1000,this);
           tempo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
     chonometroConta();   
    }
    
   
    public int getSegundos(){
        return chonometroConta();
    }
    
    public int getMinutos(){
        return this.minutos;
    }
    
    public int chonometroConta(){
            
           if(this.segundos < 60){
            System.out.println(segundos);  
            return segundos++; 
            }
                
             else
              minutos++;
              return segundos = 0;
  
    }
   
   
    
}
