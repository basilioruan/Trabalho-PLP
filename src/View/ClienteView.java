/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ClienteController;
import DAO.ClienteDAOException;
import FileUtils.FileIO;
import Model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfarr
 */
public class ClienteView {
    
    private final Scanner scanner;
    private static ArrayList<Cliente> clientes_array_ = new ArrayList();
    private final ClienteController cliente_controller_;
    private final EnderecoView endereco_view = new EnderecoView();


    public ClienteView() {
        this.scanner = new Scanner(System.in);
        cliente_controller_ = new ClienteController();
    }   
    
    public void insertion () throws Exception{
        try{
            Cliente aux = new Cliente();   
            aux.setId_(clientes_array_.size());
            
            System.out.println("Entre com as informações do Cliente");
            System.out.print("Nome: ");
            aux.setNome_(scanner.nextLine());
            System.out.print("CPF: ");
            aux.setCpf_(scanner.nextLine());
            System.out.print("Email: ");
            aux.setEmail_(scanner.nextLine());
            System.out.print("Telefone: ");
            aux.setTelefone_(scanner.nextLine());
            aux.setId_endereco_(endereco_view.insertion());
            
            if (cliente_controller_.insert(clientes_array_, aux)){
                System.out.println("Cliente inserido com sucesso!");
            } else {
                System.out.println("Falha na inserção do cliente!");
            }
            
            
        } catch (ClienteDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente View - insertion ");
        }
    }
    
    public void deletion () throws Exception {
        try{
            String cpf;
            System.out.print("Digite o CPF: ");
            cpf = scanner.nextLine();

            if(cliente_controller_.delete (clientes_array_, cpf)){
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Falha na deleção do cliente!");
            }
            
        } catch (ClienteDAOException e){
            throw new Exception (e.getMessage() + " // Erro em Cliente View - deletion");
        }
    }
    
    public void read () throws Exception {
        try{
        
            String cpf;
            System.out.print("Digite o CPF: ");
            cpf = scanner.nextLine();

            Cliente c = cliente_controller_.read(clientes_array_, cpf);

            if (c != null){
                System.out.println("Dados do cliente: ");
                System.out.println("Nome: " + c.getNome_());
                System.out.println("CPF: " + c.getCpf_());
                System.out.println("Email: " + c.getEmail_());
                System.out.println("Telefone: " + c.getTelefone_());
                
                int id_end = c.getId_endereco_();
                //System.out.println(id_end);
                endereco_view.read(id_end);
            } else {
                System.out.println("CPF inexistente.");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Cliente View - read");
        }
    }
    
    public void readAll() throws Exception {
        
        try {
        
            for (Cliente c : clientes_array_){
                System.out.println("Nome: " + c.getNome_());
                System.out.println("CPF: " + c.getCpf_());
                System.out.println("Email: " + c.getEmail_());
                System.out.println("Telefone: " + c.getTelefone_());
                endereco_view.read(c.getId_endereco_());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Cliente View - readAll");
        }
            
    }
    
    public void update () throws Exception {
        
        try{
            System.out.print("Digite o CPF do Cliente que deseja alterar: ");
            String cpf = scanner.nextLine();   
            String _new;
            if(cliente_controller_.checkCPF(clientes_array_, cpf)){
                System.out.print("Digite qual campo do Cliente deseja alterar (nome/cpf/email/telefone/endereço): ");
                String op = scanner.nextLine();
                if(!op.toLowerCase().equals("endereço")){
                    System.out.print("Digite o novo: ");
                    _new = scanner.nextLine();
                    cliente_controller_.update(clientes_array_, cpf, op, _new);
                 
                } else {
                    endereco_view.update(cliente_controller_.read(clientes_array_, cpf).getId_endereco_());
                }
            } else{
                System.out.print("CPF invalido!");
            }


        } catch (ClienteDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente View - update");
        }
    }
    
    public void save() throws Exception{
        FileIO.saveToFile(clientes_array_, "clientes");
    }
    
    public static void load() throws Exception{
        try{
            clientes_array_ = (ArrayList<Cliente>) FileIO.loadFromFile("clientes");
        }catch (ClassCastException e){
            System.out.println("Class cast error");
        }
    }
}
