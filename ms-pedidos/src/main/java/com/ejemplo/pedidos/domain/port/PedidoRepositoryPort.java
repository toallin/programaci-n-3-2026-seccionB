/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pedidos.domain.port;

import com.ejemplo.pedidos.domain.model.Pedido;

public interface PedidoRepositoryPort {
    Pedido guardar(Pedido pedido);
}