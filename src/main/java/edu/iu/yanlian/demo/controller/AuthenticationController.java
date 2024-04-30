package edu.iu.yanlian.demo.controller;



import edu.iu.yanlian.demo.model.Customer;
import edu.iu.yanlian.demo.repository.CustomerFileRepository;
import edu.iu.yanlian.demo.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    CustomerFileRepository customerRepository;
    public AuthenticationController(AuthenticationManager
                                            authenticationManager,
                                    TokenService tokenService,
                                    CustomerFileRepository
                                            customerRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String passwokrdEncoded = bc.encode(customer.getPassword());
            customer.setPassword(passwokrdEncoded);
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/signin")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.getUsername()
                                , customer.getPassword()));

        return tokenService.generateToken(authentication);
    }
}