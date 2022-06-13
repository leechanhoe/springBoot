package dodo.hellospring.service;

import dodo.hellospring.domain.Member;
import dodo.hellospring.repository.MemberRepository;
import dodo.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service // 이러면 스프링이 컨테이너에 등록 #이게 컴포넌트 스캔 방식, Component라고 해도됨
@Transactional // 데이터를 저장이나 변경할때 있어야함
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired // memorymemberrepo를 주입해줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member){
        vaildateDuplicateMember(member);//같은 이름이 있는 중복 회원X
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(long memberId) {
        return memberRepository.findById(memberId);
    }
}
