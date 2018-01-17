/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author orlando
 */
public class KATA5P1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\orlan\\Desktop\\KATA5.db"); 
        
        Statement statement = connection.createStatement(); 
        ResultSet res = statement.executeQuery("SELECT * FROM PEOPLE;");
        
        
        while (res.next()){
            System.out.println("ID = " + res.getInt("Id"));
            System.out.println("NAME =" + res.getString("Name"));
            
        }
        
        statement.execute("CREATE TABLE 'MAIL' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "'Mail' INTEGER NOT NULL);");
        
        
    }
    
}
