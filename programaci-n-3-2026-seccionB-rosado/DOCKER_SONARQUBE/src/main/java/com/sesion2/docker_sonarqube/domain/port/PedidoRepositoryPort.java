/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.domain.port;

import com.sesion2.docker_sonarqube.domain.model.Pedido;

/**
 *
 * @author LABORATORIO - F
 */
public interface PedidoRepositoryPort {
    Pedido guardar(Pedido pedido);
}
