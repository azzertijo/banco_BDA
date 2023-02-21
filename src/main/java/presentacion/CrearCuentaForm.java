/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.CuentasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
  * @author Jorge Sánchez y Rosalía Pérez
 */
public class CrearCuentaForm extends javax.swing.JFrame {
private final IClientesDAO clientesDAO;
private final ICuentasDAO cuentasDAO;
private final Cliente cliente;
private final IConexionBD conexion;
private int num_cuenta;

    /**
     * Constructores
     */
    public CrearCuentaForm(IConexionBD conexion, Cliente cliente) {
        this.conexion=conexion;
        this.cuentasDAO= new CuentasDAO(conexion);
        this.clientesDAO= new ClientesDAO(conexion);
        this.cliente=cliente;
        initComponents();
        Random random = new Random();
        num_cuenta= random.nextInt(9000000) + 10000000;
        this.lblCuenta.setText(String.valueOf(num_cuenta));
    }

    /**
     * Extrae los datos de la cuenta creada para el cliente
     * @return Número de cuenta
     */
    public Cuenta extraerDatosCuenta(){
       Double saldo = Double.parseDouble(this.txtSaldo.getText());
       Integer numcuenta =Integer.parseInt(this.lblCuenta.getText());
       Integer id_cliente = this.cliente.getId();
       Cuenta cuentaC = new Cuenta(numcuenta,saldo,id_cliente);
       System.out.println(cuentaC);
       return cuentaC;  
    }
    /**
     * Muestra un mensaje si la cuenta se creó
     * @param cuentaGuardada 
     */
    private void mostrarMensajeCuentaGuardado(Cuenta cuentaGuardada){
        JOptionPane.showMessageDialog(this, "Se creó la cuenta: " + cuentaGuardada.getNum_cuenta(),"Información",JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Muestra un mensaje si la cuenta no se creó
     */
    private void mostrarMensajeErrorAlGuardar(){
        JOptionPane.showMessageDialog(this, "No fue posible crear la cuenta","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Crea el ID de la cuenta
     * @throws PersistenciaException 
     */
    private void crear() throws PersistenciaException{
        try{
            Cuenta cuentaE = this.extraerDatosCuenta();
            System.out.println( "E"+cuentaE);
            this.cuentasDAO.insertar(cuentaE);

            this.mostrarMensajeCuentaGuardado(cuentaE);
        }catch(PersistenciaException e){
            this.mostrarMensajeErrorAlGuardar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtSaldo = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear cuenta");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(191, 218, 220));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 51, 89));
        jLabel1.setText("Numero de cuenta:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(26, 51, 89));
        jLabel2.setText("Saldo a agregar:");

        btnCrear.setBackground(new java.awt.Color(218, 81, 85));
        btnCrear.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(89, 164, 232));
        btnRegresar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtSaldo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(26, 51, 89));

        lblCuenta.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(26, 51, 89));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(97, 164, 127));
        jLabel4.setText("CREAR UNA CUENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Crea la cuenta con el saldo seleccionado
 * @param evt Botón de crear cuenta
 */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
       CuentasForm cuentas = new CuentasForm(conexion,cliente);
        if(this.txtSaldo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un saldo a agregar a la cuenta");
        }else{
            try{
                this.crear();
                this.setVisible(false);
                cuentas.setVisible(true);
            }catch(PersistenciaException e){
                JOptionPane.showMessageDialog(null, "No se pudo crear la cuenta");
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed
/**
 * Botón de regreso al menú de cuentas
 * @param evt 
 */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        CuentasForm cuentas = new CuentasForm(conexion,cliente);
        this.setVisible(false);
        cuentas.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
