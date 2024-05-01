package me.young.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.young.springbootdeveloper.domain.Article;
import me.young.springbootdeveloper.dto.AddArticleRequest;
import me.young.springbootdeveloper.dto.ArticleResponse;
import me.young.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogsService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogsService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogsService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id){
        Article article = blogsService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }
}
