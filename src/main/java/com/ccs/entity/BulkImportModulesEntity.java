package com.ccs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "modules_type")
@NamedQueries({
	@NamedQuery(name="BulkImportModulesEntity.getAllBulkImportModules", query = "SELECT m FROM BulkImportModulesEntity m WHERE m.status=true order by m.priority")
})
public class BulkImportModulesEntity extends AbstractPersistable<Long> implements Serializable {

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

	@Column(name = "status")
	private boolean status;

	
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
	public BulkImportModulesEntity(String moduleName, String moduleURLName, String structure, int moduleDataType,
			int priority, boolean status) {
		super();
		this.moduleName = moduleName;
		this.moduleURLName = moduleURLName;
		this.structure = structure;
		this.moduleDataType = moduleDataType;
		this.priority = priority;
		this.status = status;
	}


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
