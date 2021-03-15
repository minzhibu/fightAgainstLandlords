package com.sjm.PlayingCards.core.fightAgainstLandlords.util;/*
 *@program:gameDemo
 *@author: songjiamin
 *@Time: 2021/1/8  11:11
 */

public class CircularLinked<T> {
    private Node<T> head;
    private Node<T> last;

    /**
     * 将node加入循环链表
     * @param node
     * @return
     */
    public Node<T> addNode(Node<T> node){
        if(head == null){
            head = node;
        }else{
            last.setNext(node);
            node.setNext(head);
            last = node;
        }
        return head;
    }

    /**
     * 返回循环链表中的个数
     * @return
     */
    public int size(){
        Node temp = head;
        int size = 0;
        while(temp.getNext() != head){
            size++;
        }
        return size;
    }
}
