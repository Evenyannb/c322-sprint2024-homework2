package edu.iu.yanlian.demo.repository;

import edu.iu.yanlian.demo.model.User;
import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class UserRepository {

    private static final String FILE_PATH = "data/customers.txt";

    public static void saveUser(User user) throws IOException {
        String data = String.format("%s,%s,%s%n", user.getUsername(), user.getPassword(), user.getEmail());

        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data);
        }
    }
    public static boolean loginUser(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
