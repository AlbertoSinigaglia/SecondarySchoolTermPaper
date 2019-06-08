/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

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
    
    @ManyToMany(mappedBy="nonConfGest", fetch=FetchType.EAGER)
    private Set<Dipendente> dipendentiGest= null;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PIVA", nullable=true)
    private Cliente cliente= new Cliente();
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CODICEPEZZO")
    private Pezzo pezzo= new Pezzo();
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CODICEARTICOLO")
    private Articolo articolo= new Articolo();
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMAIL", nullable=true)
    private Dipendente dipendenteRisc= new Dipendente();
    
    public NonConformita() {}

    public int getNr() {
        return nr;
    }

    public String getVerificaEfficacia() {
        return verificaEfficacia;
    }

    public String getVerificaAzioni() {
        return verificaAzioni;
    }

    public String getAzioniRicorrenza() {
        return azioniRicorrenza;
    }

    public String getReparto() {
        return reparto;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public String getCause() {
        return cause;
    }

    public String getDescrSpedizione() {
        return descrSpedizione;
    }

    public float getCosto() {
        return costo;
    }

    public String getDescrProblema() {
        return descrProblema;
    }

    public String getAzioneContenimento() {
        return azioneContenimento;
    }

    public String getAzioneCorrettiva() {
        return azioneCorrettiva;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setVerificaEfficacia(String verificaEfficacia) {
        this.verificaEfficacia = verificaEfficacia;
    }

    public void setVerificaAzioni(String verificaAzioni) {
        this.verificaAzioni = verificaAzioni;
    }

    public void setAzioniRicorrenza(String azioniRicorrenza) {
        this.azioniRicorrenza = azioniRicorrenza;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDescrSpedizione(String descrSpedizione) {
        this.descrSpedizione = descrSpedizione;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setDescrProblema(String descrProblema) {
        this.descrProblema = descrProblema;
    }

    public void setAzioneContenimento(String azioneContenimento) {
        this.azioneContenimento = azioneContenimento;
    }

    public void setAzioneCorrettiva(String azioneCorrettiva) {
        this.azioneCorrettiva = azioneCorrettiva;
    }

    public Set<Dipendente> getDipendentiGest() {
        return dipendentiGest;
    }

    public void setDipendentiGest(Set<Dipendente> dipendentiGest) {
        this.dipendentiGest = dipendentiGest;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pezzo getPezzo() {
        return pezzo;
    }

    public void setPezzo(Pezzo pezzo) {
        this.pezzo = pezzo;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public Dipendente getDipendenteRisc() {
        return dipendenteRisc;
    }

    public void setDipendenteRisc(Dipendente dipendenteRisc) {
        this.dipendenteRisc = dipendenteRisc;
    }
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
}
