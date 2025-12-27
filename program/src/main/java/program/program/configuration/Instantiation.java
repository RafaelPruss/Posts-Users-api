package program.program.configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import program.program.entities.Post;
import program.program.entities.User;
import program.program.entities.util.AuthorDTO;
import program.program.entities.util.CommentDTO;
import program.program.repository.PostRepository;
import program.program.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        AuthorDTO a1 = new AuthorDTO(null, "realaf", "rew");
        User u1 = new User(a1);
        repository.save(u1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Post p1 = new Post(null, sdf.parse("21/03/2011"), "generic", "body", a1);
        postRepository.save(p1);
        CommentDTO cm1 = new CommentDTO("generic", sdf.parse("12/03/2011"), a1);
        p1.getCommentDTOs().add(cm1);
        postRepository.save(p1);
    }
}