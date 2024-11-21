package me.shinsunyoung.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


//@EntityListeners(AuditingEntityListener.class) // 엔티티 변경 시간 체크
@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 프로텍티드 기본 생성자
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder // 빌더 패턴으로 객체 생성??
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true; // 계정이 만료되지 않았음
    }

    @Override
    public boolean isAccountNonLocked(){
        return true; //  계정이 잠기지 않았음
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true; // 패스워드 만료되지 않았음
    }

    @Override
    public boolean isEnabled(){
        return true; // 계정 사용 가능
    }
//
//    @CreatedDate // 엔티티 생성 시간 저장
//    @Column(name="created_at")
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate // 엔티티 수정 시간 저장
//    @Column(name="updated_at")
//    private LocalDateTime updatedAt;
//
//
//
//    public void update(String title, String content){
//        this.title = title;
//        this.content = content;
//    }
//
//    @Override
//    public int compareTo(Article o) {
//        return this.id.compareTo(o.getId());
//    }
}
