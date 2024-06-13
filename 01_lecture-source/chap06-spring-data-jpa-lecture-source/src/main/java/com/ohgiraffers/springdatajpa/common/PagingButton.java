package com.ohgiraffers.springdatajpa.common;

public class PagingButton {



    private int currentPage;
    private int startPage;
    private int endPage;

    public PagingButton() {
    }


    public PagingButton(int currentPage, int startPage, int endPage) {
        this.currentPage = currentPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PagingButton{" +
                "currentPage=" + currentPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }
}
