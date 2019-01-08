/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */    
package navispace;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author allan
 */

public class Fundo  extends JPanel implements ActionListener{
private Image imagen,gifs; 
private Navi navi;
private Timer tempo; 
private int x,y;
private Inimigo in;
List<Misseis> miss;
List<Inimigo> inimigo;
List<InimigoBravo> inimigoBR;
private boolean jogo;
private Font fontContador = new Font("Impact",Font.PLAIN,35);
private Font fontCrono = new Font("Arial",Font.BOLD,50);      
private Font font = new Font("Serif",Font.BOLD,10);
private int contador=0,largura;
public static boolean  colide = false; 
ImageIcon restart = new ImageIcon(NaviSpace.class.getResource("gameOver.gif")); 
CompChono  cho;
/////audio////
AudioClip audioclip;
private String audio = "floop_sfx";
public static boolean pararSFX = true;
boolean travaSFX = false; 


private Timer tempoGifs;
private int  delay=1000,FrameTotal=10,FrameCurrent=0;
private ImageIcon arrayGifs[];
private ImageIcon terra;
private ImageIcon planeta,jupiter;

private int matrizEule[][] = { {1900,91},{2500,364},
                               {1500,273},
                               {1400,364},
                               {600,91},
                            
                                                    };

private int matrizBravo[][] = { {2900,497},{3000,213},
                               {3600,142},{4700,355},
                               {2400,213},
                               {3600,284},
                                                               };

 
    
     Fundo(){ 
               
                 
                  somAdioclip(audio);///Som de Inicializar////
                  audio = "sonar_x";
                  somAdioclip(audio);
                  //--------------------------------------------------
                  setFocusable(true);
                  setDoubleBuffered(true);
                  jogo = true;
                  cho = new CompChono();
                  
                  addKeyListener(new TecladoAdapter()); 
                  ImageIcon fundopng = new ImageIcon(NaviSpace.class.getResource("fundo.png"));
                  imagen = fundopng.getImage();
                  terra = new ImageIcon(NaviSpace.class.getResource("terra.gif"));
                  planeta = new ImageIcon(NaviSpace.class.getResource("Planeta.gif"));
                  jupiter = new ImageIcon(NaviSpace.class.getResource("Jupiterct.gif"));
                  
                  navi = new  Navi();
                  this.x = 250;
                  this.y = 0; 
                  tempo = new Timer(5,this);     
                  tempo.start();
                  ChamaInimigo();
                  ChamarInimigoBR();                
                  largura = imagen.getWidth(null);
                
                  
            }
     
     

               
               /////Classes para execultar o audio///
       public void somAdioclip(String audio){ 
        URL url = NaviSpace.class.getResource(audio+".wav");
        audioclip = Applet.newAudioClip(url);   
        audioclip.play();   
         
    }
       
  

         public void ChamaInimigo(){
               inimigo = new ArrayList<Inimigo>();
               for(int i=0;i<matrizEule.length;i++){
                    this.inimigo.add(new Inimigo(matrizEule[i][0],matrizEule[i][1]));
                   
                }   
             
             }
         
           public void ChamarInimigoBR(){
               inimigoBR =  new ArrayList<InimigoBravo>(); 
             for(int i=0;i< matrizBravo.length;i++)
               this.inimigoBR.add(new InimigoBravo(matrizBravo[i][0],matrizBravo[i][1]));
               
           } 
                
    
        /*  */ public void paintComponent(Graphics grafico){ 
                
              super.paintComponent(grafico);
               //Graphics2D grafico = (Graphics2D) g; 
              // if(FrameCurrent >= arrayGifs.length)
              // FrameCurrent =0;   
               // FrameCurrent++; 
                       
                if( jogo == true){
                miss = navi.getMissel();////
                grafico.drawImage(imagen,0,0,null);
                grafico.drawImage(terra.getImage(),380,220,77,70,null); 
                grafico.drawImage(planeta.getImage(),0,0,null);
                grafico.drawImage(jupiter.getImage(),425,210,null);
                
                grafico.drawImage(navi.getImage(),navi.getX(),navi.getY(),null);
                ///---------------------------------------------------------------
                             
                                ///Legenda dos Player///
                            ////Indentificação da nave////
                grafico.setColor(new java.awt.Color(255,10,0,255));
                grafico.setFont(font);
                grafico.drawString("Play 1",navi.getX()+10,navi.getY()-10);
                /////////////////////////////////////////////////////////////
                         //////Misseis////Tiro Play
                for (int i=0;i< miss.size();i++){
                 Misseis m  =(Misseis) miss.get(i);
                 grafico.drawImage(m.getImage(),m.getX(),m.getY(),this);  
                    
                }
                
               grafico.setColor(new java.awt.Color(255,10,0,255));
               grafico.setFont(font);
                            ////Inimigo///
               for(int i=0;i<inimigo.size();i++){
               Inimigo inimi = (Inimigo) inimigo.get(i);
               grafico.drawImage(inimi.getImage(),inimi.getx(),inimi.getY(),this);
                           ///Legenda dos Player///
               grafico.drawString("FK-38",inimi.getx()+30,inimi.getY()-5);
               
               
              }
                        
         
                              ////Inimigo Bravo///////
             for (int i=0;i< inimigoBR.size();i++){
               InimigoBravo iniBravo = (InimigoBravo) inimigoBR.get(i);
               grafico.drawImage(iniBravo.getImage(),iniBravo.getx(),iniBravo.getY(),this);    
               grafico.drawString("Bravo-FS-11",iniBravo.getx()+30,iniBravo.getY()-5);
                                        
             }
             
            
              ////Componentes do Menu para Restart////
               grafico.setColor(Color.YELLOW);
               grafico.setFont(fontContador);
               grafico.drawString("Restante:"+ (inimigo.size()+inimigoBR.size()),largura-195,40);
               grafico.setColor(Color.BLUE);
               grafico.drawString("Quantidade:"+ contador,0,40);
               grafico.setFont(fontCrono);
               grafico.drawString( cho.getMinutos()+":"+cho.getSeundos(),largura/2,40);
           
              }
 
              else{
                 cho.setSeundos(0);//reset
                 cho.setMinutos(0);//reset
                 grafico.drawImage(restart.getImage(),0,0,null); 
                 pararSFX = false;
               
              }
                      
                 grafico.dispose();
              
            }
             
  
   
