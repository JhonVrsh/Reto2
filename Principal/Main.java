
package Principal;
import Vistas.*;
import Modelo.*;



public class Main {

    
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        conexion.getConnection();
        
        //1. Crear la instancia del Jframe Login
        Login Login = new Login();
        Login.setVisible(true);
        
    }
    
}
