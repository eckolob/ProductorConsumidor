/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class Buffer {
    int cuentabuffer;
    ArrayList<Integer> buffer;
    
    
    Buffer()
    {
        buffer = new ArrayList();
        cuentabuffer=0;
          for(int a=0;a<35;a++)
    {
        this.buffer.add(a,null);
    }
    }
            
   public synchronized  void  productor(int productorduerme) throws InterruptedException
   {
      
       while(productorduerme==1)
       {
           wait();
       }
       
     
       //en x momento el productor llama a este metodo sincronizado y si la condicion no entra en el while
       //entonces despierta al consumidor(en este punto se supone que ya hizo su tarea el productor)
       notifyAll();
   }
   
    public synchronized  void  consumidor(int consumidorduerme) throws InterruptedException
   {
       
       while(consumidorduerme==1)
       {
           
           wait();
       }
      
       
   
       //en x momento el consumidor llama a este metodo sincronizado y si la condicion no entra en el while
       //entonces despierta al productor(en este punto se supone que ya hizo su tarea el consumidor)
      notifyAll();
   }
    
    
    public int obtenNumeroElementos()
    {
        //Cada que se invoca este metodo es porque se produjo un elemento, 
       //Cada que se agrega un elemento guarda la suma de los elementos actualmente en buffer en la variablecuentabuffer
        cuentabuffer=0;
        for(int a=0;a<buffer.size()-1;a++)
       {
           if(buffer.get(a)!=null)
           {
               cuentabuffer++;
           }
          
          
       }
        return cuentabuffer;
    }
}
