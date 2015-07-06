package mx.edu.ilce.sep.nomina.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;

import mx.edu.ilce.infrestructura.service.BaseService;
import mx.edu.ilce.sep.nomina.dao.CurpIdoneoDAO;
import mx.edu.ilce.sep.nomina.helper.CurpIdoneoHelper;
import mx.edu.ilce.sep.nomina.model.CurpIdoneoModel;
import mx.edu.ilce.sep.nomina.model.CurpIdoneoResponseModel;
import mx.edu.ilce.sep.nomina.service.CurpService;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="curpService")
public class CurpServiceImpl extends BaseService implements CurpService  {
	
	@Autowired
	private CurpIdoneoDAO curpIdoneoDAO;
	
	@Autowired
	private CurpIdoneoHelper curpIdonioWSHelper;

	public CurpIdoneoResponseModel consultaCurpIdoneo(String curp, Holder<String> idSecurity) {
		CurpIdoneoModel curpIdoneo = curpIdoneoDAO.find(curp);
		
		//idSec implementation
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);		
		idSecurity.value = curpIdonioWSHelper.generateId(request, curp); 
		
		return curpIdonioWSHelper.construyeRespuesta(curp, curpIdoneo);
	}

}
