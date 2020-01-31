package com.ccs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ccs.entity.BulkImportModulesEntity;
import com.ccs.entity.BulkImportInfoEntity;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@Repository
public interface BulkImportModulesRepository extends JpaRepository<BulkImportModulesEntity, Long> {

	@Query("SELECT m FROM BulkImportModulesEntity m WHERE m.active=true order by m.priority")
	List<BulkImportModulesEntity> getAllBulkImportModules();

}
