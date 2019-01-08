/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication38;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;//
import java.awt.GridBagConstraints;//
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;




/**
 *
 * @author allan
 */
public class Conta extends JFrame implements ActionListener   {
    /**
     * @param args the command line arguments
     */
    private String [] colunas = {"F:graus  ","32.0F"}; 
    private String [] colunasNova = {"C:Celcius","0.0C"}; 
    private ContaFR contas;
    JTextField txt2;///Globais
    JTextField  txt;///Globais
    JButton btn2;
    JButton btn1;
    JButton  rec;
    JTextField respTex,respTex2 ;
    String aux,aux2;
    String erro = "Erro 101: Erro de Conflito de Calculo";
    
    public Conta(){
       PainelP();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("Graus");
       this.setSize(530,230);
       this.setVisible(true);
       this.setLocationRelativeTo(null); 
       this.setResizable(true);
       this.setLayout(null);
      // this.pack();
       PainelDialog();
    }
    
      public void PainelP(){
        GridBagConstraints  grade = new  GridBagConstraints(); 
        JPanel  jp = new JPanel();
        rec = new JButton("Reset");
        JComboBox box = new JComboBox(colunasNova);
        JComboBox box2 = new JComboBox(colunas);
        JLabel lb = new JLabel();lb.setText("Celcius");
        JLabel lb2 = new JLabel();lb2.setText("Farenheit");
        respTex =  new JTextField(3);
        respTex2 =  new JTextField(3);
        txt = new JTextField(6);
        txt2 = new JTextField(6);
   
       jp.setBackground(new java.awt.Color(0, 0, 255, 5)); 
       jp.setBorder(BorderFactory.createTitledBorder(
       BorderFactory.createEtchedBorder(10, Color.lightGray, Color.BLACK),"Conveter"));
       //jp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
       //jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),"login"));
       lb.setBorder(BorderFactory.createDashedBorder(Color.GRAY, 5.0f, 5.0f));
       lb2.setBorder(BorderFactory.createDashedBorder(Color.GRAY, 5.0f, 5.0f));
       add(jp);
       jp.setLayout(new GridBagLayout());
       ///-------------------------------------------------------------------------------------------------------------
       grade.gridy = 0; 
       grade.gridx = 0; 
       
       ///Maskara//////-----------------------------------------------------------------------------------------
//try{
      // javax.swing.text.MaskFormatter maskRes0= new javax.swing.text.MaskFormatter("########/C");
      // javax.swing.text.MaskFormatter maskRes= new javax.swing.text.MaskFormatter("########/F");
     //  respTex = new javax.swing.JFormattedTextField(maskRes);
     //  respTex2 = new javax.swing.JFormattedTextField(maskRes0);
   //  }

//catch(Exception e){
    //  JOptionPane.showMessageDialog(null, e);
//}


///---------------------------------------------------------------------------------------------------------------------
      ///Texto////
       //grade.fill = GridBagConstraints.HORIZONTAL;
       grade.insets = new Insets(0,0,10,150);
       grade.gridx =0;
       grade.gridy = 0; 
       jp.add(txt,grade);
          ////Resposta Conta///
      grade.insets = new Insets(0,90,10,0);
      grade.gridx =0;
      grade.gridy =0; 
      jp.add(respTex ,grade);
      ////Texto Conta 2
       grade.insets = new Insets(0,0,20,150);
       grade.gridx =0;
       grade.gridy =1; 
       jp.add(txt2,grade);
        ////Reposta conta 2
       grade.gridx =0;
       grade.gridy =1;
       grade.insets = new Insets(0,90,20,0);
       jp.add(respTex2 ,grade);
    ///Botôes///
       grade.gridy = 0; 
       grade.gridx = 0;  
       btn1 = new JButton("Celcius");
       grade.insets = new Insets(0,40,95,0);
       jp.add(btn1,grade);
       btn2 = new JButton("Farenheit");
       grade.insets = new Insets(0,0,95,130);
       jp.add(btn2,grade);
       ///Label///
       grade.gridy = 0; 
       grade.gridx = 0; 
       grade.insets = new Insets(0,0,10,400);
       jp.add(lb,grade);
      
       grade.gridx = 0;
       grade.gridy = 1; 
       grade.insets = new Insets(0,0,20,400);
       jp.add(lb2,grade);
      
       grade.gridx = 0;
       grade.gridy = 0; 
       grade.insets = new Insets(0,300,10,0);
       jp.add(box,grade);
       grade.gridx = 0;
       grade.gridy = 1; 
       grade.insets = new Insets(0,300,20,0);
       jp.add(box2,grade);
   
      ///Reset////
      grade.insets = new Insets(0,358,95,0);
      grade.gridx =0;
      grade.gridy =0; 
      jp.add(rec,grade);
 
       ////Eventos do Mouse///
       btn1.addActionListener(this);
       btn2.addActionListener(this);
       rec.addActionListener(this);
       txt.addActionListener(this);
       compara();
 
  
     }

