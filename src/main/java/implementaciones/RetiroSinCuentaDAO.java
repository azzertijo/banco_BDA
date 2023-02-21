/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JORGE
 */
public class RetiroSinCuentaDAO implements IRetirosDAO{
private final IConexionBD GENERADOR_CONEXIONES;

    public RetiroSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public RetiroSinCuenta hacerRetiro(RetiroSinCuenta retiro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RetiroSinCuenta generarFolio(RetiroSinCuenta retiro) throws PersistenciaException {
       String codigoSQL ="INSERT INTO RETIRO_SIN_CUENTA(folio,contrasenia) VALUES (?,?)";
        
        try(Connection conexion = GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);){
            
            comando.setInt(1, retiro.getFolio());
            comando.setInt(2, retiro.getContrasenia());
            
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                retiro.setId(llavePrimaria);
                return retiro;
            }
            throw new PersistenciaException("Retiro registrado pero ID no generado");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new PersistenciaException("No fue posible registrar el retiro");
        }
    }
    
}
