package mx.edu.ilce.sep.nomina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.edu.ilce.infrestructura.model.BaseModel;

@Entity
@Table(name = "tb_curp_idoneo")
public class CurpIdoneoModel extends BaseModel {

	private static final long serialVersionUID = 1156258196137155037L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curp_idoneo", nullable = false, length = 10)
	private Long idCurpIdonio;
	
	@Column(name="curp", updatable=false)
	private String curp;
	
	@Column(name="idoneo",updatable=false)
	private boolean idoneo;

	public Long getIdCurpIdonio() {
		return idCurpIdonio;
	}

	public void setIdCurpIdonio(Long idCurpIdonio) {
		this.idCurpIdonio = idCurpIdonio;
	}

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

}
