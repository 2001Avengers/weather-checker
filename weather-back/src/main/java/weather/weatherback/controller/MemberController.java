package weather.weatherback.controller;

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

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(MemberJoinForm memberJoinForm) {
        return "join_form";
    }


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
    public String login() {
        return "login_form";
    }

    @GetMapping("/notification")
    public String notification() {
        return "notification_page";
    }
}
