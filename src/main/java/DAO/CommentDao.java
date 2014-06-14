package DAO;

import Hibernateclasses.Comment;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public interface CommentDao {
    public List<Comment> getbyrecord(long id);
    public void incertcomment(Comment comment);
}
