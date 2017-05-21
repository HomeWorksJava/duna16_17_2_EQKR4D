package hu.menewblog.newblog.serviceImpl;

import hu.menewblog.newblog.Felhasznalo;
import hu.menewblog.newblog.services.FelhasznaloService;
import hu.javagladiators.example.sport.services.GenericDaoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author me
 */
@Stateless
public class FelhasznaloServiceImpl implements FelhasznaloService{

    @Inject
    GenericDaoService gds;
    
    @Override
    public List<Felhasznalo> getAll() {
        return (List<Felhasznalo>)gds.getEntities("Felhasznalo.osszesFel", new HashMap<>());
    }

    @Override
    public Felhasznalo getFelhasznaloByNev(String felhasznalonev) {
        Map<String, Object> params = new HashMap<>();
        params.put("felhasznalonev", felhasznalonev);
        return (Felhasznalo)gds.getEntities("Felhasznalo.getFelhasznaloByNev", params);
    }
    
    @Override
    public Felhasznalo getFelhasznaloById(Long felhasznaloId){
        Map<String, Object> params = new HashMap<>();
        params.put("id", felhasznaloId);
        return (Felhasznalo)gds.getEntity("Felhasznalo.getFelhasznaloById", params);
    }

    @Override
    public void save(Felhasznalo ujfelhasznalo) {
        gds.save(ujfelhasznalo);
    }
    
}
