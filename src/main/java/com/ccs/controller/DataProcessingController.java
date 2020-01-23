/**
 * 
 */
package com.ccs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccs.entity.BulkImportInfoEntity;
import com.ccs.service.DataProcessingService;
import com.ccs.utility.RecordNotFoundException;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@RestController
@RequestMapping("/DataProcessing")
public class DataProcessingController {

	@Autowired
	DataProcessingService dataProcessingService;

	@GetMapping
	public ResponseEntity<List<BulkImportInfoEntity>> getAllBulkImportInfo() {
		List<BulkImportInfoEntity> list = dataProcessingService.getAllBulkImportInfos();

		return new ResponseEntity<List<BulkImportInfoEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BulkImportInfoEntity> getBulkImportInfoById(@PathVariable("id") Long id)
			throws RecordNotFoundException {
		BulkImportInfoEntity entity = dataProcessingService.getBulkImportInfoById(id);

		return new ResponseEntity<BulkImportInfoEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BulkImportInfoEntity> createOrUpdateBulkImportInfo(BulkImportInfoEntity bulkImportInfoEntity)
			throws RecordNotFoundException {
		BulkImportInfoEntity updated = dataProcessingService.createOrUpdateBulkImportInfo(bulkImportInfoEntity);
		return new ResponseEntity<BulkImportInfoEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteBulkImportInfoEntityById(@PathVariable("id") Long id) throws RecordNotFoundException {
		dataProcessingService.deleteBulkImportInfoById(id);
		return HttpStatus.FORBIDDEN;
	}
}
