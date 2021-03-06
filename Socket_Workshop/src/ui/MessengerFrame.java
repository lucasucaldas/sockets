/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import socketcontroller.SocketController;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Lucas
 */
public class MessengerFrame extends javax.swing.JFrame {

    private String nickName;
    private static String sentMessage;
    private static SocketController sc;
    private final String buzzPath = "src/sound/buzz.wav";
    private final String logInPath = "src/sound/login.wav";
    private final String incomingPath = "src/sound/incoming.wav";
    public DefaultListModel<String> registeredUsers;

    /**
     * Creates new form MessengerFrame
     */
    public MessengerFrame() {
        initComponents();
        startSocket();
    }

    public void setNickName(String newNickName) {
        this.nickName = newNickName;
    }

    public void startMessenger(String userName) {

        registeredUsers = new DefaultListModel<String>();
        jList1.setModel(registeredUsers);

        sc.writeText("REGISTER " + userName);
        playSound(logInPath);
        this.setTitle("User: " + userName);
        if (sc != null) {
            sc.start(() -> {
                String action = null;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MessengerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (sc.getThread().isAlive()) {
                    try {
                        action = sc.readText();
                        if (action != null) {
                            actions(action);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat window");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Public Messagess");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Private Messages");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Send message");

        jTextArea3.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setRows(5);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Connected Users");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jScrollPane5.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton3.setText("Buzz");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jMenuBar1.setToolTipText("");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setName(nickName);
        this.sentMessage = jTextArea3.getText();
        String nameToValidate = jList1.getSelectedValue();
        if (jList1.isSelectionEmpty()) {
            sc.writeText("SENDALL " + sentMessage);
        } else if (nameToValidate.toLowerCase().equals(nickName.toLowerCase())) {
            JOptionPane.showMessageDialog(null, "It's you!!!!" + "\n"
                    + "please select a different user name", "User Name Error", 0);
        } else {
            sc.writeText("SEND " + nameToValidate
                    + " " + sentMessage);
        }
        jTextArea3.setText("");
        jTextArea3.setCaretPosition(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_jTextArea3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.sentMessage = "Wake_up";

        if (jList1.isSelectionEmpty()) {
            sc.writeText("SENDALL Wake_up");
        } else if (jList1.getSelectedValue() == nickName) {
            JOptionPane.showMessageDialog(null, "It's you!!!!" + "\n"
                    + "please select a different user name", "User Name Error", 0);
        } else {
            sc.writeText("SEND " + jList1.getSelectedValue()
                    + " " + "Wake_up");
        }
        jTextArea3.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void actions(String messengerEvent) {
        String code = getCode(messengerEvent);
        String message = getMessage(messengerEvent);
        switch (code) {
            case "1001":
                JOptionPane.showMessageDialog(null, "Invalid User Name" + "\n"
                        + "please select a valid user name", "User Name Error", 0);
                break;
            case "1002":
                JOptionPane.showMessageDialog(null, "User Name already exist" + "\n"
                        + "please select a different user name", "User Name Error", 0);
                break;
            case "1003":
                JOptionPane.showMessageDialog(null, "User already registered",
                        "User Registered Error", 0);
                break;
            case "2000":
                if (sentMessage.equals("Wake_up")) {
                    sendPublicMessages("You say: Wake up");
                    break;
                }
                sendPublicMessages("You say: " + sentMessage);
                break;
            case "2010":
                String ms = getInfoPublicMessage(message, 1);
                if (ms.equals("Wake_up")) {
                    playSound(buzzPath);
                    buzz();
                    sendPublicMessages(getInfoPublicMessage(message, 0)
                            + " says: " + "Wake up");
                    break;
                }
                playSound(incomingPath);
                sendPublicMessages(getInfoPublicMessage(message, 0)
                        + " says: " + ms);
                break;
            case "4000":
                if (sentMessage.equals("Wake_up")) {
                    sendPrivateMessages("You say: Wake up");
                    break;
                }
                sendPrivateMessages("You say: " + sentMessage + "\n"
                        + "     to: "
                        + this.jList1.getSelectedValue());
                break;
            case "4010":
                String msp = getInfoPublicMessage(message, 1);
                if (msp.equals("Wake_up")) {
                    playSound(buzzPath);
                    buzz();
                    sendPrivateMessages(getInfoPublicMessage(message, 0)
                            + " says: " + "Wake up");
                    break;
                }
                playSound(incomingPath);
                sendPrivateMessages(getInfoPublicMessage(message, 0)
                        + " says: " + msp);
                break;
            case "1000":
                JOptionPane.showMessageDialog(null, "You are online", "User Connected", 1);
                break;
            case "5000":
                getConnectedUsers(message);
                break;
        }
        jList1.clearSelection();
    }

    private String getCode(String input) {
        return input.substring(0, 4);
    }

    private String getMessage(String input) {
        return input.substring(5, input.length());
    }

    private void getConnectedUsers(String input) {
        if (input.contains(";")) {
            String[] users = input.split(";");
            for (String user : users) {
                boolean contains = !registeredUsers.contains(user);
                if (contains) {
                    registeredUsers.addElement(user);
                }
            }
        } else {
            registeredUsers.addElement(input);
        }

    }

    public void sendPublicMessages(String input) {
        this.jTextArea1.append(input + "\n");
    }

    public void sendPrivateMessages(String input) {
        this.jTextArea2.append(input + "\n");
    }

    public String getInfoPublicMessage(String input, int type) {
        String[] extracted = input.split(" ");
        if(extracted.length > 2 && type != 0){
            String aux = "";
            for(int i = 1; i < extracted.length; i++){
                aux = aux + " " + extracted[i];
            }
            extracted[type] = aux;
        }
        return extracted[type];
    }

    private void startSocket() {
        try {
            sc = new SocketController("127.0.0.1", 21212);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n"
                    + "Please check your server" + "\n"
                    + "and restart the application", "Server Error", 0);
            System.exit(0);
        }
    }

    private void playSound(String sound) {

        Clip clip;
        File file = new File(sound);

        if (file.exists()) {
            AudioInputStream ais;
            try {
                ais = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(ais);
                clip.setFramePosition(0);
                clip.start();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(MessengerFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MessengerFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MessengerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new RuntimeException("Sound: file not found: " + buzzPath);
        }

    }

    private void buzz() {
        boolean flag = true;
        try {
            for (int i = 0; i < 12; i++) {
                if (flag) {
                    this.setLocation((int) (this.getLocation().getX() + 10), (int) (this.getLocation().getY() + 10));
                    Thread.sleep(50);
                    flag = false;
                } else {
                    this.setLocation((int) (this.getLocation().getX() - 10), (int) (this.getLocation().getY() - 10));
                    Thread.sleep(50);
                    flag = true;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables

}
