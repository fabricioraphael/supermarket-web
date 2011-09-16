package br.com.faber.entity;

public class Product {

	private int id;
	private String nameComplete;
	private String nameAbbreviated;
	private String unit;
	private Integer quantity;
	private Double ValueCost;
	private Double valueCharged;
	private int idSupplier;
	private String nameSupplier;
	private String description;
	
	public Product(){
		super();
	}
	
	public Product(int id, String nameComplete, String nameAbreviated, String unit,Integer quantity, Double valueCost, Double valueCharged, int idSupplier, String nameSupplier, String description){
		this.setId(id);
		this.setNameComplete(nameComplete);
		this.setNameAbbreviated(nameAbreviated);
		this.setUnit(unit);
		this.setQuantity(quantity);
		this.setValueCost(valueCost);
		this.setValueCharged(valueCharged);
		this.setIdSupplier(idSupplier);
		this.setNameSupplier(nameSupplier);
		this.setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}

	public String getNameAbbreviated() {
		return nameAbbreviated;
	}

	public void setNameAbbreviated(String nameAbbreviated) {
		this.nameAbbreviated = nameAbbreviated;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValueCost() {
		return ValueCost;
	}

	public void setValueCost(Double valueCost) {
		ValueCost = valueCost;
	}

	public Double getValueCharged() {
		return valueCharged;
	}

	public void setValueCharged(Double valueCharged) {
		this.valueCharged = valueCharged;
	}

	public int getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
