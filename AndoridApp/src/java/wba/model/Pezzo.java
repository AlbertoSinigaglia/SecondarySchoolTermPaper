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
import com.google.gson.annotations.Expose;
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
}
