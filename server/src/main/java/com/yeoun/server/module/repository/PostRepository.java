package com.yeoun.server.module.repository;

import com.yeoun.server.module.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findById(Long yeounId);

  Page<Post> findAllByCategoryId(Pageable pageable, Long categoryId);

}
