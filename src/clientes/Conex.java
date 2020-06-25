
package clientes;

import java.sql.*;

public class Conex {
      Connection cn;
      
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","root","12345678");
            //System.out.println("conexion lista");
        }catch (Exception e){
            System.err.println("Error: "+e);
        }   
          return cn;
    }
}

