package tech.julkrolon.SpringBootAngular.services;

import org.springframework.stereotype.Service;
import tech.julkrolon.SpringBootAngular.entities.Users;
import tech.julkrolon.SpringBootAngular.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Users> getUsersFromDB() {
        return userRepository.findAll();
    }

    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
}
