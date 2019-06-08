/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.model;

/**
 *
 * @author albertosinigaglia
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
@Table(name="GESTIONE")
public class DipNc implements Serializable{
    
    @Column(name="NR")
    Integer nr;
    @Id
    @Column(name="EMAIL")
    String email;

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DipNc{" + "nr=" + nr + ", email=" + email + '}';
    }
    
}

