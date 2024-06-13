package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


    @Entity
    @Table(name = "tbl_category")
    public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name ="ref_category_code")
    private Integer refCategoryCode;

        public Category() {}

        public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
            this.categoryCode = categoryCode;
            this.categoryName = categoryName;
            this.refCategoryCode = refCategoryCode;
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
    }