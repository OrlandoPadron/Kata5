/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\orlan\\Desktop\\KATA5.db"); 
        
        Statement statement = connection.createStatement(); 
        ResultSet res = statement.executeQuery("SELECT * FROM PEOPLE;");
        
        
        while (res.next()){
            System.out.println("ID = " + res.getInt("Id"));
            System.out.println("NAME =" + res.getString("Name"));
            
        }
        
        statement.execute("CREATE TABLE IF NOT EXISTS 'MAIL' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "'Mail' INTEGER NOT NULL);");
        
        String nameFile = "emails.txt"; 
        BufferedReader lector = new BufferedReader(new FileReader(new File(nameFile)));
        String mail; 
        String query; 
        
        
        while ((mail = lector.readLine()) != null) {
            if (!mail.contains("@")) continue;
            query = "INSERT INTO MAIL (Mail) VALUES (' " + mail + "');"; 
            statement.executeUpdate(query); 
        }
        
        
    }
    
}
