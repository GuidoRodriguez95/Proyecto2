package Formularios;

import Clases.Caja;
import Clases.Clientes;
import Clases.Detalle;
import Clases.Factura;
import Clases.Inventarios;
import static Formularios.factura.fechaActual;
import Utilidades.Caja_Utilidades;
import Utilidades.Cliente_Utilidades;
import Utilidades.Detalle_Utilidades;
import Utilidades.Factura_Utilidades;
import Utilidades.Inventario_Utilidades;
import Utilidades.n2t;
import Utilidades.vld_textbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class factura extends javax.swing.JInternalFrame {

    ArrayList<Factura> facturas = new ArrayList<>();
    ArrayList<Detalle> detalles = new ArrayList<>();
    String tirilla[] = new String[50];
    ArrayList<Inventarios> productos = new ArrayList<>();
    ArrayList<Clientes> clientes = new ArrayList<>();
    ArrayList<Caja> caja = new ArrayList<>();
    String fact, det;
    String columnas[] = {"PRODUCTO", "CANTIDAD", "PRECIO"};
    DefaultTableModel tm = new DefaultTableModel(null, columnas);

    Double st = 0.0;
    Double t = 0.0, iva = 0.0;
    int co = 0;

    public factura() {
        initComponents();
        Cargar();
        hilo.start();
    }

    public void Numero() throws IOException {

        int n = 0;
        Factura f = new Factura();
        Factura_Utilidades uf = new Factura_Utilidades();
        uf.setRuta("src\\Archivos\\" + fact + "");
        List<Factura> facturas = new ArrayList();
        facturas = uf.leerFactura();

        for (Factura elem : facturas) {
            if (n < elem.getNumero()) {
                n = elem.getNumero();
            }

        }
        lblNumero.setText(Integer.toString(n + 1));
    }

    public void cargarFacturas() {

        File f = new File("src\\Archivos\\" + fact + "");
        try {

            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                facturas = (ArrayList<Factura>) ois.readObject();
                fis.close();
                ois.close();
                System.out.println("archivo cargado");
            } else {
                f.createNewFile();
                System.out.println("archivo creado");
            }
        } catch (Exception e) {
        }
    }

    public void cargarCajas() {

        File f = new File("src\\Archivos\\caja.txt");
        try {

            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                caja = (ArrayList<Caja>) ois.readObject();
                fis.close();
                ois.close();
                System.out.println("archivo cargado");
            } else {
                f.createNewFile();
                System.out.println("archivo creado");
            }
        } catch (Exception e) {
        }
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

    public void cargarDetalles() {

        File f = new File("src\\Archivos\\" + det + "");
        try {

            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                detalles = (ArrayList<Detalle>) ois.readObject();
                fis.close();
                ois.close();
                System.out.println("archivo cargado");
            } else {
                f.createNewFile();
                System.out.println("archivo creado");
            }
        } catch (Exception e) {
        }
    }

    public void Productos() {

        Inventario_Utilidades vu = new Inventario_Utilidades();
        vu.setRuta("src\\Archivos\\inventarios.txt");

        try {
            productos = vu.consultarInventario();

            for (Inventarios elem : productos) {
                combroProductos.addItem(elem.getCodigo() + "  " + elem.getNombre());

            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "error");
        }

    }

    public void Limpiar() {

        txtcliente.setText("");
        txtcedula.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtsubtotal.setText("");

        txtiva.setText("");
        txttotal.setText("");

        co++;
        st = 0.0;
        t = 0.0;
        iva = 0.0;

        String columnas[] = {"PRODUCTO", "CANTIDAD", "PRECIO"};
        DefaultTableModel tm = new DefaultTableModel(null, columnas);
        TablaFactura.setModel(tm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsalir2 = new javax.swing.JButton();
        lblhora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFactura = new javax.swing.JTable();
        lblminutos = new javax.swing.JLabel();
        lblsegundos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblfecha = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combocaja = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboBilletes = new javax.swing.JComboBox<>();
        txtmonedas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboMoneda = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtbilletes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        VENTAS = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        combroProductos = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        btnsalir2.setBackground(new java.awt.Color(51, 51, 51));
        btnsalir2.setText("MENU");
        btnsalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir2ActionPerformed(evt);
            }
        });

        lblhora.setBackground(new java.awt.Color(51, 51, 51));
        lblhora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblhora.setText("HH");

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        TablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "CANTIDAD", "DESCRIPCIÓN", "P.UNITARIO", "V. TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaFactura.setName(""); // NOI18N
        jScrollPane1.setViewportView(TablaFactura);

        lblminutos.setBackground(new java.awt.Color(51, 51, 51));
        lblminutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblminutos.setText("MM");

        lblsegundos.setBackground(new java.awt.Color(51, 51, 51));
        lblsegundos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblsegundos.setText("SS");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("C.I/ RUC:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtcliente.setEditable(false);
        txtcliente.setBackground(new java.awt.Color(102, 102, 102));
        txtcliente.setForeground(new java.awt.Color(255, 255, 0));
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        txtcedula.setBackground(new java.awt.Color(102, 102, 102));
        txtcedula.setForeground(new java.awt.Color(255, 255, 0));
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        jPanel2.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 240, -1));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Dirección:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        txtdireccion.setEditable(false);
        txtdireccion.setBackground(new java.awt.Color(102, 102, 102));
        txtdireccion.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 240, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Teléfono:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        txttelefono.setEditable(false);
        txttelefono.setBackground(new java.awt.Color(102, 102, 102));
        txttelefono.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 240, -1));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setText("BUSCAR CLIENTE POR CEDULA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        lblfecha.setBackground(new java.awt.Color(51, 51, 51));
        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfecha.setText("SS");

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("CAJA");

        combocaja.setBackground(new java.awt.Color(51, 51, 51));
        combocaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        combocaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocajaActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("BILLETES");

        comboBilletes.setBackground(new java.awt.Color(51, 51, 51));
        comboBilletes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NADA", "1", "5", "10", "20", "50", "100" }));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("CANTIDAD BILLETES");

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("MONEDAS");

        comboMoneda.setBackground(new java.awt.Color(51, 51, 51));
        comboMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NADA", "5", "10", "25", "50", "1" }));

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("CANTIDAD MONEDAS");

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Subtotal:");

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setText("COBRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txttotal.setEditable(false);

        lblNumero.setBackground(new java.awt.Color(51, 51, 51));
        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblNumero.setText("SS");

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("IVA 14%:");

        VENTAS.setFont(new java.awt.Font("Candara", 3, 36)); // NOI18N
        VENTAS.setText("INTRISEG");

        txtiva.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Candara", 3, 24)); // NOI18N
        jLabel1.setText("FACTURA #");

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Total:");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Producto");

        combroProductos.setBackground(new java.awt.Color(51, 51, 51));

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Cantidad");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setText("AÑADIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combroProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jButton3)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combroProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtsubtotal.setEditable(false);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10)
                        .addGap(24, 24, 24)
                        .addComponent(combocaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addGap(21, 21, 21)
                        .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addGap(15, 15, 15)
                        .addComponent(comboBilletes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel16)
                        .addGap(48, 48, 48)
                        .addComponent(comboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtbilletes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtmonedas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton4)
                        .addGap(465, 465, 465)
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)
                        .addComponent(btnsalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(VENTAS)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(lblNumero)
                                .addGap(164, 164, 164)
                                .addComponent(lblfecha)
                                .addGap(8, 8, 8)
                                .addComponent(lblhora)
                                .addGap(12, 12, 12)
                                .addComponent(lblminutos)
                                .addGap(8, 8, 8)
                                .addComponent(lblsegundos)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(VENTAS)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblfecha)
                            .addComponent(lblhora)
                            .addComponent(lblminutos)
                            .addComponent(lblsegundos))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(combocaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(comboBilletes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(comboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbilletes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton4))
                    .addComponent(jButton1)
                    .addComponent(btnsalir2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalir2ActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        new vld_textbox().soloNumeros(evt);
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (!new vld_textbox().validaCedula(txtcedula.getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA CEDULA VALIDA");
                return;
            }
            Cliente_Utilidades cu = new Cliente_Utilidades();
            cu.setRuta("src\\Archivos\\clientes.txt");

            clientes = cu.consultarClientes();

            for (Clientes elem : clientes) {

                if (txtcedula.getText().equals(elem.getCedula())) {

                    txtcliente.setText(elem.getNombre() + " " + elem.getApellido());

                    txtdireccion.setText(elem.getDireccion());
                    txttelefono.setText(elem.getTelefono());

                }
            }
        }catch (IOException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combocajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocajaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Caja c = new Caja();

        c.setCaja(combocaja.getSelectedItem().toString());
        if (comboBilletes.getSelectedItem().toString() != "NADA") {
            c.setBillete(Integer.parseInt(comboBilletes.getSelectedItem().toString()));
            c.setCantidadBillete(Integer.parseInt(txtbilletes.getText()));
        }

        if (comboMoneda.getSelectedItem().toString() != "NADA") {
            c.setMoneda(Double.parseDouble(comboMoneda.getSelectedItem().toString()));
            c.setCantidadMoneda(Integer.parseInt(txtmonedas.getText()));
        }

        int billetes = 0;
        Double cambio = 0.0, monedas = 0.0, t = 0.0;

        billetes = (c.getBillete() * c.getCantidadBillete());

        if (c.getMoneda() != 1) {
            monedas = (c.getMoneda() * c.getCantidadMoneda() / 100);

        } else {
            monedas = c.getMoneda() * c.getCantidadMoneda();
        }

        t = billetes + monedas;
        if (t < Double.parseDouble(txttotal.getText())) {
            JOptionPane.showMessageDialog(rootPane, "PAGO INCOMPLETO");

        } else {
            cambio = t - Double.parseDouble(txttotal.getText());
            c.setCambio(cambio);
            try {
                Caja_Utilidades cu = new Caja_Utilidades();
                cu.setRuta("src\\Archivos\\caja.txt");
                caja.add(c);
                cu.guardarCliente(caja);
                JOptionPane.showMessageDialog(rootPane, "SU CAMBIO ES DE : $" + cambio);
                bandera = true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "ERROR " + e.getMessage());

            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        new vld_textbox().soloNumeros(evt);
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (co > 0) {
            tm = new DefaultTableModel(null, columnas);
            co = co - 1;
        } else {
            for (Inventarios elem : productos) {
                if (elem.getCodigo().equalsIgnoreCase(combroProductos.getSelectedItem().toString().substring(0, 4).trim())) {
                    String registro[] = {elem.getNombre(), txtcantidad.getText(), elem.getPrecio().toString()};
                    tm.addRow(registro);
                    TablaFactura.setModel(tm);
                    st += elem.getPrecio() * Double.parseDouble(txtcantidad.getText());
                }
            }

            st = st;
            iva = st * 0.14;
            t = ((st + iva));
            txtsubtotal.setText(Double.toString((st)));
            txtiva.setText(Double.toString(((iva))));
            txttotal.setText(Double.toString((t)));

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!bandera) {
            JOptionPane.showMessageDialog(rootPane, "NO SE AH EFECTUADO EL PAGO CORRECTO");
            return;
        }
        if (txtcedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "LLENE TODOS LOS CAMPOS");
            return;
        }
        TableModel modelo = TablaFactura.getModel();
        int filas = modelo.getRowCount();

        try {

            Factura_Utilidades co = new Factura_Utilidades();
            co.setRuta("src\\Archivos\\" + fact + "");

            Factura f = new Factura();

            f.setFecha(lblfecha.getText());
            f.setNumero(Integer.parseInt(lblNumero.getText()));
            f.setIva(Double.parseDouble(txtiva.getText()));
            f.setSubtotal(Double.parseDouble(txtsubtotal.getText()));
            f.setTotal(Double.parseDouble(txttotal.getText()));
            f.setCedula_cliente(txtcedula.getText());

            facturas.add(f);
            co.guardarCliente(facturas);
            tirilla[0] = "FECHA : " + lblfecha.getText();
            tirilla[1] = "NUMERO DE FACTURA : " + lblNumero.getText();
            tirilla[2] = "CEDULA CLIENTE : " + txtcedula.getText();
            tirilla[3] = "CLIENTE :" + txtcliente.getText();
            tirilla[4] = "--------------------------------------------------";
            tirilla[5] = "----------------PRODUCTOS-------------------------";
            tirilla[6] = "--------------------------------------------------";
            tirilla[7] = "--------------EMPRESA  INTRISEG-------------------";
            tirilla[8] = "--------------------------------------------------";
            int c = 9;
            for (int i = 0; i < filas; i++) {

                Detalle df = new Detalle();
                Detalle_Utilidades dfs = new Detalle_Utilidades();
                dfs.setRuta("src\\Archivos\\" + det + "");
                df.setNumero_factura(Integer.parseInt(lblNumero.getText()));
                df.setServicio(modelo.getValueAt(i, 0).toString());
                df.setCantidad(Integer.parseInt((String) modelo.getValueAt(i, 1)));
                DisminuirStock(modelo.getValueAt(i, 0).toString(), Integer.parseInt((String) modelo.getValueAt(i, 1)));
                detalles.add(df);
                dfs.guardarCliente(detalles);
                tirilla[c] = "PRODUCTO : " + modelo.getValueAt(i, 0).toString() + "  CANTIDAD : " + (String) modelo.getValueAt(i, 1) + "  PRECIO : $" + (String) modelo.getValueAt(i, 2);
                c++;

            }

            tirilla[c] = "--------------------------------------------------";
            c++;
            tirilla[c] = "SUB-TOTAL : $" + txtsubtotal.getText();
            c++;
            tirilla[c] = "IVA : $" + txtiva.getText();
            c++;
            tirilla[c] = "TOTAL : $" + txttotal.getText();
            c++;
            n2t numero;
            String res;
            numero = new n2t();
            res = txttotal.getText();
            int posicionPunto = res.indexOf('.');
            int sHastaPrimerPunto = Integer.parseInt(res.substring(0, posicionPunto));
            int sDesdePrimerPunto = Integer.parseInt(res.substring(posicionPunto + 1, res.length()));
            String totalLetras = numero.convertirLetrasConDecimales(sHastaPrimerPunto, sDesdePrimerPunto);
            tirilla[c] = "TOTAL EN LETRAS: " + totalLetras + " centavos";
            co.escribir(tirilla, lblNumero.getText());
            JOptionPane.showMessageDialog(null, "Guardado con éxito!!");
            Limpiar();
            Numero();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Guardado con éxito!!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            fact = "facturas.txt";
            det = "detalles.txt";

            Numero();
        } catch (IOException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarFacturas();

        lblfecha.setText(fechaActual());

        Productos();
        cargarDetalles();
        cargarCajas();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        lblhora.setText(getHora().substring(0, 3));
        lblminutos.setText(getHora().substring(3, 6));
        lblsegundos.setText(getHora().substring(6, 8));        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameActivated

    public void Cargar() {

    }

    public void DisminuirStock(String c, int cantidad) {
        Inventarios s = new Inventarios();
        int cant = 0;
        try {

            remover:
            for (Inventarios elem : productos) {

                if (c.equalsIgnoreCase(elem.getNombre())) {
                    s = elem;
                    productos.remove(elem);
                    cant = s.getCantidad();
                    cant = cant - cantidad;
                    s.setCantidad(cant);
                    productos.add(s);
                    break remover;
                }
            }
        } catch (Exception e) {
        }

        try {

            Inventario_Utilidades su = new Inventario_Utilidades();
            su.setRuta("src\\Archivos\\inventarios.txt");

            su.guardarInventario(productos);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error al modificar stock");
        }
    }

    Boolean bandera = false;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaFactura;
    private javax.swing.JLabel VENTAS;
    private javax.swing.JButton btnsalir2;
    private javax.swing.JComboBox<String> comboBilletes;
    private javax.swing.JComboBox<String> comboMoneda;
    private javax.swing.JComboBox<String> combocaja;
    private javax.swing.JComboBox combroProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    private javax.swing.JLabel lblminutos;
    private javax.swing.JLabel lblsegundos;
    private javax.swing.JTextField txtbilletes;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtmonedas;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
