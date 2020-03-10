/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author alfarr
 */
public class ServicoDAOException extends Exception {
    
    ServicoDAOException(){
        super();
    }
    
    ServicoDAOException(String message){
        super("Erro em SERVICO: " + message);
    }
}
