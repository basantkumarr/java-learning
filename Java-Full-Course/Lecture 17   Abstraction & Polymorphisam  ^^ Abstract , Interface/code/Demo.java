public class Demo {

    public static void main(String[] args) {

        // Parent reference
        // Child object
        Car car = new FuelCar();

        car.start();
        car.accelerate();
        car.brake();
    }
}


// Abstract class
abstract class Car {

    // Concrete method
    // Common implementation for all cars
    void start() {
        System.out.println("Car started");
    }

    // Abstract method
    // Child class must implement it
    abstract void accelerate();

    // Abstract method
    // Child class must implement it
    abstract void brake();
}


// Child class
class FuelCar extends Car {

    @Override
    void accelerate() {
        System.out.println("Fuel car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Fuel car is stopping");
    }
}


// Another child class
class ElectricCar extends Car {

    @Override
    void accelerate() {
        System.out.println("Electric car is accelerating");
    }

    @Override
    void brake() {
        System.out.println("Electric car is stopping");
    }
}


/*
========================================================
        LOW-LEVEL ABSTRACTION vs HIGH-LEVEL ABSTRACTION
========================================================

1. ABSTRACTION
--------------
Abstraction means hiding unnecessary details and
showing only what is important.

The main idea is:

        WHAT to do
            ↓
        HOW it works is hidden


========================================================
2. LOW-LEVEL ABSTRACTION
========================================================

Low-level abstraction is closer to the hardware.

It exposes more details about HOW something works.

Examples:
    - Machine code
    - Assembly language
    - CPU instructions
    - Memory/register operations

Example:

    MOV AX, 5
    ADD AX, 10

Here we are working close to the CPU.

We need to understand things like:
    - Registers
    - Memory
    - CPU instructions

So:

    Low Level
        ↓
    Close to hardware
        ↓
    More implementation details
        ↓
    More control
        ↓
    Harder for humans


========================================================
3. HIGH-LEVEL ABSTRACTION
========================================================

High-level abstraction is closer to the user/programmer.

It hides low-level implementation details.

Example in Java:

    System.out.println("Hello");

We don't need to know:
    - How memory is allocated
    - How characters are sent to the output
    - Which CPU instructions are executed

Java handles those details for us.

So:

    High Level
        ↓
    Farther from hardware
        ↓
    Less implementation details
        ↓
    Easier for humans
        ↓
    Easier to develop software


========================================================
4. SIMPLE REAL-LIFE EXAMPLE
========================================================

CAR

Low-level:

    You understand:
        - Engine
        - Fuel injection
        - Gear mechanism
        - Braking mechanism
        - Individual mechanical operations

You are dealing with HOW the car works.

High-level:

    You simply use:

        start()
        accelerate()
        brake()

You care about WHAT the car can do,
not how it internally works.


========================================================
5. JAVA EXAMPLE
========================================================

High-level abstraction:

    car.start();

You don't need to know how the engine starts.

The implementation is hidden behind the method.

This is the main benefit of abstraction.


========================================================
6. EASY DIFFERENCE
========================================================

LOW LEVEL
    ↓
    HOW it works
    ↓
    More details
    ↓
    Close to hardware


HIGH LEVEL
    ↓
    WHAT it does
    ↓
    Hide details
    ↓
    Close to programmer/user


========================================================
7. ONE-LINE INTERVIEW ANSWER
========================================================

Low-level abstraction exposes more implementation
details and is closer to hardware.

High-level abstraction hides implementation details
and provides a simpler interface to the programmer.
*/