package microservices.book.socialmultiplication.multiplication.repository;

import microservices.book.socialmultiplication.multiplication.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAlias(String alias);

}
