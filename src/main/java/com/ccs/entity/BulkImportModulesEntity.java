/**
 * 
 */
package com.ccs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@Entity
@Table(name = "modules_type")
public class BulkImportModulesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "module_name")
	private String moduleName;

	@Column(name = "structure")
	private String structure;

	@Column(name = "module_data_type")
	private int moduleDataType;

	@Column(name = "priority")
	private int priority;

	@Column(name = "status")
	private boolean status;

	/**
	 * @return the id
	 */
	public long getId() {
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

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BulkImportModulesEntity [id=" + id + ", moduleName=" + moduleName + ", structure=" + structure
				+ ", moduleDataType=" + moduleDataType + ", priority=" + priority + ", status=" + status + "]";
	}
	
	
}
