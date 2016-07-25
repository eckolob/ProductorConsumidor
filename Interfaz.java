/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;



/**
 *
 * @author Marcos
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class Interfaz  extends Thread{
	JFrame ventana;
        JTextArea areabuffer;
        JScrollPane scrollbuffer;
        JLabel et_productor,et_consumidor;
        JTextField txt_productor,txt_consumidor;
        boolean I_esc=false; 
        
        
	public Interfaz() {
        ventana =new JFrame();
        ventana.setLayout(null);
       areabuffer = new JTextArea();
       areabuffer.setEditable(false);
       scrollbuffer = new JScrollPane(areabuffer);
       scrollbuffer.setBounds(20, 20, 400, 200);
       ventana.add(scrollbuffer);
       
       
       et_productor = new JLabel();
       et_productor.setText("Productor:");
       et_productor.setBounds(20, 220, 100, 20);
       ventana.add(et_productor);
       
       txt_productor = new JTextField();
       txt_productor.setEditable(false);
       txt_productor.setBounds(100,220,200,20);
       ventana.add(txt_productor);
       
       et_consumidor = new JLabel();
       et_consumidor.setText("Consumidor:");
       et_consumidor.setBounds(20, 240, 100, 20);
       ventana.add(et_consumidor);
      
       txt_consumidor = new JTextField();
       txt_consumidor.setEditable(false);
       txt_consumidor.setBounds(100,240,200,20);
       ventana.add(txt_consumidor);
		
	}   
        
        @Override
      public void run()
      {
           KeyListener listener = new KeyListener() {
             Interfaz listen = new Interfaz();
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			
                                if("Escape".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                    System.out.println("Ya me quiero ir..");
                                 
                                }
                          
                          
			}
           
              
 	
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
                        
		};
            
          
            
              
		ventana.addKeyListener(listener);
		ventana.setFocusable(true);
		
		 ventana.setLocation(300, 150);
        ventana.setResizable(true);
        ventana.setVisible(true);
        ventana.setSize(450, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
      }
	