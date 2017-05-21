package hu.menewblog.newblog;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author me
 */
@Entity
@NamedQueries({@NamedQuery(name = "Bejegyzes.osszesBej", query = "SELECT b FROM Bejegyzes b"),
               @NamedQuery(name = "Bejegyzes.getBejegyzesById", query = "SELECT b FROM Bejegyzes b WHERE b.bejegyzesId = :id"),
               @NamedQuery(name = "Bejegyzes.getBejegyzesByDatum", query = "SELECT b FROM Bejegyzes b WHERE b.datum = :datum"),
               @NamedQuery(name = "Bejegyzes.getBejegyzesByFelhasznaloId", query = "SELECT b FROM Bejegyzes b WHERE b.felhasznalo.felhasznaloId = :felhasznaloId"),
               //@NamedQuery(name = "Bejegyzes.getBejegyzesByFelhasznaloIdAndDatum", query = "SELECT b FROM Bejegyzes b WHERE b.felhasznalo.id = :felhasznaloId AND b.datum = :datum")
})
public class Bejegyzes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datum;
    private String szoveg;
    
    //@ManyToMany
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="felhasznaloId")
    private Felhasznalo felhasznalo;

    public Felhasznalo getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(Felhasznalo felhasznalo) {
        this.felhasznalo = felhasznalo;
    }
    
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bejegyzesId;

    public Long getId() {
        return bejegyzesId;
    }

    public void setId(Long id) {
        this.bejegyzesId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bejegyzesId != null ? bejegyzesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bejegyzes)) {
            return false;
        }
        Bejegyzes other = (Bejegyzes) object;
        if ((this.bejegyzesId == null && other.bejegyzesId != null) || (this.bejegyzesId != null && !this.bejegyzesId.equals(other.bejegyzesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.menewblog.newblog.Bejegyzes[ id=" + bejegyzesId + " ]";
    }
    
}
