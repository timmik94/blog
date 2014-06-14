package Hibernateclasses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by timur on 14.06.2014.
 */
@Entity
@Table(name = "users")

public class User implements Serializable {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private long id;

    @Column(unique = true, name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany
    private Set<Record> records;

    @OneToMany
    private Set<Comment> comments;

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }




}
