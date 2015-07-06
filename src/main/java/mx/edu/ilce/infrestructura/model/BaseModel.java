package mx.edu.ilce.infrestructura.model;

import java.io.Serializable;

import org.apache.log4j.Logger;

public abstract class BaseModel implements Serializable, Cloneable {

	private static final long serialVersionUID = 5393346429516635744L;
	
	protected Logger logger;

	public BaseModel(){
		logger = Logger.getLogger("model");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T clone(Class<T> clase) {
		try {
			return (T) super.clone();
		} catch(CloneNotSupportedException e){
			e.getMessage();
			logger.error("Clone no soportado para "+this.getClass());
			return null;
		}
    }
	
}