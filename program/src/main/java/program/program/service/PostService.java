package program.program.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;

import program.program.entities.Post;
import program.program.exception.DatabaseException;
import program.program.exception.ResourceNotFound;
import program.program.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    public List<Post> findAll(){
        return repository.findAll();
    }
    public Post findById(String id){
        Optional<Post> opt = repository.findById(id);
        return opt.orElseThrow(() -> new ResourceNotFound(id));
    }
    public Post insert(Post Post){
     try {
          return repository.save(Post);
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
    public Post update(String id, Post Post){
        Post.setId(id);
        return insert(Post);
    }
      public List<Post> findByTitle(String text){
        return repository.findByTitle(text);
    }
}