/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pedidos.domain.model;

import java.math.BigDecimal;

public record Pedido(Long id, int cantidad,
        BigDecimal precioUnitario, BigDecimal total) {}
