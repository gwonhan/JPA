package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*예약어 항상 조심*/
@Entity
@Table (name = "tbl_like")
public class Like {

    /*우리가 세트로 묶어둔 MemberNO, bookNO를 Id(pk)로서 사용하겠다.*/
    @EmbeddedId
    private LikedCompositeKey likeInfo;

    protected Like(){}

    public Like(LikedCompositeKey likeInfo) {
        this.likeInfo = likeInfo;
    }
}
