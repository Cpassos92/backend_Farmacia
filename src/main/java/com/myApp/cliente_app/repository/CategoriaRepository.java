
package com.myApp.cliente_app.repository;

import com.myApp.cliente_app.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
