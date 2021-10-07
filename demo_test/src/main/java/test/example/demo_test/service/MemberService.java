package test.example.demo_test.service;

import test.example.demo_test.domain.Member;
import test.example.demo_test.repository.MemberRepository;
import test.example.demo_test.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //회원가입
    public Long join(Member member){
        //중복회원 걸러내기
        extracted(member);
    
        memberRepository.save(member);
        return member.getId();
    }
    
    //전체 회원조회
    private void extracted(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    
}
