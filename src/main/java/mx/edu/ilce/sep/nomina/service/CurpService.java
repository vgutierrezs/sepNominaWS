package mx.edu.ilce.sep.nomina.service;

import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import mx.edu.ilce.sep.nomina.model.CurpIdoneoResponseModel;

@WebService
public interface CurpService {

	@WebResult(name="respuesta")
	CurpIdoneoResponseModel consultaCurpIdoneo(@WebParam(name="curp") String curp, @WebParam(name="idSec", header=true, mode=Mode.OUT) Holder<String> idSecurity);
}
