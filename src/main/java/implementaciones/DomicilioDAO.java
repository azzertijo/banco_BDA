/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Domicilio;
import excepciones.PersistenciaException;
import interfaces.IDomicilioDAO;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.sql.*;

/**
 *
 * @author JORGE
 */
public class DomicilioDAO implements IDomicilioDAO{
private final IConexionBD GENERADOR_CONEXIONES;
    
    public DomicilioDAO(IConexionBD generadorConexiones){
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }
    
    @Override
    public Domicilio insertar(Domicilio domicilio) throws PersistenciaException {
        String codigoSQL ="INSERT INTO DOMICILIO(calle,colonia,num_casa) VALUES (?,?,?)";
        
        try(Connection conexion = GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);){
            
            comando.setString(1, domicilio.getCalle());
            comando.setString(2,domicilio.getColonia());
           comando.setString(3, domicilio.getNum_casa());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                domicilio.setId(llavePrimaria);
                return domicilio;
            }
            throw new PersistenciaException("Domicilio registrado pero ID no generado");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new PersistenciaException("No fue posible registrar el domicilio");
        }   
    }
    
}
