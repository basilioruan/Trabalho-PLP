/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Endereco;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public interface EnderecoDAOInterface {
    
    public int insertEndereco(ArrayList<Endereco> enderecos_array, Endereco endereco) throws EnderecoDAOException;
    public boolean deleteEndereco(ArrayList<Endereco> enderecos_array, int id) throws EnderecoDAOException;
    public ArrayList<Endereco> retrieveAll () throws EnderecoDAOException;
    public Endereco retrieveByID (ArrayList<Endereco> enderecos_array, int id) throws EnderecoDAOException;
}
