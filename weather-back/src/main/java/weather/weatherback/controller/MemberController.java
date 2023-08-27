package weather.weatherback.controller;

<<<<<<< Updated upstream
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import weather.weatherback.MemberJoinForm;
import weather.weatherback.service.MemberService;
=======
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import weather.weatherback.domain.Member;
import weather.weatherback.domain.MemberCreateForm;
import weather.weatherback.repository.MemberRepository;
import weather.weatherback.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;
>>>>>>> Stashed changes

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(MemberJoinForm memberJoinForm) {
        return "join_form";
    }

<<<<<<< Updated upstream

    @PostMapping("/join")
    public String join(@Valid MemberJoinForm memberJoinForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "join_form";
        }

        if (!memberJoinForm.getPassword1().equals(memberJoinForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "비밀번호가 일치하지 않습니다.");
            return "join_form";
        }


        try {
            memberService.create(memberJoinForm.getEmail(),
                    memberJoinForm.getPassword1(),
                    memberJoinForm.getRegion(),
                    memberJoinForm.getRainOn(),
                    memberJoinForm.getSnowOn(),
                    memberJoinForm.getDustOn(),
                    memberJoinForm.getUvOn());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("joinFailed", "이미 가입된 이메일입니다.");
            return "join_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("joinFailed", e.getMessage());
            return "join_form";
        }

        return "redirect:/";
    }

    @RequestMapping("/login")
=======
    // 회원 가입 - GET
    @GetMapping("member/signup")
    public String signup(MemberCreateForm memberCreateForm) {
        return "signup_form";
    }

    // 회원 가입 - POST
    // request  Web -> Server
    // response Server -> Web
    @PostMapping("member/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "비밀번호가 일치하지 않습니다.");
            return "signup_form";
        }

        try {
            memberService.create(memberCreateForm.getEmail(),
                    memberCreateForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 가입된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";

    }

    // 로그인 - GET
    @GetMapping("member/login")
>>>>>>> Stashed changes
    public String login() {
        return "login_form";
    }

<<<<<<< Updated upstream
    @GetMapping("/notification")
    public String notification() {
        return "notification_page";
    }
=======
//    // Login form with error
//    @RequestMapping("/member/login-error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "members/login";
//    }
    /* 스프링 시큐리티가 처리할 테니 걱정말라구 -!
    // 로그인 - POST
    @PostMapping("member/login")
    public String loginComplete(Model model, HttpServletRequest request, MemberInput parameter) {

        boolean result = memberService.register(parameter);
        // 로그인 정보가 일치할 때 메인 페이지로 이동
        if (result) {
            return "main";
        }
        // 로그인 정보 불일치 시 불일치 팝업 알림 & 로그인 창으로 리다이렉트
        else {
            // 불일치 팝업 알림 띄우기
            return "redirect:/";
        }
    }

     */

    // 비밀번호 찾기
    @GetMapping("member/findPassword")
    public String findPassword() {
        return "members/find_password";
    }

    // 회원 정보
    @GetMapping("member/info")
    public String memberInfo() {
        return "members/info";
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
>>>>>>> Stashed changes
}
