package com.example.demo.repositories;

import com.example.demo.entites.BlogPost;
import com.example.demo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPost,Long> {

}
