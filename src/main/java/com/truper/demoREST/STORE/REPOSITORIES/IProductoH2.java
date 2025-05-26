package com.truper.demoREST.STORE.REPOSITORIES;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoH2  extends JpaRepository<Producto,Integer>{
}
