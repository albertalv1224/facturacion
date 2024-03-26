package com.pruebaMarshall.marshall.Controlador;

import org.springframework.web.bind.annotation.RestController;

import com.pruebaMarshall.marshall.JPA.UserQuery;
import com.pruebaMarshall.marshall.Modelo.User.User;
import com.pruebaMarshall.marshall.Servicio.Validaciones.valTipoComprobante;
import com.pruebaMarshall.marshall.Servicio.Validaciones.validacionCompleta;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class FacturacionController {
    private valTipoComprobante valTipoComprobante;
    private validacionCompleta validacionCompleta;
    private UserQuery userQuery;
    public FacturacionController(validacionCompleta validacionCompleta, UserQuery userQuery){
        this.validacionCompleta = validacionCompleta;
        this.userQuery = userQuery;
    }

    @GetMapping("/validarFactura")
    public Map<String,Object> validarTipoFactura() throws IllegalArgumentException, IllegalAccessException {
       
       return validacionCompleta.validar();
    }
    
    
    
}
