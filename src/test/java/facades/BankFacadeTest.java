package facades;

import dto.CustomerDTO;
import utils.EMF_Creator;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class BankFacadeTest {

    private static EntityManagerFactory emf;
    private static BankFacade facade;

    public BankFacadeTest() {}

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = BankFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        
         BankCustomer bankCust1 = new BankCustomer("Jacobtest", "Lange", "101", 1500, 2, "good customer");
         BankCustomer bankCust2 = new BankCustomer("Emiltest", "Emilsen", "102", 25000, 3, "bad payer");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("BankCustomer.deleteAllRows").executeUpdate();
            em.persist(bankCust1);
            em.persist(bankCust2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testGetCustomerById(){
        CustomerDTO cust = facade.getCustomerById(1l);
        
        assertEquals(1, cust.getCustomerID(), "id should be 1");
        
    }
    @Test
    public void testGetCustomerByName(){
        CustomerDTO cust = facade.getCustomerByName("Jacobtest").get(0);
        assertEquals("Jacobtest", cust.getFullName(), "expecting 'Jacobtest' in db");
    }
    
    @Test
    public void testAddCustomer(){
        EntityManager em = emf.createEntityManager();
         BankCustomer testCustomer = new BankCustomer("testt", "tester", "1010", 1501, 11, "good tester");
        
         facade.addCustomer(testCustomer);
         assertEquals(3, facade.getAllBankCustomers().size(), "hopefully 3 rows in db");
    }
  
    @Test
    public void testGetAllCustomers(){
        assertEquals(2,facade.getAllBankCustomers().size(), "expect 2 rows in db");
     
    
    }
    }


