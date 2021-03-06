package Formularios;

import Clases.Proveedores;
import Utilidades.Proveedor_Utilidades;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frm_Proveedor_Buscar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Proveedor_Buscar1
     */
    public Frm_Proveedor_Buscar() {
        initComponents();
        tabla();
        hilo.start();
    }

    public static String fechaActual() {
        Date Fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(Fecha);

    }

    public String getHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }
    Thread hilo = new Thread() {
        public void run() {
            for (int i = 0; i < 100000000; i++) {
                lblhora.setText(getHora().substring(0, 3));
                lblminutos.setText(getHora().substring(3, 6));
                lblsegundos.setText(getHora().substring(6, 8));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    };

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

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        radioCodigo = new javax.swing.JRadioButton();
        radioNombre = new javax.swing.JRadioButton();
        t1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_prov = new javax.swing.JTable();
        salir = new javax.swing.JButton();
        lblsegundos = new javax.swing.JLabel();
        lblminutos = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 170, 160));

        jLabel2.setFont(new java.awt.Font("Niagara Solid", 1, 48)); // NOI18N
        jLabel2.setText("Buscar Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 300, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 300, 30));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Método de Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Niagara Solid", 1, 18))); // NOI18N

        radioCodigo.setBackground(new java.awt.Color(102, 102, 255));
        radioCodigo.setFont(new java.awt.Font("Niagara Solid", 1, 18)); // NOI18N
        radioCodigo.setText("Código");

        radioNombre.setBackground(new java.awt.Color(102, 102, 255));
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

        salir.setFont(new java.awt.Font("Niagara Solid", 1, 24)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1487472258_Exit.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 40, 40));

        lblsegundos.setBackground(new java.awt.Color(51, 51, 51));
        lblsegundos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblsegundos.setText("SS");
        getContentPane().add(lblsegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        lblminutos.setBackground(new java.awt.Color(51, 51, 51));
        lblminutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblminutos.setText("MM");
        getContentPane().add(lblminutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        lblhora.setBackground(new java.awt.Color(51, 51, 51));
        lblhora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblhora.setText("HH");
        getContentPane().add(lblhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        lblfecha.setBackground(new java.awt.Color(51, 51, 51));
        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfecha.setText("SS");
        getContentPane().add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoazulceleste.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNombreActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

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

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        lblhora.setText(getHora().substring(0, 3));
        lblminutos.setText(getHora().substring(3, 6));
        lblsegundos.setText(getHora().substring(6, 8));         // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        lblfecha.setText(fechaActual());        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

private TableRowSorter trsFiltro;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_prov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    private javax.swing.JLabel lblminutos;
    private javax.swing.JLabel lblsegundos;
    private javax.swing.JRadioButton radioCodigo;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JButton salir;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
