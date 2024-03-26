package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlrpc.parser.DoubleParser;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valConceptoTrasladosBase {
    private MarshallCFDI marshallCFDI;

    public valConceptoTrasladosBase(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> recuperarTrasladosBase() {
        List<List<String>> listaTraslados = marshallCFDI.obtenerConceptoImpuestosTrasladoBase();
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
                boolean algunaBaseInvalida = false;
                for (String base : list) {
                    try {
                        double numero = Double.parseDouble(base);
                        if (numero <= 0.0) {
                            listaValida.add("No válido. Error " + CodigoError.CFDI40174);
                            algunaBaseInvalida = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        listaValida.add("No válido. Error " + CodigoError.CFDI40174);
                        algunaBaseInvalida = true;
                        break;
                    }
                }
                if (!algunaBaseInvalida) {
                    listaValida.add("Válido");
                }
            }
        }
        return listaValida;
    }
    
    
    
}
