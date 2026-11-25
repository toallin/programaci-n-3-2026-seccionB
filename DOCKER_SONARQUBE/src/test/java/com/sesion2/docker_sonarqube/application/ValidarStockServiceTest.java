/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *
 * @author LABORATORIO - F
 */
class ValidarStockServiceTest {

    private final ValidarStockService service = new ValidarStockService();

    @Test
    void retornaTrueCuandoHayStockSuficiente() {
        assertTrue(service.tieneStock(10, 5));
        assertTrue(service.tieneStock(5, 5));
    }

    @Test
    void retornaFalseCuandoNoHayStockSuficiente() {
        assertFalse(service.tieneStock(3, 5));
    }

    @Test
    void rechazaCantidadNoPositiva() {
        assertThrows(IllegalArgumentException.class, () -> service.tieneStock(10, 0));
    }
}
