package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Cliente;

public interface ClienteService {
    /**
     * Crea un nuevo cliente.
     * @param cliente Objeto cliente a ser creado.
     * @return Cliente creado.
     * @throws IllegalArgumentException si el email ya está registrado.
     */
    Cliente newCliente(Cliente cliente);

    /**
     * Obtiene todos los clientes.
     * @return Iterable de clientes.
     */
    Iterable<Cliente> getAll();

    /**
     * Modifica un cliente existente.
     * @param cliente Cliente con datos actualizados.
     * @return Cliente modificado.
     * @throws IllegalArgumentException si el cliente no existe.
     */
    Cliente modifyCliente(Cliente cliente);

    /**
     * Elimina un cliente por su ID.
     * @param idcliente ID del cliente a eliminar.
     * @throws IllegalArgumentException si el cliente no existe.
     */
    void deleteCliente(Long idcliente);

    /**
     * Verifica si un email ya está registrado.
     * @param email El email a verificar.
     * @return true si el email ya existe, false en caso contrario.
     */
    boolean emailExists(String email);
}
