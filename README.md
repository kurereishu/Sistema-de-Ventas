Descripción del Sistema de Ventas en Java con MySQL
Este sistema de ventas está desarrollado en Java y utiliza MySQL como base de datos para almacenar información de productos, clientes y facturas. La interfaz gráfica está diseñada para facilitar la gestión de ventas, permitiendo a los usuarios realizar operaciones como seleccionar productos, calcular totales y registrar ventas.

Componentes Principales:

Interfaz Gráfica (GUI):

Pestañas: Categoría, Producto, Cliente, Factura.
Campos de Entrada: Selección de cliente, búsqueda de producto, cantidad, datos de factura.
Tabla de Factura: Muestra detalles como número, nombre, cantidad, precio unitario, subtotal, IVA, pago total y acción.
Base de Datos MySQL:

Tablas:
clientes (id, nombre, dirección, teléfono)
productos (id, nombre, precio, stock)
facturas (id, cliente_id, fecha, subtotal, iva, total)
detalle_factura (id, factura_id, producto_id, cantidad, precio_unitario, subtotal)
Funciones Principales:

Selección y Búsqueda: Permite seleccionar clientes y productos, y buscar por nombre.
Cálculo de Totales: Calcula el subtotal, IVA y total a pagar.
Registro de Ventas: Guarda la información de la venta en la base de datos.
