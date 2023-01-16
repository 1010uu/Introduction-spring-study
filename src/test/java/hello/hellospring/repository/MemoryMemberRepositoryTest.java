package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    
    @AfterEach //테스트 동작이 끝날 때마다 호출
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        /* optional에서 값을 바로 꺼낼 때 get() 사용 할 수 있음 */
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result =" + (result == member));
        //기대한 것, 실제 값
//        org.junit.jupiter.api.Assertions.assertEquals(member, result);

        //org.assertj.core.api.Assertions 가독성이 좋다
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    /*
    * 순서에 의존 x , 원하는 순서대로 실행되지 않음. 따라서 테스트가 끝나고 나면 데이터 clear가 필요하다.
    * */

}
