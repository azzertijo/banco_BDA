/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Domicilio;
import excepciones.PersistenciaException;

public interface IDomicilioDAO {
    
    Domicilio insertar(Domicilio domicilio) throws PersistenciaException;
}
