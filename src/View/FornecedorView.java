/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FornecedorController;
import DAO.FornecedorDAOException;
import FileUtils.FileIO;
import Model.Fornecedor;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class FornecedorView {
    
    private final Scanner scanner;
    private static ArrayList<Fornecedor> fornecedor_array_ = new ArrayList();
    private final FornecedorController controller_fornecedor = new FornecedorController();
    
    public FornecedorView() {
        this.scanner = new Scanner(System.in);
    }
    
    public void insertion () throws Exception{
        try{
            Fornecedor aux = new Fornecedor();

            EnderecoView endereco_view = new EnderecoView();
            
            aux.setId_(fornecedor_array_.size());
            
            System.out.println("Entre com as informações do Fornecedor");
            System.out.print("CNPJ: ");
            aux.setCnpj_(scanner.nextLine());
            System.out.print("Nome fantasia: ");
            aux.setNome_fantasia(scanner.nextLine());
            aux.setId_endereco_(endereco_view.insertion());
            
            if (controller_fornecedor.insert (fornecedor_array_, aux)){
                System.out.println("Fornecedor inserido com sucesso!");
            } else {
                System.out.println("Erro na inserção do Fornecedor!");
            }
            
        } catch (Exception e){
            throw new Exception(e.getMessage() + "// Erro em Fornecedor View- insertion ");
        }
    } 
    
    public void deletion () throws Exception {
        try{
            String cnpj;
            
            System.out.print("CNPJ: ");
            
            cnpj = scanner.nextLine();   
            
            if(controller_fornecedor.delete (cnpj, fornecedor_array_)){
                System.out.println("Fornecedor deletado com sucesso!");
            } else {
                System.out.println("Erro na deleção do Fornecedor!");
            }
            
        }catch (FornecedorDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Fornecedor View - deletion");
        }
    }
    
    public void read () throws Exception {
        try{
            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            EnderecoView endereco_view = new EnderecoView();
            
            Fornecedor f = controller_fornecedor.read(fornecedor_array_, cnpj);
            
            if (f != null){
                System.out.println("Nome Fantasia: " + f.getNome_fantasia());
                System.out.println("CNPJ: " + f.getCnpj_());
                endereco_view.read(f.getId_endereco_());
            } else {
                System.out.println("CNPJ inexistente.");
            }
         } catch (FornecedorDAOException e){
             throw new Exception(e.getMessage() + " // Erro em Fornecedor View - read ");
         }
    }
    
    public void update() throws Exception{
        try{
            
            System.out.print("Digite o cpf do cliente para trocar: ");
            String cpf = scanner.nextLine();
            
            System.out.print("O que quer trocar: ");
            String op = scanner.nextLine();
            System.out.print("Digite o novo: ");
            String _new = scanner.nextLine();
 
            if(controller_fornecedor.checkCNPJ(cpf, fornecedor_array_)){
                controller_fornecedor.update(fornecedor_array_, cpf, op, _new);
            } else{
                System.out.print("CNPJ invalido!");
            }
            
        } catch (FornecedorDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Fornecedor View - update  ");    
        }
    }

    public void readAll() throws Exception{
        EnderecoView endereco_view = new EnderecoView();
        
        try {
            for (Fornecedor f : fornecedor_array_){
                System.out.println("Nome: " + f.getNome_fantasia());
                System.out.println("CNPJ " + f.getCnpj_());
                endereco_view.read(f.getId_endereco_());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Fornecedor View - readAll");
        }
    }
    
    public void save() throws Exception{
        FileIO.saveToFile(fornecedor_array_, "fornecedores");
    }
    
    public static void load() throws Exception{
        try{
            fornecedor_array_ = (ArrayList<Fornecedor>) FileIO.loadFromFile("fornecedores");
        }catch (ClassCastException e){
            System.out.println("Class cast error");
        }
    }
}
