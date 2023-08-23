package weather.weatherback.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import weather.weatherback.domain.Member;
import weather.weatherback.domain.MemberInput;
import weather.weatherback.repository.MemberRepository;
import weather.weatherback.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;

//@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 메인 화면
    @GetMapping("/")
    public String root() {
        return "home";
    }

    // 회원 가입 - GET
    @GetMapping("/member/register")
    public String register() {
        return "members/register";
    }

    // 회원 가입 - POST
    // request  Web -> Server
    // response Server -> Web
    @PostMapping("/member/register")
    public String registerSubmit(HttpServletRequest request) {


        /* MemberInput 으로 자동 매핑
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         */

        String rePassword = request.getParameter("rePassword");
        System.out.println(rePassword);

        //Member member = new Member();
        //member.setEmail(parameter.getEmail());
        //member.setPassword(parameter.getPassword());
        //member.setRegDt(LocalDateTime.now());

        //memberRepository.save(member);

        return "members/register_complete";

    }

    // 로그인
    @GetMapping("/member/login")
    public String createForm() {
        return "members/login";
    }

    // 비밀번호 찾기
    @GetMapping("/member/findPassword")
    public String findPassword() {
        return "members/find_password";
    }

    /*
    @PostMapping("/member/findPassword")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = memberService.sendResetPassword(parameter);
        model.addAttribute("result", result);

        return "members/find_password_result";
    }

    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> memberList = this.memberService.getList();
        model.addAttribute("memberList", memberList);
        return "members/member_list";

    }

     */
//
//    @Autowired  // Spring이 Spring container에 있는 memberService를 가져다가 연결시켜줌
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @GetMapping("/members/new")
//    public String createForm() {
//        return "members/createMemberForm";
//    }
//
//    @GetMapping("/member/list")
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }
}
