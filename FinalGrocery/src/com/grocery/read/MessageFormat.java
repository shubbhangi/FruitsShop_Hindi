/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.read;

/**
 *
 * @author Admin
 */
public class MessageFormat 
{
    public static String getMessage(String message)
    {
        String newMessage = "<HTML><strong>" + message + "</HTML>";
        return newMessage;
    }
    
}
