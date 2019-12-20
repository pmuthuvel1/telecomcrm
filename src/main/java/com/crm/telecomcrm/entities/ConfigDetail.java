package com.crm.telecomcrm.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the config_details database table.
 * 
 */
@Entity
@Table(name="config_details")
@NamedQuery(name="ConfigDetail.findAll", query="SELECT c FROM ConfigDetail c")
public class ConfigDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="config_details_id")
	private Integer configDetailsId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="created_user_id")
	private String createdUserId;

	@Column(name="deletion_status")
	private String deletionStatus;

	private String key;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="modified_user_id")
	private String modifiedUserId;

	private String value;

	//bi-directional many-to-one association to ConfigMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="config_master_id")
	private ConfigMaster configMaster;

	public ConfigDetail() {
	}

	public Integer getConfigDetailsId() {
		return this.configDetailsId;
	}

	public void setConfigDetailsId(Integer configDetailsId) {
		this.configDetailsId = configDetailsId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getDeletionStatus() {
		return this.deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedUserId() {
		return this.modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConfigMaster getConfigMaster() {
		return this.configMaster;
	}

	public void setConfigMaster(ConfigMaster configMaster) {
		this.configMaster = configMaster;
	}

}