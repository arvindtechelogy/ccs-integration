/**
 * 
 */
package com.ccs.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */

@Entity
@Table(name = "bulk_import_info")
@NamedQueries({
	@NamedQuery(name="BulkImportInfoEntity.getAllByModules", query = "SELECT bi FROM BulkImportInfoEntity bi WHERE bi.bulkImportModulesEntity.id=:modulesIdFk")
})
public class BulkImportInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "upload_date")
	private Date uploadDate;

	@Column(name = "process_date")
	private Date processDate;

	@Column(name = "status")
	private int status;

	@Column(name = "result")
	private int result;

	@Column(name = "remarks")
	private String remarks;

	@OneToOne
	@JoinColumn(name = "modules_Id_fk")
	private BulkImportModulesEntity bulkImportModulesEntity;

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
		return "BulkImportInfoEntity [id=" + id + ", fileName=" + fileName + ", uploadDate=" + uploadDate
				+ ", processDate=" + processDate + ", status=" + status + ", result=" + result + ", remarks=" + remarks
				+ ", bulkImportModulesEntity=" + bulkImportModulesEntity + "]";
	}

	
}
