package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class BiDirectionTests {
    /*필기.
    *  데이터베이스의 테이블으ㄴ 외래키 하나로 양방향 조회가 가능하지만
    *  객체는 서로 다른 두 단방향 참조를 합쳐서 양방향이라고 한다.
    *  따라서, 두 개의 연관관계 중 연관관계의 주인을 정하고, 주인이 아닌
    *  연관관계를 추가하는 방식으로 작성한다.
    *  - 양방향 연관관계는 항상 설정하는 것이 아닌, 반대 방향으로도 접근하여
    *  - 객체 그래프(참조) 할 일이 많을 때만 설계한다.
    *  - 양방향 연관관계 매핑시 연관관계의 주인은 비지니스 로직 상 중요하다고 해서
    *  주인이 되는 것이 아니다.
    *  그러면 누가 주인이 될 것 인가?
    *  외래키(FK) 를 관리하는 엔티티가 주인이 되어야 한다.
    *  즉, 완관관계의 주인은 외래키를 가지고 있는 엔티티가 되어야 한다.
    *  (우리가 쓰는 테이블로 따지면 Menu 가 주인이다.)
    * */

    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 연관관계 매핑 조회 테스트 1(연관관계의 주인인 객체)")
    @Test
    void ownerFindTest1(){

        //given
        int menuCode = 10;

        //when
        /* 처음부터 조회시 조인한 결과를 가져온다. */
        Menu foundMenu = biDirectionService.findMenu(menuCode);

        //then
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);

    }

    @DisplayName("양방향 연관관계 매핑 조회 테스트 1(연관관계의 주인이 아닌 객체)")
    @Test
    void notOwnerFindTest2(){

        //given
        int categoryCode = 10;

        //when
        /*해당 엔티티를 조회하고 필요시 연관관계 엔티티를 조회하는 쿼리를 실행한다.*/
        Category foundCategory = biDirectionService.findCategory(categoryCode);

        //then

        Assertions.assertEquals(categoryCode, foundCategory. getCategoryCode());

    }

    private  static Stream<Arguments> getMenuInfo(){
        return Stream.of(
                Arguments.of(321, "돈까스 스파게티", 30000, "Y")
        );
    }


    @DisplayName("양방향 연관관계 주인 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void ownerInsertTest1(int menuCode, String menuName, int menuPrice, String orderableStatus){
        Category category =biDirectionService.findCategory(4);
        Menu menu = new Menu(menuCode,menuName,menuPrice,category,orderableStatus);

        Assertions.assertDoesNotThrow(
                ()->biDirectionService.registMenu(menu)
        );
    }
    private static Stream<Arguments> getCategoryInfo(){
        return Stream.of(
                Arguments.of(111,"양방향 카테곻리", null)
        );
    }

    @DisplayName("양방향 연관관계 주인이 아닌 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getCategoryInfo")
    void notOwnerInsertTest2(int categoryCode, String categoryName, Integer refCategoryCode){

        Category category = new Category(
                categoryCode,
                categoryName,
                refCategoryCode
        );
        biDirectionService.registCategory(category);


        //등록 후 조회 성공여부 테스트
        Category foundCategory = biDirectionService.findCategory(categoryCode);

        Assertions.assertNotNull(foundCategory);
    }


}
