/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class FornecedorDAO implements FornecedorDAOInterface{
    
    @Override
    public boolean insertFornecedor(Fornecedor fornecedor) throws FornecedorDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insertFornecedor(ArrayList<Fornecedor> fornecedor_array, Fornecedor fornecedor) throws FornecedorDAOException {
       try{
           if (!checkCNPJ(fornecedor_array, fornecedor.getCnpj_()))
               return fornecedor_array.add(fornecedor);
           else{
               System.out.println("CNPJ repetido!");
               return false;
           }
       } catch (Exception e){
           throw new FornecedorDAOException(e.getMessage() + " // Erro em insertFornecedor(array,fornecedor) ");
       }
    }
    @Override
    public boolean deleteFornecedor(int id) throws FornecedorDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public ArrayList<Fornecedor> retrieveAll() throws FornecedorDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Fornecedor retrieveFornecedorByCNPJ(ArrayList<Fornecedor> fornecedor_array, String cnpj) throws FornecedorDAOException {
        try{
            Fornecedor rFornecedor = null;
            
            for(Fornecedor f : fornecedor_array){
                if (f.getCnpj_().equals(cnpj)){
                    rFornecedor = f;
                    break;
                }
            }
            
            return rFornecedor;
                
        }catch (Exception e){
            throw new FornecedorDAOException(e.getMessage() + " // Erro em retrieveFornecedorByCNPJ");
        }
    }
    
    @Override
    public boolean checkCNPJ(ArrayList<Fornecedor> fornecedor_array, String cnpj){
        boolean rFlag = false;
        for(Fornecedor f : fornecedor_array){
            if (f.getCnpj_().equals(cnpj)){
                rFlag = true;
                break;
            }
        }
        return rFlag;
    }
    
}
