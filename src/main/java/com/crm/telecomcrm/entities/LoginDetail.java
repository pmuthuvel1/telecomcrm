package com.crm.telecomcrm.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the login_details database table.
 * 
 */
@Entity
@Table(name="login_details")
@NamedQuery(name="LoginDetail.findAll", query="SELECT l FROM LoginDetail l")
public class LoginDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="login_id")
	private Integer loginId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="created_user_id")
	private String createdUserId;

	@Column(name="deletion_status")
	private String deletionStatus;

	private String email;

	@Column(name="last_login_date")
	private Timestamp lastLoginDate;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="modified_user_id")
	private String modifiedUserId;

	private String name;

	private String password;

	private String token;

	private String username;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="loginDetail")
	private List<ProductSale> productSales;

	public LoginDetail() {
	}

	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ProductSale> getProductSales() {
		return this.productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}

	public ProductSale addProductSale(ProductSale productSale) {
		getProductSales().add(productSale);
		productSale.setLoginDetail(this);

		return productSale;
	}

	public ProductSale removeProductSale(ProductSale productSale) {
		getProductSales().remove(productSale);
		productSale.setLoginDetail(null);

		return productSale;
	}

}