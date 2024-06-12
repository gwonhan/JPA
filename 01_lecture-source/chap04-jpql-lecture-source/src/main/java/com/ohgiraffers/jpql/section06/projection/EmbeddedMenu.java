package com.ohgiraffers.jpql.section06.projection;

import jakarta.persistence.*;

@Entity(name = "EmbeddedMenu")
@Table(name = "tbl_menu")
public class EmbeddedMenu {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Embedded
    private MenuInfo menuInfo;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orederableStatus;

    public EmbeddedMenu() {
    }

    public EmbeddedMenu(int menuCode, MenuInfo menuInfo, int categoryCode, String orederableStatus) {
        this.menuCode = menuCode;
        this.menuInfo = menuInfo;
        this.categoryCode = categoryCode;
        this.orederableStatus = orederableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public MenuInfo getMenuInfo() {
        return menuInfo;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrederableStatus() {
        return orederableStatus;
    }

    @Override
    public String toString() {
        return "EmbeddedMenu{" +
                "menuCode=" + menuCode +
                ", menuInfo=" + menuInfo +
                ", categoryCode=" + categoryCode +
                ", orederableStatus='" + orederableStatus + '\'' +
                '}';
    }
}
