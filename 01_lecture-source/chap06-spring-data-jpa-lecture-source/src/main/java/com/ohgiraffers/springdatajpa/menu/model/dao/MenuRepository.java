package com.ohgiraffers.springdatajpa.menu.model.dao;


import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*필기.
    *  JpaRepository 상속받을 것이다.(<내가 사용할 엔티티, 해당 클래스의 아이디 값)
    *  Repository <- CrudRepository <-pagingAndSortingRepository <-JpaRepository
    *  - EntityManagerFactory, EntityManager, EntityTransaction 자동 구현
    *  */

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    
//    List<Menu> findByMenuPriceGreaterThan(int menuPrice);
//
//    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(int menuPrice);
//
//    List<Menu> findByMenuPriceGreaterThan(int menuPrice, Sort menuPrice1);
    List<Menu> findByMenuPriceGreaterThan(int menuPrice);
}
