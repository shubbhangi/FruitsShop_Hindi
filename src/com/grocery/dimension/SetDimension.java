/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grocery.dimension;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author ISHWAR
 */
public class SetDimension 
{
    public void setInternalFrameLocation(JDesktopPane jDesktopPane, JInternalFrame jInternalFrame)
    {
        Dimension desktopSize = jDesktopPane.getSize();
        Dimension internalFrameSize = jInternalFrame.getSize();
        jInternalFrame.setLocation((desktopSize.width - internalFrameSize.width)/2 , (desktopSize.height- internalFrameSize.height)/2);   
    }
    
    public void setFrameLocation(JFrame jFrame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dimension.width/2-jFrame.getSize().width/2, dimension.height/2-jFrame.getSize().height/2);
    }
}
