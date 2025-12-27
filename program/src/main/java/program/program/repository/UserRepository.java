package program.program.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import program.program.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
