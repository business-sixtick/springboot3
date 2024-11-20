package me.shinsunyoung.blog.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.blog.domain.Article;
import me.shinsunyoung.blog.dto.AddArticleRequest;
import me.shinsunyoung.blog.dto.UpdateArticleRequest;
import me.shinsunyoung.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final 이나 @NotNull 이 붙은 필드를 인자로 받는 생성자 생성.
@Service // 빈으로 등록됨
public class BlogService {
    private final BlogRepository blogRepository; // 빈으로 등록 되어서 자동으로 주입됨?

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional  //트랜젝션 메서드 . 조회 업데이트 를 묶음 처리함
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