       public void actionPerformed(ActionEvent evt){
          ContaFR ctt = new ContaFR(); 
          int resposta;

             if(evt.getSource() == btn2){
                 // txt.setText("");
                //  txt2.setText("");
                  
                  aux = txt.getText();//Armazena na  axiliar
                  int  conv = Integer.parseInt(aux);//Converte dados para inteiro
                  ctt.setcelsis(conv);///Seta meu celsis
                  
                  float cot = ctt.getFarenitsConta();////Faz a conta
                  String respostaF = Float.toString(cot);////Coverte um float para String
                  respTex.setText(respostaF);
            
                                  ////Caixas de dialogo////
                  resposta = JOptionPane.showConfirmDialog(this,"Deseja Permaneser", "Sair",JOptionPane.YES_OPTION);
                   if(resposta == JOptionPane.YES_OPTION)
                       JOptionPane.showMessageDialog(this,"Sucesso");
                   
                        else
                          JOptionPane.showMessageDialog(this,"Cancelado");
                       
                  }
   
              if(evt.getSource() == btn1 ){
                 //-----------------------------------------------------------------------------------------------
                 // txt2.setText("");
                 // txt.setText("");
                  
                  aux2 = txt2.getText();//jogar na aux
                  float ct2 = Integer.parseInt(aux2);///converte um String para float
                  ctt.setFarenits(ct2);///Setar os Farenats
                  
                  float cot2 = ctt.getCelsisConta();///Fazer a conta
                  String respostaC = Float.toString(cot2);////Coverte conta para String
                  respTex2.setText(respostaC);///Mostra na caixa de texto
                  
                                 ///Caixas de dialogo////
                  resposta = JOptionPane.showConfirmDialog(this,"Deseja Permaneser", "Sair",JOptionPane.YES_OPTION);
                   if(resposta == JOptionPane.YES_OPTION)
                       JOptionPane.showMessageDialog(this,"Sucesso");
                        else
                          JOptionPane.showMessageDialog(this,"Cancelado");
              }
                      
                        ////Limpar a caixa de texto////
                          else  if(evt.getSource() == rec){
                           txt.setText("");txt2.setText("");respTex.setText("");respTex2.setText("");
                          }
      
       }
       
 
     public void PainelDialog(){
        JPanel pn= new JPanel();
        JPanel pn2= new JPanel();
        JPanel pn3= new JPanel();
        JPanel pn4= new JPanel();
        /////Menu Graus///
        pn.setSize(70,135);
        pn.setBackground(new java.awt.Color(10, 25, 20,5));
        pn.setLocation(22,40);
        pn.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createDashedBorder(Color.GRAY, 1.0f, 1.0f),"Graus"));
        add(pn);
        ////Painel2////
        pn2.setSize(120,135);
        pn2.setBackground(new java.awt.Color(10, 25, 20,5));
        pn2.setLocation(350,40);
        pn2.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createDashedBorder(Color.GRAY, 1.0f, 1.0f),"Menu"));
        add(pn2);
        ////Caixas botões/// 
        pn3.setSize(180,30);
        pn3.setBackground(new java.awt.Color(10, 25, 20,5));
        pn3.setLocation(141,16);
        pn3.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createDashedBorder(Color.GRAY, 1.0f, 1.0f)));
        add(pn3);
        ////Caixas grade///
        pn4.setSize(250,122);
        pn4.setBackground(new java.awt.Color(10, 25, 20,5));
        pn4.setLocation(95,50);
        pn4.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createDashedBorder(Color.GRAY, 1.0f, 1.0f)));
        add(pn4);
    
      
     }
     
    private  void compara() {
      txt.setText("Exemplo:27.0");
      txt2.setText("Exemplo:80.0");
      respTex.setText("/F");
      respTex2.setText("/C");
        

        ////Condições///
       if(txt.getText().equals("Exemplo:") || txt2.getText().equals("Exemplo:")){
           txt.setText("");txt2.setText(""); respTex.setText("");}
       

            
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
       Conta ct = new Conta();
       

    }


    
}
