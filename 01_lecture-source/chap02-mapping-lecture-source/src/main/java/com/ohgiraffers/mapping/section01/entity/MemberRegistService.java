package com.ohgiraffers.mapping.section01.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registMember(MemberRegistDTO memberRegistDTO) {
        Member member = new Member(
                memberRegistDTO.getMemberId(),
                memberRegistDTO.getMemberPwd(),
                memberRegistDTO.getMemberName(),
                memberRegistDTO.getPhone(),
                memberRegistDTO.getAddress(),
                memberRegistDTO.getEnrollDate(),
                memberRegistDTO.getMemberRole(),
                memberRegistDTO.getStatus()
        );

        memberRepository.save(member);
    }
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO memberRegist) {

        registMember(memberRegist);

        return memberRepository.findName(memberRegist.getMemberId());
    }
}