package com.truper.demoREST.STORE.CONTROLLERS;

import com.truper.demoREST.JWT.CONTROLLERS.JwtUtil;
import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Producto;
import com.truper.demoREST.STORE.ENTITYS.Sucursal;
import com.truper.demoREST.STORE.SERVICES.IServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ordenes")
@CrossOrigin
@Primary
public class OrdenesController implements IOrdenesController{
    private final IServiceOrders serviceOrders;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public OrdenesController(IServiceOrders serviceOrders){
        this.serviceOrders=serviceOrders;
    }

    public boolean isValidAuthorization(String authHeader){
        if(authHeader==null||!authHeader.startsWith("Bearer "))
            return false;

        String token = authHeader.substring(7);

        if(!jwtUtil.isTokenValid(token))
            return false;

        return true;
    }

    public ResponseEntity<?>RegresarErrorConToken(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("problemas con el token");
    }

    @Override
    @GetMapping
    public ResponseEntity<?> readAllOrders(@RequestHeader("Authorization") String authHeader) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.readAllOrders());
    }

    @Override
    @GetMapping("/{orden_id}")
    public ResponseEntity<?> readOneOrder(@RequestHeader("Authorization")String authHeader, @PathVariable("orden_id") int orden_id) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.readOneOrder(orden_id));
    }

    @Override
    @PostMapping("/orden")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> insertOrder(@RequestHeader("Authorization")String authHeader, @RequestBody Orden orden) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.insertOrder(orden));
    }

    @Override
    @PutMapping
    public ResponseEntity<?> UpdateProduct(@RequestHeader("Authorization")String authHeader, @RequestBody Producto producto) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.UpdateProduct(producto));
    }

    @Override
    @PostMapping("/sucursal")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> insertSucursal(@RequestHeader("Authorization")String authHeader, @RequestBody Sucursal sucursal) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.insertSucursal(sucursal));
    }

    @Override
    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> insertProduct(@RequestHeader("Authorization")String authHeader, @RequestBody Producto producto) {
        if(isValidAuthorization(authHeader))
            return RegresarErrorConToken();

        return ResponseEntity.ok(serviceOrders.insertProduct(producto));
    }
}