             ////Evento direto////

    @Override
    public void actionPerformed(ActionEvent e){   
        if(inimigo.size() == 0 && inimigoBR.size() == 0)
            jogo = false;
     
            //////Lista para disparar////
         miss = navi.getMissel();
         for (int i=0;i< miss.size();i++){
          Misseis m  =(Misseis) miss.get(i);
                            
                if(m.getvisible() == true)
                    m.mexerMiss();                    
     
                else
                    miss.remove(i); 
        
        }
         
           //////Verificar visibilidade e remover do leayer
       for(int i=0;i<miss.size();i++){
         Misseis missel  = (Misseis) miss.get(i);
            if(missel.getvisible() == false){
                  miss.remove(miss.get(i));       
                         
            }    
       }
       
   
          for(int j=0;j<inimigo.size();j++){
           Inimigo inimi = (Inimigo) inimigo.get(j);
              if(inimi.getVisible() == false )
                  inimigo.remove(inimigo.get(j));
         
              else
                   inimi.mexerInimigo(); 
         
          }
          
        
          for (int i=0;i< inimigoBR.size();i++){
           InimigoBravo iniBravo = (InimigoBravo) inimigoBR.get(i);
              if(iniBravo.getVisible() == false)
                 inimigoBR.remove(inimigoBR.get(i));

              else
                iniBravo.mexerBravo();
           }
            
    
          if(navi.getVisible()== false)
              jogo = false;
       
          
          checColisoes(); 
          navi.mexer(); 
          repaint();
         
    }
    
       /////Verificar colisões do inimigo com a nave ////
    public void checColisoes(){
        
        miss = navi.getMissel();
        Rectangle NaviRec = navi.getBlondsNavis();
        Rectangle misseisRec;
        Rectangle inimigoRec;
        Rectangle inimigoBRrec;
       
                ////Inimigos colide///
             // colisão da na com misseis
      for(int i=0;i<miss.size();i++){
           Misseis missel  = (Misseis) miss.get(i);
             misseisRec = missel.getBlondsMisseis();
             
           for(int j=0;j<inimigo.size();j++){ 
               Inimigo  inimi= (Inimigo) inimigo.get(j);      
               inimigoRec = inimi.getBlondsInimigo();
                  if(misseisRec.intersects(inimigoRec)){
                     contador++;
                     inimi.setVisible(false);
                     missel.setVisible(false);
                     audio = "explosion_x";         
                     somAdioclip(audio);   
                   
             }
                 
                     
                  
           } 
           
        }
      
            for(int j=0;j<inimigo.size();j++){ 
               Inimigo  inimi= (Inimigo) inimigo.get(j);
                 inimigoRec = inimi.getBlondsInimigo();
                         if(inimigoRec.intersects(NaviRec)){
                            navi.setVisible(false); 
                            inimi.setVisible(false);
                            audio = "explosion_x";
                            somAdioclip(audio);
                         }
            }
       
  
                      //InimigoBravo Colide///
    for(int i=0;i<miss.size();i++){
        Misseis missel  = (Misseis) miss.get(i);
           misseisRec  =   missel.getBlondsMisseis();                 
       for (int j=0;j< inimigoBR.size();j++){
            InimigoBravo iniBravo = (InimigoBravo) inimigoBR.get(j);
              inimigoBRrec = iniBravo.getBlondsInimigoBR();
        
             if(misseisRec.intersects(inimigoBRrec)){
               iniBravo.setVisible(false);
                missel.setVisible(false);
                audio = "explosion_x";
                somAdioclip(audio);
             }  
                 
           
       }
       
    }
    
     for (int j=0;j< inimigoBR.size();j++){
            InimigoBravo iniBravo = (InimigoBravo) inimigoBR.get(j);
              inimigoBRrec = iniBravo.getBlondsInimigoBR();
          if(inimigoBRrec.intersects(NaviRec)){
                 iniBravo.setVisible(false);
                 navi.setVisible(false);
                 audio = "explosion_x";
                 somAdioclip(audio);
               
             }
    
       
    }
    
 }
                  ///Eventos teclados///
       private  class TecladoAdapter extends KeyAdapter{      
        public void keyPressed(KeyEvent e){
                  if(jogo == false){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
              jogo= true;  
              ChamaInimigo();
              navi = new Navi();
              audio = "floop_sfx";
              somAdioclip(audio);
              audio = "jet_doppler2";
              somAdioclip(audio);
              audio = "sonar_x";
              somAdioclip(audio);
              pararSFX = true;
            }   
                }
               navi.keyPressed(e);  
   
            }
                
               public void keyReleased(KeyEvent e){
                  navi.keyReleased(e);
                   
                }
                
           }
       
 
    
         
    }

       
        
    

           
