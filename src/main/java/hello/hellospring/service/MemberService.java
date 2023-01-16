package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    * 회원가입
    * */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 금지
        //자동으로 반환값 ctrl + alt + v
        //Optional<Member> result = memberRepository.findByName(member.getName());

        //자동으로 메서드 생성 ctrl + alt + m
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{ //null이 아니라 어떤 값이 있으면 (optional이라 가능)
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체회원조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}