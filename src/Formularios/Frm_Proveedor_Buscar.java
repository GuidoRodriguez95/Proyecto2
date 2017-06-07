package Formularios;
import Clases.Proveedores;
import Utilidades.Proveedor_Utilidades;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Frm_Proveedor_Buscar extends javax.swing.JFrame {

    /**
     * Creates new form Busqueda
     */
    public Frm_Proveedor_Buscar() {
        initComponents();
        this.setLocationRelativeTo(null);
        tabla();
        
    }
    
    public void filtro() {
        
        int columnaABuscar = 0;
        if (radioCodigo.isSelected()) {
            columnaABuscar = 0;
        }
        if (radioNombre.isSelected()) {
            columnaABuscar = 1;
        }

        trsFiltro.setRowFilter(RowFilter.regexFilter(t1.getText(), columnaABuscar));
    }
    
    public void tabla() {

        String columnas[] = {"CODIGO", "EMPRESA" , "DIRECCION", "TELEFONO", "CELULAR", "E-MAIL", "SITIO WEB" , "PRODUCTO" , "DESCRIPCION" , "FECHA"};
        DefaultTableModel tm = new DefaultTableModel(null, columnas);

        Proveedor_Utilidades pu = new Proveedor_Utilidades();
        pu.setRuta("src\\Archivos\\proveedores.txt");

        List<Proveedores> lista = new ArrayList();

        try {
            lista = pu.consultarProveedor();

            for (Proveedores elem : lista) {

                String registros[] = {elem.getCodigo(),elem.getEmpresa(),elem.getDireccion(),elem.getTelefono(),elem.getCelular(),elem.getEmail(),elem.getSitioweb(),elem.getProducto(),elem.getDescripcion(),elem.getFecha()};
                tm.addRow(registros);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "error");
        }

        Tabla_prov.setModel(tm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radioCodigo = new javax.swing.JRadioButton();
        radioNombre = new javax.swing.JRadioButton();
        t1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_prov = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1487472907_deliverables.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Niagara Solid", 1, 48)); // NOI18N
        jLabel2.setText("Buscar Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 300, 50));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Método de Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Niagara Solid", 1, 18))); // NOI18N

        radioCodigo.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup1.add(radioCodigo);
        radioCodigo.setFont(new java.awt.Font("Niagara Solid", 1, 18)); // NOI18N
        radioCodigo.setText("Código");

        radioNombre.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup1.add(radioNombre);
        radioNombre.setFont(new java.awt.Font("Niagara Solid", 1, 18)); // NOI18N
        radioNombre.setText("Nombre");
        radioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNombreActionPerformed(evt);
            }
        });

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(radioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNombre)
                    .addComponent(radioCodigo))
                .addGap(18, 18, 18)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 370, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 300, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 160));

        salir.setFont(new java.awt.Font("Niagara Solid", 1, 24)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1487472258_Exit.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 40, 40));

        Tabla_prov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        Tabla_prov.getTableHeader().setResizingAllowed(false);
        Tabla_prov.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabla_prov);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 670, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoazulceleste.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
        Menu m=new Menu();
        m.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    private void radioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNombreActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
        t1.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (t1.getText());
                t1.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(Tabla_prov.getModel());
        Tabla_prov.setRowSorter(trsFiltro);        // TODO add your handling code here:
    }//GEN-LAST:event_t1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Proveedor_Buscar().setVisible(true);
            }
        });
    }
private TableRowSorter trsFiltro;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_prov;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioCodigo;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JButton salir;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
