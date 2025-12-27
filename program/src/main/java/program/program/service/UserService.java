package program.program.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;

import program.program.entities.Post;
import program.program.entities.User;
import program.program.exception.DatabaseException;
import program.program.exception.ResourceNotFound;
import program.program.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(String id){
        Optional<User> opt = repository.findById(id);
        return opt.orElseThrow(() -> new ResourceNotFound(id));
    }
    public User insert(User user){
     try {
          return repository.save(user);
     } catch (MongoWriteException e) {
        throw new DatabaseException(e.getMessage());
     }
    }
    public void delete(String id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(id);
        }
    }
    public User update(String id, User user){
        user.setId(id);
        return insert(user);
    }
}