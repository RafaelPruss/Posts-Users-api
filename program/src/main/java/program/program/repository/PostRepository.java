package program.program.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import program.program.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    public List<Post> findByTitle(String text);
}
