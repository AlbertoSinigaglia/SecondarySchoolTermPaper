/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
@Entity
@Table(name="ARTICOLI")
public class Articolo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CODICEARTICOLO")
    private Integer codiceArticolo;
 
    @Column(name = "NOME", nullable = false)
    private String nome;
 
    @Column(name = "DESCRIZIONE", nullable = false)
    private String descrizione;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "COMPORRE", 
        joinColumns = { @JoinColumn(name = "CODICEARTICOLO") }, 
        inverseJoinColumns = { @JoinColumn(name = "CODICEPEZZO") }
    )
    private Set<Pezzo> pezzi= new HashSet<>();
    
    @OneToMany(mappedBy="articolo", fetch=FetchType.EAGER)
    private Set<NonConformita> nonConf= new HashSet<>();

    
    public Articolo(){}
    public Articolo(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
    }
    
    public int getCodiceArticolo() {
        return codiceArticolo;
    }

    public void setCodiceArticolo(int codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Set<Pezzo> getPezzi() {
        return pezzi;
    }

    public void setPezzi(Set<Pezzo> pezzi) {
        this.pezzi = pezzi;
    }

    public Set<NonConformita> getNonConf() {
        return nonConf;
    }

    public void setNonConf(Set<NonConformita> nonConf) {
        this.nonConf = nonConf;
    }
}
