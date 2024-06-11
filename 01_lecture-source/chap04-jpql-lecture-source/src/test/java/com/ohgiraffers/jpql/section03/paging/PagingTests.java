package com.ohgiraffers.jpql.section03.paging;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class PagingTests {

    /*필기.
    *  페이징 처리용 SQL 문은 DBMS 에 따라 각각 문법이 다른
    *  문제점을 가지고 있다.
    *  JPA 는 이러한 페이징을 API 를 통해 추상화하여 간단하게
    *  처리할 수 있도록 제공한다.
    *  - [sql]
    *  - setFirstResult(int startPosition): 조회를 시작할 위치 (0시작)
    *  - setMaxResult(int maxResult) : 조회할 테이터의 수
    *  - limit: 쿼리 겨로가 최대 행 수를 지정할 수 있다. -> 행의 수 제한
    *  - offset : 쿼리 결과에서 반환을 시작할 행의 위치
    *  - remix -> 특정 위치에서 시작해서 지정된 행의 수를 반환할 수 있음
    *  */

    @Autowired
    private PagingRepository pagingRepository;

    @DisplayName("페이징 API 를 이용한 조회 테스트")
    @Test
    void testUsingPagingAPI(){

        //given
        int offset =10; // 조회를 건너 뛸 행의 수
        int limit =5;   //조회 할 최대 행의 수

        //when
        List<Menu> menuList = pagingRepository.usingPaingAPI(offset, limit);

        //then
        Assertions.assertTrue(menuList.size() > 0 && menuList.size() < 6);

        menuList.forEach(menu -> System.out.println(menu));

    }

}
