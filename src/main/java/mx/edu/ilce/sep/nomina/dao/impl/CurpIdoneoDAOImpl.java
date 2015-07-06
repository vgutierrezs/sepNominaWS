package mx.edu.ilce.sep.nomina.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.edu.ilce.infrestructura.dao.BaseDAO;
import mx.edu.ilce.sep.nomina.dao.CurpIdoneoDAO;
import mx.edu.ilce.sep.nomina.model.CurpIdoneoModel;

@Repository
public class CurpIdoneoDAOImpl extends BaseDAO implements CurpIdoneoDAO{

	public CurpIdoneoModel find(String curp) {
		StringBuilder sb = new StringBuilder("FROM CurpIdoneoModel ci WHERE ci.curp = :curp");
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("curp", curp);
		List<CurpIdoneoModel> list = query.getResultList();
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
