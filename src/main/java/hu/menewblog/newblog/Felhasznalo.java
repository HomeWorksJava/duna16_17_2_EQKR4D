package hu.menewblog.newblog;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author me
 */
@Entity
@NamedQueries({@NamedQuery(name = "Felhasznalo.osszesFel", query = "SELECT f FROM Felhasznalo f"),
               @NamedQuery(name = "Felhasznalo.getFelhasznaloById", query = "SELECT f FROM Felhasznalo f WHERE f.felhasznaloId = :id"),
               @NamedQuery(name = "Felhasznalo.getFelhasznaloByNev", query = "SELECT f FROM Felhasznalo f WHERE f.felhasznalonev = :felhasznalonev"),
               //@NamedQuery(name = "Felhasznalo.searchByNev", query = "SELECT f FROM Felhasznalo f WHERE f.felhasznalonev = :felhasznalonev")
})
public class Felhasznalo implements Serializable {

    private String felhasznalonev;
    
    //@ManyToMany
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="bejegyzesId")
    private List<Bejegyzes> bejegyzes;

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public List<Bejegyzes> getBejegyzes() {
        return bejegyzes;
    }

    public void setBejegyzes(List<Bejegyzes> bejegyzes) {
        this.bejegyzes = bejegyzes;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long felhasznaloId;

    public Long getId() {
        return felhasznaloId;
    }

    public void setId(Long id) {
        this.felhasznaloId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (felhasznaloId != null ? felhasznaloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Felhasznalo)) {
            return false;
        }
        Felhasznalo other = (Felhasznalo) object;
        if ((this.felhasznaloId == null && other.felhasznaloId != null) || (this.felhasznaloId != null && !this.felhasznaloId.equals(other.felhasznaloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.menewblog.newblog.Felhasznalo[ id=" + felhasznaloId + " ]";
    }
    
}
