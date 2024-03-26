package com.pruebaMarshall.marshall.Controlador;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaMarshall.marshall.JPA.UserQuery;
import com.pruebaMarshall.marshall.Modelo.User.User;
import com.pruebaMarshall.marshall.Servicio.xmlServicio;
import com.pruebaMarshall.marshall.Servicio.Cliente.procesarPath;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {
    private UserQuery userQuery;

    public ClienteController(UserQuery userQuery){
        this.userQuery= userQuery;
    }
    @PostMapping("/obtenerPath")
    public void obtenerPath(@RequestBody User user) {
        int id = user.getId();
        String ruta = user.getRuta();
        userQuery.modificarRuta(id,ruta);
    }
    
}
