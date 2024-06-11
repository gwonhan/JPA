package com.ohgiraffers.jpql.section04.groupfuction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class GroupTests {

    /*필기.
    *  JPQL 의 그룹함수는 COUNT, MAX, MIN, SUM, AVG
    *  우리가 MYSQL 에서 사용한 그룹함수와 차이가 없다.
    *  단, 몇가지의 주의사항이 존재한다.
    *  1. 그룹함수의 반환 타입은 결과 값이 정수이면 Long, 실수이면 Double 로 반환된다.
    *  2. 값이 없는 상태에서 count 를 제외한 그룹 함수는 null이 되고, count 만 0 이된다.
    *  -> 따라서 반환 값을 담기 위해 선언하는 변수 타입을 기본자료형으로 하면
    *  -> 조회 결과를 언박싱 할 때 nullPointException 이 발생한다.
    *  3. 그룹 함수의 반환 자료형은 Long or Double 이기 떄문에 Having 절에서
    *   그룹 함수 결과 값과 비교하기 위한 파라미터 타입은 Long 또는 Double 로 해야한다.
    * */

    /*필기.
    *  Group By -> 데이터를 특정 컬럼을 기준으로 그룹화 한다.
    *  select category_code , count(*) from tbl_menu 카테고리 코드를 기준으로 그룹화 한다.
    *  Having 절은 Group By 절로 그룹화 된 결과에 대해 조건을 지정
    *  집계합수(그룹화) 에 결과 에 대해 조건을 지정할 때 사용
    *  */

    @Autowired
    private GroupRepository repository;

    @DisplayName("특정 카테고리에 등록된 메뉴 수 조회")
    @Test
    void testCountMenuAndCategory(){
        int categoryCode=4;
        Long countOfMenu = repository.countMenuOfCategory(categoryCode);

        System.out.println("countOfMenu = " + countOfMenu);

        Assertions.assertTrue(countOfMenu>=0);
    }


    @DisplayName("count 를 제외한 그룹 함수의 조회결과가 없는 경우 테스트")
    @Test

    void testWithoutCount(){

        int categoryCode=50;

//        long sumOfPrice = repository.noResult(categoryCode);
//
//        Assertions.assertTrue(sumOfPrice>=0);

        Assertions.assertDoesNotThrow(
                ()->{ Long sumOfPrice = repository.noResult(categoryCode); }
        );

    }

    @DisplayName("GroupBy 절과 Having 절을 사용한 조회 테스트")
    @Test
    void testGroupAndHaving(){

//        int menuPrice = 50000;
        long minPrice = 50000L;
        List<Object[]> sumPriceOfCategoryList = repository.selectGroupAndHaving(minPrice);
        Assertions.assertNotNull(sumPriceOfCategoryList);
        sumPriceOfCategoryList.forEach(
                row->{
                    for (Object column : row){
                        System.out.println( column + "");
                    }
                    System.out.println();
                }
        );
    }

}
