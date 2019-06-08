/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name="DIPENDENTI")
public class Dipendente  implements Serializable{
    @Column(name="NOME", nullable=false)
    private String nome;
    @Column(name="COGNOME", nullable=false)
    private String cognome;
    
    @Column(name="TELEFONO", nullable=false)
    private String tel;
    
    @Column(name="TELEFONO2")
    private String tel2;
    @Column(name="ACCETTATO")
    private Boolean accettato;
    @Id
    @Column(name="EMAIL", nullable=false, length=30)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name="RUOLO", nullable=false)
    private Ruolo ruolo;
    
    @Column(name="PASSWORD")
    private String password;
    
    @OneToMany(mappedBy="dipendenteRisc", fetch=FetchType.EAGER)
    private Set<NonConformita> nonConf= null;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "GESTIONE", 
        joinColumns = { @JoinColumn(name = "EMAIL",insertable=true, updatable=true) }, 
        inverseJoinColumns = { @JoinColumn(name = "NR", insertable=true, updatable=true),  } 
    )
    private Set<NonConformita> nonConfGest= null;

    public Dipendente(String nome, String cognome, String tel, String tel2, String email, Ruolo ruolo, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.tel2 = tel2;
        this.email = email;
        this.ruolo = ruolo;
        this.password = password;
        accettato=false;
    }

    public Boolean isAccettato() {
        return accettato;
    }

    public void setAccettato(Boolean accettato) {
        this.accettato = accettato;
    }
    
     public Dipendente(){}   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Ruolo getRuolo() {
        return ruolo;
    }
    
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
    
    public Set<NonConformita> getNonConf() {
        return nonConf;
    }

    public void setNonConf(Set<NonConformita> nonConf) {
        this.nonConf = nonConf;
    }

    public Set<NonConformita> getNonConfGest() {
        return nonConfGest;
    }

    public void setNonConfGest(Set<NonConformita> nonConfGest) {
        this.nonConfGest = nonConfGest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccettato() {
        return accettato;
    }
    

}
