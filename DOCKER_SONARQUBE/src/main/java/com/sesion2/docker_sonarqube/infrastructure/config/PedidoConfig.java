/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.infrastructure.config;

import com.sesion2.docker_sonarqube.application.RegistrarPedidoUseCase;
import com.sesion2.docker_sonarqube.domain.port.PedidoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author LABORATORIO - F
 */
@Configuration
public class PedidoConfig {

    @Bean
    RegistrarPedidoUseCase registrarPedido(PedidoRepositoryPort port) {
        return new RegistrarPedidoUseCase(port);
    }
}
