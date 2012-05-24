/*//GEN-FIRST:event_jButton4ActionPerformed
 * To change this template, choose Tools | Templates//GEN-LAST:event_jButton4ActionPerformed
 * and open the template in the editor.
 */

/*
 * jAsciiChecker.java
 *
 * Created on Sep 8, 2011, 10:33:19 AM
 */
package com.swingmvc.jasciichecker;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JCheckBox;


/**
 *
 * @author NUSNAFIF
 */
public class jAsciiChecker extends javax.swing.JFrame {
    
     
        com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();          
        public String iUser = NTSystem.getName();
        public String myEmail = iUser+"@digi.com.my";
    
    static CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder(); // or "ISO-8859-1" for ISO Latin 1

  public static boolean isPureAscii(String v) {      
      return asciiEncoder.canEncode(v);
  }
  
    /** Creates new form jAsciiChecker */
    public jAsciiChecker() {
        initComponents();
        setSize(720,255);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = getSize();
	setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        // Set Icon Apps
        setIconImage(Toolkit.getDefaultToolkit().getImage(jAsciiChecker.class.getResource("images/fedora.png")));
        jLabel1.setText("isPureAscii() --> "); // Set Label
        
        com.sun.security.auth.module.NTSystem 
        NTSystem = new com.sun.security.auth.module.NTSystem();          
        String iuser = NTSystem.getName();
        jLabel3.setText("Username --> "+iuser);
    }
    
    // CMS file broadcast Report
    private void SendAllRpt(String ntuser, String email) throws Exception {                
        String host = "172.18.129.66";
        String user = "cmsuser";
        String pass = "cmsuser";
        String command = "/bin/sh /home/cmsuser/reqrpt1.sh "+ntuser+" "+email;
                                    
        try {
            JSch jsch=new JSch(); 
            //jsch.setKnownHosts("/home/cmsuser/.ssh/known_hosts"); 
            Session session = jsch.getSession(user, host);  
            session.setPassword(pass);
            java.util.Properties config=new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(); 
       
            ChannelExec channel = (ChannelExec) session.openChannel("exec"); 
            channel.setCommand(command);  // Pull Report            
            channel.connect(); 
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
            String output = reader.readLine();
            while (output != null) {
                System.out.println(output);
                output = reader.readLine();
            }
            reader.close();
            
            channel.disconnect();  
            session.disconnect();  
        
        } catch (Exception t) {
            System.out.println(t);
        }
    }
        
    
    private void GetRptByID(String cmpgn, String ntuser, String myEmail) throws Exception {
                
        String host = "172.18.129.66";
        String user = "cmsuser";
        String pass = "cmsuser";        
        String command = "/bin/sh /home/cmsuser/reqrpt2.sh "+cmpgn+ " "+ntuser+" "+myEmail;
                            
        try {
            JSch jsch=new JSch(); 
            //jsch.setKnownHosts("/home/cmsuser/.ssh/known_hosts"); 
            Session session = jsch.getSession(user, host);  
            session.setPassword(pass);
            java.util.Properties config=new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(); 
       
            //Pull Report
            ChannelExec channel = (ChannelExec) session.openChannel("exec"); 
            channel.setCommand(command);  //Pull report            
            channel.connect(); 
                                    
            BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
            String output = reader.readLine();
            while (output != null) {
                System.out.println(output);
                output = reader.readLine();
            }
            reader.close();
            
            channel.disconnect();  
            session.disconnect();  
        
        } catch (Exception t) {
            System.out.println(t);
        }
    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ascii Checker");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Text"));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("isPureAscii() : ?");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swingmvc/jasciichecker/images/search.png"))); // NOI18N
        jButton1.setText("Check!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swingmvc/jasciichecker/images/Logo.png"))); // NOI18N
        jButton2.setText("Clear!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swingmvc/jasciichecker/images/exit-icon.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Position :");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swingmvc/jasciichecker/images/Mailto.png"))); // NOI18N
        jButton4.setText("CMS Broadcast Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Username : ()");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Campaign Report"));

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swingmvc/jasciichecker/images/gomail.png"))); // NOI18N
        jButton5.setText("Send Report");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("All Campaign");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("By Campaign[s] ID");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int koral =0;
        
        for (int j = jTextArea1.getText().length(); j>= koral; j--) {
            String s = jTextArea1.getText().substring(j);//substring(koral, j);            
            if (isPureAscii(s) == false ) {
                jLabel1.setText("isPureAscii() --> "+isPureAscii(jTextArea1.getText())+"  Failed at position : "+ j);
                //System.out.println("Char at position: "+ j);                            
                break;
            }else
                jLabel1.setText("isPureAscii() --> " +isPureAscii(jTextArea1.getText()));
        }
    }                                        

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            // TODO add your handling code here:
            jTextArea1.setText("");
            jLabel1.setText("isPureAscii() --> "); 
        }                                        

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            // TODO add your handling code here:
            System.exit(0);
        }                                        

        private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {                                       
            // TODO add your handling code here:
            jLabel2.setText("Text Position : "+ jTextArea1.getCaretPosition());
        }                                      

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        setSize(720,420);
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (jRadioButton1.isSelected() == true) {                        
            try {
                SendAllRpt(iUser, myEmail);                
            } catch (Exception cl) {
                System.out.println(cl);
            }                        
        } else if (jRadioButton2.isSelected() == true) {
            try {
                String iCmpgn=jTextArea2.getText();
                GetRptByID(iCmpgn,iUser,myEmail);
                
            } catch (Exception l) {
                System.out.println(l);
            }   
        }
        setSize(720,255);
                
//                try {
//            com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();          
//            String input = NTSystem.getName();
//            String myemail = input+"@digi.com.my";
//            SendRpt(input, myemail);            
//        } catch (Exception cl) {
//            System.out.println(l);
//        }
        
    }                                        

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        if (jRadioButton1.isSelected() == true) {
            jRadioButton2.setEnabled(false);
            jTextArea2.setEnabled(false);
            jButton5.setEnabled(true);                    
        } else {
            jRadioButton2.setEnabled(true);
            jTextArea2.setEnabled(true);
            jButton5.setEnabled(false);
        }
        
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        if (jRadioButton2.isSelected() == true) {
            //jRadioButton2.setEnabled(false);
            //jTextArea2.setEnabled(false);
            jRadioButton1.setEnabled(false);
            jButton5.setEnabled(true);
        } else {
            jRadioButton1.setEnabled(true);
            jButton5.setEnabled(false);
        }
        
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new jAsciiChecker().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration                   
}
