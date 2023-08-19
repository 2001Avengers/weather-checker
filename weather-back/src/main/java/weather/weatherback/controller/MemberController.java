package weather.weatherback.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weather.weatherback.domain.Member;
import weather.weatherback.service.MemberService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String root() {
        return "home";
    }

    @GetMapping("/member/login")
    public String createForm() {
        return "members/login";
    }

    @GetMapping("/member/findPassword")
    public String findPassword() {
        return "members/find_password";
    }

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
