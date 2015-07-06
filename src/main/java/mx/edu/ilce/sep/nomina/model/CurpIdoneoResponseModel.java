package mx.edu.ilce.sep.nomina.model;

import mx.edu.ilce.infrestructura.model.BaseModel;

public class CurpIdoneoResponseModel extends BaseModel {

	private static final long serialVersionUID = 932987554002899697L;
	private String curp;
	private boolean idoneo;
	private String mensaje;

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public boolean isIdoneo() {
		return idoneo;
	}

	public void setIdoneo(boolean idoneo) {
		this.idoneo = idoneo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
