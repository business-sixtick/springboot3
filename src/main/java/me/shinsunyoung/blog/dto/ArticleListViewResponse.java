package me.shinsunyoung.blog.dto;

import lombok.Getter;
import me.shinsunyoung.blog.domain.Article;

@Getter
public class ArticleListViewResponse implements Comparable<ArticleListViewResponse>{

    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();;
        this.content = article.getContent();
    }

    @Override
    public int compareTo(ArticleListViewResponse o) {
//        return this.id.compareTo(o.getId()); // 오름차순
        return o.getId().compareTo(this.id); //
    }
}
