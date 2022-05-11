public class Main
{
    public static void main(String[] args)
    {
        BankAccount b1 = new BankAccount(100.00, "abc123", "gates");
        BankAccount b2 = new BankAccount(500.00, "xyz789", "woods");

        System.out.println(b1.getBalance());
        b1.withdraw(5.00);
        System.out.println(b1.getAccountNumber());
        System.out.println(b1.getBalance());

        System.out.println("---");

        System.out.println(b2.getBalance());
        b2.deposit(23.00);
        System.out.println(b2.getLastName());
        System.out.println(b2.getBalance());

        System.out.println("---");

        b1.transfer(50.00, b2);
        System.out.println(b1.getBalance());
        System.out.println(b2.getBalance());
    }
}
