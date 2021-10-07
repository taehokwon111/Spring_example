package test.example.demo_test.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import test.example.demo_test.domain.Member;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    
    MemberService memberService = new MemberService();
    
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        
        
        //when
        Long saveId = memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    
    @Test
    void 중복회원예외() {
    
        //given
        Member member1 = new Member();
        member1.setName("spring");
    
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다");
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }
    
        //then
        
    }
    
    @Test
    void findOne() {
    }
}