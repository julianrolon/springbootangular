package tech.julkrolon.SpringBootAngular.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.julkrolon.SpringBootAngular.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
}
