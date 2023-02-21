/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Transferencia;
import excepciones.PersistenciaException;

/**
 *
 * @author JORGE
 */
public interface ITransferenciasDAO {
    
    Transferencia hacerTransferencia(Transferencia transferencia) throws PersistenciaException;
    
    
    
}
