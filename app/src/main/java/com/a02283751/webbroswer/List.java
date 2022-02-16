package com.a02283751.webbroswer;

public class List {
    // node class
    private class ListNode {
         String value;
         ListNode next;
         ListNode previous;
         ListNode() {}
         ListNode(String value) {
            this.value = value;
        }
    }

    private ListNode position = new ListNode();
    private ListNode tail = new ListNode();

    public List() {
        position.next = tail;
    }



    //adds a value to the end of the list
    public void add(String value) {

        ListNode node = new ListNode(value);
        if (position.next.previous != null) {
            position.next.previous = node;
        }
        node.previous = position;
        node.next = position.next;
        position.next = node;
        position = node;


    }



    public String goBack() {
        if(position.previous == null) {
            return position.value;
        } else {
            //need to return the last value going back
            ListNode temp = position;
            position = position.previous;
            position.next = temp;
            return position.value;
        }

    }


    public String goForward() {
        if (position.next == null) {
            return null;
        } else {
            // need to move forward and return the value
            ListNode temp = position;
            position = position.next;
            position.previous = temp;
            return position.value;
        }
    }







}
