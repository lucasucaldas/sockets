/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomessengertest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketcontroller.SocketController;

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SocketController sc = null;
        
        try {
            sc = new SocketController("127.0.0.1", 21212);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(sc != null){
            final SocketController sc2 = sc;
            
            sc2.writeText("REGISTER usuario9");
            sc2.start(() -> {
                while (true){
                    System.out.println(sc2.readText());
                }
            }); 
        }
    }
}
