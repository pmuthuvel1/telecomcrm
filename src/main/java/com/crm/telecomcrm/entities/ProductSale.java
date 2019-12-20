package com.crm.telecomcrm.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the product_sales database table.
 * 
 */
@Entity
@Table(name="product_sales")
@NamedQuery(name="ProductSale.findAll", query="SELECT p FROM ProductSale p")
public class ProductSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sales_id")
	private Integer salesId;

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

	private Integer quantity;

	@Column(name="total_amount")
	private BigDecimal totalAmount;

	//bi-directional many-to-one association to LoginDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private LoginDetail loginDetail;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;

	public ProductSale() {
	}

	public Integer getSalesId() {
		return this.salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LoginDetail getLoginDetail() {
		return this.loginDetail;
	}

	public void setLoginDetail(LoginDetail loginDetail) {
		this.loginDetail = loginDetail;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}