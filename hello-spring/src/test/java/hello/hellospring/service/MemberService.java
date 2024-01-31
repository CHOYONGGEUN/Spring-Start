package hello.hellospring.service;

import spring.springstart.domain.Member;
import spring.springstart.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // Ctrl + Shift + T 를 누르면 자동으로 @Test가 만들어진다.


    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //new를 생성하는 것이 아니라 외부에서 생성하는 것임
    /*
    *  회원가입 */


    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
       memberRepository.findByName(member.getName())
                .ifPresent (m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });


        memberRepository.save(member);
        return member.getId();//id를 반환
    }
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){ //단일 객체를 찾기 위한 메서드
        return memberRepository.findById(memberId);
    }
}
