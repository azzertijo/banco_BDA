/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import dominio.Cliente;
import dominio.Domicilio;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.DomicilioDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.IDomicilioDAO;
import presentacion.LoginForm;
import presentacion.RegistroForm;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/banco", "root", "adalgd123");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        IDomicilioDAO domicilioDAO = new DomicilioDAO(generadorConexiones);
        new LoginForm(clientesDAO,domicilioDAO).setVisible(true);
        
//        java.sql.Date d = java.sql.Date.valueOf("2021-10-10");
//        try {
//
//            //Cliente cliente = clientesDAO.insertar(new Cliente("Jorge Luis","Sánchez","Quezada",d,"YorchS","contraseña123",1));
//           // Domicilio domicilio = domicilioDAO.insertar(new Domicilio("5 de febrero","Zona norte","8320"));
//        } catch (PersistenciaException e) {
//           e.getMessage();
//        }
    }
    }
    

