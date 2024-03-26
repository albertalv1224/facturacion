package com.pruebaMarshall.marshall;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.Concepto;
import com.pruebaMarshall.marshall.Modelo.Conceptos;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.xmlServicio;



@SpringBootApplication
public class MarshallApplication {

   

    public static void main(String[] args) {
        SpringApplication.run(MarshallApplication.class, args);
		
		/*MarshallCFDI marshallCFDI = new MarshallCFDI(xmlServicio);
		Comprobante comprobante = new Comprobante(marshallCFDI.obtenerCertificado(),
                marshallCFDI.obtenerNoCertificado(), marshallCFDI.obtenerSello(), marshallCFDI.obtenerExportacion(),
                marshallCFDI.obtenerCfdiRelacionados(), marshallCFDI.obtenerEmisor(),
                marshallCFDI.obtenerReceptor(), marshallCFDI.obtenerConceptos(), marshallCFDI.obtenerImpuestos(), marshallCFDI.obtenerComplemento());
        
		//valTipoComprobante valTipoComprobante = new valTipoComprobante(marshallCFDI);
        System.out.print(comprobante);*/

    }

   
        


}
