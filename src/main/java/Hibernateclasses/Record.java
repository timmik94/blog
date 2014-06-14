package Hibernateclasses;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by timur on 14.06.2014.
 */
@Entity
@Table(name = "Records")
public class Record {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private long id;
    @Column(name = "date")
    private long date;
    @Column
    private String title;
    @Column
    private String text;
    @ManyToOne
    private User user;
    @OneToMany
    private Set<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate() {
        this.date =System.currentTimeMillis();
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
