package mx.edu.ilce.infrestructura.helper;

import org.apache.log4j.Logger;

public class BaseHelper {
	protected Logger logger;

	public BaseHelper(){
		logger = Logger.getLogger("rules");
	}
}
