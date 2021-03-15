package com.sjm.PlayingCards.core.fightAgainstLandlords.util;/*
 *@program:gameDemo
 *@author: songjiamin
 *@Time: 2021/1/8  11:09
 */

public class Node<T> {
    private T t;
    private Node<T> next;
    public Node(T t, Node<T> next) {
        this.t = t;
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
