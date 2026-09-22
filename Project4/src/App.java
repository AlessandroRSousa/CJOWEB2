import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static PeopleManager manager = new PeopleManager();

    public static int menu(){
        System.out.println("----------------------------------");
        System.out.println("--Sistema de Controle de Pessoas--");
        System.out.println("----------------------------------");
        System.out.println("---------MENU DE OPÇÕES-----------");
        System.out.println("----------------------------------");
        System.out.println("1 - Inserir");
        System.out.println("2 - Buscar pelo CPF");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.println("5 - Sair");
        System.out.println("----------------------------------");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static void insert(){
        System.out.println("Digite o nome:");
        String name = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        Person person = new Person(name, cpf);
        if(manager.save(person)){
            System.out.println("Pessoa inserida com sucesso!");
        }else{
            System.out.println("Erro ao inserir a pessoa!");
        }
    }

    private static void search() {
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        Person person = manager.search(cpf);
        if(person != null){
            System.out.println("Pessoa encontrada. Dados da pessoa:");
            System.out.println(person);
        }else{
            System.out.println("Pessoa não encontrada.");
        }
    }

    public static void update(){
        System.out.println("Digite o nome:");
        String name = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        if(manager.update(name, cpf)){
            System.out.println("Dados atualizados com sucesso!");
        }else{
            System.out.println("Erro ao atualizar os dados.");
        }
    }

    public static void delete(){
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        if(manager.delete(cpf)){
            System.out.println("Pessoa removida com sucesso!");
        }else{
            System.out.println("Erro ao remover a pessoa.");
        }
    }

    public static void main(String[] args) throws Exception {
        int option;

        do{
            option = menu();
            scanner.nextLine();
            switch (option) {
                case 1:
                    insert();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();
        } while (option != 5);
    }

}
