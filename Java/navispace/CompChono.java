/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Timer;

/**
 *
 * @author allan
 */


public class CompChono {
    private URL url;
    private String arquivoSFX = "alarm_beep";
       ///Chonometro///
    private Timer timer;

    private String  covetSegundos;
    private String  covetMinutos;
    private int segundos=0;
    private int minutos=0;
    
    CompChono (){
       cotador();   
       SFXaudiclip(arquivoSFX);
    }
    
    
    public void SFXaudiclip(String som){
       url = NaviSpace.class.getResource(arquivoSFX+".wav");
       AudioClip somAudioclip = Applet.newAudioClip(url);
       somAudioclip.loop();
       
    }
    
    
  public void cotador(){
  ActionListener action = new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
           
           if(segundos < 60){
             segundos++; 
            }
                
           else{
              minutos++;
              segundos = 0;
        
           }
        
      covetSegundos = Integer.toString(segundos);
      covetMinutos =Integer.toString(minutos); 
    }
    
      };
  
   timer = new Timer(1000,action);  
   timer.start();
};
  
   public void setSeundos(int segundos){
       this.segundos=  segundos;
  }
  
  
   public void setMinutos(int minutos){
       this.minutos  = minutos;
  }
  
  
  
  
  public String getSeundos(){
      return  covetSegundos;
  }
  
  
   public String getMinutos(){
      return  covetMinutos;
  }
  
}


