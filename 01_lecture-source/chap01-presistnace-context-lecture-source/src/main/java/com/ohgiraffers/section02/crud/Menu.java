package com.ohgiraffers.section02.crud;


import jakarta.persistence.*;

@Entity(name = "section02Menu")
@Table(name = "tbl_menu")
public class Menu {

    //pk -> not null, unique -> auto increment
    @Id//not null, unique
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토(알아서 해줌), 아이덴티티(마이 바티스), 시퀸스(오라클)

    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    //같은 패키지 내에 있는 녀석들만 사용 가능 할 수 있다.
    protected Menu(){}

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

}
