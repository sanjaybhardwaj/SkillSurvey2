package au.com.redbackconsulting.skillsurvey.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.redbackconsulting.skillsurvey.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.skillsurvey.persistence.model.Level;

public class LevelDAO extends BasicDAO<Level>  {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    public LevelDAO() {
    	super(PersistenceManager.getInstance().getEntityManagerProvider());

    
    }



	@Override
	protected String getidFieldName() {		
		return "idlevel";
	}



    

}
