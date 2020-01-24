/**
 * 
 */
package com.ccs.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.repository.BulkImportInfoRepositoryCustom;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Repository
@Transactional
public class BulkImportInfoRepositoryImpl implements BulkImportInfoRepositoryCustom{

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BulkImportInfoEntity> findByModulesIdFk(long modulesIdFk) {
		Query query = entityManager.createNamedQuery("BulkImportInfoEntity.getAllByModules");
        query.setParameter("modulesIdFk", modulesIdFk);
        return query.getResultList();
	}

}
