package mx.edu.ilce.infrestructura.service;

import org.apache.log4j.Logger;

public abstract class BaseService {

	protected Logger logger;

	public BaseService(){
		logger = Logger.getLogger("service");
	}
	
}
