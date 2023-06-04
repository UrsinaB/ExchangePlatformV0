package ch.fhnw.crm.crmwebservice.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.crm.crmwebservice.data.domain.Comment;

@Repository
public interface  CommentRepository extends JpaRepository<Comment, Long> {



  //find a comment by its id
    Comment findByCommentId(int commentId);

    //delete a comment by its id
    void deleteByCommentId(int commentId);

    //find all comments
    List<Comment> findAll();

  
   
    


    
}
