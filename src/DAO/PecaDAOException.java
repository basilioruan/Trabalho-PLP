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
public class PecaDAOException extends Exception {
    
    PecaDAOException(){
        super();
    }
    
    PecaDAOException(String message){
        super("Erro em PECA: " + message);
    }
}
