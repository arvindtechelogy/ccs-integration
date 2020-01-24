/**
 * 
 */
package com.ccs.repository;

import java.util.List;

import com.ccs.entity.BulkImportInfoEntity;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
public interface BulkImportInfoRepositoryCustom {
	
	
	List<BulkImportInfoEntity> findByModulesIdFk(long modulesIdFk);

}
