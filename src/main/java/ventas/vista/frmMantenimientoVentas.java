/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.vista;


import ventas.modelo.daoVendedores;
import ventas.modelo.daoVentas;
import ventas.modelo.daoCliente;
import ventas.controlador.clsVentas;
import ventas.controlador.clsCliente;
import ventas.controlador.clsVendedores;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import logistica.controlador.clsBodega;
import logistica.controlador.clsProductos;
import logistica.modelo.daoBodega;
import logistica.modelo.daoProductos;



/**
 *
 * @author visitante
 */
public class frmMantenimientoVentas extends javax.swing.JInternalFrame {

    public void ComboCliente() {
        daoCliente VentasDAO = new daoCliente();
        List<clsCliente> ventas = VentasDAO.select();
        cbox_clicodigo.addItem("Seleccione un cliente");
        //cbox_clicodigo.removeAllItems();
        for (int i = 0; i < ventas.size(); i++) {
            cbox_clicodigo.addItem(String.valueOf(ventas.get(i).getClicodigo()));
        }
    }
    
        public void ComboEstatus() {
        daoVentas VentasDAO = new daoVentas();
        List<clsVentas> ventas = VentasDAO.select();
        cbox_veeestatus.addItem("Seleccione un Estado");
    }
    
        public void estados() {    
        cbox_veeestatus.addItem("1");
        cbox_veeestatus.addItem("0");
    }
        
        public void ComboProducto() {
        daoProductos VentasDAO = new daoProductos();
        List<clsProductos> ventas = VentasDAO.select();
        cbox_prodcodigo.addItem("Seleccione un Producto");
        //cbox_clicodigo.removeAllItems();
        for (int i = 0; i < ventas.size(); i++) {
            cbox_prodcodigo.addItem(String.valueOf(ventas.get(i).getProdcodigo()));
        }
    }
        
        public void ComboBodega() {
        daoBodega VentasDAO = new daoBodega();
        List<clsBodega> ventas = VentasDAO.select();
        cbox_bodcodigo.addItem("Seleccione una Bodega");
        //cbox_clicodigo.removeAllItems();
        for (int i = 0; i < ventas.size(); i++) {
            cbox_bodcodigo.addItem(String.valueOf(ventas.get(i).getcodigob()));
        }
    }    
    

    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Documento");//ENCABEZADO
        modelo.addColumn("ID cliente");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total Venta");
        modelo.addColumn("Estatus");
        modelo.addColumn("Orden");//DETALLE
        modelo.addColumn("ID Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("ID Bodega");

        daoVentas vendedorDAO = new daoVentas();
        List<clsVentas> ventas = vendedorDAO.select();
        daoVentas vendedorDAO2 = new daoVentas();
        List<clsVentas> ventas2 = vendedorDAO.select2();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < ventas.size(); i++) {
            dato[0] = ventas.get(i).Getveedocumento(); //ENCABEZADO
            dato[1] = Integer.toString(ventas.get(i).Getclicodigo());
            dato[2] = ventas.get(i).Getveefecha();
            dato[3] = Integer.toString(ventas.get(i).Getveetotal());
            dato[4] = ventas.get(i).Getveeestatus();
            dato[5] = Integer.toString(ventas2.get(i).Getvedorden());//DETALLE
            dato[6] = Integer.toString(ventas2.get(i).Getprodcodigo());
            dato[7] = Integer.toString(ventas2.get(i).Getvedcantidad());
            dato[8] = Integer.toString(ventas2.get(i).Getvedprecio());
            dato[9] = Integer.toString(ventas2.get(i).Getbodcodigo());
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
        clsVentas ventasAConsultar = new clsVentas();
        clsVentas ventasAConsultar2 = new clsVentas();
        daoVentas vendedorDAO = new daoVentas();   
        daoVentas vendedorDAO2 = new daoVentas();
        
        //***************************ENCABEZADO*********************************
        ventasAConsultar.Setvedcodigo(txtbuscado.getText());
        ventasAConsultar = vendedorDAO.query(ventasAConsultar); 
        txtIDDocumento.setText(ventasAConsultar.Getveedocumento());
        cbox_clicodigo.setSelectedItem(Integer.toString(ventasAConsultar.Getclicodigo()));
        txtFecha.setText(ventasAConsultar.Getveefecha());
        txtTotalVentas.setText(Integer.toString(ventasAConsultar.Getveetotal()));
        cbox_veeestatus.setSelectedItem(ventasAConsultar.Getveeestatus());
        //***************************DETALLE***********************************
        ventasAConsultar2.Setvedcodigo(txtbuscado.getText());
        ventasAConsultar2 = vendedorDAO2.query2(ventasAConsultar2);
        txtIDDocumento.setText(ventasAConsultar2.Getveedocumento());
        txtOrdenID.setText(Integer.toString(ventasAConsultar2.Getvedorden()));
        cbox_prodcodigo.setSelectedItem(Integer.toString(ventasAConsultar2.Getprodcodigo()));
        txtCantidad.setText(Integer.toString(ventasAConsultar2.Getvedcantidad()));
        txtPrecio.setText(Integer.toString(ventasAConsultar2.Getvedprecio()));
        cbox_bodcodigo.setSelectedItem(Integer.toString(ventasAConsultar2.Getbodcodigo()));
        txtIDDocumento.setEnabled(false);
        
    }

