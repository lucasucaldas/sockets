/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class SocketController {
    
    private Thread theThread = null;
    private Socket theSocket = null;
    private PrintWriter theOut = null;
    private BufferedReader theIn = null;
    
    
    private void initStream(Socket newSocket) throws IOException{
        
        OutputStream outStream = null;
        InputStream inStream = null;
        
        outStream = newSocket.getOutputStream();
        inStream = newSocket.getInputStream();
        
        theOut = new PrintWriter(outStream, true);
        theIn = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
    }
    
    public SocketController(String newHost, int newPort) throws IOException{
        theSocket = new Socket(newHost, newPort);
        initStream(theSocket);
    }
    
    public SocketController(Socket newSocket) throws IOException{
        theSocket = newSocket;
        initStream(newSocket);
    }
    
    public Thread start(Runnable r){
        theThread = new Thread(r);
        getTheThread().start();
        
        return getTheThread();
    }
    
    public void close() throws IOException{
        getTheSocket().close();
    }

    /**
     * @return the theThread
     */
    public Thread getTheThread() {
        return theThread;
    }

    /**
     * @return the theSocket
     */
    public Socket getTheSocket() {
        return theSocket;
    }
    
    public String readText(){
        try {
            return theIn.readLine();
        } catch (IOException ex) {
            return null;
        }
    }
    
    public void writeText(String newText){
        theOut.println(newText);
    }
    
    public String writeReadText(String newText){
        
        writeText(newText);
        
        return readText();
    }
    
}
