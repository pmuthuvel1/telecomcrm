package com.crm.telecomcrm.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the config_master database table.
 * 
 */
@Entity
@Table(name="config_master")
@NamedQuery(name="ConfigMaster.findAll", query="SELECT c FROM ConfigMaster c")
public class ConfigMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="config_master_id")
	private Integer configMasterId;

	@Column(name="config_desc")
	private String configDesc;

	@Column(name="config_name")
	private String configName;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="created_user_id")
	private String createdUserId;

	@Column(name="deletion_status")
	private String deletionStatus;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="modified_user_id")
	private String modifiedUserId;

	//bi-directional many-to-one association to ConfigDetail
	@OneToMany(mappedBy="configMaster")
	private List<ConfigDetail> configDetails;

	public ConfigMaster() {
	}

	public Integer getConfigMasterId() {
		return this.configMasterId;
	}

	public void setConfigMasterId(Integer configMasterId) {
		this.configMasterId = configMasterId;
	}

	public String getConfigDesc() {
		return this.configDesc;
	}

	public void setConfigDesc(String configDesc) {
		this.configDesc = configDesc;
	}

	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
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

	public List<ConfigDetail> getConfigDetails() {
		return this.configDetails;
	}

	public void setConfigDetails(List<ConfigDetail> configDetails) {
		this.configDetails = configDetails;
	}

	public ConfigDetail addConfigDetail(ConfigDetail configDetail) {
		getConfigDetails().add(configDetail);
		configDetail.setConfigMaster(this);

		return configDetail;
	}

	public ConfigDetail removeConfigDetail(ConfigDetail configDetail) {
		getConfigDetails().remove(configDetail);
		configDetail.setConfigMaster(null);

		return configDetail;
	}

}