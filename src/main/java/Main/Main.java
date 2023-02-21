/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;


import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import implementaciones.DomicilioDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDomicilioDAO;
import presentacion.LoginForm;



public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/banco", "root", "adalgd123");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        IDomicilioDAO domicilioDAO = new DomicilioDAO(generadorConexiones);
        ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexiones);
        new LoginForm(clientesDAO,domicilioDAO,cuentasDAO).setVisible(true);
        

    }
    }
    

