import java.util.Scanner;

public class Quiz {
public static void main(String[] args){

    String q1 = "What is hardware?\n"
          + "(a)virtual machine\n(b)the physical machine\n(c)applications such as browsers\n(d)part of the processor\n";

    String q2 = "What does counter++; do?\n"
          + "(a)Adds 1 to counter\n(b)Adds 2 to counter\n(c)Gets the sum\n(d)Multiplies the numbers\n";

    String q3 = "What is a loop that never stops?\n"
          + "(a)For Loop\n(b)Infinite Loop\n(c)Do-While Loop\n(d)Full Loop\n";

    String q4 = "In a while loop, if the boolean expression is true, what will the loop do?\n"
          + "(a)Break\n(b)Program will exit\n(c)Repeat\n(d)Continue through program\n";

    String q5 = "What special value is designated for controlling a loop?\n"
          + "(a)Control value\n(b)Mutator Method\n(c)Accessor Method\n(d)Sentinel Value\n";

    String q6 = "What is a method?\n"
          + "(a)A collection of statements grouped together to perform an operation\n(b)A value returned from a method using the return statement\n(c)The portion of the program where the variable can be accessed.\n(d)The combination of the name of a method and the list of its parameters\n";

    String q7 = "What is an object?\n"
          + "(a)Representation of an entity in the real world that can be distinctly identified\n(b)A static method can be called without creating an instance of the class\n(c)Instance variable/instance mthod\n(d)A template, blueprint or contract that defines what an object's data fields and methods will be.\n";

    String q8 = "What is an array?\n"
          + "(a)Numbers of items ArrayList can store without increasing its size\n(b)Number used as an index to pinpoint a specfic element within an array\n(c)Object that can store a group of values, all of the same type\n(d)Method of locating a specific item in a larger collection of data\n";

    String q9 = "You use this statement to throw an exception manually.\n"
          + "(a)Throw\n(b)call stack\n(c)try block\n(d)thrown\n";

    String qF = "When an exception is generated, it is said to have been what?\n"
          + "(a)Created\n(b)Called\n(c)Thrown\n(d)Generated\n";


    Question [] questions = {
            new Question(q1, "b"),
            new Question(q2, "a"),
            new Question(q3, "b"),
            new Question(q4, "c"),
            new Question(q5, "d"),
            new Question(q6, "a"),
            new Question(q7, "a"),
            new Question(q8, "c"),
            new Question(q9, "a"),
            new Question(qF, "c")
    };
    takeTest(questions);


}


public static void takeTest(Question [] questions){
    int score = 0,n=0,c=0;
    Scanner keyboardInput = new Scanner(System.in);


    for(int i = 0; i < questions.length; i++) {
        System.out.println(questions[i].prompt);
        String answer = keyboardInput.nextLine();
        if(answer.equals(questions[i].answer)) {
            score=score+5;
            c++;
        }
        else{
          n++;
        }
    }
    System.out.println("You got " + score + "/" + (questions.length*5));
    System.out.println("Correct answer is:" + c );
    System.out.println("incorrect answer is:" + n );
}
}
class Question{
String prompt;
String answer;

public Question(String prompt, String answer) {
    this.prompt = prompt;
    this.answer = answer;
}
}
