
package modelo;

import java.sql.*;

public class ConexionBD {
    
    static String bd = "tienda";
    static String login = "root";
    static String password = "System";
    static String url = "jdbc:mysql://localhost:3306/"+bd+"?useUnicode=true";
    
    Connection conn = null;
    
    public ConexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if(conn != null){
                System.out.println("Conexion a base de datos " + bd + " correcta");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return conn;
        
    }
    
    public void desconectar(){
        conn = null;
    }
    public static void main(String[] args) {
        ConexionBD c = new ConexionBD();
        c.getConnection();
    }
    
}
