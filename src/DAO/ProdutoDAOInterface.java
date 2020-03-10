/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public interface ProdutoDAOInterface {
    
    public <T> boolean insertProduto(ArrayList<T> array_generico, T produto) throws Exception;
    public <T> boolean deleteProduto(ArrayList<T> array_generico, int id) throws Exception;
    public <T> Produto retrieveByNome(ArrayList<T> array_generico, String nome) throws Exception; 
    public <T> Produto returnByID(ArrayList<T> array_generico, int id) throws Exception;
}
