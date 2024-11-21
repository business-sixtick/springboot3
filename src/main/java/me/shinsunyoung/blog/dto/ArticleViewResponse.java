package me.shinsunyoung.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.blog.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor // 기본생성자
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title; // 아 리스트 디티오에서는 final 쓰고 여기서 안쓰는게 여기서는 변경을 염두해두고 안쓰는구만 ㅋ
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
