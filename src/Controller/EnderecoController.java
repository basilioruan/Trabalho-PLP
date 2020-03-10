/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EnderecoDAO;
import DAO.EnderecoDAOException;
import Model.Endereco;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfarr
 */
public class EnderecoController {
    
    private final Scanner scanner;
    private final EnderecoDAO endereco_dao;
    
    public EnderecoController() {
        this.scanner = new Scanner(System.in);
        this.endereco_dao = new EnderecoDAO();
    }
    
     
    public int insert (ArrayList<Endereco> enderecos_array_, Endereco endereco) throws Exception {
        try{
            return endereco_dao.insertEndereco(enderecos_array_, endereco);
            
        } catch (EnderecoDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Endereço Controller - insertion ");
        }
            
    }
    
    public boolean delete (ArrayList<Endereco> enderecos_array_, int id) throws Exception {
        try{
            return endereco_dao.deleteEndereco(enderecos_array_, id);
        } catch (EnderecoDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Endereço Controller - deletion ");
        }
    }
    
    public Endereco read (ArrayList<Endereco> enderecos_array_, int id) throws Exception{
        try{
            return endereco_dao.retrieveByID(enderecos_array_, id);
        } catch (EnderecoDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Endereço Controller - read ");
        }
        
    }
   
    public boolean update (ArrayList<Endereco> enderecos_array_, int id, String[] vetor) throws Exception{
        try{
            Endereco aux = endereco_dao.retrieveByID(enderecos_array_, id);
            if (aux == null) return false;

            enderecos_array_.remove(aux);
            
            aux.setCep_(vetor[0]);
            aux.setRua_(vetor[1]);
            aux.setNumero_(vetor[2]);
            aux.setBairro_(vetor[3]);
            aux.setCidade_(vetor[4]);
            aux.setEstado_(vetor[5]);
            
            enderecos_array_.add(aux);
            
            return true;
            
        } catch (EnderecoDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Endereço Controller - update (id)  ");  
        }
    }
    
}
