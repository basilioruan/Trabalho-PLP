/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Peca;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public interface PecaDAOInterface {
    
    public <T> boolean updatePeca(ArrayList<Peca> array_generico, int id, String op, T update) throws Exception;
    public boolean updateEstoque (ArrayList<Peca> array_peca, int id, int venda) throws Exception;
    
}
