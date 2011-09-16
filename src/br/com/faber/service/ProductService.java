package br.com.faber.service;

import java.util.Vector;

import javax.swing.JOptionPane;

import br.com.faber.dao.ProdutoDao;
import br.com.faber.entity.Product;

public class ProductService {

	public void saveProduct(String nameComplete, String nameAbbreviated, String unit, String quantity, String valueCost, String valueCharged, int idSupplier, String nameSupplier, String description){
		Product produto = new Product();
		ProdutoDao produtoServise = new ProdutoDao();
		
		Integer intQuantity = Integer.parseInt(quantity);
		Double doubleValueCost = Double.parseDouble(valueCost);
		Double doubleValueCharged = Double.parseDouble(valueCharged);
		
		produto.setNameComplete(nameComplete);
		produto.setNameAbbreviated(nameAbbreviated);
		produto.setUnit(unit);
		produto.setQuantity(intQuantity);
		produto.setValueCost(doubleValueCost);
		produto.setValueCharged(doubleValueCharged);
		produto.setIdSupplier(idSupplier);
		produto.setNameSupplier(nameSupplier);
		produto.setDescription(description);
		

		produtoServise.insereProduto(produto);
	}
	
	public Vector<Product> PesquisaTodosProduto(){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Product> valor = new Vector<Product>();
		valor = produtoDao.consultaTodosProduto();
		return valor;
	}
	public Vector<Product> PesquisaUmProduto(String stgColuna, String stgValor){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Product> valores = new Vector<Product>();
		valores = produtoDao.consultaUmProduto(stgColuna, stgValor);
		return valores;
	}
	public Vector<Product> PesquisaUmProduto(int id){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Product>  produto = new Vector<Product>();
		produto = produtoDao.consultaUmProduto(id);
		return produto;
	}
	
	
	/*
	 * Metodos
	 */


	public boolean isValidateCost(String valueCost){
		try {
			Double doubleValueCost = Double.parseDouble(valueCost);
			if(doubleValueCost <= 0){
				JOptionPane.showMessageDialog(null, "Valor de Custo invalido!");
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor de custo invalido, digite apenas numeros!");
			return false;
		}
	}
	
	
	public Double CalculePercentage(String txtValueCost){
		Double valueTotal= null;
		try {
			Double doubleValueCost = Double.parseDouble(txtValueCost);
			String stgPercentage = JOptionPane.showInputDialog("Digite a porcentagem!");
			Double doublePercentage = Double.parseDouble(stgPercentage);
			valueTotal = (doubleValueCost * doublePercentage) / 100 + doubleValueCost;
//			valueTotal = String.valueOf(doubleValorTotal);
			return valueTotal;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preenxa o campo Valor De Custo!");
			return valueTotal;
		}
	}
}
