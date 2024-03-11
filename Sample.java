class AnimalEat {
   void eat(){
      System.err.println("super");
   };
}

class Animal extends AnimalEat {
   public void eat() {
      System.out.println("Animal is eating");
   }
}
public class Sample {
   public static void main(String args[]) {
      AnimalEat a = new Animal();
      a.eat();
      ((Animal)a).eat();

   }
}

// import java.util.*;
// class Question {  //Define a class Question with two elements e1 and e2.
//   Scanner sc = new Scanner(System.in);
// int e1 = sc.nextInt();  //Read e1
// int e2 = sc.nextInt();  //Read e2
// }
// public class Sample{
// //Template code 
// //Define static method swap()to swap the values of e1 and e2 of class T. 
// public static void swap(Question t) {
// int temp = t.e1;
//     t.e1 = t.e2;
//     t.e2 = temp;
//   }
// public static void main(String[] args) {
// //Create an object of class Question
// 	Question t = new Question ();
//   //Call the method swap()
// swap(t);

// System.out.println(t.e1+" "+t.e2);    
//   }

// }