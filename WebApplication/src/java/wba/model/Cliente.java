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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author polato3547
 */
@Entity
@Table(name="CLIENTI")
public class Cliente implements Serializable{
    @Column(name="PIVA")
    @Id
    private String piva;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="TELEFONO", nullable=false)
    private String tel;
    
    @Column(name="TELEFONO2")
    private String tel2;
    
    @Column(name="DENOM_AZIENDA")
    private String azienda;
    
    @OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
    private Set<NonConformita> nc;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="ACCETTATO")
    private Boolean accettato=false;
    
    public Cliente(){accettato=false;}

    public Cliente(String piva, String email, String tel, String tel2, String azienda, String password) {
        this.piva = piva;
        this.email = email;
        this.tel = tel;
        this.tel2 = tel2;
        this.azienda = azienda;
        this.password = password;
        accettato=false;
    }

    public Boolean isAccettato() {
        return accettato;
    }

    public void setAccettato(Boolean accettato) {
        this.accettato = accettato;
    }
    
    public String getPiva() {
        return piva;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getTel2() {
        return tel2;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public Set<NonConformita> getNc() {
        return nc;
    }

    public void setNc(Set<NonConformita> nc) {
        this.nc = nc;
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
