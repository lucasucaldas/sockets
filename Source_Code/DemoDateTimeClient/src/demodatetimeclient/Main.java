/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demodatetimeclient;

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
        
        SocketController sockCtrl = null;
        
        try {
            sockCtrl = new SocketController("127.0.0.1", 2300);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(sockCtrl != null){
            System.out.println(sockCtrl.readText());
            System.out.println(sockCtrl.writeReadText("Date"));
            System.out.println(sockCtrl.writeReadText("Time"));
            System.out.println(sockCtrl.writeReadText("DateTime"));
            System.out.println(sockCtrl.writeReadText("Invalid Command"));
            
            try {
                sockCtrl.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
