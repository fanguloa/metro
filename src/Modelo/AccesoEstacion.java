
package Modelo;

import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoEstacion extends Conexion{
    private ResultSet resultado;
    
    public AccesoEstacion() {
        super.conectar();
    }
    
    //metodo CRUD - Read
    public ResultSet listarEstacion(){    
        try {
            super.getStmt();
            resultado = stmt.executeQuery("select e.idEstaciones AS `id`, e.nombreEstacion AS `nombre`, \n" +
                        "e.tipoEstacion AS `tipo`, e.tiendas AS `tiendas`,\n" +
                        "e.aireAcondicionado AS `aire`, e.accesoMinusvalidos AS `acceso`,\n" +
                        "e.salidaParadero AS `paradero`, l.colorEstacion AS `color` \n" +
                        "FROM `estaciones` AS e \n" +
                        "INNER JOIN `linea` AS l ON e.linea_id = l.idLinea\n" +
                        "ORDER BY e.idEstaciones");
        } catch (SQLException ex) {
            Logger.getLogger(AccesoEstacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    
    //metodo CRUD - Create
    public void ingresarEstacion(String nombreEstacion,String tipoEstacion,
            boolean tiendas, boolean aireAcondicionado, boolean accesoMinusvalidos,
            boolean salidaParadero, int linea_id){
        try {
            super.getStmt();
            stmt.executeUpdate("Insert into estaciones (nombreEstacion, tipoEstacion,"
                    + "tiendas, aireAcondicionado, accesoMinusvalidos, salidaParadero,"
                    + "linea_id)"
                    + "values ('"+nombreEstacion+"',"
                            + "'"+tipoEstacion+"',"
                            + ""+tiendas+","
                            + ""+aireAcondicionado+","
                            + ""+accesoMinusvalidos+","
                            + ""+salidaParadero+","
                            + ""+linea_id+")");
            System.out.println("Ingresado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar Estación!");
            Logger.getLogger(AccesoEstacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Update
    public void actualizarEstacion(int idEstaciones,String nombreEstacion,String tipoEstacion,
            boolean tiendas, boolean aireAcondicionado, boolean accesoMinusvalidos,
            boolean salidaParadero, int linea_id){
        try {
            super.getStmt();
            stmt.executeUpdate("Update estaciones set "
                    + "nombreEstacion='"+nombreEstacion+"',"
                    + "tipoEstacion='"+tipoEstacion+"',"
                    + "tiendas="+tiendas+","
                    + "aireAcondicionado="+aireAcondicionado+","
                    + "accesoMinusvalidos="+accesoMinusvalidos+","
                    + "salidaParadero="+salidaParadero+","
                    + "linea_id="+linea_id+" where idEstaciones="+idEstaciones);
            System.out.println("Actualizado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Estación!");
            Logger.getLogger(AccesoEstacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Delete
    public void eliminarEstacion(int idEstaciones){
        try {
            super.getStmt();
            stmt.executeUpdate("Delete from estaciones where idEstaciones="+idEstaciones);
            System.out.println("Eliminado con exito!");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Estación!");
            Logger.getLogger(AccesoEstacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}