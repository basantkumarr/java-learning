/*
========================================================
                    POLYMORPHISM
========================================================

1. WHAT IS POLYMORPHISM?
------------------------

Polymorphism means:

        "One name, many forms"

In Java, the same method call can behave differently
depending on the actual object.

Example:

        A a = new B();

        a.getX();

Even though the reference is of type A,
the actual object is B.

Therefore, B's getX() will execute.


========================================================
2. RUNTIME POLYMORPHISM
========================================================

Runtime polymorphism is achieved using:

        Method Overriding

A child class provides its own implementation of
a method that already exists in the parent class.

Example:

        class A {
            int getX() {
                return 10;
            }
        }

        class B extends A {
            int getX() {
                return 20;
            }
        }


========================================================
3. IMPORTANT RULE
========================================================

Look at:

        A a = new B();

There are TWO things:

        Reference Type  = A
        Object Type     = B

The method that gets executed is decided by the
ACTUAL OBJECT at runtime.

Actual object = B

Therefore:

        a.getX();

calls:

        B's getX()


========================================================
4. OUTPUT
========================================================

        A a = new B();

        System.out.println(a.getX());

Output:

        20

Why?

Because the actual object is B.


========================================================
5. VERY IMPORTANT
========================================================

METHODS can be polymorphic.

        a.getX();

If B overrides getX(), Java calls B's version.


FIELDS / VARIABLES are NOT polymorphic.

For example:

        class A {
            int x = 10;
        }

        class B extends A {
            int x = 20;
        }

        A a = new B();

        System.out.println(a.x);

Output:

        10

Because fields are resolved using the
REFERENCE TYPE.

Reference type = A

Therefore:

        A's x


========================================================
6. METHODS vs FIELDS
========================================================

METHOD:

        A a = new B();

        a.getX();

Actual object decides.

        B's getX() → 20


FIELD:

        A a = new B();

        a.x;

Reference type decides.

        A's x → 10


Remember:

        METHODS → Runtime / Object
        FIELDS  → Reference / Compile time


========================================================
7. STATIC METHODS
========================================================

Static methods belong to the CLASS, not objects.

Therefore static methods are NOT overridden.

They are HIDED.

Example:

        class A {
            static void fun() {
                System.out.println("Hello");
            }
        }

        class B extends A {
            static void fun() {
                System.out.println("Bye");
            }
        }

        A a = new B();

        a.fun();

Output:

        Hello

Because static methods are resolved using the
reference type.

Reference type = A


========================================================
8. PRIVATE METHODS
========================================================

Private methods are NOT inherited by child classes.

Therefore they cannot be overridden.

Example:

        class A {
            private void fun() {
            }
        }

B cannot override A's private fun().


========================================================
9. FINAL METHODS
========================================================

A final method cannot be overridden.

Example:

        class A {
            final void fun() {
            }
        }

        class B extends A {
            void fun() {       // ❌ ERROR
            }
        }

final means:

        "Child classes cannot change this method."


========================================================
10. FINAL CLASS
========================================================

A final class cannot be inherited.

Example:

        final class A {
        }

        class B extends A {    // ❌ ERROR
        }

Examples from Java:

        String

String is a final class.

Therefore, we cannot create a child class of String.


========================================================
11. COMPLETE RULES
========================================================

Normal instance method
        ↓
Can be overridden
        ↓
Runtime polymorphism


Static method
        ↓
Cannot be overridden
        ↓
Method hiding


Private method
        ↓
Cannot be overridden
        ↓
Not inherited


Final method
        ↓
Cannot be overridden


Final class
        ↓
Cannot be extended


Fields / Variables
        ↓
Not polymorphic
        ↓
Reference type decides


========================================================
12. EASY WAY TO REMEMBER
========================================================

        NORMAL METHOD
              ↓
        POLYMORPHISM ✅


        STATIC METHOD
              ↓
        METHOD HIDING ❌


        PRIVATE METHOD
              ↓
        NOT OVERRIDABLE ❌


        FINAL METHOD
              ↓
        NOT OVERRIDABLE ❌


        FIELD / VARIABLE
              ↓
        NOT POLYMORPHIC ❌
*/


public class Demo3 {

    public static void main(String[] args) {

        /*
         * Reference type = A
         * Actual object  = B
         */
        A a = new B();

        /*
         * Runtime polymorphism.
         *
         * getX() is overridden by B.
         *
         * Actual object is B,
         * so B's getX() is called.
         */
        System.out.println(a.getX());
    }
}


class A {

    int getX() {
        return 10;
    }
}


class B extends A {

    /*
     * Method overriding.
     *
     * B provides its own implementation
     * of A's getX().
     */
    @Override
    int getX() {
        return 20;
    }
}