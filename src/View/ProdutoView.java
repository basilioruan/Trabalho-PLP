/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ProdutoController;
import DAO.PecaDAOException;
import DAO.ServicoDAOException;
import Model.Peca;
import Model.Produto;
import Model.Servico;
import java.util.ArrayList;
import java.util.Scanner;
import FileUtils.FileIO;
import Model.Venda;

/**
 *
 * @author ruanbasilio
 */
public class ProdutoView {

   public Scanner scanner;
   private static ArrayList<Venda> array_vendas = new ArrayList();
   private static ArrayList<Servico> array_servicos = new ArrayList();
   private static ArrayList<Peca> array_pecas = new ArrayList();
   private final ProdutoController produto_controller; 

    public ProdutoView() {
        this.scanner = new Scanner(System.in);
        this.produto_controller = new ProdutoController();
        
    }
   
    public void insertion () throws Exception{
    try{
        System.out.print("Digite a categoria que deseja inserir (peça/serviço): ");
        String subclass = scanner.nextLine();
           
        Produto temp;
           
        switch (subclass.toLowerCase()) {
            case "peça":
                temp = new Peca();
                break;
            case "serviço":
                temp = new Servico();
                break;
            default:
                throw new Exception (" // Erro ao selecionar categoria do produto em Produto View - insertion");
        }
           
        boolean rFlag = false;
           
        System.out.print("Nome: ");
        temp.setNome_(scanner.nextLine());
        System.out.print("Descrição: ");
        temp.setDesc_(scanner.nextLine());
        System.out.print("Preço: ");
        temp.setPreco_(scanner.nextDouble());
        scanner.nextLine();
          
        switch (subclass.toLowerCase()){
               
            case "peça":{
                Peca peca = (Peca) temp;
                peca.setId_(array_pecas.size());
                System.out.print("Número do Fornecedor: ");
                peca.setId_fornecedor_(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Quantidade em estoque: ");
                peca.setQtd_(scanner.nextInt());
                scanner.nextLine();
                
                rFlag = produto_controller.insertion_peca(array_pecas, peca);
                break;
            }
               
            case "serviço":{
                Servico servico = (Servico) temp;
                servico.setId_(array_servicos.size());
                System.out.print("Média de duração do serviço: ");
                servico.setDuracao_(scanner.nextDouble());
                scanner.nextLine();
                
                rFlag = produto_controller.insertion_servico(array_servicos, servico);
                break;
            }
               
        }
           
        if(rFlag){
               System.out.println("Produto inserido com sucesso!");
        } else {
               System.out.println("Erro na inserção do produto.");
        }
        
       } catch (ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto View - insertion ");
       }
           
    }

    public void deletion () throws Exception{
       try{
           
           System.out.print("Digite a categoria que deseja apagar (peça/serviço): ");
           String subclass = scanner.nextLine();
           boolean rFlag = false;
           System.out.print("Digite o id do produto (listados acima): ");
           int id = scanner.nextInt();
           scanner.nextLine();
           
           switch (subclass.toLowerCase()){
               
               case "peça":{
                   rFlag = produto_controller.deletion_peca(array_pecas, id);
                   break;
               }
               
               case "serviço":{
                   rFlag = produto_controller.deletion_servico(array_pecas, id);
                   break;
               }
               
               default:
                throw new Exception (" // Erro ao selecionar categoria do produto em Produto View - deletion");
            }
           
            if(rFlag){
               System.out.println("Produto deletado com sucesso!");
           } else {
               System.out.println("Erro na deleção do produto.");
           }
            
       } catch (PecaDAOException | ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto View - deletion ");
       }
    }
    
    public void readAll(){
        
       System.out.println("======== PEÇAS ========");
       System.out.println("ID | NOME | DESCRIÇÃO | FORNECEDOR | QUANTIDADE | PREÇO");
       array_pecas.forEach((p) -> {
           System.out.println(p.toString());
       });
       
       System.out.println("======== SERVIÇOS ========");
       System.out.println("--------------------------------------");
       System.out.println("ID | NOME | DESCRIÇÃO | DURAÇÃO | PREÇO");
       array_servicos.forEach((s) -> {
           System.out.println(s.toString());
       });
    }
    
    public void read() throws Exception{
       
       try{
           System.out.print("Digite a categoria em que o produto se encontra (peça/serviço): ");
           String subclass = scanner.nextLine();
           System.out.print("Digite o nome buscado: ");
           String nome = scanner.nextLine();
           
           Produto temp;
           
            switch(subclass.toLowerCase()){
               
                case "peça": {
                   temp = produto_controller.read_peca(array_pecas, nome);
                   break;
                }
               
                case "serviço": {
                   temp  = produto_controller.read_servico(array_servicos, nome);
                   break;
                }
                
                default:
                    throw new Exception (" // Erro ao selecionar categoria do produto em Produto View - read");

            }
           
            System.out.println(temp.toString());
           
       } catch (PecaDAOException | ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto View - read  ");
       }
               
    }
    
    public void update() throws Exception{
       
       try{
           System.out.print("Digite o a opção para update (peça ou serviço): ");
           String subclass = scanner.nextLine();
           boolean rFlag = false;
           System.out.print("Digite o ID: ");
           int id = scanner.nextInt();
           scanner.nextLine();
           String op;
           
           switch (subclass.toLowerCase()){
               case "peça":{
                   System.out.print("Digite o que deseja alterar (nome/descrição/preço/fornecedor/quantidade): ");
                   op = scanner.nextLine();
                   System.out.print("Digite o novo valor: ");
                   switch (op.toLowerCase()){
                    case "nome":{
                            String update = scanner.nextLine();
                            rFlag = produto_controller.update_peca(array_pecas, id, op, update);
                            break;
                        }

                        case "descrição":{
                            String update = scanner.nextLine();
                            rFlag = produto_controller.update_peca(array_pecas, id, op, update);
                            break;
                        }

                        case "preço":{
                            double update = scanner.nextDouble();
                            scanner.nextLine();
                            rFlag = produto_controller.update_peca(array_pecas, id, op, update);
                            break;
                        }

                        case "fornecedor": {
                            int update = scanner.nextInt();
                            scanner.nextLine();
                            rFlag = produto_controller.update_peca(array_pecas, id, op, update);
                            break;
                        }
                        case "quantidade":{
                            int update = scanner.nextInt();
                            scanner.nextLine();
                            rFlag = produto_controller.update_peca(array_pecas, id, op, update);
                            break;
                        }
                        default:
                            throw new Exception (" // Erro ao selecionar categoria do update em Produto View - update peca");
                    }
                   
                   
                   break;
               }
               
               case "serviço":{
                   System.out.print("Digite o que deseja alterar (nome/descricao/preco/duracao): ");
                   op = scanner.nextLine();
                   System.out.print("Digite o novo valor: ");
                    switch (op.toLowerCase()){
                       
                       case "nome":{
                           String update = scanner.nextLine();
                           rFlag = produto_controller.update_servico(array_servicos, id, op, update);
                           break;
                       }
                       
                       case "descrição":{
                           String update = scanner.nextLine();
                           rFlag = produto_controller.update_servico(array_servicos, id, op, update);
                           break;
                       }
                       
                       case "preço":{
                           double update = scanner.nextDouble();
                           scanner.nextLine();
                           rFlag = produto_controller.update_servico(array_servicos, id, op, update);
                           break;
                       }
                       
                       case "duração":{
                           double update = scanner.nextDouble();
                           scanner.nextLine();
                           rFlag = produto_controller.update_servico(array_servicos, id, op, update);
                           break;
                       }
                       default:
                            throw new Exception (" // Erro ao selecionar categoria do update em Produto View - update servico");
                    }
                    break;
                }
               
               default:
                throw new Exception (" // Erro ao selecionar categoria do produto em Produto View - update");
            }
           
           if(rFlag){
               System.out.println("Produto alterado com sucesso!");
           } else {
               System.out.println("Erro na alteração do produto.");
           }
           
       } catch (PecaDAOException | ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto View - update ");
       }

   }
    
    public void venda() throws Exception{
        
        try{
        
            System.out.println("Digite os produtos que deseja cadastrar na venda (-1 para terminar)");

            int op;

            Venda venda = new Venda();

            venda.setId_(array_vendas.size());

            readAll();

            while (true){
                System.out.println("Digite o id (listado acima) do produto desejado: ");

                op = scanner.nextInt();
                scanner.nextLine();
                if (op == -1)
                    break;

                System.out.print("Digite a categoria que o produto se encontra (peça/serviço): ");
                String subclass = scanner.nextLine();

                Produto temp;

                int qtd = 1;



                switch (subclass.toLowerCase()) {
                    case "peça":{
                        temp = (Peca) produto_controller.returnByID_peca(array_pecas, op);
                        System.out.println("Quantas peças deseja? ");
                        qtd = scanner.nextInt();
                        
                        if (!produto_controller.update_estoque(array_pecas, op, qtd)){
                            throw new Exception (" // Produto sem estoque!");
                        }
                        scanner.nextLine();
                        break;
                    }
                    case "serviço":{
                        temp = (Servico) produto_controller.returnByID_servico(array_servicos, op);
                        break;
                    }
                    default:
                        throw new Exception (" // Erro ao selecionar categoria do produto em Produto View - venda");
                }

                if (venda.getProdutos().containsKey(temp) && subclass.toLowerCase().equals("peça")){
                    qtd =  venda.getProdutos().get(temp) + qtd;
                } 
                
                venda.putProduto(temp, qtd);

            }
            
            venda.calcTotal();
            
            array_vendas.add(venda);
        } catch (Exception e){
            throw new Exception (e.getMessage() + " // Erro em Produto View - venda");
        }
    }
    
    public void readVendas() throws Exception {
    
        
        array_vendas.forEach((Venda _item) -> {
            System.out.println("======================");
            System.out.println("Venda número: " + _item.getId_());
            _item.getProdutos().entrySet().forEach((entry) -> {
                System.out.println(entry.getKey().toString());
            });
            System.out.println("====================== Total: " + _item.getTotal_());
       });


    }
    
    public void save() throws Exception{
        FileIO.saveToFile(array_pecas, "pecas");
        FileIO.saveToFile(array_servicos, "servicos");
        FileIO.saveToFile(array_vendas, "vendas");
    }
    
     public static void load() throws Exception{
        try {
            array_vendas = (ArrayList<Venda>) FileIO.loadFromFile("vendas");
            array_servicos = (ArrayList<Servico>) FileIO.loadFromFile("servicos");
            array_pecas = (ArrayList<Peca>) FileIO.loadFromFile("pecas");
        }catch (ClassCastException e){
            System.out.println("Class cast error");
        }
    }

}
