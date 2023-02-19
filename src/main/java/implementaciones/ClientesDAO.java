/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.*;


public class ClientesDAO implements IClientesDAO{

    private final IConexionBD GENERADOR_CONEXIONES;
    
    public ClientesDAO(IConexionBD generadorConexiones){
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }
    
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
      
        String codigoSQL ="INSERT INTO CLIENTES(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, usuario, contrasenia, id_domicilio) VALUES (?,?,?,?,?,?,?)";
        
        try(Connection conexion = GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);){
            
            comando.setString(1, cliente.getNombre());
            comando.setString(2,cliente.getApellido_paterno());
            comando.setString(3,cliente.getApellido_materno());
            comando.setDate(4, cliente.getFecha_nacimiento());
            comando.setString(5, cliente.getUsuario());
            comando.setString(6, cliente.getContrasenia());
            comando.setInt(7, cliente.getIdDireccion());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cliente.setId(llavePrimaria);
                return cliente;
            }
            throw new PersistenciaException("Cliente registrado pero ID no generado");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }          
    }

    @Override
    public Cliente consultarCuenta(Cliente cliente) {
        Cliente clienteLog = null;
        String codigoSQL = "SELECT id,nombre,apellido_paterno,apellido_materno,fecha_nacimiento,usuario,contrasenia,id_domicilio FROM CLIENTES WHERE usuario=? AND contrasenia= ?";
    
        try(
            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);  
            )   
            
        {
            comando.setString(1, cliente.getUsuario());
            comando.setString(2, cliente.getContrasenia());

            ResultSet resultado = comando.executeQuery();

            
        if(resultado.next()){
            Integer id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String apellidoPaterno = resultado.getString("apellido_paterno");
            String apellidoMaterno = resultado.getString("apellido_materno");
            Date fecha_nac = resultado.getDate("fecha_nacimiento");
            String usuarioLog = resultado.getString("usuario");
            String contrasenia = resultado.getString("contrasenia");
            Integer idDireccion = resultado.getInt("id_domicilio");
            clienteLog = new Cliente(id,nombre,apellidoPaterno,apellidoMaterno,fecha_nac,usuarioLog,contrasenia,idDireccion);
        }
        
        return clienteLog;
        }catch(SQLException ex){

            return null;
        }
    }
   
    
}
