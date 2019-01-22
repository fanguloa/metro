
package Modelo;

import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoLinea extends Conexion{
    private ResultSet resultado;
    
    public AccesoLinea() {
        super.conectar();
    }
    
    //metodo CRUD - Read
    public ResultSet listarLinea(){    
        try {
            super.getStmt();
            resultado = stmt.executeQuery("Select * from linea");
        } catch (SQLException ex) {
            Logger.getLogger(AccesoLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    
    //metodo CRUD - Create
    public void ingresarLinea(int idLinea, String colorEstacion, int anoInauguracion){
        try {
            super.getStmt();
            stmt.executeUpdate("Insert into linea "
                    + "values ("+idLinea+","
                            + "'"+colorEstacion+"',"
                            + ""+anoInauguracion+")");
            System.out.println("Ingresado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Linea!");
            Logger.getLogger(AccesoLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Update
    public void actualizarLinea(int idLinea, String colorEstacion, int anoInauguracion){
        try {
            super.getStmt();
            stmt.executeUpdate("Update linea set "
                    + "idlinea="+idLinea+","
                    + "colorEstacion='"+colorEstacion+"',"
                    + "anoInauguracion="+anoInauguracion+" where idLinea="+idLinea);
            System.out.println("Actualizado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Linea!");
            Logger.getLogger(AccesoLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Delete
    public void eliminarLinea(int idLinea){
        try {
            super.getStmt();
            stmt.executeUpdate("Delete from linea where idLinea="+idLinea);
            System.out.println("Eliminado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Linea!");
            Logger.getLogger(AccesoLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}