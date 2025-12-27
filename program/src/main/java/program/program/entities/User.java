package program.program.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.program.entities.util.AuthorDTO;
@NoArgsConstructor
@Getter
@Setter
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    @DBRef
    private List<Post> posts = new ArrayList<>();
    public User(AuthorDTO author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
    }
}
