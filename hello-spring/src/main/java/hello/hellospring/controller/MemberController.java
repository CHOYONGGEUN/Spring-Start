package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

    private MemberService memberService;

//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }
//    @Autowired private MemberService memberService;

//    @Autowired
//
  public MemberController(MemberService memberService){
 this.memberService = memberService;
  }
}

//스프링 컨테이너에서 멤버 서비스를 가져 오는 것
//스프링이 'MemberService'에 필요한 'MemberRepository'를 자동으로 연결해준다.
/*MemberService는 순수한 자바 클래스로 정의되어 있으며, Sring 컨테이너가 이 클래스의 객체를
 * 자동으로 관리하기 위해서는 클래스에 '@Service' 어노테이션을 추가해야 한다.
 * 즉, 간단히 말해서 'MemberService' 클래스는 회원과 관련된 주요 작업을 처리하고,
 * 'MemberRepository'를 통해 이러한 작업에 필요한 데이터를 관리한다.
 *
 * 스프링 컨테이너는 스프링 기반의 애플리케이션에서 객체의 생성과 관리를 담당하여 애플리케이션의
 * 설정과 실행을 단순화하고, 유지 관리를 용이하게 한다.
 *
 *
 * 정리하면, 컨트롤러를 통해서 외부 요청을 받고, 그 다음에 서비스에서 비즈니스 로직을 만들고,
 * 리포지토리에서 데이터를 저장하는 것이다.*/