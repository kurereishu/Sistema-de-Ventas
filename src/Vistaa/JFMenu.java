package Vistaa;

import Modelo.Categoria;
import Controladores.Ctrl_Categoria;
import Controladores.Ctrl_Cliente;
import Controladores.Ctrl_Producto;
import Controladores.Ctrl_RegistrarVenta;
import Modelo.CabeceraVenta;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Tablas_SQL.Tablas_MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexion.Conexion;
import controlador.Ctrl_PDF;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFMenu extends javax.swing.JFrame {

    DefaultTableModel modeloTcategorias, modeloTproductos, modeloTClientes, modeloDatosProductos; //para las tablas
    Tablas_MySQL op;
    Ctrl_Categoria ctrl_Categoria;
    Ctrl_Producto ctrl_Producto;
    Ctrl_Cliente ctrl_Cliente;
    Ctrl_RegistrarVenta ctrl_RegistrarVenta;

    //para obtener idCategoria
    public static int idCategoria;
    public int idProducto = 0;
    public int idCliente = 0;
    //para factura
    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    //private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //private int idProductoFactura = 0;
    //private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    //una lista para el detalle de venta de los producto
    ArrayList<DetalleVenta> listaProductosFactura = new ArrayList<>();
    private DetalleVenta producto;
    private int auxIdDetalle = 1;

    //Fin
    public JFMenu() {
        initComponents();
        setLocationRelativeTo(this);
        //Inicio cargar TBCategoria
        modeloTcategorias = new DefaultTableModel(new Object[]{"idCategoria", "descripcion"}, 0); //anadi estado
        jTTablaCategorias.setModel(modeloTcategorias);
        op = new Tablas_MySQL();
        op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
        //fin cargar TBcategoria
        op.cargarCBCategorias(jCBCategoria);
        op.cargarCBCategorias(jCBCategoriaProductoTB);
        op.cargarCBClientes(jCBClienteFactura);
        op.cargarCBProductos(jCBProductoFactura);
        //Inicio cargar TBProductos
        modeloTproductos = new DefaultTableModel(new Object[]{"idProducto", "nombre", "cantidad", "precio", "descripcion", "porcentajeIva", "idCategoria"}, 0);//anadi estado
        jTTablaProductos.setModel(modeloTproductos);
        op.cargarTablaProducto(modeloTproductos, jTTablaProductos);
        //Fin cargar TBProductos
        //Iniicio cargar TBClientes
        modeloTClientes = new DefaultTableModel(new Object[]{"idCliente", "nombre", "apellido", "cedula", "telefono", "direccion"}, 0);
        jTTablaClientes.setModel(modeloTClientes);
        op.cargarTablaClientes(modeloTClientes, jTTablaClientes);
        //Fin cargar TBClientes
        //Inicio tablaProductoFactura 
        modeloDatosProductos = new DefaultTableModel(new Object[]{"N", "Nombre", "Cantidad", "Prc. Unitario", "SubTotal", "Iva", "Pago Total", "Accion"}, 0);
        jTTablaProductoFactura.setModel(modeloDatosProductos);

        //listaTablaProductosFactura();
        //fin tablaProductoFactura
        ctrl_Categoria = new Ctrl_Categoria();//implemento control categoria para acceder a sus metodos
        ctrl_Producto = new Ctrl_Producto();//Implemento control producto para acceder a sus metodos
        ctrl_RegistrarVenta = new Ctrl_RegistrarVenta(listaProductosFactura);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFInsertCategoria = new javax.swing.JTextField();
        jBInsertarCategoria = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFEditarCategoria = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTablaCategorias = new javax.swing.JTable();
        jBEliminar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFNombreProducto = new javax.swing.JTextField();
        jTFCantidadProducto = new javax.swing.JTextField();
        jTFPrecioProducto = new javax.swing.JTextField();
        jTFDescripcionProducto = new javax.swing.JTextField();
        jCBIva = new javax.swing.JComboBox<>();
        jCBCategoria = new javax.swing.JComboBox<>();
        jBGuardarProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTTablaProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTFNombreProductoTB = new javax.swing.JTextField();
        jTFCantidadProductoTB = new javax.swing.JTextField();
        jTFPrecioProductoTB = new javax.swing.JTextField();
        jTFDescripcionProductoTB = new javax.swing.JTextField();
        jCBIvaProductoTB = new javax.swing.JComboBox<>();
        jCBCategoriaProductoTB = new javax.swing.JComboBox<>();
        jBActualizarProductoTB = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTFBuscar = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTFNombreCliente = new javax.swing.JTextField();
        jTFApellidoCliente = new javax.swing.JTextField();
        jTFCedulaCliente = new javax.swing.JTextField();
        jTFTelefonoCliente = new javax.swing.JTextField();
        jTFDireccionCliente = new javax.swing.JTextField();
        jBGuardarCliente = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTTablaClientes = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jTFNombreClienteTB = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTFTelefonoClienteTB = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTFApellidoClienteTB = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTFDireccionClienteTB = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTFCedulaClienteTB = new javax.swing.JTextField();
        jBActualizarClientesTB = new javax.swing.JButton();
        jBEliminarClienteTB = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jTFBuscarCliente = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCBClienteFactura = new javax.swing.JComboBox<>();
        jCBProductoFactura = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jTFCantidadFactura = new javax.swing.JTextField();
        jBAnadirFactura = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jBCalcularCambio = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jTFSubtotal = new javax.swing.JTextField();
        jTFIva = new javax.swing.JTextField();
        jTFTotalPagar = new javax.swing.JTextField();
        jTFEfectivo = new javax.swing.JTextField();
        jTFCambio = new javax.swing.JTextField();
        jBRegistrarVenta = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTTablaProductoFactura = new javax.swing.JTable();
        jTFBuscarProductoFactura = new javax.swing.JTextField();
        jTFBuscarClienteFactura = new javax.swing.JTextField();
        jBBuscarNombre = new javax.swing.JToggleButton();
        jBBuscarProducto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar una categoria"));

        jLabel1.setText("Nombre de la categoria:");

        jBInsertarCategoria.setText("Insertar");
        jBInsertarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jTFInsertCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBInsertarCategoria)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFInsertCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBInsertarCategoria)
                .addGap(22, 22, 22))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edicion de categorias"));

        jLabel2.setText("Categoria:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTFEditarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Categorias"));

        jTTablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTTablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTTablaCategorias);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBEliminar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBEliminar)
                            .addComponent(jBActualizar)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Categoria", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Descripcion:");

        jLabel7.setText("IVA:");

        jLabel8.setText("Categoria:");

        jCBIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IVA:", "No aplica", "12%", " " }));

        jCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria.", "Item 2", "Item 3", "Item 4" }));

        jBGuardarProducto.setText("Guardar");
        jBGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGuardarProducto)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFNombreProducto)
                            .addComponent(jTFCantidadProducto)
                            .addComponent(jTFPrecioProducto)
                            .addComponent(jTFDescripcionProducto)
                            .addComponent(jCBIva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBCategoria, 0, 232, Short.MAX_VALUE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCBIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jBGuardarProducto)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Productos"));

        jTTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTTablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTTablaProductos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel9.setText("Nombre:");

        jLabel10.setText("Cantidad:");

        jLabel11.setText("Precio:");

        jLabel12.setText("Descripcion:");

        jLabel13.setText("Iva:");

        jLabel14.setText("Categoria:");

        jCBIvaProductoTB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "No aplica", "12%", " " }));

        jCBCategoriaProductoTB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBActualizarProductoTB.setText("Actualizar");
        jBActualizarProductoTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarProductoTBActionPerformed(evt);
            }
        });

        jBeliminar.setText("Eliminar");
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

        jLabel15.setText("Buscar:");

        jTFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jBActualizarProductoTB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBeliminar))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFNombreProductoTB, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jTFCantidadProductoTB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFDescripcionProductoTB))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(38, 38, 38)
                                        .addComponent(jTFPrecioProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBIvaProductoTB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBCategoriaProductoTB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jTFNombreProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPrecioProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBIvaProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jTFCantidadProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDescripcionProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBCategoriaProductoTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBActualizarProductoTB)
                            .addComponent(jBeliminar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Producto", jPanel5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar Cliente"));

        jLabel16.setText("Nombre:");

        jLabel17.setText("Apellido:");

        jLabel18.setText("Cedula:");

        jLabel19.setText("Telefono:");

        jLabel20.setText("Direccion:");

        jBGuardarCliente.setText("Guardar");
        jBGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFApellidoCliente)
                            .addComponent(jTFCedulaCliente)
                            .addComponent(jTFTelefonoCliente)
                            .addComponent(jTFDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(jTFNombreCliente)))
                    .addComponent(jBGuardarCliente))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTFApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTFCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTFTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTFDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jBGuardarCliente)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Clientes"));

        jTTablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTTablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTTablaClientes);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel21.setText("Nombre:");

        jLabel22.setText("Telefono:");

        jLabel23.setText("Apellidos:");

        jLabel24.setText("Direccion:");

        jLabel25.setText("Cedula:");

        jTFCedulaClienteTB.setEditable(false);

        jBActualizarClientesTB.setText("Actualizar");
        jBActualizarClientesTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarClientesTBActionPerformed(evt);
            }
        });

        jBEliminarClienteTB.setText("Eliminar");
        jBEliminarClienteTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarClienteTBActionPerformed(evt);
            }
        });

        jLabel35.setText("Buscar:");

        jTFBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jBActualizarClientesTB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBEliminarClienteTB))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFBuscarCliente))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFNombreClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFTelefonoClienteTB)))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFApellidoClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFDireccionClienteTB)))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCedulaClienteTB, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTFNombreClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jTFApellidoClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jTFCedulaClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jTFTelefonoClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jTFDireccionClienteTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBActualizarClientesTB)
                            .addComponent(jBEliminarClienteTB))))
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTFBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel8);

        jLabel26.setText("Cliente:");

        jLabel27.setText("Producto:");

        jCBClienteFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));

        jCBProductoFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("Cantidad:");

        jBAnadirFactura.setText("Anadir Factura");
        jBAnadirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnadirFacturaActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Factura"));

        jLabel29.setText("Subtotal:");

        jLabel31.setText("IVA:");

        jLabel32.setText("Total a pagar:");

        jLabel33.setText("Efectivo:");

        jBCalcularCambio.setText("Calcular cambio");
        jBCalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularCambioActionPerformed(evt);
            }
        });

        jLabel34.setText("Cambio:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBCalcularCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jTFCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFSubtotal)
                            .addComponent(jTFIva)
                            .addComponent(jTFTotalPagar)
                            .addComponent(jTFEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTFIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTFTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTFEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jBCalcularCambio)
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTFCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBRegistrarVenta.setText("Registrar Venta");
        jBRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarVentaActionPerformed(evt);
            }
        });

        jTTablaProductoFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTTablaProductoFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTablaProductoFacturaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTTablaProductoFactura);

        jBBuscarNombre.setText("Buscar por nombre");
        jBBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarNombreActionPerformed(evt);
            }
        });

        jBBuscarProducto.setText("Buscar producto");
        jBBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCantidadFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCBClienteFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBProductoFactura, 0, 187, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBAnadirFactura)
                                    .addComponent(jBBuscarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFBuscarProductoFactura)
                                    .addComponent(jTFBuscarClienteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                        .addGap(195, 195, 195))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addGap(63, 63, 63)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jBRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFBuscarClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBBuscarNombre)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBProductoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFBuscarProductoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBBuscarProducto)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jTFCantidadFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAnadirFactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Factura", jPanel11);

        jMenu1.setText("Sistema de Ventas");

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Salir");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Insertar una categoria
    private void jBInsertarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertarCategoriaActionPerformed

        ctrl_Categoria = new Ctrl_Categoria();
        String descripcion = jTFInsertCategoria.getText();
        int estado = 1;
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de categoria no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!ctrl_Categoria.existeCategoria(jTFInsertCategoria.getText().trim())) {
                Categoria nuevaCategoria = new Categoria(0, descripcion, estado);
                if (ctrl_Categoria.guardar(nuevaCategoria)) {
                    JOptionPane.showMessageDialog(this, "Categoria insertada con éxito.");
                    op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
                    jTFInsertCategoria.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar la categoria.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La categoria ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
        op.cargarCBCategorias(jCBCategoria);
        op.cargarCBCategorias(jCBCategoriaProductoTB);

    }//GEN-LAST:event_jBInsertarCategoriaActionPerformed

    private void jTTablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTablaCategoriasMouseClicked
        //Permite obtener la descipcion de un categoria y imprimirla en el JTFEitarCategoria.
        int fila = jTTablaCategorias.getSelectedRow();
        String pk;
        pk = (String) jTTablaCategorias.getValueAt(fila, 1);
        this.jTFEditarCategoria.setText(pk);
        idCategoria = (int) modeloTcategorias.getValueAt(fila, 0);

    }//GEN-LAST:event_jTTablaCategoriasMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed

        if (!jTFEditarCategoria.getText().isEmpty()) { // Si el jtfDescripcion es diferente del vacío
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la categoría?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                Categoria categoria = new Categoria();
                Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
                categoria.setDescripcion(jTFInsertCategoria.getText().trim()); // trim elimina los espacios de la cadena
                if (controlCategoria.eliminar(idCategoria)) {
                    JOptionPane.showMessageDialog(null, "Categoría Eliminada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar categoría");
                }
                this.jTFInsertCategoria.setText("");
                op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría");
        }
        op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);


    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed

        if (!jTFEditarCategoria.getText().isEmpty()) {
            Categoria producto = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();

            producto.setDescripcion(jTFEditarCategoria.getText().trim());

            if (controlCategoria.existeCategoria(producto.getDescripcion())) {
                JOptionPane.showMessageDialog(null, "La categoría ya está registrada, ingrese otro nombre", "Error", JOptionPane.ERROR_MESSAGE);
                jTFEditarCategoria.setText("");
            } else {
                if (controlCategoria.actualizar(producto, idCategoria)) {
                    JOptionPane.showMessageDialog(null, "Categoría actualizada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar categoría");
                    jTFEditarCategoria.setText("");
                }
                op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría");
        }

        op.cargarTablaCategorias(modeloTcategorias, jTTablaCategorias);
        op.cargarCBCategorias(jCBCategoria);
        op.cargarCBCategorias(jCBCategoriaProductoTB);
        op.cargarCBCategorias(jCBClienteFactura);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarProductoActionPerformed
        /*int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro de agregar el siguiente producto?", "Alerta!", JOptionPane.YES_NO_OPTION);
        Producto producto = new Producto();
        String iva = jCBIva.getSelectedItem().toString().trim();
        String categoria = jCBCategoria.getSelectedItem().toString().trim();
        if (this.jTFNombreProducto.getText().equals("") || this.jTFCantidadProducto.getText().equals("") || this.jTFPrecioProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos!");
        } else {
            if (!ctrl_Producto.existeProducto(jTFNombreProducto.getText().trim())) {
                if (iva.equalsIgnoreCase("Seleccione IVA:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione IVA!!");
                } else {
                    if (categoria.equalsIgnoreCase("Seleccione una categoria.")) {
                        JOptionPane.showMessageDialog(null, "Seleccione una categoria!!");
                    } else {
                        try {
                            producto.setNombre(this.jTFNombreProducto.getText().trim());
                            producto.setCantidad(Integer.parseInt(this.jTFCantidadProducto.getText().trim()));
                            String precioText = this.jTFPrecioProducto.getText().trim();
                            double precio = 0.0;
                            boolean aux = false;
                            //validador de punto o coma
                            for (int i = 0; i < precioText.length(); i++) {
                                if (precioText.charAt(i) == ',') {
                                    String precioNuevo = precioText.replace(",", ".");
                                    precio = Double.parseDouble(precioNuevo);
                                    aux = true;
                                }
                            }
                            if (aux == true) {
                                producto.setPrecio(precio);
                            } else {
                                precio = Double.parseDouble(precioText);
                                producto.setPrecio(precio);
                            }

                            producto.setDescripcion(this.jTFDescripcionProducto.getText().trim());
                            //Iva
                            if (iva.equalsIgnoreCase("No aplica")) {
                                producto.setPorcentajeIva(0);
                            } else if (iva.equalsIgnoreCase("12%")) {
                                producto.setPorcentajeIva(12);
                            }
                            //Anadir la categoria
                            idCategoria = ctrl_Producto.idCategoria(categoria); //jCBCategoria o //categoria para la funcion de obtener
                            //fin
                            producto.setIdCategoria(idCategoria);
                            producto.setEstado(1);
                            if (ctrl_Producto.guardar(producto)) {
                                JOptionPane.showMessageDialog(null, "Registro guardado");
                                op.cargarCBCategorias(jCBCategoria);
                                this.jCBIva.setSelectedItem("Seleccione IVA:");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al guardar");
                            }
                        } catch (Exception e) {

                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la BD");
            }
        }
        op.cargarTablaProducto(modeloTproductos, jTTablaProductos);
        op.cargarCBProductos(jCBProductoFactura);*/
        int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro de agregar el siguiente producto?", "Alerta!", JOptionPane.YES_NO_OPTION);
        Producto producto = new Producto();
        String iva = jCBIva.getSelectedItem().toString().trim();
        String categoria = jCBCategoria.getSelectedItem().toString().trim();

        if (this.jTFNombreProducto.getText().equals("") || this.jTFCantidadProducto.getText().equals("") || this.jTFPrecioProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos!");
        } else {
            String cantidadText = this.jTFCantidadProducto.getText().trim();
            String precioText = this.jTFPrecioProducto.getText().trim();
            if (cantidadText.matches("\\d+") && (precioText.matches("\\d+(\\.\\d+)?") || precioText.matches("\\d+(,\\d+)?"))) { // Verifica que cantidad contenga solo dígitos y precio contenga solo dígitos, punto o coma decimal
                if (!ctrl_Producto.existeProducto(jTFNombreProducto.getText().trim())) {
                    if (iva.equalsIgnoreCase("Seleccione IVA:")) {
                        JOptionPane.showMessageDialog(null, "Seleccione IVA!!");
                    } else {
                        if (categoria.equalsIgnoreCase("Seleccione una categoria.")) {
                            JOptionPane.showMessageDialog(null, "Seleccione una categoria!!");
                        } else {
                            try {
                                producto.setNombre(this.jTFNombreProducto.getText().trim());
                                producto.setCantidad(Integer.parseInt(cantidadText));

                                double precio = 0.0;
                                boolean aux = false;
                                // Validador de punto o coma
                                for (int i = 0; i < precioText.length(); i++) {
                                    if (precioText.charAt(i) == ',') {
                                        String precioNuevo = precioText.replace(",", ".");
                                        precio = Double.parseDouble(precioNuevo);
                                        aux = true;
                                        break;
                                    }
                                }
                                if (aux) {
                                    producto.setPrecio(precio);
                                } else {
                                    precio = Double.parseDouble(precioText);
                                    producto.setPrecio(precio);
                                }

                                producto.setDescripcion(this.jTFDescripcionProducto.getText().trim());
                                // IVA
                                if (iva.equalsIgnoreCase("No aplica")) {
                                    producto.setPorcentajeIva(0);
                                } else if (iva.equalsIgnoreCase("12%")) {
                                    producto.setPorcentajeIva(12);
                                }
                                // Añadir la categoria
                                idCategoria = ctrl_Producto.idCategoria(categoria);
                                // Fin
                                producto.setIdCategoria(idCategoria);
                                producto.setEstado(1);
                                if (ctrl_Producto.guardar(producto)) {
                                    JOptionPane.showMessageDialog(null, "Registro guardado");
                                    op.cargarCBCategorias(jCBCategoria);
                                    this.jCBIva.setSelectedItem("Seleccione IVA:");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error al guardar");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error al procesar los datos: " + e.getMessage());
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El producto ya existe en la BD");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad debe contener solo números y el precio debe ser un número válido!");
            }
        }

        op.cargarTablaProducto(modeloTproductos, jTTablaProductos);
        op.cargarCBProductos(jCBProductoFactura);


    }//GEN-LAST:event_jBGuardarProductoActionPerformed
    //Nos permite obtener los datos para poder editarlos.
    private void jTTablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTablaProductosMouseClicked
        //Permite obtener la descipcion de un producto y imprimirla en los jtf del producto
        int fila = jTTablaProductos.getSelectedRow();
        idProducto = Integer.parseInt(modeloTproductos.getValueAt(fila, 0).toString());
        String nombre = modeloTproductos.getValueAt(fila, 1).toString();
        int cantidad = Integer.parseInt(modeloTproductos.getValueAt(fila, 2).toString());
        double precio = Double.parseDouble(modeloTproductos.getValueAt(fila, 3).toString());
        String descripcion = modeloTproductos.getValueAt(fila, 4).toString();
        double iva = Double.parseDouble(modeloTproductos.getValueAt(fila, 5).toString());
        //int iva = Integer.parseInt(modeloTproductos.getValueAt(fila, 5).toString());
        String categoriaDescripcion = modeloTproductos.getValueAt(fila, 6).toString();
        //iva
        String ivaText;
        if (iva == 0) {
            ivaText = "No aplica";
        } else if (iva == precio * 0.12) {
            ivaText = "12%";
        } else {
            ivaText = ""; // Manejar cualquier otro caso de error o excepción
        }
        //fin iva
        // Actualiza los campos en tu JFrame
        this.jTFNombreProductoTB.setText(nombre);
        this.jTFCantidadProductoTB.setText(String.valueOf(cantidad));
        this.jTFPrecioProductoTB.setText(String.valueOf(precio));
        this.jTFDescripcionProductoTB.setText(descripcion);
        this.jCBIvaProductoTB.setSelectedItem(ivaText);
        // En lugar de buscar la categoría por ID, ya tenemos la descripción directamente
        this.jCBCategoriaProductoTB.setSelectedItem(categoriaDescripcion);
    }//GEN-LAST:event_jTTablaProductosMouseClicked

    private void jBActualizarProductoTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarProductoTBActionPerformed
        // Confirmación de actualización

        Producto producto = new Producto();
        Ctrl_Producto ctrlProducto = new Ctrl_Producto();
        String iva = jCBIvaProductoTB.getSelectedItem().toString().trim();
        String categoria = jCBCategoriaProductoTB.getSelectedItem().toString().trim();

        if (jTFNombreProductoTB.getText().isEmpty() || jTFCantidadProductoTB.getText().isEmpty() || jTFPrecioProductoTB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        if (iva.equalsIgnoreCase("Seleccione iva:")) {
            JOptionPane.showMessageDialog(null, "Seleccione IVA");
            return;
        }

        if (categoria.equalsIgnoreCase("Seleccione una categoria:")) {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría");
            return;
        }

        try {
            producto.setNombre(jTFNombreProductoTB.getText().trim());
            producto.setCantidad(Integer.parseInt(jTFCantidadProductoTB.getText().trim()));

            // Procesar el precio
            String precioText = jTFPrecioProductoTB.getText().trim();
            double precio = Double.parseDouble(precioText.replace(",", "."));
            producto.setPrecio(precio);

            producto.setDescripcion(jTFDescripcionProductoTB.getText().trim());

            // Procesar IVA
            if (iva.equalsIgnoreCase("No aplica")) {
                producto.setPorcentajeIva(0);
            } else if (iva.equalsIgnoreCase("12%")) {
                producto.setPorcentajeIva(12);
            }

            // Obtener ID de categoría
            idCategoria = ctrlProducto.idCategoria(categoria); //aqui cambie el tipo de variable a int.
            if (idCategoria == -1) {
                JOptionPane.showMessageDialog(null, "Error al obtener ID de la categoría");
                return;
            }
            producto.setIdCategoria(idCategoria);
            producto.setEstado(1);
            //idProducto = 18;
            // Actualizar producto
            if (ctrlProducto.actualizar(producto, idProducto)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                op.cargarTablaProducto(modeloTproductos, jTTablaProductos);
                op.cargarCBProductos(jCBProductoFactura);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar " + idCategoria + idProducto);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato de número incorrecto: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBActualizarProductoTBActionPerformed
    //Eliminar productos
    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
        
        ctrl_Producto = new Ctrl_Producto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar el producto?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                if (!ctrl_Producto.eliminar(idProducto)) {
                    //JOptionPane.showMessageDialog(null, "Producto eliminado existosamente!");
                    this.op.cargarTablaProducto(modeloTproductos, jTTablaProductos);
                    this.op.cargarCBCategorias(jCBCategoriaProductoTB);
                    op.cargarCBProductos(jCBProductoFactura);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                }
            } else {

            }
        }
    }//GEN-LAST:event_jBeliminarActionPerformed
    //Buscar producto por nombre, filtracion de la tabla de datos
    private void jTFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTTablaProductos.getModel();
        model.setRowCount(0);
        Connection cn = Conexion.conectar();
        String sql = "SELECT p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion AS categoria, p.estado "
                + "FROM tb_producto AS p "
                + "JOIN tb_categoria AS c ON p.idCategoria = c.idCategoria "
                + "WHERE p.nombre LIKE ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, jTFBuscar.getText() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double precio = rs.getDouble("precio");
                int porcentajeIva = rs.getInt("porcentajeIva");
                Object[] fila = new Object[8];
                fila[0] = rs.getObject("idProducto");
                fila[1] = rs.getObject("nombre");
                fila[2] = rs.getObject("cantidad");
                fila[3] = rs.getObject("precio");
                fila[4] = rs.getObject("descripcion");

                //calcular el IVA usando el metodo calcularIVA
                double IVA = ctrl_Producto.calcularIva(precio, porcentajeIva);
                fila[5] = IVA;
                fila[6] = rs.getObject("categoria");
                fila[7] = rs.getObject("estado");
                model.addRow(fila);

            }
            jTTablaProductos.setModel(model);
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTFBuscarKeyReleased
    //Clientes
    private void jBGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarClienteActionPerformed
        /*Cliente cliente = new Cliente();
        ctrl_Cliente = new Ctrl_Cliente();
        if (!jTFNombreCliente.getText().isBlank() && !jTFApellidoCliente.getText().isEmpty() && !jTFCedulaCliente.getText().isEmpty()) {
            if (!ctrl_Cliente.existeCliente(jTFCedulaCliente.getText().trim())) {
                cliente.setNombre(jTFNombreCliente.getText().trim());
                cliente.setApellido(jTFApellidoCliente.getText().trim());
                cliente.setCedula(jTFCedulaCliente.getText().trim());
                cliente.setTelefono(jTFTelefonoCliente.getText().trim());
                cliente.setDireccion(jTFDireccionCliente.getText().trim());
                cliente.setEstado(1);
                if (ctrl_Cliente.guardar(cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el cliente!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El cliente ya existe en la Base de Datos!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos s campos!");
        }
        op.cargarTablaClientes(modeloTClientes, jTTablaClientes);
        op.cargarCBClientes(jCBClienteFactura);*/
        Cliente cliente = new Cliente();
        ctrl_Cliente = new Ctrl_Cliente();
        String cedula = jTFCedulaCliente.getText().trim();
        String telefono = jTFTelefonoCliente.getText().trim();

        if (!jTFNombreCliente.getText().isBlank() && !jTFApellidoCliente.getText().isEmpty() && !jTFCedulaCliente.getText().isEmpty() && !jTFTelefonoCliente.getText().isEmpty()) {
            if (cedula.matches("\\d+") && telefono.matches("\\d+")) { // Verifica que "cedula" y "telefono" contengan solo dígitos
                if (!ctrl_Cliente.existeCliente(cedula)) {
                    cliente.setNombre(jTFNombreCliente.getText().trim());
                    cliente.setApellido(jTFApellidoCliente.getText().trim());
                    cliente.setCedula(cedula);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(jTFDireccionCliente.getText().trim());
                    cliente.setEstado(1);
                    if (ctrl_Cliente.guardar(cliente)) {
                        JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar el cliente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente ya existe en la Base de Datos!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cédula y el teléfono deben contener solo números!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos!");
        }

        op.cargarTablaClientes(modeloTClientes, jTTablaClientes);
        op.cargarCBClientes(jCBClienteFactura);


    }//GEN-LAST:event_jBGuardarClienteActionPerformed

    private void jTTablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTablaClientesMouseClicked
        int fila = jTTablaClientes.getSelectedRow();
        idCliente = Integer.parseInt(modeloTClientes.getValueAt(fila, 0).toString());
        String nombre = modeloTClientes.getValueAt(fila, 1).toString();
        String apellido = modeloTClientes.getValueAt(fila, 2).toString();
        String cedula = modeloTClientes.getValueAt(fila, 3).toString();
        String telefono = modeloTClientes.getValueAt(fila, 4).toString();
        String direccion = modeloTClientes.getValueAt(fila, 5).toString();
        //int estado = Integer.parseInt(modeloTClientes.getValueAt(fila, 6).toString());

        this.jTFNombreClienteTB.setText(nombre);
        this.jTFApellidoClienteTB.setText(apellido);
        this.jTFCedulaClienteTB.setText(cedula);
        this.jTFTelefonoClienteTB.setText(telefono);
        this.jTFDireccionClienteTB.setText(direccion);

    }//GEN-LAST:event_jTTablaClientesMouseClicked

    private void jBActualizarClientesTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarClientesTBActionPerformed
        if (jTFNombreClienteTB.getText().isEmpty() || jTFApellidoClienteTB.getText().isEmpty() || jTFCedulaClienteTB.getText().isEmpty() || jTFTelefonoClienteTB.getText().isEmpty() || jTFDireccionClienteTB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos!!!");
        } else {
            ctrl_Cliente = new Ctrl_Cliente();
            Cliente cliente = new Cliente();
            cliente.setNombre(jTFNombreClienteTB.getText().trim());
            cliente.setApellido(jTFApellidoClienteTB.getText().trim());
            cliente.setCedula(jTFCedulaClienteTB.getText().trim());
            cliente.setTelefono(jTFTelefonoClienteTB.getText().trim());
            cliente.setDireccion(jTFDireccionClienteTB.getText().trim());
            cliente.setEstado(1);

            try {
                if (ctrl_Cliente.actualizar(cliente, idCliente)) {
                    JOptionPane.showMessageDialog(null, "Datos del cliente actualizados correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el cliente!");
                }
                op.cargarTablaClientes(modeloTClientes, jTTablaClientes);
                op.cargarCBClientes(jCBClienteFactura);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jBActualizarClientesTBActionPerformed

    private void jBEliminarClienteTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarClienteTBActionPerformed
        
        ctrl_Cliente = new Ctrl_Cliente();
        if (idCliente == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                if (!ctrl_Cliente.eliminar(idCliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");
                    op.cargarTablaClientes(modeloTClientes, jTTablaClientes);
                    op.cargarCBClientes(jCBClienteFactura);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
                }
            }

        }
        
        
        
    }//GEN-LAST:event_jBEliminarClienteTBActionPerformed
    //Factura
    private void jBAnadirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnadirFacturaActionPerformed
        //bloquear el CBde Clientes
        jCBClienteFactura.setEnabled(false);

        String combo = this.jCBProductoFactura.getSelectedItem().toString().trim();
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto!");
        } else {
            if (!jTFCantidadFactura.getText().isEmpty()) {
                boolean validacion = ctrl_RegistrarVenta.validar(jTFCantidadFactura.getText());
                if (validacion == true) {
                    if (Integer.parseInt(jTFCantidadFactura.getText()) > 0) {
                        cantidad = Integer.parseInt(jTFCantidadFactura.getText());
                        ctrl_RegistrarVenta.DatosDelProducto(combo);

                        cantidadProductoBBDD = ctrl_RegistrarVenta.getCantidadProductoBBDD();
                        precioUnitario = ctrl_RegistrarVenta.getPrecioUnitario();
                        //anadi
                        porcentajeIva = (int) ctrl_RegistrarVenta.getIva();
                        //fin
                        //iva = ctrl_RegistrarVenta.getIva();
                        iva = ctrl_RegistrarVenta.calcularIva(precioUnitario, porcentajeIva);

                        if (cantidad <= cantidadProductoBBDD) {
                            subtotal = precioUnitario * cantidad;
                            totalPagar = subtotal + iva * cantidad;

                            //Redondear decimales
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            iva = (double) Math.round(iva * 100) / 100 * cantidad;
                            //descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            //Se crea un nuevo producto 
                            producto = new DetalleVenta(auxIdDetalle, 1, ctrl_RegistrarVenta.getIdProducto(), ctrl_RegistrarVenta.getNombre(), Integer.parseInt(jTFCantidadFactura.getText()), precioUnitario, subtotal, iva, totalPagar, 1);
                            //anadir a la lista
                            listaProductosFactura.add(producto);
                            //listaTablaProductosFactura();
                            //anadi
                            ctrl_RegistrarVenta.listaTablaProductosFactura(modeloDatosProductos);
                            //anadi
                            JOptionPane.showMessageDialog(null, "Producto Agregado!!");
                            auxIdDetalle++;
                            jTFCantidadFactura.setText("");//limpiar el campo
                            op.cargarCBProductos(jCBProductoFactura);
                            ctrl_RegistrarVenta.CalcularTotalPagar();
                            //this.CalcularTotalPagar();

                            //
                            //
                            jTFSubtotal.setText(String.valueOf(ctrl_RegistrarVenta.getSubtotalGeneral()));
                            jTFIva.setText(String.valueOf(ctrl_RegistrarVenta.getIvaGeneral()));
                            //jTFDescuento.setText(String.valueOf(ctrl_RegistrarVenta.getDescuentoGeneral()));
                            jTFTotalPagar.setText(String.valueOf(ctrl_RegistrarVenta.getTotalPagarGeneral()));

                            jTFEfectivo.setEnabled(true);
                            jBCalcularCambio.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el Stock!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad n puede ser menor o igual a 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }
        // this.listaTablaProductosFactura();
        ctrl_RegistrarVenta.listaTablaProductosFactura(modeloDatosProductos);
    }//GEN-LAST:event_jBAnadirFacturaActionPerformed

    private void jBCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularCambioActionPerformed
        if (!jTFEfectivo.getText().isEmpty()) {
            boolean validacion = ctrl_RegistrarVenta.validarDouble(jTFEfectivo.getText());
            if (validacion == true) {

                double efc = Double.parseDouble(jTFEfectivo.getText());
                double top = Double.parseDouble(jTFTotalPagar.getText());
                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente!!");
                } else {
                    double cambio = (efc - top);
                    double cambioAux = (double) Math.round(cambio * 100) / 100;
                    String cambioT = String.valueOf(cambioAux);
                    jTFCambio.setText(cambioT);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio :c");
        }
    }//GEN-LAST:event_jBCalcularCambioActionPerformed
    int idArrayList;


    private void jTTablaProductoFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTablaProductoFacturaMouseClicked
        int fila_point = jTTablaProductoFactura.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar Producto?");
        switch (opcion) {
            case 0:
                listaProductosFactura.remove(idArrayList - 1);
                //ctrl_RegistrarVenta.CalcularTotalPagar();
                ctrl_RegistrarVenta.listaTablaProductosFactura(modeloDatosProductos);

                ctrl_RegistrarVenta.CalcularTotalPagar();
                //actualizarCamposTexto();
                //actualizarCamoosTexto
                jTFSubtotal.setText(String.valueOf(ctrl_RegistrarVenta.getSubtotalGeneral()));
                jTFIva.setText(String.valueOf(ctrl_RegistrarVenta.getIvaGeneral()));
                //jTFDescuento.setText(String.valueOf(ctrl_RegistrarVenta.getDescuentoGeneral()));
                jTFTotalPagar.setText(String.valueOf(ctrl_RegistrarVenta.getTotalPagarGeneral()));
                //fin
                break;
            case 1:
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jTTablaProductoFacturaMouseClicked

    private void jBRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarVentaActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        ctrl_RegistrarVenta = new Ctrl_RegistrarVenta(listaProductosFactura);

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!jCBClienteFactura.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductosFactura.size() > 0) {
                cabeceraVenta.ObtenerIdCliente(this.jCBClienteFactura.getSelectedItem().toString());
                idCliente = cabeceraVenta.getIdCliente();
                cabeceraVenta.setIdCabeceraVenta(0);
                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(Double.parseDouble(jTFTotalPagar.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);

                if (ctrl_RegistrarVenta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "La venta ha sido registrada con éxito!");

                    // Obtener idCabeceraVenta registrado
                    int idCabeceraVenta = ctrl_RegistrarVenta.getIdCabeceraRegistrada();

                    // Imprimir PDF
                    Ctrl_PDF ctrl_PDF = new Ctrl_PDF();
                    ctrl_PDF.DatosCliente(idCliente);
                    ctrl_PDF.generarFacturaPDF(jTFTotalPagar.getText(), idCabeceraVenta, jTTablaProductoFactura);

                    // Guardar detalle
                    for (DetalleVenta elemento : listaProductosFactura) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(idCabeceraVenta);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubTotal(elemento.getSubTotal());
                        //detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIva(elemento.getIva());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);

                        if (ctrl_RegistrarVenta.guardarDetalle(detalleVenta)) {
                            jTFSubtotal.setText("0.0");
                            jTFIva.setText("0.0");
                            //jTFDescuento.setText("0.0");
                            jTFTotalPagar.setText("0.0");
                            jTFEfectivo.setText("");
                            jTFCambio.setText("0.0");
                            //Desbloquear el CB
                            jCBClienteFactura.setEnabled(true);

                            auxIdDetalle = 1;
                            op.cargarCBClientes(jCBClienteFactura);
                            // restar stock productos
                            ctrl_RegistrarVenta.restarStockProd(elemento.getIdProducto(), elemento.getCantidad());
                        } else {
                            JOptionPane.showConfirmDialog(null, "Error al guardar el detalle de VENTA!");
                        }
                    }
                    listaProductosFactura.clear();
                    ctrl_RegistrarVenta.listaTablaProductosFactura(modeloDatosProductos);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar la cabecera de VENTA!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un PRODUCTO!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente!");
        }
    }//GEN-LAST:event_jBRegistrarVentaActionPerformed

    private void jTFBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarClienteKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTTablaClientes.getModel();
        model.setRowCount(0);
        Connection cn = Conexion.conectar();
        String sql = "SELECT c.idCliente, c.nombre, c.apellido, c.cedula, c.telefono, c.direccion "
                + "FROM tb_cliente AS c "
                + "WHERE c.nombre LIKE ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, jTFBuscarCliente.getText() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getObject("idCliente");
                fila[1] = rs.getObject("nombre");
                fila[2] = rs.getObject("apellido");
                fila[3] = rs.getObject("cedula");
                fila[4] = rs.getObject("telefono");
                fila[5] = rs.getObject("direccion");
                model.addRow(fila);
            }
            jTTablaClientes.setModel(model);
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTFBuscarClienteKeyReleased

    private void jBBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarNombreActionPerformed

        String clienteBuscar = jTFBuscarClienteFactura.getText().trim();
        Connection cn = Conexion.conectar();
        // Ajustar la consulta para buscar tanto nombre como apellido
        String sql = "SELECT nombre, apellido FROM tb_cliente WHERE CONCAT(nombre, ' ', apellido) = ?";
        PreparedStatement pst;

        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clienteBuscar);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                jCBClienteFactura.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jCBClienteFactura.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Nombre de cliente incorrecto o no encontrado!");
            }
            jTFBuscarClienteFactura.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }

    }//GEN-LAST:event_jBBuscarNombreActionPerformed

    private void jBBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarProductoActionPerformed
        String clienteBuscar = jTFBuscarProductoFactura.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "SELECT nombre FROM tb_producto WHERE nombre = ?";
        PreparedStatement pst;

        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clienteBuscar);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                jCBProductoFactura.setSelectedItem(rs.getString("nombre"));
            } else {
                jCBProductoFactura.setSelectedItem("Seleccione producto:");
                JOptionPane.showMessageDialog(null, "¡Nombre de producto incorrecto o no encontrado!");
            }
            jTFBuscarProductoFactura.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar producto!, " + e);
        }
    }//GEN-LAST:event_jBBuscarProductoActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBActualizarClientesTB;
    private javax.swing.JButton jBActualizarProductoTB;
    private javax.swing.JButton jBAnadirFactura;
    private javax.swing.JToggleButton jBBuscarNombre;
    private javax.swing.JButton jBBuscarProducto;
    private javax.swing.JButton jBCalcularCambio;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarClienteTB;
    private javax.swing.JButton jBGuardarCliente;
    private javax.swing.JButton jBGuardarProducto;
    private javax.swing.JButton jBInsertarCategoria;
    private javax.swing.JButton jBRegistrarVenta;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBCategoriaProductoTB;
    private javax.swing.JComboBox<String> jCBClienteFactura;
    private javax.swing.JComboBox<String> jCBIva;
    private javax.swing.JComboBox<String> jCBIvaProductoTB;
    private javax.swing.JComboBox<String> jCBProductoFactura;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFApellidoCliente;
    private javax.swing.JTextField jTFApellidoClienteTB;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFBuscarCliente;
    private javax.swing.JTextField jTFBuscarClienteFactura;
    private javax.swing.JTextField jTFBuscarProductoFactura;
    private javax.swing.JTextField jTFCambio;
    private javax.swing.JTextField jTFCantidadFactura;
    private javax.swing.JTextField jTFCantidadProducto;
    private javax.swing.JTextField jTFCantidadProductoTB;
    private javax.swing.JTextField jTFCedulaCliente;
    private javax.swing.JTextField jTFCedulaClienteTB;
    private javax.swing.JTextField jTFDescripcionProducto;
    private javax.swing.JTextField jTFDescripcionProductoTB;
    private javax.swing.JTextField jTFDireccionCliente;
    private javax.swing.JTextField jTFDireccionClienteTB;
    private javax.swing.JTextField jTFEditarCategoria;
    private javax.swing.JTextField jTFEfectivo;
    private javax.swing.JTextField jTFInsertCategoria;
    private javax.swing.JTextField jTFIva;
    private javax.swing.JTextField jTFNombreCliente;
    private javax.swing.JTextField jTFNombreClienteTB;
    private javax.swing.JTextField jTFNombreProducto;
    private javax.swing.JTextField jTFNombreProductoTB;
    private javax.swing.JTextField jTFPrecioProducto;
    private javax.swing.JTextField jTFPrecioProductoTB;
    private javax.swing.JTextField jTFSubtotal;
    private javax.swing.JTextField jTFTelefonoCliente;
    private javax.swing.JTextField jTFTelefonoClienteTB;
    private javax.swing.JTextField jTFTotalPagar;
    private javax.swing.JTable jTTablaCategorias;
    private javax.swing.JTable jTTablaClientes;
    public static javax.swing.JTable jTTablaProductoFactura;
    private javax.swing.JTable jTTablaProductos;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
