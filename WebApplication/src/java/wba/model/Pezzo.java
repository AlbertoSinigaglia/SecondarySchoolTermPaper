/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
@Entity
@Table(name="PEZZI")
public class Pezzo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CODICEPEZZO")
    private Integer codicePezzo;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "DESCRIZIONE", nullable = false)
    private String descrizione;
    
    @ManyToMany(mappedBy="pezzi", fetch=FetchType.EAGER)
    private Set<Articolo> articoli = new HashSet<>();
    
    @OneToMany(mappedBy="pezzo", fetch=FetchType.EAGER)
    private Set<NonConformita> nonConf= new HashSet<>();

    public Pezzo(){}
    
    public Pezzo(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
    }

    public int getCodicePezzo() {
        return codicePezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setCodicePezzo(int codicePezzo) {
        this.codicePezzo = codicePezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
   

    public Set<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set <Articolo> articoli) {
        this.articoli = articoli;
    }
    
    public Set<NonConformita> getNonConf() {
        return nonConf;
    }

    public void setNonConf(Set<NonConformita> nonConf) {
        this.nonConf = nonConf;
    }
}
