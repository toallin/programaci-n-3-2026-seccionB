/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.application;

import com.sesion2.docker_sonarqube.domain.model.Pedido;
import com.sesion2.docker_sonarqube.domain.port.PedidoRepositoryPort;
import java.math.BigDecimal;

/**
 *
 * @author LABORATORIO - F
 */
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
