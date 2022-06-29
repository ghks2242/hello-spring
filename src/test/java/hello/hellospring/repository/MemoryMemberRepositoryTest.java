package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRespository respostiory = new MemoryMemberRespository();

    @AfterEach
    public void afterEach() {
        respostiory.clearStroe();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        respostiory.save(member);
        Member result = respostiory.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        respostiory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respostiory.save(member2);

        Member result = respostiory.findByName("spring1").get();
//        Assertions.assertEquals(member1, result);
        assertThat(member1).isEqualTo(result);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        respostiory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respostiory.save(member2);

        List<Member> result = respostiory.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
