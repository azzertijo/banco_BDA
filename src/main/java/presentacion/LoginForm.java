/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.CuentasDAO;
import implementaciones.DomicilioDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDomicilioDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Sánchez y Rosalía Pérez
 */
/**
 * Se mandan a llamar las interfaces que se necesitarán para el login.
 */
public class LoginForm extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final IDomicilioDAO domicilioDAO;
    private final ICuentasDAO cuentasDAO;
    private final IConexionBD conexion;
    private Cliente clienteLog;

    /**
     * Creación del constructor donde se crea un nuevo cliente, domicilio y
     * cuentas, además de ser conectadas con la base de datos.
     */
    public LoginForm(IConexionBD conexion) {
        this.conexion = conexion;
        this.clientesDAO = new ClientesDAO(conexion);
        this.domicilioDAO = new DomicilioDAO(conexion);
        this.cuentasDAO = new CuentasDAO(conexion);
        initComponents();
    }

    /**
     * Se extraen los datos de la base de datos
     * @return Los datos del cliente guardados en la base
     */
    private Cliente extraerLogin() {
        Cliente cliente = new Cliente();
        String usuario = this.txtfUsuarioLogin.getText();
        String contrasenia = this.pwrdContraLogin.getText();
        cliente.setUsuario(usuario);
        cliente.setContrasenia(contrasenia);

        System.out.println(this.pwrdContraLogin.getText() + "" + contrasenia);

        cliente = clientesDAO.consultarCuenta(cliente);

        System.out.println(cliente);
        clienteLog = cliente;
        return cliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtfUsuarioLogin = new javax.swing.JTextField();
        pwrdContraLogin = new javax.swing.JPasswordField();
        btnRegistrarse = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAcceder1 = new javax.swing.JButton();
        btnRetiroSinFolio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banco BDA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(187, 187, 207));

        txtfUsuarioLogin.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        pwrdContraLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnRegistrarse.setBackground(new java.awt.Color(89, 164, 232));
        btnRegistrarse.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");

        lblContra.setBackground(new java.awt.Color(255, 255, 255));
        lblContra.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblContra.setForeground(new java.awt.Color(255, 255, 255));
        lblContra.setText("Contraseña");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64, 64, 133));
        jLabel1.setText("BANCO BDA");

        btnAcceder1.setBackground(new java.awt.Color(218, 81, 85));
        btnAcceder1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAcceder1.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceder1.setText("Acceder");
        btnAcceder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceder1ActionPerformed(evt);
            }
        });

        btnRetiroSinFolio.setBackground(new java.awt.Color(65, 207, 144));
        btnRetiroSinFolio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnRetiroSinFolio.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiroSinFolio.setText("Retiro sin folio");
        btnRetiroSinFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinFolioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContra)
                            .addComponent(lblUsuario)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pwrdContraLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAcceder1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrarse)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnRetiroSinFolio)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(lblUsuario)
                .addGap(3, 3, 3)
                .addComponent(txtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContra)
                .addGap(0, 0, 0)
                .addComponent(pwrdContraLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse)
                    .addComponent(btnAcceder1))
                .addGap(18, 18, 18)
                .addComponent(btnRetiroSinFolio)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 *  Se crea un nuevo forms al seleccionar la opción de registro
 * @param evt Botón para el formulario de registro
 */
    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        RegistroForm registro = new RegistroForm(conexion);
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    /**
     *  Botón para entrar al programa una vez puesto el usuario y contraseña correcta
     * @param evt Accede al menú
     */
    private void btnAcceder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceder1ActionPerformed
        if (this.extraerLogin() != null) {
            MenuForm menu = new MenuForm(conexion, clienteLog);
            menu.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese credenciales validas");
        }
    }//GEN-LAST:event_btnAcceder1ActionPerformed

    /**
     * Retiro de dinero sin necesidad de un folio
     * @param evt 
     */
    private void btnRetiroSinFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroSinFolioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder1;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRetiroSinFolio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwrdContraLogin;
    private javax.swing.JTextField txtfUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
