package config;

import entities.User;
import org.springframework.boot.CommandLineRunner;
import repositories.UserRepository;

import java.util.Arrays;

public class TestConfig implements CommandLineRunner {

    UserRepository userRepo;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","maria@gmail.com", "988888888","123456");
        User u2 = new User(null,"Alex Green","alex@gmail.com", "977777777","123456");
        userRepo.saveAll(Arrays.asList(u1,u2));
    }
}
