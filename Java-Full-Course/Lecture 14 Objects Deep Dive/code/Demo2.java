// IMPORTANT:
// Java does NOT have Call by Reference.
// Java is ALWAYS Call by Value.
//
// For primitive data types:
//     A COPY of the actual value is passed.
//
// For objects:
//     A COPY of the REFERENCE (address-like value) is passed.
//
// Example:
// Random r1 = new Random(4, 5);
//
// new Random(4, 5) creates an object in Heap Memory.
// r1 stores the reference to that object.
//
// When we call:
// addTen(r1);
//
// The reference stored in r1 is COPIED into r.
// So both r1 and r point to the SAME object.
//
// r1 ──────────┐
//              ↓
//           [ x=4, y=5 ]
//              ↑
// r  ──────────┘
//
// Therefore, changing r.x or r.y changes the SAME object.
//
// ------------------------------------------------------------


// Call by Reference --> There is NO Call by Reference in Java.

public class Demo2 {
    public static void main(String[] args) {

        Random r1 = new Random(4, 5);

        System.out.println(r1.x + " , " + r1.y);

        addTen(r1);

        System.out.println(r1.x + " , " + r1.y);
    }

    static void addTen(Random r) {

        // r contains a COPY of the reference stored in r1.
        // r and r1 point to the SAME object.

        r.x = r.x + 10;
        r.y = r.y + 10;
    }
}

class Random {
    int x;
    int y;

    Random(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy deep Constructor
    Random(Random r) {
        this.x = r.x;
        this.y = r.y;
    }
}




// SHALLOW / REFERENCE COPY

// Random r1 = new Random(4, 5);
// Random r2 = r1;

// r1 ──────┐
//          ↓
//       [4, 5]
//          ↑
// r2 ──────┘

// Same object



// DEEP / INDEPENDENT COPY

// Random r1 = new Random(4, 5);
// Random r2 = new Random(r1);

// r1 ──────> [4, 5]

// r2 ──────> [4, 5]

// Different objects