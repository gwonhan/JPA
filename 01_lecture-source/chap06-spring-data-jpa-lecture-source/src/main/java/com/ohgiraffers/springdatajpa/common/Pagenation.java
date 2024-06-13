package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

import java.util.Map;

public class Pagenation {

    public static PagingButton getPagingInfo(Page page){

        /*현재 페이지에 대한 정보. +1 이유는 0 부터 시작하니까 사용자가 보는 시점에 맞추었다*/
        int currentPage = page.getNumber() +1;

        /*페이지 버튼의 기본 갯수*/

        int defaultButtonCount =10;

        /*현재 시작 페이지 계산*/

        int startPage =(int)(Math.ceil((double) currentPage / defaultButtonCount ) -1) * defaultButtonCount +1;


        /*끝 페이지 계산*/

        int endPage = startPage + defaultButtonCount -1;

        /*실제 총 페이지가 endPage 보다 작으면 endPage 를 총 페이지로*/

        if (page.getTotalPages()< endPage){
            endPage = page.getTotalPages();
        }
        /*페이지 0이면 끝 페이지를 시작 페이지로 설정하겠다.*/

        if (page.getTotalPages()==0 && endPage == 0){
            endPage =startPage;
        }

        /*게산을 한 정보들을 반환*/

        return new PagingButton(currentPage, startPage,endPage);

    }


}
