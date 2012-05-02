/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvc.jasciichecker;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author NUSNAFIF
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new jAsciiChecker().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
}
