public class App {
    public static void main(String[] args) throws Exception {
        Client client = new Client(1, "Maria da Silva", "1234");
        BankAccount account = new BankAccount(1, client, -500);
        System.out.println(account);
        // account.setId(2);
        // account.setClientName("João da Silva");
        // account.setBalance(1000.999);
        // System.out.println("Código: " + account.getId());
        // System.out.println("Nome do cliente: " + account.getClientName());
        // System.out.printf("Saldo: R$ %.2f\n", account.getBalance());
        // account.deposit(1000);
        // account.withdraw(500);
        
        // BankAccount account2 = new BankAccount(3, "Adriana Santos");
        // account2.deposit(300);
        // System.out.println(account2);
    }
}
