/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication38;

/**
 *
 * @author allan
 */
public class ContaFR {
    private float c,f;
    
   public void setFarenits(float farenits){ 
       this.f = farenits;
   }
   public float getFarenits(){
     return this.f; 
   }
   
   
    public void setcelsis(float celsis){
       this.c = celsis;
   }
    
    public float getCelsis(){
       return c;
   }
    
    
    /////Conta/////
    public float getFarenitsConta(){
        float conta = (getCelsis() *1.8f) + 32f; 
        return conta;
    }
   
    
     public float getCelsisConta(){
        float conta = (getFarenits() - 32)/ 1.8f;
        return conta;
    }
   
        
}
