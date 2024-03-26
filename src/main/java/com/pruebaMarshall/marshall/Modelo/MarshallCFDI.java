package com.pruebaMarshall.marshall.Modelo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Servicio.xmlServicio;
import com.pruebaMarshall.marshall.Servicio.Cliente.procesarPath;

@Service
public class MarshallCFDI {
    private final xmlServicio xmlService;
    private final List<Comprobante> comprobante;
 
    
    public MarshallCFDI(xmlServicio xmlService) {
        this.xmlService = xmlService;
        this.comprobante = xmlService.devolverDatosXml();
    }

    public List<String> obtenerCertificados() {
        List<String> certificados = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            certificados.add(comprobante.getCertificado());
        }
        return certificados;
    }

    public List<String> obtenerNoCertificados() {
        List<String> noCertificados = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            noCertificados.add(comprobante.getNoCertificado());
        }
        return noCertificados;
    }

    public List<String> obtenerSellos() {
        List<String> sellos = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            sellos.add(comprobante.getSello());
        }
        return sellos;
    }

    public List<String> obtenerTiposDeComprobante() {
        List<String> tiposDeComprobante = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            tiposDeComprobante.add(comprobante.getTipoDeComprobante());
        }
        return tiposDeComprobante;
    }

    public List<String> obtenerExportaciones() {
        List<String> exportaciones = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            exportaciones.add(comprobante.getExportacion());
        }
        return exportaciones;
    }

    public List<String> obtenerVersiones() {
        List<String> versiones = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            versiones.add(comprobante.getVersion());
        }
        return versiones;
    }

    public List<String> obtenerSeries() {
        List<String> series = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            series.add(comprobante.getSerie());
        }
        return series;
    }

    public List<String> obtenerFolios() {
        List<String> folios = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            folios.add(comprobante.getFolio());
        }
        return folios;
    }

    public List<String> obtenerTotales() {
        List<String> totales = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            totales.add(comprobante.getTotal());
        }
        return totales;
    }

    public List<String> obtenerSubTotales() {
        List<String> subTotales = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            subTotales.add(comprobante.getSubTotal());
        }
        return subTotales;
    }

    public List<String> obtenerFecha(){
        List<String> fechas = new ArrayList<>();
        for(Comprobante comprobante : comprobante){
            fechas.add(comprobante.getFecha());
        }
        return fechas;
    }

    public List<String> obtenerMoneda(){
        List<String> monedas = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            monedas.add(comprobante.getMoneda());
        }
        return monedas;
    }

    public List<String> obtenerLugarExpedicion(){
        List<String> lugarExpedicion = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            lugarExpedicion.add(comprobante.getLugarExpedicion());
        }
        return lugarExpedicion;
    }

    public List<String> obtenerFormaPago(){
        List<String> formaPago = new ArrayList<>();
        for (Comprobante comprobante: comprobante) {
            formaPago.add(comprobante.getFormaPago());
        }
        return formaPago;
    }

    public List<String> obtenerMetodoPago(){
        List<String> metodoPago = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            metodoPago.add(comprobante.getMetodoPago());
        }    
        return metodoPago;
    }

    public List<CfdiRelacionados> obtenerCfdiRelacionados() {
        List<CfdiRelacionados> cfdiRelacionadosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            cfdiRelacionadosList.add(comprobante.getCfdiRelacionados());
        }
        return cfdiRelacionadosList;
    }

    public List<String> obtenerTipoRelacion(){
        List<String> tipoRelacion = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            tipoRelacion.add(comprobante.getCfdiRelacionados().getTipoRelacion());
        }
        return tipoRelacion;
    }

    public List<Emisor> obtenerEmisores() {
        List<Emisor> emisores = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            emisores.add(comprobante.getEmisor());
        }
        return emisores;
    }

    public List<String> obtenerDescuentos(){
        List<String> descuentos = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            descuentos.add(comprobante.getDescuento());
        }
        return descuentos;
    }

    public List<String> obtenerRegimenFiscalEmisor(){
        List<String> lista = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            lista.add(comprobante.getEmisor().getRegimenFiscal());
        }
        return lista;
    }

    public List<String> obtenerRegimenFiscalReceptor(){
        List<String> lista = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            lista.add(comprobante.getReceptor().getRegimenFiscalReceptor());
        }
        return lista;
    }

    public List<Receptor> obtenerReceptores() {
        List<Receptor> receptores = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            receptores.add(comprobante.getReceptor());
        }
        return receptores;
    }

    public List<String> obtenerNombresReceptores(){
        List<String> nombresReceptores = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            nombresReceptores.add(comprobante.getReceptor().getNombre());
        }
        return nombresReceptores;
    }

    public List<String> obtenerRfcReceptor(){
        List<String> rfcReceptor = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            rfcReceptor.add(comprobante.getReceptor().getRfc());
        }
        return rfcReceptor;
    }

    public List<String> obtenerDomicilioFiscalReceptor(){
        List<String> domicilioFiscal = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            domicilioFiscal.add(comprobante.getReceptor().getDomicilioFiscalReceptor());
        }
        return domicilioFiscal;
    }

    public List<String> obtenerUsoCfdi(){
        List<String> listaUsoCfdi = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            listaUsoCfdi.add(comprobante.getReceptor().getUsoCFDI());
        }
        return listaUsoCfdi;
    }

    public List<Conceptos> obtenerConceptos() {
        List<Conceptos> conceptosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        return conceptosList;
    }

    public List<List<String>> obtenerValorUnitario(){
        List<Conceptos> conceptosList = new ArrayList<>();
        List<List<String>> listaValorUnitario = new ArrayList<>();
        
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        
   
        for (Conceptos conceptos : conceptosList) {
            List<Concepto> conceptoList = conceptos.getConcepto();
            List<String> valorUnitario = new ArrayList<>();
            for (Concepto concepto : conceptoList) {
                valorUnitario.add(concepto.getValorUnitario());
            }
            listaValorUnitario.add(valorUnitario);
        }
        
        return listaValorUnitario;
    }

    public List<List<String>> obtenerObjetoImp(){
        List<Conceptos> conceptosList = new ArrayList<>();
        List<List<String>> listaObjetoImp = new ArrayList<>();
        
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        
   
        for (Conceptos conceptos : conceptosList) {
            List<Concepto> conceptoList = conceptos.getConcepto();
            List<String> objetoImp = new ArrayList<>();
            for (Concepto concepto : conceptoList) {
                objetoImp.add(concepto.getObjetoImp());
            }
            listaObjetoImp.add(objetoImp);
        }
        
        return listaObjetoImp;
    }

    public List<List<Impuestos>> obtenerConceptoImpuestos(){
        
        List<Conceptos> conceptosList = new ArrayList<>();
        List<List<Impuestos>> listaObjetoImp = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        
   
        for (Conceptos conceptos : conceptosList) {
            List<Concepto> conceptoList = conceptos.getConcepto();
            List<Impuestos> objetoImp = new ArrayList<>();
            
            for (Concepto concepto : conceptoList) {
                objetoImp.add(concepto.getImpuestos());
            }
            listaObjetoImp.add(objetoImp);
        }
        return listaObjetoImp;
    }

    public List<List<String>> obtenerConceptoImpuestosTrasladoBase() {
    List<Conceptos> conceptosList = new ArrayList<>();
    List<List<String>> listaObjetoImp = new ArrayList<>();

    for (Comprobante comprobante : comprobante) {
        conceptosList.add(comprobante.getConceptos());
    }

    for (Conceptos conceptos : conceptosList) {
        List<Concepto> conceptoList = conceptos.getConcepto();
        List<String> objetoImp = new ArrayList<>();

        for (Concepto concepto : conceptoList) {
            Impuestos impuestos = concepto.getImpuestos();
            if (impuestos != null) {
                Traslados traslados = impuestos.getTraslados();
                if (traslados != null) {
                    Traslado traslado = traslados.getTraslado();
                    if (traslado != null) {
                        String base = traslado.getBase();
                        if (base != null) {
                            objetoImp.add(base);
                        } else {
                            objetoImp.add("Valor no disponible");
                        }
                    } else {
                        objetoImp.add("Traslado no disponible");
                    }
                } else {
                    objetoImp.add("Traslados no disponibles");
                }
            } else {
                objetoImp.add("Impuestos no disponibles");
            }
        }
        
        boolean allNull = objetoImp.stream().allMatch(Objects::isNull);
        if (!allNull) {
            listaObjetoImp.add(objetoImp);
        }
    }
    return listaObjetoImp;
}

