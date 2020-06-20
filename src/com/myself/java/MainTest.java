package com.myself.java;



public class MainTest {


    static class Link{


            private class Node{
                private String data;
                private Node next;
                public Node (String data) {
                    this.data=data;
                }
                public void addNode(Node newNode) {
                    if(this.next==null) {
                        this.next=newNode;
                    }else {
                        this.next.addNode(newNode);
                    }

                }
                public void printNode() {
                    System.out.println(this.data);
                    if(this.next!=null) {
                        this.next.printNode();
                    }
                }
                public boolean conrtainsNode(String data) {
                    if(data.equals(this.data)) {
                        return true;
                    }
                    if(this.next!=null) {
                        return this.next.conrtainsNode(data);
                    }
                    else {
                        return false;
                    }
                }
                public String getNode(int index) {
                    if(Link.this.foot==index) {
                        return this.data;
                    }else {
                        foot++;

                        return this.next.getNode(index);
                    }
                }
                public void setNode(int index,String data) {
                    if(Link.this.foot==index) {
                        this.data=data;
                    }else {
                        foot++;
                        this.next.setNode(index, data);
                    }
                }
                public void removeNode(Node previous,String data) {
                    if(data.equals(this.data)) {
                        previous.next=this.next;
                    }
                    else {
                        this.next.removeNode(this, data);
                    }
                }
                public void toArrayNode() {
                    Link.this.retArray[Link.this.foot++]=this.data;
                    if(this.next!=null) {
                        this.next.toArrayNode();
                    }
                }
            }

            /*******************************************************************/
            private Node root;
            private int count;
            private int foot=0;
            private String retArray[];
            public void add(String data) {
                Node newNode =new Node(data);
                if(data==null) {
                    return;
                }
                if(this.root==null) {
                    this.root=newNode;
                }else {
                    this.root.addNode(newNode);
                }
                count++;
            }
            public int Count() {
                return	this.count;
            }
            public void print() {
                if(this.root!=null) {
                    this.root.printNode();
                }
            }
            public boolean isEmpty() {
                if(this.root==null||this.count==0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            public boolean contains(String data) {
                if(this.root==null||data==null) {
                    return false;
                }
                else {
                    return this.root.conrtainsNode(data);
                }
            }
            public String get(int index) {
                if(index>=this.count) {
                    return null;
                }
                this.foot=0;
                return this.root.getNode(index);
            }
            public void set(int index,String data) {
                if(this.count<=index) {
                    return;
                }
                this.foot=0;
                this.root.setNode(index, data);
            }
            public void remove (String data) {
                if(this.contains(data)) {
                    if(data.equals(this.root.data)) {
                        this.root=this.root.next;
                    }else {
                        this.root.next.removeNode(this.root, data);
                    }
                    this.count--;
                }
            }
            public String[] toArray() {
                if(this.root==null) {
                    return null;
                }
                this.foot=0;
                this.retArray=new String [this.count];
                this.root.toArrayNode();
                return this.retArray;
            }
    }

/******************************************************************/

    //测试方法
    public static void main(String args[]) {
        Link link =new Link();
        System.out.println("link的Count："+link.Count());
        link.add("1");
        link.add("2");
        link.add("3");
        link.add(null);
        System.out.println("link的Count："+link.Count());
        link.add("4");
        System.out.println("link-------1------开始");
        link.print();
        System.out.println("link-------1------结束");
        System.out.println("link是否包含1："+link.contains("1"));
        System.out.println("link是否包含2："+link.contains("2"));
        System.out.println("link是否包含4："+link.contains("4"));
        System.out.println("link[1]："+link.get(1));
        System.out.println("link[6]："+link.get(6));
        link.set(1, "8");
        System.out.println("link------2-------开始");
        link.print();
        System.out.println("link------2-------结束");
        String [] data=link.toArray();
        for(int x= 0 ;x<data.length;x++) {
            System.out.println("第"+(x+1)+"个元素："+data[x]);
        }

    }



}
