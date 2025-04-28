package com.learn.java.problemsolving;

class exam{
    public String name;
    public String surename;
    int age ;

}
public class SelfPractice {
    public static void main(String[] args) {
        exam a =new exam();
        sample2 b=new sample2();
        a.name="Sakshi";
        System.out.println(a.name);
        a.age=19;
        System.out.println(a.age);

        a.surename="Rautela";
        
        System.out.println(a.surename);

        b.method2(a);
        System.out.println(a.name);
        System.out.println(a.surename);
        System.out.println(a.age);


        int ag=19;
        System.out.println(ag);

        b.method(ag);
        System.out.println(ag);

    }
}
class sample2{
    void method2(exam e){
        e.name="Vipin";
        e.surename="Bhandari";
        e.age=25;
    }
    void method(int a){
        a=25;
    }
    
}