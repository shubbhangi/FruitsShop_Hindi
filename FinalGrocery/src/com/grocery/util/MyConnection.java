/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grocery.util;

/**
 *
 * @author comp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Softech
 */
public class MyConnection
{
    public static Connection createConnection()throws SQLException,ClassNotFoundException
    {
                Connection con=null;
                //Properties pr = new Properties();

              //pr.put("characterEncoding", "UTF-8");
              //pr.put("useUnicode", "true");
                Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","vertrigo");
                return con;
    }
    public static void main(String[] args) {
		MyConnection obj=new MyConnection();
		try {
			Connection con=obj.createConnection();
			System.out.println("Connected:"+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
