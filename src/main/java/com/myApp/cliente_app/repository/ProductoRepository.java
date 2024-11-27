
package com.myApp.cliente_app.repository;

import com.myApp.cliente_app.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
