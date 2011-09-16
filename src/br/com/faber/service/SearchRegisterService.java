package br.com.faber.service;

import br.com.faber.entity.Supplier;

public class SearchRegisterService {

	public void controler(String selectLIst, String option, String id, String name, String address ){
		Integer selectList = Integer.parseInt(selectLIst);
		Integer opt = Integer.parseInt(option);
		SupplierService supplierS = new SupplierService();
		
		switch (selectList) {
		case 1:
			System.out.println("Opção Cliente!");
			break;
		case 2:
			
			
			break;
		case 3:
			System.out.println("Opção Funcionário");
			break;
		}
	}

	/*all 1; id 2; name 3; address 4*/
	public Object checkOption(String optStg, String id, String name, String address){
		Integer opt = Integer.parseInt(optStg);
		
		switch (opt) {
		case 1:
			//all	
			break;
		case 2:
			// id
			break;
		case 3:
			// name
			break;
		case 4:
			//addres
			break;
		}
		return false;
	}

	public boolean isCampValidates(String value){
		if( !(value.trim().equalsIgnoreCase("") || value == null) ){
			return true;
		}else{
			return false;
		}
	}




}