public List<List<String>> obtenerConceptoImpuestosTrasladoImpuesto() {
    List<Conceptos> conceptosList = new ArrayList<>();
    List<List<String>> listaObjetoImp = new ArrayList<>();

    for (Comprobante comprobante : comprobante) {
        conceptosList.add(comprobante.getConceptos());
    }

    for (Conceptos conceptos : conceptosList) {
        List<Concepto> conceptoList = conceptos.getConcepto();
        List<String> objetoImp = new ArrayList<>();

        for (Concepto concepto : conceptoList) {
            Impuestos impuestos = concepto.getImpuestos();
            if (impuestos != null) {
                Traslados traslados = impuestos.getTraslados();
                if (traslados != null) {
                    Traslado traslado = traslados.getTraslado();
                    if (traslado != null) {
                        String impuesto = traslado.getImpuesto();
                        if (impuesto != null) {
                            objetoImp.add(impuesto);
                        } else {
                            objetoImp.add("Nulo");
                        }
                    } else {
                        objetoImp.add("Nulo");
                    }
                } else {
                    objetoImp.add("Nulos");
                }
            } else {
                objetoImp.add("Nulo");
            }
        }
        
        boolean allNull = objetoImp.stream().allMatch(Objects::isNull);
        if (!allNull) {
            listaObjetoImp.add(objetoImp);
        }
    }
    return listaObjetoImp;
}


    public List<List<String>> obtenerListasClaveUnidad() {
        List<Conceptos> conceptosList = new ArrayList<>();
        List<List<String>> listaClaveUnidad = new ArrayList<>();
        
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        
   
        for (Conceptos conceptos : conceptosList) {
            List<Concepto> conceptoList = conceptos.getConcepto();
            List<String> claveUnidad = new ArrayList<>();
            for (Concepto concepto : conceptoList) {
                claveUnidad.add(concepto.getClaveUnidad());
            }
            listaClaveUnidad.add(claveUnidad);
        }
        
        return listaClaveUnidad;
    }
    
    public List<List<String>> obtenerClaveProdServ(){
        List<Conceptos> conceptosList = new ArrayList<>();
        List<List<String>> listaClaveProdServ = new ArrayList<>();
        
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }

        for (Conceptos conceptos : conceptosList) {
            List<Concepto> conceptoList = conceptos.getConcepto();
            List<String> claveProdServ = new ArrayList<>();
            for (Concepto concepto : conceptoList) {
                claveProdServ.add(concepto.getClaveProdServ());
            }
            listaClaveProdServ.add(claveProdServ);
        }
        return listaClaveProdServ;
    }
    
    
    
    
    
    
    



    public List<Impuestos> obtenerImpuestos() {
        List<Impuestos> impuestosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            impuestosList.add(comprobante.getImpuestos());
        }
        return impuestosList;
    }

    public List<Complemento> obtenerComplementos() {
        List<Complemento> complementosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            complementosList.add(comprobante.getComplemento());
        }
        return complementosList;
    }

    public List<String> obtenerNombres(){
        List<String> nombres = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            nombres.add(comprobante.getNombre());
        }
        return nombres;
    }
    
}
