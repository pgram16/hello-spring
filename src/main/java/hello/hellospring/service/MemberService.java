package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    MemberRepository memRepository;

    public MemberService(MemberRepository memRepository) {
        this.memRepository = memRepository;
    }

    /**
     * 회원가입
     * */
    public Long join(Member member) {

        validateDuplicateMember(member);
        memRepository.save(member);

        return member.getId();
    }

    public void validateDuplicateMember(Member member) {

        //동일한 이름의 유저는 없어야한다.
        memRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers() {

        return memRepository.findAll();

    }

    /**
     * 회원 검색
     * */
    public Optional<Member> findOne(Long memberId){
        return memRepository.findById(memberId);
    }
}
