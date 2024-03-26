package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

import com.pruebaMarshall.marshall.Servicio.xmlServicio;

@Service
public class validacionCompleta {
    @Autowired
    private valTipoComprobante valTipoComprobante;
    @Autowired
    private valExportacion valExportacion;
    @Autowired
    private valVersion valVersion;
    @Autowired
    private valSerie valSerie;
    @Autowired
    private valFolio valFolio;
    @Autowired
    private valTotal valTotal;
    @Autowired
    private valSubtotal valSubtotal;
    @Autowired
    private valFecha valFecha;
    @Autowired 
    private valMoneda valMoneda;
    @Autowired
    private valFormaPago valFormaPago;
    @Autowired
    private valDescuento valDescuento;
    @Autowired
    private valRegimenFiscal valRegimenFiscal;
    @Autowired
    private valReceptorNombre valReceptorNombre;
    @Autowired
    private valReceptorDomicilioFIscal valReceptorDomicilioFIscal;
    @Autowired
    private valMetodoPago valMetodoPago;
    @Autowired
    private valLugardeExpedicion valLugardeExpedicion;
    @Autowired
    private valCfdiRelacionadosTipoRelacion valCfdiRelacionadosTipoRelacion;
    @Autowired
    private valConceptosClaveUnidad valConceptosClaveUnidad;
    @Autowired
    private valConceptosClaveProdServ valConceptosClaveProdServ;
    @Autowired
    private valConceptosValorUnitario valConceptosValorUnitario;
    @Autowired
    private valConceptosUsoCfdi valCfdiUsoCfdi;
    @Autowired
    private valConceptosObjetoImp valConceptosObjetoImp;
    @Autowired
    private valConceptoTrasladosBase valConceptoTrasladosBase;
    @Autowired
    private MarshallCFDI marshallCFDI;
 
 
    private xmlServicio xmlServicio;
    private List<Comprobante> comprobantes;

   
    public validacionCompleta(xmlServicio xmlServicio) {
        this.xmlServicio = xmlServicio;
        this.comprobantes = xmlServicio.devolverDatosXml();
    }

    public Map<String, Object> validar() throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> mapa = new LinkedHashMap<>();
        
        System.out.println(valConceptoTrasladosBase.recuperarTrasladosBase());
        for (int i = 0; i < marshallCFDI.obtenerNombres().size(); i++) {
            Map<String, Object> mapaValidacion = new LinkedHashMap<>();
            mapaValidacion.put("Exportacion", valExportacion.validarExportacion().get(i));
            mapaValidacion.put("TipoDeComprobante", valTipoComprobante.validarValidezCFDI().get(i));
            mapaValidacion.put("SubTotal", valSubtotal.devolverMapa().get(i));
            mapaValidacion.put("Total", valTotal.validarTotal().get(i));
            mapaValidacion.put("Serie", valSerie.validarSerie().get(i));
            mapaValidacion.put("Folio", valFolio.validarFolio().get(i));
            mapaValidacion.put("Version", valVersion.validarVersion().get(i));
            mapaValidacion.put("Fecha", valFecha.validarFecha().get(i));
            mapaValidacion.put("Moneda", valMoneda.validarMoneda().get(i));
            mapaValidacion.put("FormaPago", valFormaPago.agregarMapa().get(i));
            mapaValidacion.put("Descuento", valDescuento.devolverMapa().get(i));
            mapaValidacion.put("cfdi:Receptor.RegimenFiscalReceptor", valRegimenFiscal.devolverMapa().get(i));
            mapaValidacion.put("Nombre Receptor", valReceptorNombre.validarReceptor().get(i));
            mapaValidacion.put("Domicilio fiscal receptor", valReceptorDomicilioFIscal.validarAtributoRFC().get(i));
            mapaValidacion.put("Metodo Pago", valMetodoPago.agregarMapa().get(i));
            mapaValidacion.put("cfdi:CfdiRelacionados. Tipo Relacion", valCfdiRelacionadosTipoRelacion.validarCTipoRelacion().get(i));
            mapaValidacion.put("Lugar expedicion", valLugardeExpedicion.validarCodigoPostal().get(i));
            mapaValidacion.put("Clave Unidad", valConceptosClaveUnidad.devolverClaveUnidad().get(i));
            mapaValidacion.put("ClaveProdServ", valConceptosClaveProdServ.validarProdServ().get(i));
            mapaValidacion.put("UsoCFDI", valCfdiUsoCfdi.validarUsoCfdi().get(i));
            mapaValidacion.put("Valor Unitario", valConceptosValorUnitario.validarValorUnitario().get(i));
            mapaValidacion.put("ObjetoImp", valConceptosObjetoImp.agregarMapa().get(i));
            mapaValidacion.put("Base", valConceptoTrasladosBase.recuperarTrasladosBase().get(i));
            mapa.put(marshallCFDI.obtenerNombres().get(i), mapaValidacion);
        }
        return mapa;
    }
   
}
