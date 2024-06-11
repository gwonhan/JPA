package com.ohgiraffers.jpql.section05.join;

import jakarta.persistence.*;


@Entity(name = "section05Menu")
@Table(name = "tbl_menu")
public class Menu {
    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @ManyToOne
    @JoinColumn(name = "category_code")
    private Category category;

    @Column(name = "orderable_status")
    private String orderabaleStatus;

    public Menu() {}

    public Menu(int menuCode, String menuName, int menuPrice, Category category, String orderabaleStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderabaleStatus = orderabaleStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public String getOrderabaleStatus() {
        return orderabaleStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderabaleStatus='" + orderabaleStatus + '\'' +
                '}';
    }
}
