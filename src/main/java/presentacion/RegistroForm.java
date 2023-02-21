/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import dominio.Domicilio;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDomicilioDAO;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author JORGE
 */
public class RegistroForm extends javax.swing.JFrame {
private final IClientesDAO clientesDAO;
private final IDomicilioDAO domicilioDAO;
private ICuentasDAO cuentasDAO;
    /**
     * Creates new form RegistroForm
     */
    public RegistroForm(IClientesDAO clientesDAO, IDomicilioDAO domicilioDAO) {
        this.clientesDAO = clientesDAO;
        this.domicilioDAO = domicilioDAO;
        initComponents();
    }

    public void validarFechaNac(String txt){
        String patron = "\"^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$\"";
        Pattern pattern  = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(txt);
   
        if(!matcher.matches()){
             JOptionPane.showMessageDialog(this, "Ingrese una fecha con el formato 'yyyy-mm-dd'");
        }
    }
    
    private Cliente extraerDatosCliente(){
         java.sql.Date fechaNacimiento;
        String nombre = this.txtfNombres.getText();
        String apellidoPaterno = this.txtfApellidoPat.getText();
        String apellidoMaterno = this.txtfApellidoMat.getText();
         if(!this.txtfFechaNac.getText().matches("\"^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$\"")){
            JOptionPane.showMessageDialog(null, "Formato de fecha invalido ingrese una fecha 'yyyy-mm-dd'");
        }  fechaNacimiento = java.sql.Date.valueOf(this.txtfFechaNac.getText());
        String usuario = this.txtfUser.getText();
        String contrasenia = this.txtContra.getText();
        Cliente cliente = new Cliente(nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,usuario,contrasenia);
        return cliente;
    }
    
    private Domicilio extraerDatosDomicilio(){
        String calle = this.txtfCalle.getText();
        String colonia = this.txtfColonia.getText();
        String numCasa = this.txtfNumCasa.getText();
        Domicilio domicilio = new Domicilio(calle,colonia,numCasa);
        return domicilio;
    }
    
    private void mostrarMensajeClienteGuardado(Cliente clienteGuardado){
        JOptionPane.showMessageDialog(this, "Se agregó el cliente: " + clienteGuardado.getNombre(),"Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeErrorAlGuardar(){
        JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpiarCampos(){
        this.txtContra.setText("");
        this.txtfApellidoMat.setText("");
        this.txtfApellidoPat.setText("");
        this.txtfCalle.setText("");
        this.txtfColonia.setText("");
        this.txtfFechaNac.setText("");
        this.txtfNombres.setText("");
        this.txtfNumCasa.setText("");
        this.txtfUser.setText("");
    }
    
    
    
    private void guardar() throws PersistenciaException{
        //SACAR DATOS----VALIDARLOS ---- ENVIAR A DAO PARA GUARDAR
        try{
        Domicilio domicilio = this.extraerDatosDomicilio();
        Cliente cliente = this.extraerDatosCliente();
        System.out.println(domicilio);
        this.domicilioDAO.insertar(domicilio);
        cliente.setIdDireccion(domicilio.getId());
        this.clientesDAO.insertar(cliente);
        this.mostrarMensajeClienteGuardado(cliente);
        this.limpiarCampos();
        }catch(PersistenciaException ex){
           this.mostrarMensajeErrorAlGuardar();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtContra = new javax.swing.JTextField();
        txtfNombres = new javax.swing.JTextField();
        txtfApellidoPat = new javax.swing.JTextField();
        txtfApellidoMat = new javax.swing.JTextField();
        txtfFechaNac = new javax.swing.JTextField();
        txtfCalle = new javax.swing.JTextField();
        txtfNumCasa = new javax.swing.JTextField();
        txtfColonia = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        txtfUser = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(236, 250, 239));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Nombres");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Apellido paterno");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Apellido materno");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Usuario");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("contraseña");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Calle");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Colonia");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Num. casa");

        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        txtfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfNombresKeyTyped(evt);
            }
        });

        txtfApellidoPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfApellidoPatKeyTyped(evt);
            }
        });

        txtfApellidoMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfApellidoMatKeyTyped(evt);
            }
        });

        btnAcceder.setBackground(new java.awt.Color(81, 183, 145));
        btnAcceder.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAcceder.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceder.setText("Registrar");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        txtfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfUserKeyTyped(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(81, 183, 145));
        btnRegresar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setText("yyyy/mm/dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtfNombres))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfApellidoMat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfNumCasa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfColonia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfApellidoPat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtfFechaNac)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfApellidoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(txtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceder)
                    .addComponent(btnRegresar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        if (this.txtContra.getText().isEmpty() || this.txtfApellidoMat.getText().isEmpty() || this.txtfApellidoPat.getText().isEmpty() || this.txtfCalle.getText().isEmpty() || this.txtfColonia.getText().isEmpty() 
                || this.txtfFechaNac.getText().isEmpty()  || this.txtfNombres.getText().isEmpty() || this.txtfNumCasa.getText().isEmpty() || this.txtfUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que ser llenados");
        } else {
            try {
                this.guardar();
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar el cliente");
            }
        }
    }//GEN-LAST:event_btnAccederActionPerformed

    private void txtfNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfNombresKeyTyped
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfNombres.getText().length()>=50)evt.consume();  
    }//GEN-LAST:event_txtfNombresKeyTyped

    private void txtfApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfApellidoPatKeyTyped
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfApellidoPat.getText().length()>=50)evt.consume();  
    }//GEN-LAST:event_txtfApellidoPatKeyTyped

    private void txtfApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfApellidoMatKeyTyped
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfApellidoMat.getText().length()>=50)evt.consume();  
    }//GEN-LAST:event_txtfApellidoMatKeyTyped

    private void txtfUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfUserKeyTyped
         if(this.txtfUser.getText().length()>=20)evt.consume();
    }//GEN-LAST:event_txtfUserKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        if(this.txtContra.getText().length()>=16)evt.consume();
    }//GEN-LAST:event_txtContraKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       LoginForm login = new LoginForm(clientesDAO,domicilioDAO,cuentasDAO);
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtfApellidoMat;
    private javax.swing.JTextField txtfApellidoPat;
    private javax.swing.JTextField txtfCalle;
    private javax.swing.JTextField txtfColonia;
    private javax.swing.JTextField txtfFechaNac;
    private javax.swing.JTextField txtfNombres;
    private javax.swing.JTextField txtfNumCasa;
    private javax.swing.JTextField txtfUser;
    // End of variables declaration//GEN-END:variables
}
