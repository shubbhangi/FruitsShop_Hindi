/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgrocery;

import com.grocery.read.ReadFile;
import com.grocery.view.LoginPage_1;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class FinalGrocery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        StringBuilder sb = new StringBuilder();
        InetAddress ip;
	try {
			
		ip = InetAddress.getLocalHost();
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
//		byte[] mac = network.getHardwareAddress();
//	
//		for (int i = 0; i < mac.length; i++) {
//			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
//                }	
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
        
     /*   if(!(sb.toString().equals("80-19-34-F3-8B-44")))
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("System Error!!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    /*    byte[] encodedBytes = Base64.getEncoder().encode(sb.toString().getBytes());
        String s1 =  new String(encodedBytes);

        encodedBytes = Base64.getEncoder().encode("E8-40-F2-06-35-59".getBytes());
        String s2 =  new String(encodedBytes);
        
        if(!(s1.equals(s2)))
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("System Error!!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }   */
        
        Calendar expiry = Calendar.getInstance();
        expiry.set(2018, 6, 30,0,0); // Expires on July 30
        Calendar now = Calendar.getInstance();
        
        // If you don't trust client's clock, fetch time from some reliable time server
        if(now.after(expiry))
        {
           /* JOptionPane.showMessageDialog(null, MessageFormat.getMessage("java.io.FileNotFoundException: the system cannot find the file specified"));
            return; */
        }
        
        try
        {
            ImageIcon ic= new ImageIcon(ReadFile.getPath() + "groceries.png");
            LoginPage_1 loginPage = new LoginPage_1();
            
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            loginPage.setLocation(dim.width/2-loginPage.getSize().width/2, dim.height/2-loginPage.getSize().height/2);
            loginPage.setIconImage(ic.getImage());
            loginPage.setVisible(true);
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
