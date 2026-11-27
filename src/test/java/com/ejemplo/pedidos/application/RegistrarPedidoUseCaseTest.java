package com.ejemplo.pedidos.application;

import com.ejemplo.pedidos.domain.model.Pedido;
import com.ejemplo.pedidos.domain.port.PedidoRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarPedidoUseCaseTest {

    @Test
    void registraPedidoYCalculaTotal() {
        AtomicReference<Pedido> guardado = new AtomicReference<>();
        PedidoRepositoryPort repositorio = pedido -> {
            Pedido persistido = new Pedido(7L, pedido.cantidad(), pedido.precioUnitario(), pedido.total());
            guardado.set(persistido);
            return persistido;
        };

        Pedido resultado = new RegistrarPedidoUseCase(repositorio)
                .registrar(3, new BigDecimal("12.50"));

        assertEquals(7L, resultado.id());
        assertEquals(3, resultado.cantidad());
        assertEquals(new BigDecimal("12.50"), resultado.precioUnitario());
        assertEquals(new BigDecimal("37.50"), resultado.total());
        assertEquals(resultado, guardado.get());
    }

    @Test
    void rechazaCantidadCero() {
        assertThrows(IllegalArgumentException.class,
                () -> new RegistrarPedidoUseCase(p -> p).registrar(0, new BigDecimal("10.00")));
    }

    @Test
    void rechazaPrecioNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new RegistrarPedidoUseCase(p -> p).registrar(1, null));
    }

    @Test
    void rechazaPrecioCero() {
        assertThrows(IllegalArgumentException.class,
                () -> new RegistrarPedidoUseCase(p -> p).registrar(1, BigDecimal.ZERO));
    }
}
