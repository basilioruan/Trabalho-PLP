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
public class EnderecoDAO implements EnderecoDAOInterface{
    

    @Override
    public int insertEndereco(ArrayList<Endereco> enderecos_array_, Endereco endereco) throws EnderecoDAOException {
       try{
           enderecos_array_.add(endereco);
           int rId = enderecos_array_.indexOf(endereco);

           return rId;
       } catch (Exception e){
           throw new EnderecoDAOException(e.getMessage() + " // Erro em insertEndereco(array, endereco) ");
       }
        
    }
    
    
    @Override
    public boolean deleteEndereco(ArrayList<Endereco> enderecos_array,int id) throws EnderecoDAOException {
        try{
            Endereco E = retrieveByID(enderecos_array, id);
            if(E == null) return false;
            enderecos_array.remove(E);
           return true;
        } catch (EnderecoDAOException e){
            throw new EnderecoDAOException(e.getMessage() + " // Erro em deleteEndereco(array, id) ");
        }
    }
    
    

    @Override
    public ArrayList<Endereco> retrieveAll() throws EnderecoDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco retrieveByID(ArrayList<Endereco> enderecos_array_, int id) throws EnderecoDAOException {
        try{
            Endereco rEndereco = null;
            for(Endereco e : enderecos_array_){
                if (e.getId_() == id){
                    rEndereco = e;
                    break;
                }
            }
            
            return rEndereco;
                
        }catch (Exception e){
            throw new EnderecoDAOException(e.getMessage() + " // Erro em retrieveFornecedorByCNPJ");
        }
    }
            

    
    
}
