package me.young.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.young.springbootdeveloper.dto.ArticleListViewResponse;
import me.young.springbootdeveloper.dto.ArticleResponse;
import me.young.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String articles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                        .map(ArticleListViewResponse::new)
                        .toList();
        model.addAttribute("articles", articles);
        return "articleList";
    }
}
