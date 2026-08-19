 

/*
===========================================================
                    SUPER KEYWORD
===========================================================

'super' is a keyword in Java.

It is used to refer to the IMMEDIATE PARENT CLASS object.

In our example:

    Student = Parent class
    EngineeringStudent = Child class

So inside EngineeringStudent:

    super -> refers to Student


===========================================================
            3 MAIN USES OF super
===========================================================

1. super()       -> Call parent constructor

2. super.variable -> Access parent variable

3. super.method()  -> Call parent method


===========================================================
        1. super() -> CALL PARENT CONSTRUCTOR
===========================================================

In our code:

EngineeringStudent(String name, int age,
                   int rollNo, String college) {

    super(name, age, rollNo);

    this.college = college;
}


Here:

    super(name, age, rollNo);

calls the constructor of the PARENT class:

    Student(String name, int age, int rollNo)


So:

    EngineeringStudent constructor
                |
                v
    super(name, age, rollNo)
                |
                v
    Student constructor


The parent constructor:

Student(String name, int age, int rollNo) {

    this.name = name;
    this.age = age;
    this.rollNo = rollNo;

}


Therefore:

    super(name, age, rollNo);

initializes:

    name
    age
    rollNo


and then:

    this.college = college;

initializes:

    college


===========================================================
                IMPORTANT RULE
===========================================================

super()

must be the FIRST statement inside a constructor.

Correct:

EngineeringStudent(...) {

    super(name, age, rollNo);

    this.college = college;

}


Wrong:

EngineeringStudent(...) {

    this.college = college;

    super(name, age, rollNo);  // ERROR

}


===========================================================
        2. super.variable -> PARENT VARIABLE
===========================================================

Suppose both parent and child have a variable with
the same name.

Example:

class Student {

    String name = "Student";

}


class EngineeringStudent extends Student {

    String name = "Engineering Student";


    void print() {

        System.out.println(name);
        System.out.println(super.name);

    }

}


Output:

Engineering Student
Student


Here:

    name
        -> Child class variable

    super.name
        -> Parent class variable


So:

    super.variable

means:

    "Use the variable from the immediate parent class."


===========================================================
        3. super.method() -> CALL PARENT METHOD
===========================================================

Our code has:

class Student {

    void print() {

        System.out.println(name + " , "
                + age + " , " + rollNo);

    }

}


Child class also has:

void print() {

    super.print();

    System.out.println(college);

}


Here:

    super.print();

calls the parent's print() method.

So:

    EngineeringStudent.print()
              |
              v
        super.print()
              |
              v
        Student.print()
              |
              v
    Prints name, age, rollNo

Then:

    System.out.println(college);

prints the college.


===========================================================
                WHY USE super.print()?
===========================================================

Because the child class has OVERRIDDEN print().

Parent:

void print() {
    ...
}


Child:

void print() {
    ...
}


When we call:

    es2.print();

Java calls the CHILD'S print() method.

Inside the child method:

    super.print();

means:

    "Now execute the parent's print() method."


===========================================================
                YOUR CODE FLOW
===========================================================

This line:

EngineeringStudent es2 =
    new EngineeringStudent(
        "Aditya", 28, 101, "IIT G"
    );


calls:

EngineeringStudent constructor


Inside it:

super(name, age, rollNo);


calls:

Student constructor


Student constructor sets:

    name = "Aditya"
    age = 28
    rollNo = 101


Then child constructor sets:

    college = "IIT G"


Then:

es2.print();


calls EngineeringStudent's print().


Inside it:

super.print();


calls Student's print().


Student prints:

Aditya , 28 , 101


Then child prints:

IIT G


Final output:

Aditya , 28 , 101
IIT G


===========================================================
                super vs this
===========================================================

this:

    Refers to the CURRENT class/object.


super:

    Refers to the IMMEDIATE PARENT class.


Example:

this.name

    -> current class's name


super.name

    -> parent's name


this()

    -> calls another constructor of SAME class


super()

    -> calls constructor of PARENT class


this.method()

    -> calls current class method


super.method()

    -> calls parent class method


===========================================================
                EASY WAY TO REMEMBER
===========================================================

this  -> ME

super -> MY PARENT


this.name
    -> My variable


super.name
    -> Parent's variable


this()
    -> My constructor


super()
    -> Parent's constructor


this.print()
    -> My method


super.print()
    -> Parent's method


===========================================================
                ONE-LINE DEFINITION
===========================================================

super keyword is used to refer to the immediate parent
class and is mainly used to access the parent class's
constructor, variables, and methods.


===========================================================
                YOUR CODE: super USES
===========================================================

class EngineeringStudent extends Student {

    String college;


    EngineeringStudent(String name, int age,
                       int rollNo, String college) {

        // 1. Calling parent constructor
        super(name, age, rollNo);

        this.college = college;
    }


    void print() {

        // 2. Calling parent method
        super.print();

        System.out.println(college);
    }
}


In YOUR code, you are using super in TWO places:

    super(name, age, rollNo);
        -> Parent constructor

    super.print();
        -> Parent method


There is no super.variable in your current code,
but it can be used when parent and child have variables
with the same name.
*/

public class Demo5 {
    public static void main(String[] args) {
        // EngineeringStudent es1 = new EngineeringStudent();
        // es1.name = "Aditya";
        // es1.age = 28;
        // es1.rollNo = 101;
        // es1.college = "IIT Guwahati";

        // es1.print();

    EngineeringStudent es2 = new EngineeringStudent("Aditya", 28, 101, "IIT G");
        es2.print();
    }
}

class Student {
    String name;
    int age;
    int rollNo;

    Student() {}

    Student(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }

    void print() {
        System.out.println(name + " , " + age + " , " + rollNo);
    }
}

class EngineeringStudent extends Student {
    String college;

    EngineeringStudent(String name, int age, int rollNo, String college) {
        super(name, age, rollNo);
        this.college = college;
    }

    void print() {
       super.print();
       System.out.println(college);
    }

    
}
