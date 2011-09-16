package br.com.faber.entity;

public class Supplier extends Person{

	private String nameComplete;
	private String nameAbbreviated;
	private String CNPJ;
	private Integer phone1;
	private Integer phone2;
	private String email;
	private String description;
	
	public Supplier(){
		super();
	}
	
	public Supplier(int id, String nameComplete, String nameAbbreviated, String CNPJ, String address, Integer phone1, Integer phone2, String email, String description){
		this.setId(id);
		this.setNameComplete(nameComplete);
		this.setNameAbbreviated(nameAbbreviated);
		this.setCNPJ(CNPJ);
		this.setAddress(address);
		this.setPhone1(phone1);
		this.setPhone2(phone2);
		this.setEmail(email);
		this.setDescription(description);
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

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public Integer getPhone1() {
		return phone1;
	}

	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}

	public Integer getPhone2() {
		return phone2;
	}

	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
