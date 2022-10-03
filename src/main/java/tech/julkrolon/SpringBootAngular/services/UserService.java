package tech.julkrolon.SpringBootAngular.services;

import tech.julkrolon.SpringBootAngular.entities.User;
import tech.julkrolon.SpringBootAngular.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsersFromDB() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
