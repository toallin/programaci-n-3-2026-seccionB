/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.infrastructure.adapter.in.rest;

import com.sesion2.docker_sonarqube.application.RegistrarPedidoUseCase;
import com.sesion2.docker_sonarqube.domain.model.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author LABORATORIO - F
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final RegistrarPedidoUseCase casoUso;

    public PedidoController(RegistrarPedidoUseCase casoUso) {
        this.casoUso = casoUso;
    }

    public record Solicitud(
        @Min(1) int cantidad,
        @NotNull @DecimalMin("0.01") BigDecimal precioUnitario
    ) {}

    @PostMapping
    public ResponseEntity<Pedido> registrar(@Valid @RequestBody Solicitud s) {
        Pedido pedido = casoUso.registrar(s.cantidad(), s.precioUnitario());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
