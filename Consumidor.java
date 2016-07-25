/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Consumidor extends Thread{
    int cuentaconsumidosparcial,cuentaconsumidostotal,consumidorduerme;
     Buffer buffer;
     Random aleatorio;
     Interfaz ventana;
     
     Consumidor(Buffer bc, Interfaz vc)
     {
         this.buffer=bc;
         this.ventana=vc;
         cuentaconsumidosparcial=0;
         cuentaconsumidostotal=0;
        consumidorduerme=0;
         aleatorio = new Random();
         
     }
     
    @Override
    public void run(){
        //Mientras no este vacio el buffer consume
        
        
        while(true)
        {
            if(buffer.cuentabuffer>0)
            {
                 buffer.buffer.set(cuentaconsumidostotal,null);
             cuentaconsumidostotal++;  
            }
            if(buffer.cuentabuffer==0) 
                {
                 cuentaconsumidostotal=0;   
                 }
         
          
        
         String bf="";
                for(int z=0;z<buffer.buffer.size();z++)
                {
                     if(buffer.buffer.get(z)==null)
                    {
                         bf+=z+1+":"+" "+"\t";
                    }else{
                          bf+=z+1+":"+buffer.buffer.get(z)+"\t";
                     }
                    if((z+1)%5==0)
                    {
                        bf+="\n";
                    }
                    
                
                }
                     try {
                           ventana.areabuffer.setText(bf);
              Thread.sleep(500);
          } catch (InterruptedException ex) {
              Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
          }
               //Si esta vacio el buffer duerme al consumidor y despierta al productor
               
                     if(cuentaconsumidostotal==35)
                     {
                       try {
              
              this.buffer.productor(consumidorduerme);
          } catch (InterruptedException ex) {
              Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
          } 
                     }
          
        }   
    
    
    }
}
