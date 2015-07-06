package mx.edu.ilce.infrestructura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public abstract class BaseDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Logger logger;

	public BaseDAO(){
		logger = Logger.getLogger("dao");
	}
	
}
