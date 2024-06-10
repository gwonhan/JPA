package com.ohgiraffers.associationmapping.section02.onetomany;

import java.util.List;

public class CategoryDTO {

    private int categoryCode;
    private String categoryName;

    private Integer refCategoryCode;
    private List<MenuDTO>menuList;

    public CategoryDTO() {

    }

    public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode, List<MenuDTO> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
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

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }
}
