package com.pruebaMarshall.marshall.Servicio.Validaciones;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Impuestos;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valConceptosImpuestosTrasladosImpuestos {
    private MarshallCFDI marshallCFDI;

    public valConceptosImpuestosTrasladosImpuestos(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> recuperarTrasladosBaseImpuestos() {
        List<List<String>> listaTraslados = marshallCFDI.obtenerConceptoImpuestosTrasladoImpuesto();
        List<String> listaValida = new ArrayList<>();
        
        for (List<String> list : listaTraslados) {
            boolean impuestosDisponibles = true;
            for (String base : list) {
                if (base == null) {
                    listaValida.add("No válido. Impuestos no disponibles");
                    impuestosDisponibles = false;
                    break;
                }
            }
            if (impuestosDisponibles) {
                boolean algunaBaseValida = false;
                for (String base : list) {
                    if (base.equals("Nulo")) {
                        listaValida.add("No válido");
                        algunaBaseValida = true;
                        break;
                    } else if (base.equals("01") || base.equals("02") || base.equals("03")) {
                        algunaBaseValida = true;
                        break;
                    }
                }
                if (algunaBaseValida) {
                    listaValida.add("Válido");
                } else {
                    listaValida.add("No válido");
                }
            }
        }
        return listaValida;
    }
    
    

    public List<String> validarNodoHijo() {
        List<String> listaValida = new ArrayList<>();
        List<List<String>> listaObjetoImp = marshallCFDI.obtenerObjetoImp();
        List<List<Impuestos>> listaImpuestos = marshallCFDI.obtenerConceptoImpuestos();
    
        for (int i = 0; i < listaObjetoImp.size(); i++) {
            boolean sublistValida = true; 
            List<String> sublist = listaObjetoImp.get(i); 
            String objetoImp = sublist.get(sublist.size() - 1); 
            
            if (objetoImp.equals("02")) { 
                List<Impuestos> impuestos = listaImpuestos.get(i); 
                if (impuestos != null) { 
                    for (Impuestos impuesto : impuestos) { 
                        if (impuesto == null) { 
                            sublistValida = false; 
                            break; 
                        }
                    }
                } else {
                    sublistValida = false; 
                }
            }
            
            String validado = sublistValida ? "Válido" : "No válido. Error " + CodigoError.CFDI40171;
            listaValida.add(validado);
        }
        
        return listaValida;
    }
    
    
    
}
