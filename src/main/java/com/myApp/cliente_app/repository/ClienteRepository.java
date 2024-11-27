
package com.myApp.cliente_app.repository;

import com.myApp.cliente_app.model.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}