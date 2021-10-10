package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stefannie Flandez
 */
public class conexionSQL {
     Connection conectar = null;
    
    public Connection conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion "+e.getMessage());
        }
        return conectar;
    }
}
