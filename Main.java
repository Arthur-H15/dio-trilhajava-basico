import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import contaTerminal.clientes.Clientes;





public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Clientes> bancoClientes = new ArrayList<>();
    
    


    public static void main(String[] args) {
        System.out.println("hello World");
        try {
            
            Menu();
           
            // Scanner input = new Scanner(System.in);
            // System.out.println("insira Seu Saldo:");
            // double saldo = input.nextDouble();
            // clientes cliente = new clientes("arthur  henrique ferreira silva", "001-0", "0010", saldo);
            // System.out.println("nome=" + cliente.getAgencia());
            // input.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error=>" + e);
        }
        finally{
            scanner.close();
        }

    }

    
    public static void Menu() {
       
        int escolha = -1;

        while (escolha != 0) {
            exibirMenu();

            try {
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        CriarCliente();
                        break;
                    case 2:
                        System.out.println("Você escolheu a opção 2.");
                        break;
                    case 3:
                        System.out.println("Você escolheu a opção 3.");
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpar a entrada inválida do Scanner
            }
        }

        
    }

    public static void exibirMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1 adicionar Cliente ");
        System.out.println("2. Opção 2");
        System.out.println("3. Opção 3");
        System.out.println("0. Encerrar");
        System.out.print("Escolha uma opção: ");
    }
    public static void CriarCliente() {
        try {
            
        
        // private String nome;
        // private String agencia;
        // private String numero;
        // private double saldo;
        System.out.println("Digite Nome Do Cliente:");
        String nome = scanner.next();
        System.out.println("Digite Agencia:");
        String agencia = scanner.next();
        System.out.println("Digite Numero Da Conta:");
        String conta = scanner.next();
        System.out.println("digite o saldo:");
        double saldo =scanner.nextDouble();
     Clientes cliente=   new Clientes(nome, agencia, conta, saldo);
      boolean adicionado=bancoClientes.add(cliente);
    //  String mensagem = String.format("cliente s% criado Com sucesso", cliente.getNome(), cliente.getAgencia(), cliente.getNumero(), cliente.getSaldo());
    //  System.out.println(mensagem);
     System.out.println("bancoClientes =>");
     System.out.println(bancoClientes.toArray());
    } catch (Exception e) {
        System.out.println(e);
            // TODO: handle exception
        }


    }
    
}
