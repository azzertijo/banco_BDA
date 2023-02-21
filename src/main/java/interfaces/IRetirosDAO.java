/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author JORGE
 */
public interface IRetirosDAO {
    
    RetiroSinCuenta hacerRetiro(RetiroSinCuenta retiro) throws PersistenciaException;
    
    RetiroSinCuenta generarFolio(RetiroSinCuenta retiro) throws PersistenciaException;
    
}
