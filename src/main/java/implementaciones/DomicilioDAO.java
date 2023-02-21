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

    @Override
    public Domicilio consultar(Integer idDomicilio) throws PersistenciaException {
        String codigoSQL = "SELECT id,calle,colonia,num_casa FROM DOMICILIO WHERE ID=?";
        
        try(
            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            )
        
        {
            comando.setInt(1,idDomicilio);
            ResultSet resultado = comando.executeQuery();

        Domicilio domicilio = null;
        if(resultado.next()){
           
            
            String calle = resultado.getString("calle");
            String colonia = resultado.getString("colonia");
            String num_casa = resultado.getString("num_casa");
            domicilio = new Domicilio(idDomicilio,calle,colonia,num_casa);
//            cliente.setNombre(nombre);
//            cliente.setApellido_paterno(apellido_paterno);
// 
//            System.out.printf("%s, %s",nombre,apellido_paterno);
                    
        }
        
        return domicilio;
       
        }catch(SQLException ex){
            System.out.println("No se pudo consultar el domicilio");
            return null;
        }
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) throws PersistenciaException {
        String codigoSQL = "UPDATE DOMICILIO SET calle=?, colonia=?,num_casa=? WHERE id=?;";
        
        try(
            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            )
        
        {
            comando.setString(1,domicilio.getCalle());
            comando.setString(2, domicilio.getColonia());
            comando.setString(3,domicilio.getNum_casa());
            comando.setInt(4, domicilio.getId());
            
            ResultSet resultado = comando.executeQuery();
            comando.executeUpdate();
        
        if(resultado.next()){
            String calle = resultado.getString("calle");
            String colonia = resultado.getString("colonia");
            String num_casa = resultado.getString("num_casa");
            Integer id = resultado.getInt("id");
            domicilio = new Domicilio(id,calle,colonia,num_casa);

        }
        return domicilio;
       
        }catch(SQLException ex){
            
            return null;
        }
    }
    
}
