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
public class Productor extends Thread {
      int cuentaproducidosparcial,cuentaproducidostotal,productorduerme;
      Buffer buffer;
      Random aleatorio;
      Interfaz ventana;
      
    Productor(Buffer bp, Interfaz vp)
    {
        this.buffer=bp;
        this.ventana=vp;
        cuentaproducidosparcial=0;
        cuentaproducidostotal=0;
        productorduerme=0;
        aleatorio = new Random();
    }
      
      @Override
    public void run()
    {
        while(true)
        {
            System.out.println(buffer.obtenNumeroElementos());
      
      int elemento = aleatorio.nextInt(99)+1;
      //esto se esta guardando en la copia que productor tiene del buffer
     if(buffer.cuentabuffer<34)
     {
        buffer.buffer.set(cuentaproducidostotal,elemento); 
         cuentaproducidostotal++;   
     }
      if(buffer.cuentabuffer==35) 
      {
       cuentaproducidostotal=0;   
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
                //Si esta lleno el buffer duerme al productor y despierta al consumidor
             
                if(cuentaproducidostotal==34)
                {
                      try {
              this.buffer.consumidor(productorduerme);
          } catch (InterruptedException ex) {
              Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
          }
                }
        
        }
    }
}
