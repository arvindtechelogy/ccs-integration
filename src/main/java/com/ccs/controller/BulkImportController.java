package com.ccs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccs.service.BulkImportService;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@RestController
@RequestMapping("/bulk-import")
public class BulkImportController {

	@Autowired
	BulkImportService bulkImportService;

	@GetMapping("/download-file")
	public ResponseEntity<?> downloadfile() throws IOException {
		return ResponseEntity.ok(bulkImportService.downloadFile("FROM_URL", "TO_URL"));
	}

}
