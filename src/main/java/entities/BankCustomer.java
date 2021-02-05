package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "BankCustomer.deleteAllRows", query = "DELETE from BankCustomer")
public class BankCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String accountnumber;
    private double balance;
    private int cusomterRanking;
    private String internalInfo;
    
    public BankCustomer() {
    }  

    public BankCustomer(Long id, String firstName, String lastName, String accountnumber, double balance, int cusomterRanking, String internalInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.cusomterRanking = cusomterRanking;
        this.internalInfo = internalInfo;
    }

    public BankCustomer(String firstName, String lastName, String accountnumber, double balance, int cusomterRanking, String internalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.cusomterRanking = cusomterRanking;
        this.internalInfo = internalInfo;
    }

    public BankCustomer(Long id, String firstName, String accountnumber, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCusomterRanking() {
        return cusomterRanking;
    }

    public void setCusomterRanking(int cusomterRanking) {
        this.cusomterRanking = cusomterRanking;
    }

    public String getInternalInfo() {
        return internalInfo;
    }

    public void setInternalInfo(String internalInfo) {
        this.internalInfo = internalInfo;
    }

    @Override
    public String toString() {
        return "BankCustomer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", accountnumber=" + accountnumber + ", balance=" + balance + ", cusomterRanking=" + cusomterRanking + ", internalInfo=" + internalInfo + '}';
    }
    
    
    
    
    

   
}
