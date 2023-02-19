/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dominio.Cliente;
import dominio.Cuenta;

import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import java.sql.Connection;
import java.util.List;
import utils.ConfiguracionPaginado;
/**
 *
 * @author JORGE
 */
public interface ICuentasDAO {
    
    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;
    
    List<Cuenta> consultar(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException;
    
     IConexionBD getGENERADOR_CONEXIONES();
    
}
