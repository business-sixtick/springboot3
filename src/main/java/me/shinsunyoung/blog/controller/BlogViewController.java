package me.shinsunyoung.blog.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.blog.domain.Article;
import me.shinsunyoung.blog.dto.ArticleListViewResponse;
import me.shinsunyoung.blog.dto.ArticleViewResponse;
import me.shinsunyoung.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
//                .sorted() // Comparable 구현시
                .sorted(Comparator.comparing(ArticleListViewResponse::getId).reversed())
                .toList();

        model.addAttribute("articles", articles); // 블로그 글 리스트 저장

        return "articleList"; // articleList.html 뷰 리턴
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    // 수정 페이지
    @GetMapping("new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if (id == null){ // 없으면 생성
            model.addAttribute("article", new ArticleViewResponse());
        }else{ // 있으면 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
