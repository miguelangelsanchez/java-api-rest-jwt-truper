package com.truper.demoREST.STORE.REPOSITORIES;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalH2  extends JpaRepository<Sucursal,Integer> {
}
