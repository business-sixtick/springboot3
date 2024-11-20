package me.shinsunyoung.springbootdeveloper;


import jakarta.persistence.*;
import lombok.*; // 개터 쌔터 생성자 투스트링 해시코드 등 반복적인 코드를 자동으로 생성해준다.

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity  // 엔티티로 지정 테이블과 매핑 됨
public class Member {
    @Id // 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public void changeName(String name){
        this.name = name;
    }
}
