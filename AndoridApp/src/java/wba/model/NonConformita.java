/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author polato3547
 */
@Entity
@Table(name="NONCONFORMITA")
public class NonConformita implements Serializable{
    @Column(name="NR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer nr;
    
    @Column(name="VERIFICAEFFICACIA") 
    private String verificaEfficacia;
    
    @Column(name="VERIFICAAZIONI") 
    private String verificaAzioni;
    
     @Column(name="AZIONIRICORRENZA") 
    private String azioniRicorrenza;
     
    @Column(name="REPARTO") 
    private String reparto;
    
    @Column(name="DATAINIZIO") 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInizio;
    
    @Column(name="DATAFINE") 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFine;
    
    @Column(name="CAUSE") 
    private String cause;
    
    @Column(name="DESCRSPEDIZIONE") 
    private String descrSpedizione;
    
    @Column(name="COSTO") 
    private Float costo=new Float(0);
    
    @Column(name="DESCRPROBLEMA") 
    private String descrProblema;
    
    @Column(name="AZIONECONTENIMENTO") 
    private String azioneContenimento;
     
    @Column(name="AZIONECORRETTIVA") 
    private String azioneCorrettiva;
    
    @Column(name="PIVA")
    private String cliente;
     
    @Column(name="CODICEPEZZO")
    private Integer pezzo;
    
    @Column(name="CODICEARTICOLO") 
    private Integer articolo;
    
    @Column(name="EMAIL")
    private String dipendenteRisc;
    
    public NonConformita() {}

    public String realDataInizio(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInizio);
        return cal.get(Calendar.DAY_OF_MONTH)+" / "+cal.get(Calendar.MONTH)+" / "+cal.get(Calendar.YEAR);
    }
    public String realDataFine(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataFine);
        return cal.get(Calendar.DAY_OF_MONTH)+" / "+cal.get(Calendar.MONTH)+" / "+cal.get(Calendar.YEAR);
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getVerificaEfficacia() {
        return verificaEfficacia;
    }

    public void setVerificaEfficacia(String verificaEfficacia) {
        this.verificaEfficacia = verificaEfficacia;
    }

    public String getVerificaAzioni() {
        return verificaAzioni;
    }

    public void setVerificaAzioni(String verificaAzioni) {
        this.verificaAzioni = verificaAzioni;
    }

    public String getAzioniRicorrenza() {
        return azioniRicorrenza;
    }

    public void setAzioniRicorrenza(String azioniRicorrenza) {
        this.azioniRicorrenza = azioniRicorrenza;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescrSpedizione() {
        return descrSpedizione;
    }

    public void setDescrSpedizione(String descrSpedizione) {
        this.descrSpedizione = descrSpedizione;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getDescrProblema() {
        return descrProblema;
    }

    public void setDescrProblema(String descrProblema) {
        this.descrProblema = descrProblema;
    }

    public String getAzioneContenimento() {
        return azioneContenimento;
    }

    public void setAzioneContenimento(String azioneContenimento) {
        this.azioneContenimento = azioneContenimento;
    }

    public String getAzioneCorrettiva() {
        return azioneCorrettiva;
    }

    public void setAzioneCorrettiva(String azioneCorrettiva) {
        this.azioneCorrettiva = azioneCorrettiva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getPezzo() {
        return pezzo;
    }

    public void setPezzo(Integer pezzo) {
        this.pezzo = pezzo;
    }

    public Integer getArticolo() {
        return articolo;
    }

    public void setArticolo(Integer articolo) {
        this.articolo = articolo;
    }

    public String getDipendenteRisc() {
        return dipendenteRisc;
    }

    public void setDipendenteRisc(String dipendenteRisc) {
        this.dipendenteRisc = dipendenteRisc;
    }
    
    
}
