/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.application;

import static org.junit.jupiter.api.Assertions.*;

import com.sesion2.docker_sonarqube.domain.model.Pedido;
import com.sesion2.docker_sonarqube.domain.port.PedidoRepositoryPort;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;

/**
 *
 * @author LABORATORIO - F
 */
class RegistrarPedidoUseCaseTest {

    private final AtomicLong ids = new AtomicLong();
    private final PedidoRepositoryPort fake = p ->
        new Pedido(ids.incrementAndGet(), p.cantidad(), p.precioUnitario(), p.total());
    private final RegistrarPedidoUseCase useCase = new RegistrarPedidoUseCase(fake);

    @Test
    void registraPedidoYCalculaTotal() {
        Pedido p = useCase.registrar(3, new BigDecimal("150.00"));
        assertEquals(new BigDecimal("450.00"), p.total());
        assertNotNull(p.id());
    }

    @Test
    void rechazaCantidadInvalida() {
        assertThrows(
            IllegalArgumentException.class,
            () -> useCase.registrar(0, new BigDecimal("150.00"))
        );
    }

    @Test
    void rechazaPrecioInvalido() {
        assertThrows(
            IllegalArgumentException.class,
            () -> useCase.registrar(2, BigDecimal.ZERO)
        );
    }
}
