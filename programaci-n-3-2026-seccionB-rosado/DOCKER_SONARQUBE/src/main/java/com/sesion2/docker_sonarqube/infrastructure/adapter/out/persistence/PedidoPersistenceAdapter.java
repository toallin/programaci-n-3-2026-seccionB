/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sesion2.docker_sonarqube.infrastructure.adapter.out.persistence;

import com.sesion2.docker_sonarqube.domain.model.Pedido;
import com.sesion2.docker_sonarqube.domain.port.PedidoRepositoryPort;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LABORATORIO - F
 */
@Repository
public class PedidoPersistenceAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpa;

    public PedidoPersistenceAdapter(PedidoJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Pedido guardar(Pedido p) {
        PedidoEntity entidad = jpa.save(
            new PedidoEntity(p.cantidad(), p.precioUnitario(), p.total())
        );
        return new Pedido(
            entidad.getId(),
            entidad.getCantidad(),
            entidad.getPrecioUnitario(),
            entidad.getTotal()
        );
    }
}
