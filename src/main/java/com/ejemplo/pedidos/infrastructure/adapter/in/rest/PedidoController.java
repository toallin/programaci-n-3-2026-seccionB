/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pedidos.infrastructure.adapter.in.rest;

import java.math.BigDecimal;
import com.ejemplo.pedidos.application.RegistrarPedidoUseCase;
import com.ejemplo.pedidos.domain.model.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final RegistrarPedidoUseCase casoUso;

    public PedidoController(RegistrarPedidoUseCase casoUso) {
        this.casoUso = casoUso;
    }

    public record Solicitud(
            @Min(1) int cantidad,
            @NotNull @DecimalMin("0.01") BigDecimal precioUnitario) {}

    @PostMapping
    public ResponseEntity<Pedido> registrar(@Valid @RequestBody Solicitud s) {
        Pedido pedido = casoUso.registrar(s.cantidad(), s.precioUnitario());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}