package hu.menewblog.newblog.resources;

import hu.javagladiators.example.sport.services.GenericDaoService;
import hu.menewblog.newblog.Bejegyzes;
import hu.menewblog.newblog.Felhasznalo;
import hu.menewblog.newblog.services.BejegyzesService;
import hu.menewblog.newblog.services.FelhasznaloService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;

/**
 *
 * @author me
 */
@Path("blog")
@RequestScoped
public class BejegyzesekRes {
    @Inject
    BejegyzesService bejegyzes;
    @Inject
    FelhasznaloService felhasznalo;
    
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
    public BejegyzesekRes(){
        log.info("BejegyzesekRes peldany letrejott");
    }

    @GET
    @Path("osszesBej")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bejegyzes>getBejegyzesek(){
        return bejegyzes.getAll();
    }
    
    @GET
    @Path("osszesFel")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Felhasznalo>getFelhasznalok(){
        return felhasznalo.getAll();
    }
    
    @GET
    @Path("osszes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList Elemek()
    {
        ArrayList al = new ArrayList();
        al.add(felhasznalo.getAll());
        al.add(bejegyzes.getAll());
        
        return al;
    }
    
    @POST
    @Path("ujbejegyzes")
    @Produces(MediaType.TEXT_PLAIN)
    public void insertBejegyzes(@FormParam("felhasznalonev") String felhnev,
                                  @FormParam("bejegyzes") String bej){
        Bejegyzes ujb = new Bejegyzes();
        Felhasznalo felh = new Felhasznalo();
        /*Boolean van = false;
        
        for(Felhasznalo f : getFelhasznalok())
        {
            van = f.getFelhasznalonev().equals(felhnev);
        }
        if(van)
            return "A név foglalt. Adj meg egy másikat";
        else
        {
            felh.setFelhasznalonev(felhnev);
            ujb.setDatum(Timestamp.valueOf(LocalDateTime.now()));
            ujb.setSzoveg(bej);
            felhasznalo.save(felh);
            bejegyzes.save(ujb);
            return "ok";
        }*/
        felh.setFelhasznalonev(felhnev);
        ujb.setDatum(Timestamp.valueOf(LocalDateTime.now()));
        ujb.setSzoveg(bej);
        felhasznalo.save(felh);
        bejegyzes.save(ujb);
        //return "ok";
    }
}
