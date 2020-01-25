package com.ccs.service.impl;

import java.io.File;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccs.dao.BulkImportDao;
import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.repository.BulkImportInfoRepository;
import com.ccs.repository.BulkImportModulesRepository;
import com.ccs.service.BulkImportService;
import com.ccs.utility.ApiResponse;
import com.ccs.utility.StatusMessage;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Service
public class BulkImportServiceImpl extends StatusMessage implements BulkImportService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	BulkImportDao bulkImportDao;
	
	@Autowired
	BulkImportModulesRepository bulkImportModulesRepository;
	
	@Autowired
	BulkImportInfoRepository bulkImportInfoRepository;

	@Override
	public List<BulkImportInfoEntity> getAllBulkImportInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BulkImportInfoEntity> getBulkImportInfoByModulesId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BulkImportInfoEntity> getBulkImportInfoByStatusAndResult(int status, int result) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	//@Transactional
	public Map<String, String> downloadFile(String fromURL, String toURL) {
		Map<String, String> statusList = new HashMap<>();
		List<BulkImportModulesEntity> bulkImportModulesEntitys = bulkImportDao.getAllBulkImportModules();
		for (BulkImportModulesEntity bulkImportModulesEntity : bulkImportModulesEntitys) {
			System.out.println("URL_NAME="+bulkImportModulesEntity.getModuleURLName()+", name="+bulkImportModulesEntity.getModuleName());
			if (bulkImportModulesEntity.getModuleDataType() == 1) {
				fromURL = fromURL + File.separator + "MasterData";
				toURL = toURL + File.separator + "MasterData";
			} else {
				fromURL = fromURL + File.separator + "TransactionData";
				toURL = toURL + File.separator + "TransactionData";
			}
        
			fromURL = fromURL + File.separator + "DataFiles" + File.separator
					+ bulkImportModulesEntity.getModuleURLName() + "_24/01/2020_seq_1";
			toURL = toURL + File.separator + "DataFiles" + File.separator
					+ bulkImportModulesEntity.getModuleURLName() + "_24/01/2020_seq_1";
        
			
			String jsonFileName = bulkImportModulesEntity.getModuleURLName() + "_24/01/2020_seq_1";
			String remarks = null;
			Date processDate = null;
			Date uploadDate = null;
			int result = 1;
			int status = 1;
			boolean transferFlag = false;
			// code for copy file from "fromURL" to "toURL" and return true/false
        
			if (!transferFlag) {
				BulkImportInfoEntity entity = new BulkImportInfoEntity();
				entity.setFileName(jsonFileName);
				entity.setProcessDate(processDate);
				entity.setRemarks(remarks);
				entity.setResult(result);
				entity.setStatus(status);
				entity.setUploadDate(uploadDate);
				entity.setBulkImportModulesEntity(bulkImportModulesEntity);
				/*
				BulkImportModulesEntity ModulesEntity=	bulkImportModulesRepository.getOne((long) 1);
				BulkImportModulesEntity m=	bulkImportModulesRepository.getBymoduleName(bulkImportModulesEntity.getModuleName());
				System.out.println("module name="+m.getModuleURLName());
				*/
				
				/*
				List<BulkImportInfoEntity> bulkImportInfoEntitie= bulkImportInfoRepository.getByBulkImportModulesEntity(ModulesEntity);
				for(BulkImportInfoEntity moduleEntity:bulkImportInfoEntitie) {
					System.out.println("remark="+moduleEntity.getRemarks());
				}
            	*/
				ApiResponse apiResponse = 	bulkImportDao.addBulkImportInfo(entity);
			  //if(apiResponse.getSuccess())
				if (1==2) 
				{
					statusList.put(jsonFileName, apiResponse.getMessage());
				} else {
					statusList.put(jsonFileName, DOCUMENT_UPLOADED_SUCCESSFULLY_MESSAGE);
				}
				statusList.put(jsonFileName, DOCUMENT_UPLOADED_SUCCESSFULLY_MESSAGE);
			} else {
				statusList.put(jsonFileName, FILE_TRANSFER_FAILD_MESSAGE);
			}
		}
		return statusList;
	}

	@Override
	public Map<String, String> uploadFile(String fromURL, String toURL) {
		// TODO Auto-generated method stub
		return null;
	}

	
 

}
