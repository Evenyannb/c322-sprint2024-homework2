package edu.iu.yanlian.demo.repository;



import edu.iu.yanlian.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByUsername(String username);

}