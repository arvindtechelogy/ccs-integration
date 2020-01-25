package com.ccs.dao;

import java.util.List;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.utility.ApiResponse;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
public interface BulkImportDao {
	
	public List<BulkImportModulesEntity> getAllBulkImportModules();
	
	public ApiResponse addBulkImportInfo(BulkImportInfoEntity bulkImportInfoEntity);

	
}
