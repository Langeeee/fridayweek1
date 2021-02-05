package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankFacade {

    private static BankFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
   public CustomerDTO getCustomerById(Long id) {
       EntityManager em = emf.createEntityManager();
       try {
           CustomerDTO customerDTO = new CustomerDTO(em.find(BankCustomer.class, id));
           return customerDTO;
       }finally{
           em.close();
       }
   }
   
   public List<CustomerDTO> getCustomerByName(String name) {
       EntityManager em = emf.createEntityManager();
       try {
           TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BankCustomer b WHERE b.firstName = :name",
                   BankCustomer.class).setParameter("name", name);
           List<BankCustomer> bankCustomers = query.getResultList();
           return CustomerDTO.getAllBankCustomersDTO(bankCustomers);
                  
       }finally {
           em.close();
       }
   }
   
   public BankCustomer addCustomer(BankCustomer cust){
       boolean authorized = true;
       if (authorized) {
           EntityManager em = emf.createEntityManager();
           try{
               em.getTransaction().begin();
               em.persist(cust);
               em.getTransaction().commit();
               
           } finally {
               em.close();
           }
       }
       return null;
   }

   
   public List<BankCustomer> getAllBankCustomers(){
       boolean authorized = true;
       if(authorized) {
           EntityManager em = emf.createEntityManager();
           try{
               TypedQuery<BankCustomer> query = em.createQuery("SELECT BANKCUSTOMER FROM BankCustomer bankcustomer", BankCustomer.class);
           return query.getResultList();
           }finally{
               em.close();
           }
           
       }
       return new ArrayList<>();
   }

  
}
