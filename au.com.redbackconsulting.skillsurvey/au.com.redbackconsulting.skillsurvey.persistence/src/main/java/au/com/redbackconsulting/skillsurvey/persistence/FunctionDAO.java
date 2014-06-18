package au.com.redbackconsulting.skillsurvey.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.redbackconsulting.skillsurvey.persistence.manager.EntityManagerProvider;
import au.com.redbackconsulting.skillsurvey.persistence.manager.PersistenceManager;
import au.com.redbackconsulting.skillsurvey.persistence.model.Function;

public class FunctionDAO  extends BasicDAO<Function>  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected EntityManagerProvider emProvider;

    public FunctionDAO() {
    	super(PersistenceManager.getInstance().getEntityManagerProvider());

    }

	@Override
	protected String getidFieldName() {
		
		return "idfunction";
	}

   

  
}
