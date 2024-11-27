
package com.myApp.cliente_app.services;

import com.myApp.cliente_app.model.Producto;
import com.myApp.cliente_app.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;
    
    
    @Override
    public List<Producto> obtenerTodosProductos() {
         return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
      // Aquí podrías validar el código de barras antes de guardar el producto si es necesario.
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto modificarProducto(Long id, Producto producto) {
       Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto prod = productoExistente.get();
            prod.setNombre(producto.getNombre());
            prod.setPrecio(producto.getPrecio());
            prod.setCodigoBarras(producto.getCodigoBarras());  // Actualizar código de barras
            prod.setCategoria(producto.getCategoria());
            return productoRepository.save(prod);
        } else {
            return null; // o lanzar una excepción si no se encuentra el producto
    }
    }

    @Override
    public void eliminarProducto(Long id) {
       productoRepository.deleteById(id);
    }
    
}
