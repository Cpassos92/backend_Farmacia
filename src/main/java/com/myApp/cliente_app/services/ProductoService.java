
package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Producto;
import java.util.List;
import java.util.Optional;


public interface ProductoService {
    
    
    // Obtener todos los productos
    List<Producto> obtenerTodosProductos();

    // Guardar un nuevo producto
    Producto guardarProducto(Producto producto);

    // Obtener producto por ID
    Optional<Producto> obtenerProductoPorId(Long id);

    // Modificar un producto existente
    Producto modificarProducto(Long id, Producto producto);

    // Eliminar un producto
    void eliminarProducto(Long id);
    
    
}
