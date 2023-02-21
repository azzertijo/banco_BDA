/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITransferenciasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JORGE
 */
public class TransferenciasDAO implements ITransferenciasDAO {
private final IConexionBD GENERADOR_CONEXIONES;

    public TransferenciasDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
    
    @Override
    public Transferencia hacerTransferencia(Transferencia transferencia) throws PersistenciaException {
         String codigoSQL ="INSERT INTO TRANSFERENCIAS(monto,cuenta_origen,cuenta_destino) VALUES (?,?,?)";
         
         try(Connection conexion = GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);
                )
        {
            comando.setDouble(1, transferencia.getMonto());
            comando.setInt(2, transferencia.getCuenta_origen());
            comando.setInt(3, transferencia.getCuenta_destino());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                transferencia.setId(llavePrimaria);
                return transferencia;
            }
            throw new PersistenciaException("Cuenta registrada pero ID no generada");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.out.println("Cosa123");
            throw new PersistenciaException("No fue posible registrar la cuenta");
        }
    }
    
   
    
}
