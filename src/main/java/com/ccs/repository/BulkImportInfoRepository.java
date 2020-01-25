package com.ccs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@Repository
public interface BulkImportInfoRepository extends JpaRepository<BulkImportInfoEntity, Long>{
	
	public List<BulkImportInfoEntity> getByBulkImportModulesEntity(BulkImportModulesEntity bulkImportModulesEntity);

 
}
