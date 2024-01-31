package hello.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.springstart.domain.Member;
import spring.springstart.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemberService memberService; // = new MemberService();를 사용할 필요가 없다.
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
   @BeforeEach
   /*@BeforeEach: 이 어노테이션은 JUnit에서 제공하며, 테스트 클래스 내에 있는
   각 테스트 메소드가 실행되기 전에 매번 해당 메소드(beforeEach 여기서)를 실행하도록 지시합니다.*/
   public void beforeEach(){
       memberRepository = new MemoryMemberRepository();
       memberService = new MemberService(memberRepository);
       /*memberService 객체를 생성하고 생성자에 memberRepository를 전달함으로써
       * MemberService는 주어진 memberRepository와 연동된다.*/
   }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName(("spring")); //이름이 동일하므로 예외가 발생해야 한다.

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        * assertThrows는 이 람다 표현식이 실행될 때 발생하는 예외를 캐치하고,
        * 해당 예외가 지정된 예외 타입(IllegalAccessException.class)과 일치하는지 검증합니다*/
       /* try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        //then

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}