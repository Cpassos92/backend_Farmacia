
package com.myApp.cliente_app.controller;

import com.myApp.cliente_app.model.Cliente;
import com.myApp.cliente_app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
 @CrossOrigin("http://localhost:3000/")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    // Crear un nuevo cliente
   @CrossOrigin("http://localhost:3000/")
    @PostMapping("/nuevo")
    public ResponseEntity<?>  newCliente(@RequestBody Cliente newCliente){
        try {
        Cliente clienteGuardado = clienteService.newCliente(newCliente);
        return ResponseEntity.ok(clienteGuardado);  // Devuelve 200 OK si el cliente fue creado exitosamente
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage() );  // Devuelve 400 con el mensaje de error
    }
    }
    
    
    //obtener todos loas clientes
    @CrossOrigin("http://localhost:3000/")
    @GetMapping("/mostrarCliente")
    public Iterable<Cliente> getAll(){
        return clienteService.getAll();
    }
    
    //modificar un cliente
     @CrossOrigin("http://localhost:3000/")
   @PostMapping("/modificar")
public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
    // Asegúrate de que 'cliente' tenga todos los campos requeridos
    if (cliente.getIdCliente()== null) {
        return ResponseEntity.badRequest().body(null); // Retorna un error 400 si el id es nulo
    }
    Cliente updatedCliente = clienteService.modifyCliente(cliente);
    return ResponseEntity.ok(updatedCliente);
}
    
    
  @CrossOrigin("http://localhost:3000/")
@DeleteMapping("/delete/{id}")
public void deleteCliente(@PathVariable Long id) {
    this.clienteService.deleteCliente(id);
}
}
