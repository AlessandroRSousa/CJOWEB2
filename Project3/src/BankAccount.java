public class BankAccount {

    // declaração de atributos / variáveis de instância
    private int id;
    private Client client;
    private double balance;

    // métodos construtores
    public BankAccount(int id, Client client, double balance){
        this.id = id;
        this.client = client;
        setBalance(balance);
    }

    public BankAccount(int id, Client client){
        this(id, client, 0);
    }

    // métodos acessadores
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Client getClient(){
        return client;
    }

    public void setBalance(double balance){
        if(balance >= 0){
            this.balance = balance;
        }
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
    }

    public String toString(){
        return 
            "Dados da conta:" + 
            "\nCódigo da conta: " + id +
            "\n" + client +
            "\nSaldo: R$ " + balance;
    }
}
