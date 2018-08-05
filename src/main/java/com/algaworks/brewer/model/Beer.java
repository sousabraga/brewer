package com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.brewer.validation.SKU;

@Entity
@Table(name = "beer")
public class Beer implements Serializable {

	private static final long serialVersionUID = 5860315063930019183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@SKU
	@NotBlank(message = "SKU is required")
	private String sku;
	
	@NotBlank(message = "Name is required") 
	private String name;
	
	@Size(min = 1, max = 50, message = "Description must be between 1 and 50")
	private String description;

	@NotNull(message = "Price is required")
	private BigDecimal price;
	
	@NotNull(message = "Alcohol content is required")
	@DecimalMax(value = "100.0", message = "The alcohol content must be less than 100")
	@Column(name = "alcohol_content")
	private BigDecimal alcoholContent;
	
	@NotNull(message = "Commission is required")
	@DecimalMin(value = "5.00", message = "The commission must be equal to or greater than 5")
	@DecimalMax(value = "100.0", message = "The commission must be equal to or less than 100")
	private BigDecimal commission;

	@NotNull(message = "Stock quantity is required")
	@Min(value = 10, message = "The quantity in stock must be equal to or greater than 10")
	@Max(value = 5000, message = "The quantity in stock must be less than 5000")
	@Column(name = "stock_quantity")
	private Integer stockQuantity;

	@NotNull(message = "Origin is required")
	@Enumerated(EnumType.STRING)
	private Origin origin;
	
	@NotNull(message = "Flavor is required")
	@Enumerated(EnumType.STRING)
	private Flavor flavor;
	
	@NotNull(message = "Style is required")
	@ManyToOne
	@JoinColumn(name = "style_id")
	private Style style;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(BigDecimal alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
