package com.ccs.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


/**
 * @author Arvind Maurya
 * @since 2020-01-24
 * @copyright 2020
 *
 */
@Entity
@Table(name = "bulk_import_info")
@NamedQueries({
	@NamedQuery(name="BulkImportInfoEntity.getAllByModules", query = "SELECT bi FROM BulkImportInfoEntity bi WHERE bi.bulkImportModulesEntity.id=:modulesIdFk")
})
public class BulkImportInfoEntity{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String fileName;

	@LastModifiedDate
	private Date uploadDate;
	
	@CreatedDate
	private Date processDate;

	private int status;
	
	private int result;

	private String remarks;
	
	private boolean active;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = BulkImportModulesEntity.class)
	@JoinColumn(name = "modules_Id_fk")
	private BulkImportModulesEntity bulkImportModulesEntity;



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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @return the processDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = true, updatable = false)
	public Date getProcessDate() {
		return processDate;
	}

	/**
	 * @param processDate the processDate to set
	 */
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

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
	 * @return the bulkImportModulesEntity
	 */
	public BulkImportModulesEntity getBulkImportModulesEntity() {
		return bulkImportModulesEntity;
	}

	/**
	 * @param bulkImportModulesEntity the bulkImportModulesEntity to set
	 */
	public void setBulkImportModulesEntity(BulkImportModulesEntity bulkImportModulesEntity) {
		this.bulkImportModulesEntity = bulkImportModulesEntity;
	}

	@Override
	public String toString() {
		return "BulkImportInfoEntity [fileName=" + fileName + ", uploadDate=" + uploadDate + ", processDate="
				+ processDate + ", status=" + status + ", result=" + result + ", remarks=" + remarks + ", active="
				+ active + ", bulkImportModulesEntity=" + bulkImportModulesEntity + "]";
	}

	/**
	 * @param fileName
	 * @param uploadDate
	 * @param processDate
	 * @param status
	 * @param result
	 * @param remarks
	 * @param active
	 * @param bulkImportModulesEntity
	 */
	public BulkImportInfoEntity(String fileName, Date uploadDate, Date processDate, int status, int result,
			String remarks, boolean active, BulkImportModulesEntity bulkImportModulesEntity) {
		super();
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.processDate = processDate;
		this.status = status;
		this.result = result;
		this.remarks = remarks;
		this.active = active;
		this.bulkImportModulesEntity = bulkImportModulesEntity;
	}

	/**
	 * 
	 */
	public BulkImportInfoEntity() {
		super();
	}


}
