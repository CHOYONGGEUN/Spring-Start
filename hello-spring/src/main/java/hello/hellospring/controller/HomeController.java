package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    /*
    // = @RequestMapping(method = RequestMethod.GET),
    메스드가 HTTP GET 요청을 처리한다는 것을 쉽게 식별할 수 있음
    (코드의 가독성과 유지보수성이 향상)
    여기서 GET은 주로 데이터를 읽거나 검색할 떄 사용
    * */
    public String home(){
        return "home";
        //홈페이지를 보여주기 위한 뷰의 이름을 반환
    }

}
