package me.shinsunyoung.blog.repository;

import me.shinsunyoung.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    // Long 타입의 PK를 갖는 Article 매핑 테이블
}
