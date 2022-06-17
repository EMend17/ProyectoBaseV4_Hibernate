/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author EMend17
 */
@Data
@NoArgsConstructor
@Entity
@Table (name="Articulo")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;
    @Column(name = "nombreArticulo", length = 50, nullable = false)
    private String nombreArticulo;
    @Column(name = "descripcionArticulo", length = 50, nullable = false)
    private String descripcionArticulo;
    @Column(name = "precioArticulo", length = 50, nullable = false)
    private double precioArticulo;
    @Column(name = "existenciaArticulo", length = 50, nullable = false)
    private int existenciaArticulo;
    @Column(name = "stackMinArticulo", length = 50, nullable = false)
    private int stackMinArticulo;
    @Column(name = "stackMaxArticulo", length = 50, nullable = false)
    private int stackMaxArticulo;
    @Column(name = "idCategoria", nullable = false)
    private int idCategoria;
    
    
     }
     
     
     
     
