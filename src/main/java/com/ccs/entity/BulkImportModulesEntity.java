package com.ccs.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Entity
@Table(name = "modules_type")
@NamedQueries({
	@NamedQuery(name="BulkImportModulesEntity.getAllBulkImportModules", query = "SELECT m FROM BulkImportModulesEntity m WHERE m.active=true order by m.priority")
})
public class BulkImportModulesEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "module_name")
	private String moduleName;
	
	@Column(name="module_url_name")
	private String moduleURLName;

	@Column(name = "structure")
	private String structure;

	@Column(name = "module_data_type")
	private int moduleDataType;

	@Column(name = "priority")
	private int priority;

	@Column(name = "active")
	private boolean active;
	
	@CreatedDate
	private Calendar creationDate;
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return the creationDate
	 */
	public Calendar getCreationDate() {
		return creationDate;
	}


	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}


	public BulkImportModulesEntity() {
		super();
	}


	/**
	 * @param moduleName
	 * @param moduleURLName
	 * @param structure
	 * @param moduleDataType
	 * @param priority
	 * @param status
	 */



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleURLName
	 */
	public String getModuleURLName() {
		return moduleURLName;
	}

	/**
	 * @param moduleURLName the moduleURLName to set
	 */
	public void setModuleURLName(String moduleURLName) {
		this.moduleURLName = moduleURLName;
	}

	/**
	 * @return the structure
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * @param structure the structure to set
	 */
	public void setStructure(String structure) {
		this.structure = structure;
	}

	/**
	 * @return the moduleDataType
	 */
	public int getModuleDataType() {
		return moduleDataType;
	}

	/**
	 * @param moduleDataType the moduleDataType to set
	 */
	public void setModuleDataType(int moduleDataType) {
		this.moduleDataType = moduleDataType;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
 
}
