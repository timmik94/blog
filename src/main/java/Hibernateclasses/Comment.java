package Hibernateclasses;

import javax.persistence.*;

/**
 * Created by timur on 14.06.2014.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private long id;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private long date;

    @ManyToOne
    private Record record;
    @ManyToOne
    private User user;

    public long getDate() {
        return date;
    }

    public void setDate() {
        this.date = System.currentTimeMillis();
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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String toString(){
        String s="<h5>"+user.getLogin()+"</h5>"+"<p>"+text+"</p>";
        return s;
    }
}
