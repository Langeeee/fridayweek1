/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob
 */
public class CustomerDTO {
    private long customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bankCustomer) {
        this.customerID = bankCustomer.getId();
        this.fullName = String.format(bankCustomer.getFirstName(), bankCustomer.getLastName());
        this.accountNumber = bankCustomer.getAccountnumber();
        this.balance = bankCustomer.getBalance();
    }
    
    
  public static List<CustomerDTO> getAllBankCustomersDTO(List<BankCustomer> bankCustomers) {
      List<CustomerDTO> tmp = new ArrayList<>();
      for(BankCustomer bc : bankCustomers) {
          tmp.add(new CustomerDTO(bc));
      }
      return tmp;
  }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "customerID=" + customerID + ", fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
  
  
}
