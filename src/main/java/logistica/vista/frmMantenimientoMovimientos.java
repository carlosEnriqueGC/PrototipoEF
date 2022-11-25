/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Juan Miguel Sandoval Chile.
 */
package logistica.vista;

import seguridad.vista.*;
import logistica.modelo.daoMovimientos;
import logistica.controlador.clsMovimientos;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 *
 * @author visitante Juan Miguel Sandoval
 */
public class frmMantenimientoMovimientos extends javax.swing.JInternalFrame {

    
    
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Movimiento");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Nombre producto");
         modelo.addColumn("Cantidad");
         modelo.addColumn("Nombre linea");
         modelo.addColumn("Nombre marca");
         modelo.addColumn("Nombre concepto");
         modelo.addColumn("Total");
        
        daoMovimientos perfilDAO = new daoMovimientos();
        List<clsMovimientos> perfiles = perfilDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[20];
        for (int i = 0; i < perfiles.size(); i++) {
            dato[0] = Integer.toString(perfiles.get(i).getMovid());
            dato[1] = perfiles.get(i).getMovfecha();
                 
            dato[2] = perfiles.get(i).getMovestado();
             
            dato[3] = perfiles.get(i).getProdnombre();
 
            dato[4] = Integer.toString(perfiles.get(i).getMovcantidad());
            dato[5] = perfiles.get(i).getLinnombre();
            dato[6] = perfiles.get(i).getMarnombre();
            dato[7] = perfiles.get(i).getConnombre();
            dato[8] = Integer.toString(perfiles.get(i).getmovtotal());
                 
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
        clsMovimientos vendedorAConsultar = new clsMovimientos();
        daoMovimientos perfilDAO = new daoMovimientos();

        vendedorAConsultar.setMovid(Integer.parseInt(txtbuscado.getText()));
        vendedorAConsultar = perfilDAO.query(vendedorAConsultar);
        
        
        txtFecha.setText( vendedorAConsultar.getMovfecha());  
        txEstado.setText(vendedorAConsultar.getMovestado());  
        txtProducto.setText(Integer.toString( vendedorAConsultar.getProdcodigo()));  
        txtCantidad.setText(Integer.toString( vendedorAConsultar.getMovcantidad()));  
        txtLinea.setText(Integer.toString( vendedorAConsultar.getLincodigo()));  
        txtMarca.setText(Integer.toString( vendedorAConsultar.getMarcodigo()));  
        txtConcepto.setText(Integer.toString( vendedorAConsultar.getConid()));
        txtTotal.setText(Integer.toString( vendedorAConsultar.getmovtotal()));
    } 

    public frmMantenimientoMovimientos() {
        initComponents();
        llenadoDeTablas();
      
        
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
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        BtnCalcular = new javax.swing.JButton();
        txtbuscado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        lb = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        label6 = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        label11 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        label15 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        label17 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnLimpiar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        label19 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Movimientos");
        setToolTipText("");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 95, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 95, -1));

        BtnCalcular.setText("Calcular");
        BtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, 95, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 90, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 980, 270));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 13, -1));

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtFecha.setOpaque(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Fecha movimiento");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        txEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txEstado.setOpaque(false);
        txEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(txEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 130, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Estado movimiento");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        txtProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtProducto.setOpaque(false);
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 130, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Codigo producto");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCantidad.setOpaque(false);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 120, -1));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Cantidad");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Codigo linea");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        txtLinea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtLinea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtLinea.setOpaque(false);
        txtLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaActionPerformed(evt);
            }
        });
        getContentPane().add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 130, -1));

        txtMarca.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtMarca.setOpaque(false);
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 130, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Codigo marca");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        txtConcepto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtConcepto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtConcepto.setOpaque(false);
        txtConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConceptoActionPerformed(evt);
            }
        });
        getContentPane().add(txtConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 130, -1));

        label15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label15.setText("Codigo concepto");
        getContentPane().add(label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        label16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label16.setText("Total");
        getContentPane().add(label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, -1));

        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 120, -1));

        label17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label17.setText("Precio unitario");
        getContentPane().add(label17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtPrecio.setOpaque(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 120, -1));

        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 95, -1));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Controles");
        jPanel2.add(label3);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 980, 100));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Ingreso de valores");
        jPanel3.add(label1);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 150));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label2.setText("Ingreso de informacion");
        jPanel1.add(label2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 630, 150));

        label18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label18.setText("Total");
        getContentPane().add(label18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, -1));

        label19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label19.setText("Total");
        getContentPane().add(label19, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, -1));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Registros");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoMovimientos perfilDAO = new daoMovimientos();
        clsMovimientos vendedorAEliminar = new clsMovimientos();
   
        vendedorAEliminar.setMovid(Integer.parseInt(txtbuscado.getText()));
  
        perfilDAO.delete(vendedorAEliminar);
        perfilDAO.delete2(vendedorAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoMovimientos perfilDAO = new daoMovimientos();
        clsMovimientos vendedorAInsertar = new clsMovimientos();     
        daoMovimientos perfilDAO2 = new daoMovimientos();
        clsMovimientos vendedorAInsertar2 = new clsMovimientos();   
       vendedorAInsertar.setMovfecha(txtFecha.getText());
       vendedorAInsertar.setMovestado((txEstado.getText()));
       vendedorAInsertar2.setProdcodigo(Integer.parseInt(txtProducto.getText()));
       vendedorAInsertar2.setMovcantidad(Integer.parseInt(txtCantidad.getText()));
       vendedorAInsertar2.setLincodigo(Integer.parseInt(txtLinea.getText()));
       vendedorAInsertar2.setMarcodigo(Integer.parseInt(txtMarca.getText()));
       vendedorAInsertar2.setConid(Integer.parseInt(txtConcepto.getText()));
       vendedorAInsertar2.setmovtotal(Integer.parseInt(txtTotal.getText()));
       
       perfilDAO.insert(vendedorAInsertar);
       perfilDAO2.insert2(vendedorAInsertar2);
         
         
         llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
        
      
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoMovimientos perfilDAO2 = new daoMovimientos();
        clsMovimientos vendedorAActualizar2 = new clsMovimientos(); 
        
        daoMovimientos perfilDAO = new daoMovimientos();
        clsMovimientos vendedorAActualizar = new clsMovimientos();
       
        //******************ENCABEZADO**********************
       vendedorAActualizar.setMovid(Integer.parseInt(txtbuscado.getText()));
       vendedorAActualizar.setMovfecha(txtFecha.getText());
       vendedorAActualizar.setMovestado((txEstado.getText()));
       perfilDAO.update(vendedorAActualizar);

        //******************DETALLE**************************
       vendedorAActualizar.setMovid(Integer.parseInt(txtbuscado.getText()));
       vendedorAActualizar.setProdcodigo(Integer.parseInt(txtProducto.getText()));
       vendedorAActualizar.setMovcantidad(Integer.parseInt(txtCantidad.getText()));
       vendedorAActualizar.setLincodigo(Integer.parseInt(txtLinea.getText()));
       vendedorAActualizar.setMarcodigo(Integer.parseInt(txtMarca.getText()));
       vendedorAActualizar.setConid(Integer.parseInt(txtConcepto.getText()));
       vendedorAActualizar.setmovtotal(Integer.parseInt(txtTotal.getText()));
       
       perfilDAO.update2(vendedorAActualizar);
      
      

        
        llenadoDeTablas();         

    }//GEN-LAST:event_btnModificarActionPerformed
        int cantidad;
        int numero;
    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed
     int calculo;  
        
    cantidad =  Integer.parseInt(txtCantidad.getText());  
    numero =  Integer.parseInt(txtPrecio.getText());
        
    calculo = cantidad * numero;    
    
    txtTotal.setText(String.valueOf(calculo));
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCalcularActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEstadoActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConceptoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        // TODO add your handling code here:
        cantidad =0;
        numero =0;
        txtbuscado.setText("");
        txtFecha.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txEstado.setText("");
        txtProducto.setText("");
        txtConcepto.setText("");
        txtLinea.setText("");
        txtMarca.setText("");
        txtTotal.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
        
        
        
        
    }//GEN-LAST:event_btnLimpiar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
