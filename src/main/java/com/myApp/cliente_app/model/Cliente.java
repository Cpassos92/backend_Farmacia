/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApp.cliente_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
    //clase para elaborar la entidad  de la aplicacion

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column
    private Long idCliente;


    @Column(nullable=false, length = 20)
    private String nombre;
    
    @Column (nullable=false, length = 20)
    private String apellido;
    
    @Column (name = "cooreo",nullable=false)
    private String email;
    
    @Column
    private String direccion;
    @Column
    private String telefono;
    
   
}
    
