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
public interface FornecedorDAOInterface {
    
    public boolean insertFornecedor (Fornecedor fornecedor) throws FornecedorDAOException;
    public boolean insertFornecedor(ArrayList<Fornecedor> array_fornecedor, Fornecedor fornecedor) throws FornecedorDAOException;
    public boolean deleteFornecedor (int id) throws FornecedorDAOException;
    
    public ArrayList<Fornecedor> retrieveAll () throws FornecedorDAOException;    
    public Fornecedor retrieveFornecedorByCNPJ(ArrayList<Fornecedor> array_fornecedor, String cnpj) throws FornecedorDAOException;

    public boolean checkCNPJ(ArrayList<Fornecedor> fornecedor_array, String cnpj);

}
