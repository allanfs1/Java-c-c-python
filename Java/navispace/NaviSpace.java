/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navispace;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.border.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

public class NaviSpace extends JFrame {
    /**
     * @param args the command line arguments
     */
   // private int x,y;
  //  private int dx,dy;
    private  Navi navi;
    private int PADRAO = 500;
    public static int TAMANHO = 800; 
    public static int  BTNWIT= 250;  
    public static int  BTNWITHD = 40;
    private Font font = new Font("verdade",Font.BOLD,45);
    ImageIcon iconFogo = new ImageIcon(NaviSpace.class.getResource("Logo.jpg"));
    private JMenuBar mubar;
  
private Timer tempoGifs;
private int  delay=50,FrameTotal=31,FrameCurrent=0;
private ImageIcon []arrayGifs;

    NaviSpace(){ 
        
      //painelJogoPainer();
      painelJogo();
      contruirTela(); 
      contruirJanela();
    
    }
    
    

  
    
      public JMenuBar painelJogo(){
        Font font = new Font("verdade",Font.BOLD,11); 
        JPanel jp = new JPanel();
        JPanel jp_1 = new JPanel();
        mubar = new JMenuBar();
        JMenu bar = new JMenu("File");
        JMenu  bar2 = new JMenu("Edit");
        JMenu  bar3 = new JMenu("Difficulty");
        JMenu  bar4 = new JMenu("Options");
        JMenuItem jmt = new  JMenuItem("Jogo Space Nave");
        JMenuItem item = new JMenuItem("restart");
        JMenuItem item2 = new JMenuItem("exit");
        JMenuItem item3 = new JMenuItem("audio");
        JMenuItem item4 = new JMenuItem("Instruct");
        JCheckBoxMenuItem checkEasy = new JCheckBoxMenuItem("Easy");
        JCheckBoxMenuItem checkHard = new JCheckBoxMenuItem("Hard");
        JCheckBoxMenuItem checkMediu = new JCheckBoxMenuItem("Mediu");
                /////Formatação de Font////
        item.setFont(font);item2.setFont(font);         
        item3.setFont(font);item4.setFont(font);
   
        ////Menu principal///
        mubar.setBackground(Color.GRAY);
        setJMenuBar(mubar);
     
        ///////Menu bar
        mubar.add(bar);
        mubar.add(bar2);
        mubar.add(bar3);
        mubar.add(bar4);
       
        bar.add(item);bar.add(item2);///Menu file
        bar2.add(item3);bar2.add(item4);///Menu edit
        bar3.add(checkEasy);bar3.add(checkHard);bar3.add(checkMediu);
        
        jp.setBackground(Color.LIGHT_GRAY);
        mubar.add(jp);
  
           ///////Painel////
        jp_1.setBackground(Color.black);
        jp_1.setSize(PADRAO,10);
        add(jp_1);
  
        return mubar ;
     
    }
    
 
    
    public void  painelJogoPainer(){
       ImageIcon icon = new ImageIcon(NaviSpace.class.getResource("Logo_02.jpg"));
       ImageIcon iconNavi = new ImageIcon(NaviSpace.class.getResource("nave.png"));
       JLabel iconImg = new JLabel(icon);
       JLabel iconNavimg = new JLabel(iconNavi);
  
       Font font = new Font("Serif",Font.BOLD,15);
       Font fontJogo = new Font("Serif",Font.BOLD,30);
       JPanel jp_pn = new JPanel();
       JButton btn = new JButton("Start");
       JButton btn2 = new JButton("Instructions"); 
       JButton btn3 = new JButton("Exit"); 
       JLabel jlab = new JLabel("Setup");
       //-----------------------------------------------------
       jp_pn.setBackground(new java.awt.Color(0,0,255,25));
       jp_pn.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
       jp_pn.setSize(PADRAO,TAMANHO);
       jp_pn.setLocation(100,100);
       add(jp_pn); 
 
  ////Botões////
 
      btn.setBounds(220,150+50,BTNWIT,BTNWITHD );
      btn2.setBounds(220,200+50,BTNWIT,BTNWITHD );
      btn3.setBounds(220,250+50,BTNWIT,BTNWITHD );
      btn.setBackground(Color.yellow);
      btn2.setBackground(Color.yellow);
      btn3.setBackground(Color.yellow);
      btn.add(iconNavimg);
      
      btn.setFont(font);btn2.setFont(font);btn3.setFont(font);
      add(btn);add(btn2);add(btn3); 
  
      
      jlab.setFont(fontJogo); 
      jlab.setLocation(250,250);
      jp_pn.add(jlab);
       
        ////LogoTipo do Jogo////
       iconImg.setLocation(100,0);
       iconImg.setSize(500,100);
       add(iconImg);
    ///---------------------------------------------------------------------------
                       ///Botão Exit////
           btn3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                      System.exit(0);
           }       
       });
                       /////Botão de isntruções///     
           btn2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              System.out.print("ok click");
           }    
             });
                         ////Botão Start////
           btn.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
             remove(btn);remove(btn2);remove(btn3);
             remove(jp_pn);remove(jlab);remove(iconImg);
             remove(painelJogo());
             mubar.setVisible(false);
             repaint();
            
           }
           
            });
 
    }
      
  
    

    public void contruirJanela(){ 
     
      setTitle("Nave Space");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(TAMANHO,500); 
      setLocationRelativeTo(null);
      setResizable(true);
      setVisible(true);
      setIconImage(iconFogo.getImage());///Icone do Jogo
      this.setLayout(null);   
      
   
    }
    

    public JPanel contruirTela(){
        Fundo fundo = new Fundo();
          add(new Fundo());
          return fundo;
          
    }
    
     
      public static void main(String[] args) {
        // TODO code application logic here 
        NaviSpace spc = new NaviSpace ();
        // spc.contruirJanela(); 
    
         
    }
    
}


