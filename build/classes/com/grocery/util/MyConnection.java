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
    private Connection MyConnection;
    public static Connection createConnection()throws SQLException,ClassNotFoundException
    {
                Connection con=null;
                //Properties pr = new Properties();

                Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hindi_project_shubhangi?useUnicode=yes&characterEncoding=UTF-8","root","password");
              //  String connectionURL = "jdbc:mysql://localhost:3306/student?useUnicode=yes&characterEncoding=UTF-8";
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
