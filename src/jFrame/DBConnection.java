/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jFrame;
import java.sql.*;
/**
 *
 * @author 91938
 */
public class DBConnection {
    
    static final String DB_URL="jdbc:mysql://localhost/demo";
    static final String USER="root";
    static final String PASS="";

    public static Connection connectDB(){
        Connection connect=null;
        try{
//             class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection(DB_URL,USER,PASS);
            return connect;
        }catch(Exception ex){
            System.out.println("There were errors while connecting to dB");
            return null;
        }
    }
    
}
