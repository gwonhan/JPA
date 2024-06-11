package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @Autowired
    private EntityManager entityManager;


    public String selectSingleMenuByTypedQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultName = query.getSingleResult();

        return resultName;
    }

    public Menu findMenu(int i) {
        return entityManager.find(Menu.class, i);
    }

    public Object selectSingleMenuByQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";
        Query query = entityManager.createQuery(jpql);
        String result = (String) query.getSingleResult();
        return result;
    }


    public Menu selectSingleRowByTypedQuery() {

        String jpql = "SELECT m FROM section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query =entityManager.createQuery(jpql, Menu.class);
        Menu resultMenu = query.getSingleResult();

        return resultMenu;
    }

    public List<Menu> selectMultiRowByTypedQuery() {

        String jpql = "SELECT m FROM section01Menu m";
        TypedQuery<Menu> query =entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenuList=query.getResultList();

        return resultMenuList;

    }

    public List<Menu> selectMultiRowByQuery() {
        String jpql = "SELECT m FROM section01Menu m";

        Query query = entityManager.createQuery(jpql);

       List<Menu> resultMenuList = query.getResultList();

       return resultMenuList;
    }


    public List<Integer> selectUseDistinct() {
        String jpql = "SELECT DISTINCT m.categoryCode FROM section01Menu m WHERE m.categoryCode IN(11,20)";
        TypedQuery<Integer> query =entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryCodeList = query.getResultList();

        return resultCategoryCodeList;
    }
}
