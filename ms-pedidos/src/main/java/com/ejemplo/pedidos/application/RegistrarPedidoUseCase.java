/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pedidos.application;

import java.math.BigDecimal;
import com.ejemplo.pedidos.domain.model.Pedido;
import com.ejemplo.pedidos.domain.port.PedidoRepositoryPort;

public class RegistrarPedidoUseCase {

    private final PedidoRepositoryPort repositorio;

    public RegistrarPedidoUseCase(PedidoRepositoryPort repositorio) {
        this.repositorio = repositorio;
    }

    public Pedido registrar(int cantidad, BigDecimal precio) {
        if (cantidad <= 0 || precio == null || precio.signum() <= 0) {
            throw new IllegalArgumentException("Datos invalidos");
        }
        BigDecimal total = precio.multiply(BigDecimal.valueOf(cantidad));
        return repositorio.guardar(new Pedido(null, cantidad, precio, total));
    }
}
