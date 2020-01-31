package com.ccs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.ccs.dao.BulkImportDao;
import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.utility.ApiResponse;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Service
public class BulkImportDaoImpl implements BulkImportDao{

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BulkImportModulesEntity> getAllBulkImportModules1() {
		Query query = entityManager.createNamedQuery("BulkImportModulesEntity.getAllBulkImportModules");
        //query.setParameter("modulesIdFk", modulesIdFk);
        return query.getResultList();
	}

	@Override
	public ApiResponse addBulkImportInfo(BulkImportInfoEntity bulkImportInfoEntity) {
		return null;
		
	}



}
