package com.ccs.service;

import java.util.List;
import java.util.Map;

import com.ccs.entity.BulkImportInfoEntity;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
public interface BulkImportService {
	
	public List<BulkImportInfoEntity> getAllBulkImportInfo();
	public List<BulkImportInfoEntity> getBulkImportInfoByModulesId();
	public List<BulkImportInfoEntity> getBulkImportInfoByStatusAndResult(int status, int result);

	public Map<String, String>  downloadFile(String fromURL, String toURL);
	public Map<String, String> uploadFile(String fromURL, String toURL);
	
	
}
