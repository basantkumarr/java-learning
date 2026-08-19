// Encapsulation




/*
===========================================================
                ACCESS MODIFIERS IN JAVA
===========================================================

Access modifiers control:
    "WHO CAN ACCESS a class, variable, method, or constructor?"

Java has 4 access modifiers:

1. public
2. private
3. protected
4. default (no keyword)


-----------------------------------------------------------
1. PUBLIC
-----------------------------------------------------------

public means:
    "Accessible from anywhere."

Example:

public int age;

A public variable/method can be accessed:
    - Inside the same class
    - From another class in the same package
    - From another package


-----------------------------------------------------------
2. PRIVATE
-----------------------------------------------------------

private means:
    "Accessible ONLY inside the same class."

Example:

private int age;

It CANNOT be directly accessed from another class.

This is very important for ENCAPSULATION.

Example:

class Student {

    private int age;

}

class Demo {
    public static void main(String[] args) {

        Student s = new Student();

        // s.age = 20;
        // ERROR because age is private

    }
}


-----------------------------------------------------------
3. PROTECTED
-----------------------------------------------------------

protected means:

    Accessible:
    1. Inside the same class
    2. Inside the same package
    3. In a different package through inheritance


Example:

class Student {

    protected int age;

}


-----------------------------------------------------------
4. DEFAULT
-----------------------------------------------------------

If we don't write any access modifier,
it is called DEFAULT access.

Example:

class Student {

    int age;

}

Here 'age' has default access.

Default means:

    Accessible inside the SAME PACKAGE.

It cannot be directly accessed from a different package.


===========================================================
                ACCESS MODIFIER SUMMARY
===========================================================

Modifier       Same Class   Same Package   Subclass   Other Package
--------------------------------------------------------------------
public            YES           YES          YES          YES
protected         YES           YES          YES*         NO
default           YES           YES          NO           NO
private           YES           NO           NO           NO

* protected can be accessed in another package through inheritance.


===========================================================
                EASY WAY TO REMEMBER
===========================================================

public    -> EVERYWHERE

private   -> ONLY MY CLASS

default   -> MY PACKAGE

protected -> MY PACKAGE + CHILD CLASS


===========================================================
                NOW: ENCAPSULATION
===========================================================

Encapsulation means:

    "Wrapping data and methods together in a class
     and restricting direct access to the data."

In simple words:

    Hide the data
    +
    Control how the data is accessed


The main tool used for encapsulation is:

    private


===========================================================
                WHY DO WE NEED ENCAPSULATION?
===========================================================

Suppose we have:

class BankAccount {

    public double balance;

}

Now anyone can do:

account.balance = -50000;

This is dangerous.

We don't want anyone to directly change our balance.

So we make it:

private double balance;

Now outside classes cannot directly access balance.


===========================================================
                EXAMPLE WITHOUT ENCAPSULATION
===========================================================

class Student {

    public int age;

}


class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        s.age = -50;

        // Problem:
        // We allowed invalid data.

    }
}


===========================================================
                EXAMPLE WITH ENCAPSULATION
===========================================================

class Student {

    // Data is hidden
    private int age;


    // Method to SET the age
    public void setAge(int age) {

        if (age >= 0) {
            this.age = age;
        }

    }


    // Method to GET the age
    public int getAge() {

        return age;

    }

}


class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        // We cannot do:
        // s.age = 20;

        // Because age is private.


        // Instead we use setter:
        s.setAge(20);


        // To get the value:
        System.out.println(s.getAge());

    }

}


===========================================================
                GETTER AND SETTER
===========================================================

Getter:

    Used to GET/read the value.

Example:

public int getAge() {
    return age;
}


Setter:

    Used to SET/change the value.

Example:

public void setAge(int age) {
    this.age = age;
}


Easy way:

    GETTER -> GET value

    SETTER -> SET value


===========================================================
                WHY "this.age"?
===========================================================

Look at this:

private int age;

public void setAge(int age) {

    this.age = age;

}


There are two 'age':

    private int age;
        ^
        Instance variable


    setAge(int age)
                ^
                Parameter/local variable


So:

    this.age
        ->
        object's instance variable


    age
        ->
        method parameter


Therefore:

    this.age = age;

means:

    object's age = parameter age


===========================================================
                IMPORTANT POINT
===========================================================

Encapsulation does NOT simply mean:

    "Make everything private."

More accurately:

    Encapsulation =

    Hiding internal data
    +
    Providing controlled access through methods


For example:

private int balance;

public void deposit(int amount) {

    if (amount > 0) {
        balance = balance + amount;
    }

}

Here we control how balance changes.


===========================================================
                REAL WORLD EXAMPLE
===========================================================

Think about an ATM.

You don't directly access the bank's database.

You interact through controlled operations:

    withdraw()
    deposit()
    checkBalance()

The actual data is protected internally.

This is similar to encapsulation.


===========================================================
                ENCAPSULATION EXAMPLE
===========================================================

class BankAccount {

    // Hidden data
    private double balance;


    // Controlled way to add money
    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }

    }


    // Controlled way to withdraw money
    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }

    }


    // Controlled way to see balance
    public double getBalance() {

        return balance;

    }

}


class Demo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();


        // Cannot directly access:
        // account.balance = 10000;

        // ERROR because balance is private.


        // We use methods instead:
        account.deposit(10000);

        account.withdraw(2000);

        System.out.println(account.getBalance());

    }

}


===========================================================
                BENEFITS OF ENCAPSULATION
===========================================================

1. DATA HIDING

    Internal data can be hidden using private.


2. SECURITY

    Outside code cannot directly modify important data.


3. CONTROL

    We can control how data is changed.

    Example:

    if (age >= 0) {
        this.age = age;
    }


4. MAINTAINABILITY

    Internal implementation can be changed
    without changing how other classes use it.


5. VALIDATION

    We can check data before storing it.


===========================================================
                VERY IMPORTANT INTERVIEW POINT
===========================================================

Question:

What is encapsulation?

Answer:

    Encapsulation is the process of wrapping data and
    methods into a single unit (class) and restricting
    direct access to the data using access control,
    mainly private variables with public getter/setter
    methods.


===========================================================
                ACCESS MODIFIER vs ENCAPSULATION
===========================================================

ACCESS MODIFIER:

    Decides WHO can access something.

Example:

    public
    private
    protected
    default


ENCAPSULATION:

    Uses access control to HIDE and CONTROL data.

Example:

    private variable
    +
    public getter/setter


===========================================================
                ONE-LINE REVISION
===========================================================

public:
    Access from anywhere.

private:
    Access only inside the same class.

default:
    Access only inside the same package.

protected:
    Same package + subclasses.

Encapsulation:
    Hide data and provide controlled access to it.

private + getter/setter:
    Most common implementation of encapsulation.


===========================================================
                MOST IMPORTANT EXAMPLE
===========================================================

class Person {

    private int age;        // DATA HIDING


    public void setAge(int age) {   // CONTROLLED ACCESS

        if (age >= 0) {
            this.age = age;
        }

    }


    public int getAge() {          // CONTROLLED ACCESS

        return age;

    }

}


class Demo {

    public static void main(String[] args) {

        Person p = new Person();

        p.setAge(21);

        System.out.println(p.getAge());

    }

}


/*
    Here:

    private int age;
        ->
        Data is hidden.

    setAge()
        ->
        Controls how age is changed.

    getAge()
        ->
        Controls how age is read.

    This is ENCAPSULATION.
*/
public class Demo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.deposit(500);
        ba.withdraw(300);

        System.out.println(ba.getBalance());
    }
}

class BankAccount {
    private double balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        // amount <= balance
        balance -= amount;
    }

    // getters / Setters
    public double getBalance() {
        return balance;
    }
}

class Student {
    private String name;
    private int rollNumber;
    private int age;
    private String college;

    Student(String name, int rollNumber, int age, String college) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        // Validations --> college should be real.
        this.college = college;
    }
}
