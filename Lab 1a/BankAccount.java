
/**
 * @author Robert Culver and Ruisi Tang and Lillian Vu
 * @version 1.0
 * The properties and methods for bank accounts
 */

public class BankAccount
{
    private double       balanceCdn;
    private final String accountNumber;
    private final String lastName;

    BankAccount(final double balanceCdn, final String accountNumber, final String lastName)
    {
        this.balanceCdn    = balanceCdn;
        this.accountNumber = accountNumber;
        this.lastName      = lastName;
    }

    final void withdraw(double amountWithdrawCdn)
    {
        this.balanceCdn = balanceCdn - amountWithdrawCdn;
    }

    final void deposit(final double amountDepositCdn)
    {
        this.balanceCdn = balanceCdn + amountDepositCdn;
    }

    final void transfer(double amountTransferCdn, BankAccount recipient)
    {
        this.balanceCdn = balanceCdn - amountTransferCdn;
        recipient.balanceCdn = recipient.getBalance() + amountTransferCdn;
    }

    final String getAccountNumber()
    {
        return accountNumber;
    }

    final String getLastName()
    {
        return lastName;
    }

    final double getBalance()
    {
        return balanceCdn;
    }
}
