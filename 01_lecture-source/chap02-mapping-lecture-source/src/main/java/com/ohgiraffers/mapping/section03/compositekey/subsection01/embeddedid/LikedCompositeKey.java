package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class LikedCompositeKey {

    @Embedded
    private LikedBookNo memberNo;

    @Embedded
    private LikedMemberNo bookNo;

    public LikedCompositeKey() {
    }

    public LikedCompositeKey(LikedBookNo memberNo, LikedMemberNo bookNo) {
        this.memberNo = memberNo;
        this.bookNo = bookNo;
    }
}
