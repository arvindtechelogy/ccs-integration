/**
 * 
 */
package com.ccs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.repository.BulkImportInfoRepository;
import com.ccs.repository.BulkImportModulesRepository;
import com.ccs.utility.RecordNotFoundException;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@Service
public class DataProcessingService {

	@Autowired
	BulkImportInfoRepository bulkImportInfoRepository;

	@Autowired
	BulkImportModulesRepository  bulkImportModulesRepository;
	
	// @Scheduled(cron = "15 * 22 * * ?")
	//@Scheduled(fixedRate = 1 * 60 * 1000)
	public List<BulkImportInfoEntity> getAllBulkImportInfos() {

		System.out.println("|||||||||||||||||||||==============Scheduled test==============|||||||||||||||||||||");
		List<BulkImportInfoEntity> bulkImportInfoEntity = bulkImportInfoRepository.findAll();

		if (bulkImportInfoEntity.size() > 0) {
			return bulkImportInfoEntity;
		} else {
			return new ArrayList<BulkImportInfoEntity>();
		}
	}

	public BulkImportInfoEntity getBulkImportInfoById(Long id) throws RecordNotFoundException {
		Optional<BulkImportInfoEntity> bulkImportInfoEntity = bulkImportInfoRepository.findById(id);

		if (bulkImportInfoEntity.isPresent()) {
			return bulkImportInfoEntity.get();
		} else {
			throw new RecordNotFoundException("No BulkImportInfo record exist for given id");
		}
	}

	public BulkImportInfoEntity createOrUpdateBulkImportInfo(BulkImportInfoEntity entity)
			throws RecordNotFoundException {
		Optional<BulkImportInfoEntity> bulkImportInfoEntity = bulkImportInfoRepository.findById(entity.getId());

		if (bulkImportInfoEntity.isPresent()) {
			BulkImportInfoEntity newEntity = bulkImportInfoEntity.get();
			newEntity.setFileName(entity.getFileName());
			newEntity.setUploadDate(entity.getUploadDate());
			newEntity.setProcessDate(entity.getProcessDate());
			newEntity.setStatus(entity.getStatus());
			newEntity.setResult(entity.getResult());
			newEntity.setRemarks(entity.getRemarks());
			newEntity = bulkImportInfoRepository.save(newEntity);

			return newEntity;
		} else {
			entity = bulkImportInfoRepository.save(entity);

			return entity;
		}
	}

	public void deleteBulkImportInfoById(Long id) throws RecordNotFoundException {
		Optional<BulkImportInfoEntity> bulkImportInfoEntity = bulkImportInfoRepository.findById(id);

		if (bulkImportInfoEntity.isPresent()) {
			bulkImportInfoRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No BulkImportInfo record exist for given id");
		}
	}

	public List<BulkImportModulesEntity> getAllBulkImportModules() {

		List<BulkImportModulesEntity> bulkImportModulesEntity = bulkImportModulesRepository.findAll();

		if (bulkImportModulesEntity.size() > 0) {
			return bulkImportModulesEntity;
		} else {
			return new ArrayList<BulkImportModulesEntity>();
		}
	}
	
	public List<BulkImportInfoEntity> findByModulesIdFk(long modulesIdFk) {
		List<BulkImportInfoEntity> bulkImportInfoEntity = bulkImportInfoRepository.findByModulesIdFk(modulesIdFk);

		if (bulkImportInfoEntity.size() > 0) {
			return bulkImportInfoEntity;
		} else {
			return new ArrayList<BulkImportInfoEntity>();
		}
	}
}
