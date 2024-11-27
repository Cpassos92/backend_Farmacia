
package com.myApp.cliente_app.controller;

import com.myApp.cliente_app.model.Categoria;
import com.myApp.cliente_app.services.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/obtener")
     public List<Categoria> obtenerCategorias() {
        return categoriaService.obtenerTodasCategorias();
    }
     
      @PostMapping("/crear")
      public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }
      
      @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> obtenerCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> modificarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaModificada = categoriaService.modificarCategoria(id, categoria);
        if (categoriaModificada != null) {
            return ResponseEntity.ok(categoriaModificada);
        } else {
            return ResponseEntity.notFound().build(); // Retornar 404 si no se encontró la categoría
        }
    }
    
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok().build();
    }
      
      
    
    
}
