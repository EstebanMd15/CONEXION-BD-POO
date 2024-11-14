
package controlador;

import modelo.Persistencia;
import java.sql.*;
import modelo.Categoria;

public class ControlCategoria {
    Categoria ca;
    Persistencia p = new Persistencia();
    String sql = "";
    ResultSet res;
    
    public boolean insertarCategoria(Categoria ca){
        sql = "Insert into categoria(cat_id, cat_nombre, cat_descipcion) "
                + "values ("+ca.getCodigo()+", '"+ca.getNombre()+"', "
                + "'"+ca.getDescripcion()+"')";
        return p.ejecutarDML(sql);
    }
    
    public boolean eliminarCategoria(int cat_id){
        sql = "Delete from categoria where cat_id ="+ cat_id;
        return p.ejecutarDML(sql);
    }
    public boolean actualizarCategoria(Categoria ca){
        sql = "Update categoria set cat_nombre = '"+ca.getNombre()+ "', cat_descipcion = '"
                + ca.getDescripcion()+ "' where cat_id = "+ca.getCodigo();
        return p.ejecutarDML(sql);
                                       
    }
    public Object[][]buscarCategoria(int cat_id){
        Object data[][] = new Object[1][3];
        sql = "Select cat_id, cat_nombre, cat_descipcion from categoria where "
                + "cat_id = " + cat_id;
        res = p.ejecutarConsulta(sql);
        
        try{
            while(res.next()){
                data[0][0] = res.getInt(1);
                data[0][1] = res.getString(2);
                data[0][2] = res.getString(3);
                
            }
        }
        catch(SQLException e){
            System.out.println("Este es el error: " +e);
        }
        return data;
    }
    public int contarCategorias(){
        int filas = 0;
        sql = "Select count(*) from categoria";
        res = p.ejecutarConsulta(sql);
        try{
           while(res.next()){
               filas = res.getInt(1);
           } 
        }catch(SQLException e){
            System.out.println("Este es el error: " + e.toString());
        
        }
        return filas;
    }
    public Object[][] listarCategorias(){
        Object data[][] = new Object[contarCategorias()][3];
        sql = "Select cat_id, cat_nombre, cat_descipcion from categoria";
        res = p.ejecutarConsulta(sql);
        int i = 0;
        try{
            while(res.next()){
                data[i][0] = res.getInt(1);
                data[i][1] = res.getString(2);
                data[i][2] = res.getString(3);
                i++;
            }
        }catch(SQLException e){
            System.out.println("Este es el error: " + e.toString());
        }
        return data;
    }
    
}
