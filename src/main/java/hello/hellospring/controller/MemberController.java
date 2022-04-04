package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;

        System.out.println("memberservice  == " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String memberForm() {
        return "/members/memberForm";
    }

    @PostMapping("/members/new")
    public String joinMember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String list(Model model) {

        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "/members/list";
    }
}
