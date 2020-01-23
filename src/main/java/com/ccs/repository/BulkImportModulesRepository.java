/**
 * 
 */
package com.ccs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccs.entity.BulkImportModulesEntity;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@Repository
public interface BulkImportModulesRepository extends JpaRepository<BulkImportModulesEntity, Long> {

}
