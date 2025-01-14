package edu.iu.yanlian.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "guiter")
public final class Customer {
    @Id
    private String username;
    private String password;
    private String email;

    public Customer(){

    }
    public Customer(String username,
                    String password,
                    String email) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
}