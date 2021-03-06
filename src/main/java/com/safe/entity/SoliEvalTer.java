
package com.safe.entity;

import java.io.Serializable;
import java.util.Date;

public class SoliEvalTer implements Serializable{
    
    
    private long idsolicitud;
    
    
    private Date fechacreacion;
    
    private Date fechaderivacion;
    
    private Usuario tecnico;
    
    private String pdf;
    
    private String direccionvisita;
    
    
    private String descripcionvisita;
    
    
    private long clienteidcliente;
    
    
    private long tipovisitteridtipovister;
    
    
    private long estadosolievalter;
    
    private String clientenombre;

    public long getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(long idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDireccionvisita() {
        return direccionvisita;
    }

    public void setDireccionvisita(String direccionvisita) {
        this.direccionvisita = direccionvisita;
    }

    public String getDescripcionvisita() {
        return descripcionvisita;
    }

    public void setDescripcionvisita(String descripcionvisita) {
        this.descripcionvisita = descripcionvisita;
    }

    public long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    public long getTipovisitteridtipovister() {
        return tipovisitteridtipovister;
    }

    public void setTipovisitteridtipovister(long tipovisitteridtipovister) {
        this.tipovisitteridtipovister = tipovisitteridtipovister;
    }

    public long getEstadosolievalter() {
        return estadosolievalter;
    }

    public void setEstadosolievalter(long estadosolievalter) {
        this.estadosolievalter = estadosolievalter;
    }
    
    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Date getFechaderivacion() {
        return fechaderivacion;
    }

    public void setFechaderivacion(Date fechaderivacion) {
        this.fechaderivacion = fechaderivacion;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }
    
    public String getClientenombre() {
        return clientenombre;
    }

    public void setClientenombre(String clientenombre) {
        this.clientenombre = clientenombre;
    }

    @Override
    public String toString() {
        return "SoliEvalTer{" + "idsolicitud=" + idsolicitud + ", fechacreacion=" + fechacreacion + ", direccionvisita=" + direccionvisita + ", descripcionvisita=" + descripcionvisita + ", clienteidcliente=" + clienteidcliente + ", tipovisitteridtipovister=" + tipovisitteridtipovister + ", estadosolievalter=" + estadosolievalter + '}';
    }    
    
}
