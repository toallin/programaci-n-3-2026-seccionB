/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.infrastructure.adapter.out.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author LABORATORIO - F
 */
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    protected PedidoEntity() {}

    public PedidoEntity(int cantidad, BigDecimal precio, BigDecimal total) {
        this.cantidad = cantidad;
        this.precioUnitario = precio;
        this.total = total;
    }

    public Long getId() { return id; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getTotal() { return total; }
}
