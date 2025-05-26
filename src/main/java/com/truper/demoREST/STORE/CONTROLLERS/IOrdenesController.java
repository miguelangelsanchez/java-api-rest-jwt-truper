package com.truper.demoREST.STORE.CONTROLLERS;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Producto;
import com.truper.demoREST.STORE.ENTITYS.Sucursal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IOrdenesController {
    ResponseEntity<?> readAllOrders(@RequestHeader("Authorization") String authHeader);

    ResponseEntity<?> readOneOrder(@RequestHeader("Authorization") String authHeader,int orden_id);
    ResponseEntity<?> insertOrder(@RequestHeader("Authorization") String authHeader, Orden orden);
    ResponseEntity<?> UpdateProduct(@RequestHeader("Authorization") String authHeader, Producto producto);

    ResponseEntity<?> insertSucursal(@RequestHeader("Authorization") String authHeader, Sucursal sucusal);

    ResponseEntity<?> insertProduct(@RequestHeader("Authorization") String authHeader, Producto producto);
}
