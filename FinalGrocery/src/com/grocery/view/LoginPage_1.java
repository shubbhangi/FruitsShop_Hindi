/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;
import com.grocery.bean.EmployeeMaster;
import com.grocery.dimension.SetDimension;
import com.grocery.query.EmployeeQuery;
import com.grocery.read.MessageFormat;
import com.grocery.read.ReadFile;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class LoginPage_1 extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage_1() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        username.setBackground(new java.awt.Color(102, 153, 255));
        username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setText("Enter Username");
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        jPanel2.add(username);
        username.setBounds(400, 160, 200, 30);

        password.setBackground(new java.awt.Color(102, 153, 255));
        password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel2.add(password);
        password.setBounds(400, 210, 200, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN HERE");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(400, 120, 200, 30);

        cancel.setBackground(new java.awt.Color(102, 153, 255));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancel.setText("Cancel");
        cancel.setMnemonic(KeyEvent.VK_C);
        cancel.setBorder(null);
        cancel.setOpaque(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelKeyPressed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(470, 260, 73, 30);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(490, 300, 120, 20);
        jLabel2.setText("<HTML><FONT color=\"#FFFFFF\"><U><strong>Forgot Password? </U></FONT></HTML>");
        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SPHERICAL INDIA");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 630, 80);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/grocery/view/login.jpg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 630, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        String username = JOptionPane.showInputDialog(null, MessageFormat.getMessage("Please enter the Username"));

        if(username.trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Username can't be empty"), "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUsername(username);

        EmployeeQuery employeeQuery = new EmployeeQuery();
        List<EmployeeMaster> list = employeeQuery.getCredentials(employeeMaster);

        if(list.isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This Username doesn't exist"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            for(EmployeeMaster em: list)
            employeeMaster.setId(em.getId());

            NewPassword newPassword = new NewPassword(employeeMaster);
            SetDimension setDimension = new SetDimension();
            setDimension.setFrameLocation(newPassword);
            newPassword.setVisible(true);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        dispose();
    }//GEN-LAST:event_cancelKeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
        evt.consume();
    }//GEN-LAST:event_passwordKeyTyped

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(password.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Password cannot be blank!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
                password.requestFocusInWindow();
            }
            else{
                getDetails();
            }
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        password.setText("");
    }//GEN-LAST:event_passwordFocusGained

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
        evt.consume();
    }//GEN-LAST:event_usernameKeyTyped

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(username.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Username cannot be blank!!"),"Error Message", JOptionPane.ERROR_MESSAGE);
                username.requestFocusInWindow();
            }
            else{
                password.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        username.setText("");
    }//GEN-LAST:event_usernameFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    public void getDetails()
    {
        if(username.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Username"), "Error Message", JOptionPane.ERROR_MESSAGE);
            username.setText("");
            username.requestFocus();
        }
        else
            if(password.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Password"), "Error Message", JOptionPane.ERROR_MESSAGE);
                password.setText("");
                password.requestFocus();
            }
            else
            {
                EmployeeMaster employeeMaster = new EmployeeMaster();
                EmployeeQuery employeeQuery = new EmployeeQuery();

                employeeMaster.setUsername(username.getText().trim());
                employeeMaster.setPassword(password.getText());

                List<EmployeeMaster> list = employeeQuery.getCredentials(employeeMaster);

                if(list.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Username and Password don't match"));
                    username.requestFocus();
                }
                else
                {
                    dispose();
                    HomePage1 frame=new HomePage1();

                    frame.setTitle("Trading Management System");
                    ImageIcon ic= new ImageIcon(ReadFile.getPath() + "\\groceries.png");
                    frame.setIconImage(ic.getImage());
                    Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
                     //    frame.setMaximumSize(DimMax);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(true); 
                }
            }
    }
}
