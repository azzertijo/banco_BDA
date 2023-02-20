/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;
import dominio.Cliente;

public interface IClientesDAO {
    
    Cliente insertar(Cliente cliente) throws PersistenciaException;
    
    Cliente consultarCuenta(Cliente cliente);
    
    Cliente actualizar(Cliente cliente) throws PersistenciaException;
    
    IConexionBD getGENERADOR_CONEXIONES();
}
