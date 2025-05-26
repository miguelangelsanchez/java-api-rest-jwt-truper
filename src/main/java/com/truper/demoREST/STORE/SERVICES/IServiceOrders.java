package com.truper.demoREST.STORE.SERVICES;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Producto;
import com.truper.demoREST.STORE.ENTITYS.Sucursal;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.Optional;
import java.util.List;

public interface IServiceOrders {
    Optional<List<Orden>> readAllOrders();
    Optional<Orden> readOneOrder(int orden_id);
    Optional<Orden> insertOrder(Orden orden);
    Optional<Producto> UpdateProduct(Producto producto);

    Optional<Sucursal> insertSucursal(Sucursal sucursal);
    Optional<Producto> insertProduct(Producto producto);
}
