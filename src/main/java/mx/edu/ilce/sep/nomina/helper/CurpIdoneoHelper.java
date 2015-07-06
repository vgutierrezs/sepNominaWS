package mx.edu.ilce.sep.nomina.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import mx.edu.ilce.infrestructura.helper.BaseHelper;
import mx.edu.ilce.sep.nomina.model.CurpIdoneoModel;
import mx.edu.ilce.sep.nomina.model.CurpIdoneoResponseModel;

import org.springframework.stereotype.Component;

@Component
public class CurpIdoneoHelper extends BaseHelper {
	
	private static ResourceBundle messages = ResourceBundle.getBundle("mx.edu.ilce.base.messages");

	public CurpIdoneoResponseModel construyeRespuesta(String curp, CurpIdoneoModel curpIdoneo){
		CurpIdoneoResponseModel curpIdoneoResponse = new CurpIdoneoResponseModel();
		if(curpIdoneo==null){
			curpIdoneoResponse.setCurp(curp);
			curpIdoneoResponse.setIdoneo(false);
			curpIdoneoResponse.setMensaje(getMsjUsuarioNoEncontrado());			
		} else {
			curpIdoneoResponse.setCurp(curpIdoneo.getCurp());
			curpIdoneoResponse.setIdoneo(curpIdoneo.isIdoneo());
			curpIdoneoResponse.setMensaje(curpIdoneo.isIdoneo()?getMsjSiEsIdoneo():getMsjNoEsIdoneo());
		}
		return curpIdoneoResponse;
	}
	
	public String generateId(HttpServletRequest request, String curp){
		StringBuilder sb = new StringBuilder(curp);
		sb.append(" | ").append(new Date().getTime());
		sb.append(" | ").append(getIpClient(request));
		String hash = md5Encrypt(sb.toString());
		StringBuilder sb2 = new StringBuilder(hash);
		sb2.append(" | ").append(sb);
		logger.info(sb2.toString());
		return hash;
	}
	
	protected String md5Encrypt(String chain) {
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(chain.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch(Exception e) {
        	throw new RuntimeException(e);
        }
    }
	
	protected String getIpClient(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	protected String getMsjUsuarioNoEncontrado(){
		ResourceBundle.clearCache();
		return messages.getString("docente.curpidoneo.no_encontrado");
	}
	
	protected String getMsjNoEsIdoneo(){
		ResourceBundle.clearCache();
		return messages.getString("docente.curpidoneo.no_es_idoneo");
	}
	
	protected String getMsjSiEsIdoneo(){
		ResourceBundle.clearCache();
		return messages.getString("docente.curpidoneo.no_encontrado");
	}

}
