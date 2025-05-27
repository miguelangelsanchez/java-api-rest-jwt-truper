# API REST con JWT - Truper

Este es el examen técnico sobre una API REST hecha en Java con Spring Boot. 
Incluye autenticación con JWT, manejo de órdenes, productos y sucursales. 
Incluye uso de JPA y H2

## Funcionalidades de la API

- Autenticación básica con usuario y contraseña (hardcoded).
- Generación y validación de tokens JWT.
- CRUD parcial de órdenes ('Orden'), productos ('Producto') y sucursales ('Sucursal').
- Verificación de token en cada endpoint para asegurar acceso autorizado.
  
## Estructura del proyecto
src/
  com.truper.demoREST
    JWT
      CONTROLLERS
        AuthController.java
        JwtUtil.java
    STORE
      CONTROLLERS
        OrdenesController.java
        IOrdenesController.java
      ENTITYS
        Orden.java
        Producto.java
        Sucursal.java
      SERVICES
        IServiceOrders.java

gracias de antemano por la lectura de este repositorio
