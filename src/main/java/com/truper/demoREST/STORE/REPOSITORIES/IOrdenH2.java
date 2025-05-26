package com.truper.demoREST.STORE.REPOSITORIES;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenH2 extends JpaRepository<Orden,Integer> {
}
