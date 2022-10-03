package tech.julkrolon.SpringBootAngular.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.julkrolon.SpringBootAngular.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
