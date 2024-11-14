
package modelo;
import java.awt.BorderLayout;
import java.sql.*;

public class Persistencia {
    ConexionBD con=new ConexionBD();
    public boolean ejecutarDML(String sql){
        boolean ejecuto= false;
        try{
            PreparedStatement ps= con.getConnection().prepareStatement(sql);
            int recibe= ps.executeUpdate();
            if(recibe > 0){
                ejecuto =true;
            }
        }
        catch(SQLException e){
            System.out.println("El error es "+e.toString());
            ejecuto= false;
        }
        return ejecuto;
    }
    
    public ResultSet ejecutarConsulta (String sql){
        ResultSet datos= null;
        try{
            PreparedStatement ps= con.getConnection().prepareStatement(sql);
            datos= ps.executeQuery();
        }
        catch(SQLException e){
            System.out.println("El error es "+e.toString());
            datos= null;
        }
        return datos;
    }
}
