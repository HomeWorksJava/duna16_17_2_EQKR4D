package hu.menewblog.newblog.services;

import hu.menewblog.newblog.Felhasznalo;
import java.util.List;

/**
 *
 * @author me
 */
public interface FelhasznaloService {
    public List<Felhasznalo> getAll();
    public Felhasznalo getFelhasznaloByNev(String felhasznalonev);
    public Felhasznalo getFelhasznaloById(Long felhasznaloId);
    public void save(Felhasznalo ujfelhasznalo);
}
