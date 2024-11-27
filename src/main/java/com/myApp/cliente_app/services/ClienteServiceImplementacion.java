
package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Cliente;
import com.myApp.cliente_app.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplementacion implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;  

    @Override
    public Cliente newCliente(Cliente cliente) {
        // Verificar si el email ya está registrado
        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteExistente.isPresent()) {
           
        }
        
        return clienteRepository.save(cliente);
        
}

    @Override
    public Iterable<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }

 @Override
public Cliente modifyCliente(Cliente cliente) {
    // Verificar si el cliente existe
    Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getIdCliente());
    if (!clienteExistente.isPresent()) {
        throw new IllegalArgumentException("El cliente no existe");
    }
    return clienteRepository.save(cliente);
}


    @Override
   // public Boolean deleteCliente(Long idcliente) {
     //   Optional<Cliente> clienteOptional = this.clienteRepository.findById(idcliente);
   // if (clienteOptional.isPresent()) {
     //   this.clienteRepository.deleteById(idcliente);
    //    return true; // Cliente eliminado
   // }
   // return false; // Cliente no encontrado
//}
    public void deleteCliente (Long idcliente){
        this.clienteRepository.deleteById(idcliente);
    }

   // public boolean emailExiste(String email) {
     //   throw new UnsupportedOperationException("El email ya está registrado"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   // }

  //  @Override
    //public boolean emailExists(String email) {
     //   throw new UnsupportedOperationException("El email ya está registrado."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   // }

    @Override
    public boolean emailExists(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}