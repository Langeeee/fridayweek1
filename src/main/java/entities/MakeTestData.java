/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author Jacob
 */

public class MakeTestData  {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    
    
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try {
            BankCustomer bankCustomer1 = new BankCustomer("Jacob", "Lange", "101", 1500, 2, "good customer");
            BankCustomer bankCustomer2 = new BankCustomer("Emil", "Emilsen", "102", 25000, 3, "bad payer");
            BankCustomer bankCustomer3 = new BankCustomer("frederik", "frederiksen", "103", -5000, 5, "worst payer");
         
   
      em.getTransaction().begin();
      
      em.persist(bankCustomer1);
      em.persist(bankCustomer2);
      em.persist(bankCustomer3);
  
      em.getTransaction().commit();
     
    	
    	} finally {
        em.close();
           
    }

     }
     }



