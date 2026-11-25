/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.domain.model;

import java.math.BigDecimal;

/**
 *
 * @author LABORATORIO - F
 */
public record Pedido(Long id, int cantidad, BigDecimal precioUnitario, BigDecimal total) {}
