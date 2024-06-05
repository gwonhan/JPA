package com.ohgiraffers.section03.entity;

import com.ohgiraffers.section02.crud.EntityManagerGenerator;
import jakarta.persistence.EntityManager;

public class EntityLifeCycle {

    private EntityManager manager;
    public EntityManager getManagerInstance(){return manager;}

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();

        return manager.find(Menu.class, menuCode);
    }
}
