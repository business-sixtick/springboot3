package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @Test
    void getAllMemberById(){
        //when
        Member member = memberRepository.findById(2L).get();
        assertThat(member.getName()).isEqualTo("B");

        member.changeName("BC"); // @Transactional 어노테이션일때 엔티티변경사항을 자동으로 업데이트한다. 해당 어노테이션은 @DataJpaTest 에 포함되어있다.
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }

    @Sql("/insert-members.sql")
    @Test
    void getAllMemberByName(){
        //when
        Member member = memberRepository.findByName("C").get(); // Optional 은 널안정성을 위해 만들었다.

        //then
        assertThat(member.getName()).isEqualTo("C");

        // ifPresent 는 널이 아니면 콜백을 실행한다.
        memberRepository.findByName("B").ifPresent(v -> {assertThat(v.getName()).isEqualTo("B");});
    }


    @Test
    void saveMember(){
        Member member = new Member(1L, "Z");

        memberRepository.save(member); // sql에서 insert 에 해당함

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("Z");
    }

    @Test
    void saveMembers(){
        List<Member> members = List.of(new Member(2L, "B"), new Member(3L, "C"));
        memberRepository.saveAll(members);
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteMemberById(){
        memberRepository.deleteById(2L);
        assertThat(memberRepository.findById(2L).isPresent()).isFalse();

        memberRepository.deleteAll();
        assertThat(memberRepository.findAll().size()).isEqualTo(0);
    }


}
















