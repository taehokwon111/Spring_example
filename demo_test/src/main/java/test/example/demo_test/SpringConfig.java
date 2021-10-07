package test.example.demo_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.example.demo_test.repository.MemberRepository;
import test.example.demo_test.repository.MemoryMemberRepository;
import test.example.demo_test.service.MemberService;


@Configuration
public class SpringConfig {
    
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
