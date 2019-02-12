package microservices.book.socialmultiplication.multiplication.repository;

import microservices.book.socialmultiplication.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.multiplication.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt,Long> {

    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);

    List<MultiplicationResultAttempt> findAll();

    List<MultiplicationResultAttempt> findByUser(User user);

}
