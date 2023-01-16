package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        /* optional에서 값을 바로 꺼낼 때 get() 사용 할 수 있음 */
        repository.findById(member.getId()).get();
    }
}
