/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import dominio.Domicilio;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.CuentasDAO;
import implementaciones.DomicilioDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDomicilioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Sánchez y Rosalía Pérez
 */
public class ActualizarForm extends javax.swing.JFrame {
private final IClientesDAO clientesDAO;
private final IDomicilioDAO domicilioDAO;
private final ICuentasDAO cuentasDAO;
private final IConexionBD conexion;
private final Cliente cliente;
private Domicilio domicilio;


    /**
     * Constructores 
     */
    public ActualizarForm(IConexionBD conexion, Cliente cliente, Domicilio domicilio) throws PersistenciaException {
       this.conexion=conexion;
       this.clientesDAO= new ClientesDAO(conexion);
       this.domicilioDAO= new DomicilioDAO(conexion);
       this.cuentasDAO= new CuentasDAO(conexion);
       this.cliente=cliente;
       this.domicilio=domicilio;
       
        initComponents();
        
        
        this.txtfUser.setText(cliente.getUsuario());
        this.txtContra.setText(cliente.getContrasenia());
        this.txtfNombres.setText(cliente.getNombre());
        this.txtfApellidoPat.setText(cliente.getApellido_paterno());
        this.txtfApellidoMat.setText(cliente.getApellido_materno());
        this.txtfCalle.setText(this.consultarDomicilioCliente().getCalle());
        this.txtfColonia.setText(this.consultarDomicilioCliente().getColonia());
        this.txtfNumCasa.setText(this.consultarDomicilioCliente().getNum_casa());
    }
    
/**
 *  Extrae los datos personales del cliente para poder ser actualizados
 * @return Datos del cliente
 */
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
    
    /**
     * Extrae los datos de domicilio del cliente para poder ser actualizados
     * @return Datos de domicilio
     */
    private Domicilio extraerDatosDomicilio(){
        String calle = this.txtfCalle.getText();
        String colonia = this.txtfColonia.getText();
        String numCasa = this.txtfNumCasa.getText();
        Domicilio domicilio = new Domicilio(calle,colonia,numCasa);
        return domicilio;
    }
    
    /**
     * Consulta el domicilio del cliente
     * @return Domicilio actualizado
     * @throws PersistenciaException En caso de que no se pudiera consultar el domicilio
     */
    private Domicilio consultarDomicilioCliente() throws PersistenciaException{
       try{
        domicilio = domicilioDAO.consultar(cliente.getIdDireccion());
        System.out.println(domicilio);
        return domicilio;
       }catch(PersistenciaException ex){
           JOptionPane.showMessageDialog(null, "No se pudo consultar el domicilio");
           return null;
       }  
    }
    
    /**
     * Mensaje de cuando los datos del cliente son guardados con éxito
     * @param clienteGuardado Datos actualizados
     */
    private void mostrarMensajeClienteGuardado(Cliente clienteGuardado){
        JOptionPane.showMessageDialog(this, "Se actualizaron los datos " + clienteGuardado.getNombre(),"Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Mensaje en caso de que existiera algún error al momento de actualizar los datos
     */
    private void mostrarMensajeErrorAlGuardar(){
        JOptionPane.showMessageDialog(this, "No fue posible actualizar los datos","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Actualiza los datos
     * @throws PersistenciaException Error en caso de que no se pudieran actualizar los datos
     */
    private void actualizar() throws PersistenciaException{
        try{
        Domicilio domicilioA = this.extraerDatosDomicilio();
        Cliente clienteA = this.extraerDatosCliente();
        cliente.setId(this.cliente.getId());
        this.domicilioDAO.actualizar(domicilioA);
        cliente.setIdDireccion(domicilioA.getId());
        this.clientesDAO.actualizar(clienteA);
        this.mostrarMensajeClienteGuardado(cliente);
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
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(198, 198, 221));
        jPanel1.setPreferredSize(new java.awt.Dimension(534, 489));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(97, 97, 164));
        jLabel1.setText("Nombres");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 97, 164));
        jLabel2.setText("Apellido paterno");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 97, 164));
        jLabel3.setText("Apellido materno");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(97, 97, 164));
        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 97, 164));
        jLabel5.setText("Usuario");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(97, 97, 164));
        jLabel6.setText("contraseña");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 97, 164));
        jLabel7.setText("Calle");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(97, 97, 164));
        jLabel8.setText("Colonia");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(97, 97, 164));
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

        btnAcceder.setBackground(new java.awt.Color(218, 81, 85));
        btnAcceder.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAcceder.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceder.setText("Actualizar");
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

        btnRegresar.setBackground(new java.awt.Color(89, 164, 232));
        btnRegresar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(156, 97, 164));
        jLabel11.setText("DATOS DE USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtfFechaNac))
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
                                    .addComponent(txtfApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnAcceder)
                        .addGap(55, 55, 55)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(txtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAcceder))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Cambio de contraseña mayor a dieciséis carácteres
 * @param evt 
 */
    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
       
        if(this.txtContra.getText().length()>=16)evt.consume();
    }//GEN-LAST:event_txtContraKeyTyped
/**
     * Revisa que solo existan carácteres entre la A a la Z, sin números
 * @param evt 
 */
    private void txtfNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfNombresKeyTyped
        
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfNombres.getText().length()>=50)evt.consume();
    }//GEN-LAST:event_txtfNombresKeyTyped
/**
 *    Revisa que solo existan carácteres entre la A a la Z, sin números
 * @param evt 
 */
    private void txtfApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfApellidoPatKeyTyped
        
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfApellidoPat.getText().length()>=50)evt.consume();
    }//GEN-LAST:event_txtfApellidoPatKeyTyped
/**
 * Revisa que solo existan carácteres entre la A a la Z, sin números
 * @param evt 
 */
    private void txtfApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfApellidoMatKeyTyped
 
        char c = evt.getKeyChar();
        if(((c<'a' || c>'z') && (c<'A') | c>'Z') || this.txtfApellidoMat.getText().length()>=50)evt.consume();
    }//GEN-LAST:event_txtfApellidoMatKeyTyped
/**
 * Botón para actualizar los datos
 * @param evt 
 */
    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        if (this.txtContra.getText().isEmpty() || this.txtfApellidoMat.getText().isEmpty() || this.txtfApellidoPat.getText().isEmpty() || this.txtfCalle.getText().isEmpty() || this.txtfColonia.getText().isEmpty()
            || this.txtfFechaNac.getText().isEmpty()  || this.txtfNombres.getText().isEmpty() || this.txtfNumCasa.getText().isEmpty() || this.txtfUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que ser llenados");
        } else {
            try {
                this.actualizar();
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar el cliente");
            }
        }
    }//GEN-LAST:event_btnAccederActionPerformed
/**
 * Se encarga de verificar que el nombre de usuario sea mayor o igual a veinte carácteres
 * @param evt 
 */
    private void txtfUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfUserKeyTyped
        
        if(this.txtfUser.getText().length()>=20)evt.consume();
    }//GEN-LAST:event_txtfUserKeyTyped
/**
 * Botón para regresar al menú
 * @param evt 
 */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuForm menu = new MenuForm(conexion,cliente);
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
