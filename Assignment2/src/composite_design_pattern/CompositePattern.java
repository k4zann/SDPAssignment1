package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Create an abstract class called Account
abstract class Account {
  public abstract float getBalance(); // Declare an abstract method to get the balance
}

// Create a class DepositeAccount that extends Account
class DepositeAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor for DepositeAccount
  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implement the getBalance method to return the account balance
  public float getBalance() {
    return accountBalance;
  }
}

// Create a class SavingAccount that extends Account
class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor for SavingAccount
  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implement the getBalance method to return the account balance
  public float getBalance() {
    return accountBalance;
  }
}

// Create a class CompositeAccount that extends Account
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  // Implement the getBalance method to calculate the total balance by aggregating sub-accounts
  public float getBalance() {
    totalBalance = 0;
    for (Account account : accountList) {
      totalBalance += account.getBalance();
    }
    return totalBalance;
  }

  // Method to add a sub-account to the composite account
  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  // Method to remove a sub-account from the composite account (implementation appears incorrect)
  public void removeAccount(Account acc) {
    // The code should likely remove the account from the list, not add it again.
    // accountList.remove(acc);
  }
}

// Create a public class called CompositePattern
public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    // Add accounts to the composite account
    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    // Calculate the total balance of the composite account
    float totalBalance = component.getBalance();
    System.out.println("Total Balance: " + totalBalance);
  }
}
