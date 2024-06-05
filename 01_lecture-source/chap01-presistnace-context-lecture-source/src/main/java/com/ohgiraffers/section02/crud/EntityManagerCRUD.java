package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager manager;

    public EntityManager getManagerInstance() {

        return manager;
    }

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();

        return manager.find(Menu.class, menuCode);

    }

    public Long saveAndReturnAllCount(Menu newMenu) {

        manager = EntityManagerGenerator.getManagerInstance();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(newMenu);
        manager.flush();

        return getCount(manager);
    }

    private Long getCount(EntityManager manager) {

        return manager.createQuery("SELECT COUNT(*) FROM section02Menu", Long.class).getSingleResult();


    }

    public Menu modifyMenuName(int menuCode, String menuName) {

        Menu foundMenu = findMenuByMenuCode(menuCode); // 메소드 재사용 가능

        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        foundMenu.setMenuName(menuName);

        manager.flush(); // 밀어 넣어주는 역할?

        return foundMenu;
    }

    public Long removeAndReturnAllCount(int menuCode) {
        Menu foundMenu = findMenuByMenuCode(menuCode);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.remove(foundMenu);
        manager.flush();

        return getCount(manager);
    }
}