package hu.menewblog.newblog.serviceImpl;

import hu.menewblog.newblog.Bejegyzes;
import hu.menewblog.newblog.services.BejegyzesService;
import hu.javagladiators.example.sport.services.GenericDaoService;
import java.util.Date;
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
public class BejegyzesServiceImpl implements BejegyzesService{
    
    @Inject
    GenericDaoService gds;
    
    @Override
    public List<Bejegyzes> getAll() {
        return (List<Bejegyzes>)gds.getEntities("Bejegyzes.osszesBej", new HashMap<>());
    }

    @Override
    public Bejegyzes getBejegyzesById(Long bejegyzesId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", bejegyzesId);
        return (Bejegyzes)gds.getEntity("Bejegyzes.getBejegyzesById", params);
    }

    @Override
    public Bejegyzes getBejegyzesByDatum(Date datum) {      
        Map<String, Object> params = new HashMap<>();
        params.put("datum", datum);
        return (Bejegyzes)gds.getEntities("Bejegyzes.getBejegyzesByDatum", params);
    }

    @Override
    public void save(Bejegyzes ujbejegyzes) {
        gds.save(ujbejegyzes);
    }

    @Override
    public Bejegyzes getBejegyzesByFelhasznaloId(Long felhasznaloId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", felhasznaloId);
        return (Bejegyzes)gds.getEntities("Bejegyzes.getBejegyzesByFelhasznaloId", params);
    }
    
}
