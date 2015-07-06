package mx.edu.ilce.infrestructura.rules;

import org.apache.log4j.Logger;

public abstract class BaseRules {

	protected Logger logger;

	public BaseRules(){
		logger = Logger.getLogger("rules");
	}
	
}
