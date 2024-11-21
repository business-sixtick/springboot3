package me.shinsunyoung.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA 엔티티에서 @CreatedDate, @LastModifiedDate, @CreatedBy, @LastModifiedBy와 같은 어노테이션을 활용해 자동으로 날짜나 사용자를 설정할 수 있습니다.
@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) { // 부트 앱 진입점
        SpringApplication.run(BlogApplication.class, args);
    }
}
