/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pedidos.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.ejemplo.pedidos.domain.model.Pedido;
import com.ejemplo.pedidos.domain.port.PedidoRepositoryPort;

public class RegistrarPedidoUseCase {

    private static final String MENSAJE_DATOS_INVALIDOS = "Datos invalidos";
    private static final int ESCALA_MONETARIA = 2;

    private final PedidoRepositoryPort repositorio;

    public RegistrarPedidoUseCase(PedidoRepositoryPort repositorio) {
        this.repositorio = repositorio;
    }

    public Pedido registrar(int cantidad, BigDecimal precio) {
        validar(cantidad, precio);
        BigDecimal total = precio
                .multiply(BigDecimal.valueOf(cantidad))
                .setScale(ESCALA_MONETARIA, RoundingMode.HALF_UP);
        return repositorio.guardar(new Pedido(null, cantidad, precio, total));
    }

    private static void validar(int cantidad, BigDecimal precio) {
        boolean cantidadInvalida = cantidad <= 0;
        boolean precioInvalido = precio == null || precio.signum() <= 0;
        if (cantidadInvalida || precioInvalido) {
            throw new IllegalArgumentException(MENSAJE_DATOS_INVALIDOS);
        }
    }
}
