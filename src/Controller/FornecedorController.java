/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FornecedorDAO;
import DAO.FornecedorDAOException;
import Model.Fornecedor;
import View.EnderecoView;
import java.util.ArrayList;
/**
 *
 * @author Picolino
 */
public class FornecedorController {
    
    public boolean insert (ArrayList<Fornecedor> fornecedor_array_, Fornecedor fornecedor) throws Exception{
        try{
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            
            return fornecedor_dao.insertFornecedor(fornecedor_array_, fornecedor);
            
        } catch (FornecedorDAOException e){
            throw new Exception(e.getMessage() + "// Erro em Fornecedor Controller- insertion ");
        }
    } 
    
    public boolean delete (String cnpj, ArrayList<Fornecedor> fornecedor_array_) throws Exception {
        try{
            FornecedorDAO fornecedorDAO = new FornecedorDAO();   
            
            Fornecedor f = fornecedorDAO.retrieveFornecedorByCNPJ(fornecedor_array_, cnpj);
            
            return fornecedorDAO.deleteFornecedor(f.getId_());
            
        }catch (FornecedorDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Fornecedor Controller - deletion");
        }
    }
    
    public Fornecedor read (ArrayList<Fornecedor> fornecedor_array_, String cnpj) throws Exception {
        try{
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            
            return fornecedorDAO.retrieveFornecedorByCNPJ(fornecedor_array_, cnpj);
            
         } catch (FornecedorDAOException e){
             throw new Exception(e.getMessage() + " // Erro em Cliente Controller - display ");
         }
    }
    
    public void update (ArrayList<Fornecedor> fornecedor_array_, String cpf, String op, String _new) throws Exception{
        try{
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            Fornecedor f = fornecedor_dao.retrieveFornecedorByCNPJ(fornecedor_array_, cpf);
            
            fornecedor_array_.remove(f);
            
            switch (op.toLowerCase()){
                case "cnpj":{
                    f.setCnpj_(_new);
                    break;
                }
                
                case "nome":{
                    f.setNome_fantasia(_new);
                    break;
                }
                
                case "endereço":{
                    EnderecoView endereco_view = new EnderecoView();
                    endereco_view.update(f.getId_endereco_());
                    break;
                }
                        
            }
            
            fornecedor_array_.add(f);
            
            
        } catch (FornecedorDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente Controller - update  ");    
        }
    }
    
    public boolean checkCNPJ(String cnpj, ArrayList<Fornecedor> fornecedor_array_) throws Exception{
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            return fornecedor_dao.checkCNPJ(fornecedor_array_, cnpj);
    }

}