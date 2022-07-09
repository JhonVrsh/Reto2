
package Vistas;


import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;
    
    

   
    public UserMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
        borrarRegistrosTabla();
        listarEmpleados();
        
    }

    private void listarEmpleados(){
        String nombre = txtBuscarEmp.getText();
        if(nombre.isEmpty()){
            String query = "SELECT * FROM empleados";
            try{
                connection = conexion.getConnection();
                // creamos la consulta query para la base de datos 
                st = connection.createStatement();
                rs = st.executeQuery(query);
                // Asignar en un objeto los datos que devuelve de cada registro 
                Object[] empleado = new Object [6];
                contenidoTablaEmpleados =(DefaultTableModel) tblEmpleados.getModel();
                // el resultado de la consulta del query nos determina el # de empleados

                while(rs.next()){
                    empleado[0] = rs.getInt("idEmp");
                    empleado[1] = rs.getString("nombreEmp"); 
                    empleado[2] = rs.getString("apellidos");
                    empleado[3] = rs.getString("tipoDocumento");
                    empleado[4] = rs.getString("documento");
                    empleado[5] = rs.getString("correo");
                    //E la tabla creamos una nueva fila con los 5 atributos del objeto empleado
                    contenidoTablaEmpleados.addRow(empleado);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                    System.out.println("idEmp : " + empleado[0] + ", nombre: " + empleado[1] + empleado[2] 
                                        + ", docuemento: " + empleado[3] + " " + empleado[4]
                                        + ", correo: " + empleado[5]);
                }

            }catch(SQLException e){
                System.out.println("No se pudo cargar la información de los empleados");

            }
        }else{
            String query = "SELECT * FROM empleados WHERE nombreEmp LIKE '%"+ nombre+"%' OR apellidos LIKE '%"+nombre+"%';";
            try{
                connection = conexion.getConnection();
                // creamos la consulta query para la base de datos 
                st = connection.createStatement();
                rs = st.executeQuery(query);
                // Asignar en un objeto los datos que devuelve de cada registro 
                Object[] empleado = new Object [6];
                contenidoTablaEmpleados =(DefaultTableModel) tblEmpleados.getModel();
                // el resultado de la consulta del query nos determina el # de empleados

                while(rs.next()){
                    empleado[0] = rs.getInt("idEmp");
                    empleado[1] = rs.getString("nombreEmp"); 
                    empleado[2] = rs.getString("apellidos");
                    empleado[3] = rs.getString("tipoDocumento");
                    empleado[4] = rs.getString("documento");
                    empleado[5] = rs.getString("correo");
                    //E la tabla creamos una nueva fila con los 5 atributos del objeto empleado
                    contenidoTablaEmpleados.addRow(empleado);
                    
                    System.out.println("idEmp : " + empleado[0] + ", nombre: " + empleado[1] + empleado[2] 
                                        + ", docuemento: " + empleado[3] + " " + empleado[4]
                                        + ", correo: " + empleado[5]);
                }
                tblEmpleados.setModel(contenidoTablaEmpleados);

            }catch(SQLException e){
                System.out.println("Error");

            }
            
        }
    }
    private void borrarRegistrosTabla(){
        for(int i = 0; i < tblEmpleados.getRowCount(); i++){
            contenidoTablaEmpleados.removeRow(i);
            //Cda vez que se elimine una fila deben quedar menos filas por eliminar 
            i = i- 1;
        }
    
    
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarEmp = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));

        jPanel4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.focusColor"));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmp", "Nombre", "Apellidos", "Tipo_documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img2.png"))); // NOI18N
        btnAddUser.setText("Añadir");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel2.setText("EMPLEADOS");

        jLabel3.setText("Mision TIC 2022");

        jLabel4.setText("Buscar");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel3))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddUser)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUserForm addUserForm = new AddUserForm(this,true);
        addUserForm.setVisible(true);
        // actualizar la informacion 
        borrarRegistrosTabla();
        listarEmpleados();
        
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada"+ row);
        // validar si el usuario no ha seleccionado una fila 
        if(row<0){
            JOptionPane.showMessageDialog(this, "Seleccione un empleado", "", JOptionPane.WARNING_MESSAGE);
            
        }else{
            int id = Integer.parseInt(tblEmpleados.getValueAt(row,0).toString());
            String nombre = (String) tblEmpleados.getValueAt(row,1);
            String apellidos = (String) tblEmpleados.getValueAt(row,2);
            String tipoDocumento = (String) tblEmpleados.getValueAt(row,3);
            String documento = (String) tblEmpleados.getValueAt(row,4);
            String correo = (String) tblEmpleados.getValueAt(row,5);
            System.out.println("id: "+ id + ", nombre: "+ nombre+" "+ apellidos+ ", tipo documento: "+ tipoDocumento+
                                "documento: "+ documento + ", correo: "+correo);
            
            
            ShowUserForm showUserForm = new ShowUserForm(this,true);
            showUserForm.recibeDatos(id,nombre,apellidos,tipoDocumento,documento,correo);
            showUserForm.setVisible(true);
            
            borrarRegistrosTabla();
            listarEmpleados();
            
                   
        }
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscarEmp;
    // End of variables declaration//GEN-END:variables
}