    public frmMantenimientoVentas() {
        initComponents();
        llenadoDeTablas();
        ComboCliente();
        ComboEstatus();
        estados();
        ComboProducto();
        ComboBodega();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtTotalVentas = new javax.swing.JTextField();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        label15 = new javax.swing.JLabel();
        txtOrdenID = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cbox_clicodigo = new javax.swing.JComboBox<>();
        cbox_prodcodigo = new javax.swing.JComboBox<>();
        cbox_bodcodigo = new javax.swing.JComboBox<>();
        label8 = new javax.swing.JLabel();
        txtIDDocumento = new javax.swing.JTextField();
        cbox_veeestatus = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Ventas");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Ventas");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Cliente codigo");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 102, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 95, -1));

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 130, 263, -1));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Fecha");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 20, 13, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, -1, -1));

        txtTotalVentas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTotalVentas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 165, 263, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Estatus");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 200, -1, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Total venta");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 165, -1, -1));

        tablaVendedores.setBackground(new java.awt.Color(153, 255, 153));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 20, 880, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        jLabel1.setText("1 = Habilitado y 0 = Inhabilitado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 263, -1));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Orden ID");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 234, -1, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Codigo Producto");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 272, -1, -1));

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Cantidad");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 309, -1, -1));

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("Precio");
        getContentPane().add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 344, -1, -1));

        label15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label15.setText("Bodega ID");
        getContentPane().add(label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 385, -1, -1));

        txtOrdenID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOrdenID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtOrdenID, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 234, 263, -1));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 309, 263, -1));

        txtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 344, 263, -1));

        cbox_clicodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_clicodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_clicodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_clicodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 92, 260, -1));

        cbox_prodcodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_prodcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_prodcodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_prodcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 269, 263, -1));

        cbox_bodcodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_bodcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_bodcodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_bodcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 382, 263, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("ID Documento");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, -1, -1));

        txtIDDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIDDocumento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtIDDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 57, 263, -1));

        getContentPane().add(cbox_veeestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 200, 263, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //****************DETALLE****************
        daoVentas vendedorDAO2 = new daoVentas();
        clsVentas vendedorAEliminar2 = new clsVentas();
        vendedorAEliminar2.Setvedcodigo(txtbuscado.getText());
        vendedorDAO2.delete2(vendedorAEliminar2);
        //****************ENCABEZADO****************
        daoVentas vendedorDAO = new daoVentas();
        clsVentas vendedorAEliminar = new clsVentas();
        vendedorAEliminar.Setvedcodigo(txtbuscado.getText());
        vendedorDAO.delete(vendedorAEliminar);        
        llenadoDeTablas();
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoVentas vendedorDAO = new daoVentas();
        daoVentas vendedorDAO2 = new daoVentas();
        clsVentas ventasAInsertar = new clsVentas();
        clsVentas ventasAInsertar2 = new clsVentas();
        //******************ENCABEZADO**********************
        ventasAInsertar.Setvedcodigo(txtIDDocumento.getText());
        ventasAInsertar.Setclicodigo(Integer.parseInt(cbox_clicodigo.getSelectedItem().toString()));
        ventasAInsertar.Setveefecha(txtFecha.getText());
        ventasAInsertar.Setveetotal(Integer.parseInt(txtTotalVentas.getText()));
        ventasAInsertar.Setveeestatus(cbox_veeestatus.getSelectedItem().toString());
        //******************DETALLE**************************
        ventasAInsertar2.Setvedcodigo(txtIDDocumento.getText());
        ventasAInsertar2.Setvedorden(Integer.parseInt(txtOrdenID.getText()));
        ventasAInsertar2.Setprodcodigo(Integer.parseInt(cbox_prodcodigo.getSelectedItem().toString()));
        ventasAInsertar2.Setvedcantidad(Integer.parseInt(txtCantidad.getText()));
        ventasAInsertar2.Setvedprecio(Integer.parseInt(txtPrecio.getText()));
        ventasAInsertar2.Setbodcodigo(Integer.parseInt(cbox_bodcodigo.getSelectedItem().toString()));
        
        vendedorDAO.insert(ventasAInsertar);
        vendedorDAO2.insert2(ventasAInsertar2);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        daoVentas vendedorDAO2 = new daoVentas();
        clsVentas vendedorAActualizar2 = new clsVentas();
        daoVentas vendedorDAO = new daoVentas();
        clsVentas vendedorAActualizar = new clsVentas();
        //******************DETALLE**************************
        vendedorAActualizar2.Setvedcodigo(txtbuscado.getText());
        vendedorAActualizar2.Setvedorden(Integer.parseInt(txtOrdenID.getText()));
        vendedorAActualizar2.Setprodcodigo(Integer.parseInt(cbox_prodcodigo.getSelectedItem().toString()));
        vendedorAActualizar2.Setvedcantidad(Integer.parseInt(txtCantidad.getText()));
        vendedorAActualizar2.Setvedprecio(Integer.parseInt(txtPrecio.getText()));
        vendedorAActualizar2.Setbodcodigo(Integer.parseInt(cbox_bodcodigo.getSelectedItem().toString()));
        vendedorDAO2.update2(vendedorAActualizar2);
        //******************ENCABEZADO**********************
        vendedorAActualizar.Setvedcodigo(txtbuscado.getText());
        vendedorAActualizar.Setclicodigo(Integer.parseInt(cbox_clicodigo.getSelectedItem().toString()));
        vendedorAActualizar.Setveefecha(txtFecha.getText());
        vendedorAActualizar.Setveetotal(Integer.parseInt(txtTotalVentas.getText()));
        vendedorAActualizar.Setveeestatus(cbox_veeestatus.getSelectedItem().toString());    
        vendedorDAO.update(vendedorAActualizar);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
        llenadoDeTablas();     
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIDDocumento.setText("");
        cbox_clicodigo.setSelectedIndex(0);
        txtFecha.setText("");
        txtTotalVentas.setText("");
        cbox_veeestatus.setSelectedIndex(0);
        txtOrdenID.setText("");
        cbox_prodcodigo.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecio.setText("");
        cbox_bodcodigo.setSelectedIndex(0);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cbox_clicodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_clicodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_clicodigoActionPerformed

    private void cbox_prodcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_prodcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_prodcodigoActionPerformed

    private void cbox_bodcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_bodcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_bodcodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_bodcodigo;
    private javax.swing.JComboBox<String> cbox_clicodigo;
    private javax.swing.JComboBox<String> cbox_prodcodigo;
    private javax.swing.JComboBox<String> cbox_veeestatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIDDocumento;
    private javax.swing.JTextField txtOrdenID;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotalVentas;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
