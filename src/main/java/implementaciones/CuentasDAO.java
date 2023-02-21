/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import utils.ConfiguracionPaginado;

/**
 *
 * @author JORGE
 */
public class CuentasDAO implements ICuentasDAO{
    private final IConexionBD GENERADOR_CONEXIONES;
    
    
    public CuentasDAO(IConexionBD generadorConexiones){
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

  @Override
    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }
  
   
    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "INSERT INTO CUENTAS(num_cuenta,saldo,id_clientes)  VALUES (?,?,?)";
        
        try(Connection conexion = GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);
                )
        {
            comando.setInt(1, cuenta.getNum_cuenta());
            comando.setDouble(2, cuenta.getSaldo());
            comando.setInt(3, cuenta.getId_cliente());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cuenta.setId(llavePrimaria);
                return cuenta;
            }
            throw new PersistenciaException("Cuenta registrada pero ID no generada");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.out.println("Cosa123");
            throw new PersistenciaException("No fue posible registrar la cuenta");
        }
    }

    @Override
    public List<Cuenta> consultar(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException {
        String codigoSQL = "SELECT num_cuenta,saldo,fecha_apertura FROM cuentas WHERE id_clientes=? LIMIT ? OFFSET ?";
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, cliente.getId());
            comando.setInt(2, configPaginado.getElementosASaltar());
            comando.setInt(3, configPaginado.getPagina());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer num_cuenta = resultado.getInt("num_cuenta");
                Double saldo = resultado.getDouble("saldo");
                Date fecha_apertura = resultado.getDate("fecha_apertura");
                Cuenta cuenta = new Cuenta(num_cuenta,saldo,fecha_apertura);
                listaCuentas.add(cuenta);
            }

            return listaCuentas;
        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible consultar la lista de cuentas");
        }
       
    }

    @Override
    public List<Cuenta> consultarCombo(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "SELECT num_cuenta,saldo FROM cuentas WHERE id_clientes=?";
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, cliente.getId());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer num_cuenta = resultado.getInt("num_cuenta");
                Double saldo = resultado.getDouble("saldo");
                Cuenta cuenta = new Cuenta(num_cuenta,saldo);
                listaCuentas.add(cuenta);
            }

            return listaCuentas;
        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible consultar la lista de cuentas");
        }
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "UPDATE CUENTAS SET SALDO=SALDO+? WHERE NUM_CUENTA=?";
        
        try(
            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            )
        
        {
            comando.setDouble(1,cuenta.getSaldo());
            comando.setInt(2, cuenta.getNum_cuenta());
            ResultSet resultado = comando.executeQuery();
            comando.executeUpdate();
        
        if(resultado.next()){
            Double saldo = resultado.getDouble("saldo");
            Integer num_cuenta = resultado.getInt("num_cuenta");
            cuenta = new Cuenta(num_cuenta,saldo);

        }
        return cuenta;
       
        }catch(SQLException ex){
            
            return null;
        }
    }
    
}
