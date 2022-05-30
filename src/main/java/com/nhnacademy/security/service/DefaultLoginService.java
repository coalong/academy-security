package com.nhnacademy.security.service;

import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DefaultLoginService implements LoginService {
    private final MemberRepository memberRepository;

    public DefaultLoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean matches(String id, String pwd) {
        Optional<Member> member = memberRepository.findById(id);
        if (Objects.equals(member.get().getPwd(), pwd) && Objects.nonNull(member)) {
            return true;
        } else {
            return false;
        }
    }
}