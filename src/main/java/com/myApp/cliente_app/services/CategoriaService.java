
package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Categoria;
import java.util.List;
import java.util.Optional;


public interface CategoriaService {
    // Obtener todas las categorías
    List<Categoria> obtenerTodasCategorias();

    // Guardar una categoría
    Categoria guardarCategoria(Categoria categoria);

    // Obtener una categoría por su ID
    Optional<Categoria> obtenerCategoriaPorId(Long id);

    // Eliminar una categoría por su ID
    void eliminarCategoria(Long id);
    
     // Modificar una categoría
    Categoria modificarCategoria(Long id, Categoria categoria);
    
}
