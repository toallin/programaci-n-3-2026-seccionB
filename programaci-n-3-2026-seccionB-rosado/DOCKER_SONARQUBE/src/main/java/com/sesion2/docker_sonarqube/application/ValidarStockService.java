/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.application;

import org.springframework.stereotype.Service;

/**
 *
 * @author LABORATORIO - F
 */
@Service
public class ValidarStockService {

    public boolean tieneStock(int stock, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        return stock >= cantidad;
    }
}
