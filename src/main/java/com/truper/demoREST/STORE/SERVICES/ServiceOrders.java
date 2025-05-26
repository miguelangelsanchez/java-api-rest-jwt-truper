package com.truper.demoREST.STORE.SERVICES;

import com.truper.demoREST.STORE.ENTITYS.Orden;
import com.truper.demoREST.STORE.ENTITYS.Producto;
import com.truper.demoREST.STORE.ENTITYS.Sucursal;
import com.truper.demoREST.STORE.REPOSITORIES.IOrdenH2;
import com.truper.demoREST.STORE.REPOSITORIES.IProductoH2;
import com.truper.demoREST.STORE.REPOSITORIES.ISucursalH2;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ServiceOrders implements  IServiceOrders {
    private final IOrdenH2 ordenH2;
    private final IProductoH2 productoH2;
    private final ISucursalH2 sucursalH2;

    public ServiceOrders(IOrdenH2 ordenH2,IProductoH2 productoH2,ISucursalH2 sucursalH2){
        this.ordenH2 = ordenH2;
        this.productoH2=productoH2;
        this.sucursalH2=sucursalH2;
    }

    @Override
    public Optional<List<Orden>> readAllOrders() {
        try{
            return Optional.of(ordenH2.findAll());
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUEDE OBTENER LA LISTA DE ORDENES");
        }
    }

    @Override
    public Optional<Orden> readOneOrder(int orden_id) {
        try{
            return ordenH2.findById(orden_id);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUDO OBTENER LA ORDEN CON EL ID "+ orden_id);
        }
    }

    @Override
    public Optional<Orden> insertOrder(Orden orden) {
        try{
            ordenH2.save(orden);
            return Optional.of(orden);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUDO GUARDAR LA ORDEN");
        }
    }

    @Override
    public Optional<Producto> UpdateProduct(Producto producto) {
        try{
            productoH2.save(producto);
            return Optional.of(producto);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUEDE ACTUALIZAR EL PRODUCTO");
        }
    }

    @Override
    public Optional<Sucursal> insertSucursal(Sucursal sucursal) {
        try{
            sucursalH2.save(sucursal);
            return Optional.of(sucursal);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUDO GUARDAR LA SUCURSAL");
        }
    }

    @Override
    public Optional<Producto> insertProduct(Producto producto){
        try{
            productoH2.save(producto);
            return Optional.of(producto);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"NO SE PUDO GUARDAR EL PRODUCTO");
        }
    }
}
