package br.com.faber.service;

import java.util.Vector;

import br.com.faber.dao.SupplierDao;
import br.com.faber.entity.Supplier;

public class SupplierService {

	public void saveSupplier(String nameComplete, String nameAbbreviated, String CNPJ, String address, String phone1, String phone2, String email, String description){
		Supplier fornecedor = new Supplier();
		SupplierDao fornecedorDao = new SupplierDao();
		Integer intTel1 = Integer.parseInt(phone1);
		Integer intTel2 = Integer.parseInt(phone2);

		fornecedor.setNameComplete(nameComplete);
		fornecedor.setNameAbbreviated(nameAbbreviated);
		fornecedor.setCNPJ(CNPJ);
		fornecedor.setAddress(address);
		fornecedor.setPhone1(intTel1);
		fornecedor.setPhone2(intTel2);
		fornecedor.setEmail(email);
		fornecedor.setDescription(description);

		fornecedorDao.insereFornecedor(fornecedor);
	}

	public Vector<Supplier> doSearchAllSupplier(){
		SupplierDao fornecedorDao = new SupplierDao();
		Vector<Supplier> valor = new Vector<Supplier>();
		valor = fornecedorDao.consultaTodosFornecedores();
		return valor;
	}

	public Vector<Supplier> doSearchSupplierByName(String stgColuna, String stgValor){
		SupplierDao fornecedorDao = new SupplierDao();
		Vector<Supplier> fornecedor = new Vector<Supplier>();
		fornecedor = fornecedorDao.doConsultSupplierByName(stgColuna, stgValor);
		return fornecedor;
	}

	public Vector<Supplier> doSearchSupplierById(int id){
		SupplierDao fornecedorDao = new SupplierDao();
		Vector<Supplier> fornecedor = new Vector<Supplier>();
		fornecedor = fornecedorDao.consultaUmFornecedor(id);
		return fornecedor;
	}

	/*
	 * Metodos
	 */

	public boolean isValidatesPhone(String telefone){
		try {
			if((telefone.length() < 8 || telefone.length() > 8)){
				return false;
			}else{
				Integer intTelefone = Integer.parseInt(telefone);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	//14.638.052/0001-00   43.288.344/0001-15   67.127.541/0001-56   23.215.483/0001-47
	public static boolean isValidatesCNPJ(String cnpj) {  
		if (!cnpj.substring(0, 1).equals("")) { 
			try {  
				cnpj = cnpj.replace('.', ' '); 
				cnpj = cnpj.replace('/', ' ');
				cnpj = cnpj.replace('-', ' '); 
				cnpj = cnpj.replaceAll(" ", ""); 
				int soma = 0, dig;  
				String cnpj_calc = cnpj.substring(0, 12);  

				if (cnpj.length() != 14) {  
					return false;  
				}  
				char[] chr_cnpj = cnpj.toCharArray();  

				for (int i = 0; i < 4; i++) {  
					if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
						soma += (chr_cnpj[i] - 48) * (6 - (i + 1));  
					}  
				}  
				for (int i = 0; i < 8; i++) {  
					if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {  
						soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));  
					}  
				}  
				dig = 11 - (soma % 11);  
				cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(  
						dig);  

				soma = 0;  
				for (int i = 0; i < 5; i++) {  
					if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
						soma += (chr_cnpj[i] - 48) * (7 - (i + 1));  
					}  
				}  
				for (int i = 0; i < 8; i++) {  
					if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {  
						soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));  
					}  
				}  
				dig = 11 - (soma % 11);  
				cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(  
						dig);  
				return cnpj.equals(cnpj_calc);  
			}  
			catch (Exception e) {  
				return false;  
			}  
		}  
		else {  
			return false;  
		} 
	}

}
