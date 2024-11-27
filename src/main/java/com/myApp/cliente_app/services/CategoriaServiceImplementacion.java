
package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Categoria;
import com.myApp.cliente_app.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoriaServiceImplementacion implements CategoriaService {
    
     @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodasCategorias() {
       return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
       return categoriaRepository.findById(id);
    }

    @Override
    public void eliminarCategoria(Long id) {
       categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria modificarCategoria(Long id, Categoria categoria) {
       // Verificar si la categoría existe
    if (!categoriaRepository.existsById(id)) {
        return null; // o lanzar una excepción
    }
    
    // Asignar el ID de la categoría a la categoría que se está modificando
    categoria.setIdCategoria(id);
    
    // Guardar la categoría actualizada
    return categoriaRepository.save(categoria);
}
    
}
