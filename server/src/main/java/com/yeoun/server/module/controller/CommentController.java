package com.yeoun.server.module.controller;

import com.yeoun.server.module.model.domain.Comment;
import com.yeoun.server.module.model.dto.comment.CommentSaveRequest;
import com.yeoun.server.module.model.dto.comment.CommentUpdateRequest;
import com.yeoun.server.module.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class CommentController {

  private final CommentService commentService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("{id}/comments")
  public void create(@PathVariable(name = "id") Long postId, @RequestBody CommentSaveRequest saveRequest) {

    log.info("[Request] comment-create");

    commentService.create(postId, saveRequest);
  }

  @GetMapping("{id}/comments")
  public Page<Comment> findAllComment(@PathVariable(name = "id") Long postId,
                             @PageableDefault(sort = "createdAt",direction = Direction.DESC)
                             Pageable pageable) {

    log.info("[Request] comment-find");

    return commentService.findAllComment(pageable);
  }

  @PutMapping("{id}/comment/{comment-id}")
  public void update(@PathVariable(name = "id") Long postId,
                     @PathVariable(name = "comment-id") Long commentId,
                     @RequestBody CommentUpdateRequest updateDto)   {

    log.info("[Request] comment-update");

    commentService.update(postId, commentId, updateDto);
  }

  @DeleteMapping("{id}/comment/{comment-id}")
  public void delete(@PathVariable(name = "id") Long postId,
                     @PathVariable(name = "comment-id") Long commentId) {

    log.info("[Request] comment-delete");

    commentService.delete(commentId);
  }
}
