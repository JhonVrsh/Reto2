
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    //1. crear instancia de la clase connection
    Connection connection;
    String driver ="com.mysql.cj.jdbc.Driver";
    String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_g55_db";
    String usuario = "root";
    String password = "";
    
    
    //2. Añadir el contructor sin arg de la clase     
    public Conexion(){
        //3. Intentar conectar con la base de datos 
        try { 
            Class.forName(driver);
            connection = DriverManager.getConnection(cadenaConexion, usuario, password);
            //4. Verificamos  si la conexión devuelve algo
            if(connection != null){
                System.out.println("Conexión exitosa con la base de datos ");
           
            }
       }catch (ClassNotFoundException | SQLException e){
            System.out.println("No se puede establecer la conexión con la base de datos ");
       }
    }
    
    public Connection getConnection(){
        return connection;
        
    }
}
