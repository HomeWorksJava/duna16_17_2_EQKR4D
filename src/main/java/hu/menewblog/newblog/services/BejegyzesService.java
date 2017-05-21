package hu.menewblog.newblog.services;

import hu.menewblog.newblog.Bejegyzes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author me
 */
public interface BejegyzesService {
    public List<Bejegyzes> getAll();
    public Bejegyzes getBejegyzesById(Long bejegyzesId);
    public Bejegyzes getBejegyzesByDatum(Date datum);
    public Bejegyzes getBejegyzesByFelhasznaloId(Long felhasznaloId);
    //public Bejegyzes getBejegyzesByFelhasznaloIdAndDatum(Long felhasznaloId, Date datum);
    public void save(Bejegyzes ujbejegyzes);
    
}
