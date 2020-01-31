package com.ccs.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.repository.BulkImportInfoRepository;
import com.ccs.repository.BulkImportModulesRepository;
import com.ccs.service.BulkImportService;
import com.ccs.utility.ConversionUtil;
import com.ccs.utility.StatusMessage;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Service
public class BulkImportServiceImpl extends StatusMessage implements BulkImportService {


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

	//@SuppressWarnings("unused")
	//@Transactional
	@Override
	public Map<String, String> downloadFile(String fromURL, String toURL) {
		Map<String, String> statusList = new HashMap<>();
		try {
			String currentDate = new ConversionUtil().getDateDDMMYYString(new Date());
			List<BulkImportModulesEntity> bulkImportModulesEntitys = bulkImportModulesRepository.getAllBulkImportModules();
			
			for (BulkImportModulesEntity bulkImportModulesEntity : bulkImportModulesEntitys) {
				
				String fromURL_ = fromURL;
				String toURL_ = toURL;
				String jsonFile = null;
				String folderType = bulkImportModulesEntity.getModuleDataType() == 1 ? "MasterData" : "TransactionData";
				fromURL_ = fromURL_ + File.separator + folderType + File.separator + "DataFiles";
				toURL_ = toURL_ + File.separator + folderType + File.separator + "DataFiles";

				File toURL_Folder = new File(toURL_);
				if (!toURL_Folder.exists()) {
					toURL_Folder.mkdirs();
				}

				FilenameFilter filter = new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.startsWith(bulkImportModulesEntity.getModuleURLName() + "_" + currentDate);
					}
				};
				String[] children = new File(fromURL_).list(filter);
				if (children == null) {
					statusList.put(fromURL_, INVALID_DIRECTORY);
				} else {
					for (int i = 0; i < children.length; i++) {
						String filename = children[i];
						jsonFile = filename;
					}
				}
				
				fromURL_ += File.separator + jsonFile;
				toURL_ += File.separator + jsonFile;
				Path src = Paths.get(fromURL_);
				Path dest = Paths.get(toURL_);
				File existFromURL_ = new File(fromURL_);
				File existToURL_ = new File(toURL_);
				
				if (existFromURL_.exists() && !existToURL_.exists()) {
					Files.copy(src, dest);
					int i = 0;
					while (!FileUtils.contentEquals(new File(fromURL_), new File(toURL_)) && i < 5) {
						Files.deleteIfExists(dest);
						Files.copy(src, dest);
						i++;
					}
					if (existToURL_.exists()) {
						BulkImportInfoEntity entity = new BulkImportInfoEntity();
						entity.setFileName(jsonFile);
						entity.setProcessDate(new Date());
						entity.setRemarks(FileUtils.contentEquals(new File(fromURL_), new File(toURL_)) == true
								? FILE_DOWNLOADED_MESSAGE
								: INCOMPLETE_DOWNLOAD_MESSAGE);
						entity.setResult(0);
						entity.setStatus(1);
						entity.setUploadDate(new Date());
						entity.setActive(true);
						entity.setBulkImportModulesEntity(bulkImportModulesEntity);
						String unloadedJsonFile = null;
						
						unloadedJsonFile = bulkImportInfoRepository.saveAndFlush(entity).getFileName();
						if (unloadedJsonFile != null) {
							statusList.put(bulkImportModulesEntity.getModuleURLName(), RECORD_INSERT_SUCCESSFULLY_MESSAGE);
						} else {
							statusList.put(bulkImportModulesEntity.getModuleURLName(), DOCUMENT_UPLOADED_SUCCESSFULLY_MESSAGE);
						}
					} else {
						statusList.put(bulkImportModulesEntity.getModuleURLName(), FILE_TRANSFER_FAILD_MESSAGE);
					}
				} else if (existToURL_.exists()) {
					statusList.put(bulkImportModulesEntity.getModuleURLName(), FILE_ALREADY_EXIST_MESSAGE);
				} else if (!existFromURL_.exists()) {
					statusList.put(bulkImportModulesEntity.getModuleURLName(), FILE_NOT_EXIST_ON_SERVER_MESSAGE);
				} else {
					statusList.put(bulkImportModulesEntity.getModuleURLName(), SOMETHING_WENTS_WRONG_MESSAGE);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return statusList;
	}

	@Override
	public Map<String, String> uploadFile(String fromURL, String toURL) {
		// TODO Auto-generated method stub
		return null;
	}

}
