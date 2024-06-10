package com.ohgiraffers.associationmapping.section03.bidirection;



import jakarta.persistence.*;

import java.util.List;
// @ToString(exclude = "menuList")
@Entity(name = "bidirection_category")
@Table(name = "tbl_category")
public class Category {


    @Id
    @Column(name = "category_code")
    private int categoryCode;
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    /*필기.
    *  객체의 참조는 둘인데, 외래키는 하나인 상황을 해결하기 위해
    *  두 객체의 연관관계 중 하나를 정해서 테이블의 외래키를 관리하는데
    *  이를 연관관계의 주인 (Owner) 라고 한다.
    *  속성은 연과관계의 주인이 아닌 쪽 (외래키가 없는 곳)에 사용되며,
    *  주인 엔티티에 연관된 필드를 가리킨다.
    *  - 원래라면 연관관계의 주인은 테이블에서 외래키가 있는 곳으로
    *  - 설정해야 하지만, 반대로 설정하는 것도 가능하다.
    *  - 하지만 성능상의 문제가 있기 떄문에 권장하지 않는다.
    * */

    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;

    protected Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode =categoryCode;
        this.categoryName =categoryName;
        this.refCategoryCode =refCategoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
//                ", menuList=" + menuList +
                '}';
    }

    public void setMenuList(List<Menu> menuList) {

        this.menuList= menuList;
    }
}