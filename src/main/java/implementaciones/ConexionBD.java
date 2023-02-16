/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import interfaces.IConexionBD;
import java.sql.*;

public class ConexionBD implements IConexionBD{
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    public ConexionBD(String CADENA_CONEXION, String USUARIO, String PASSWORD) {
        this.CADENA_CONEXION = CADENA_CONEXION;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASSWORD); 
           return conexion;
    }

 
}
