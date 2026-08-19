// Call by Value in Java
//
// 1. Java always uses "Call by Value".
// 2. When primitive variables are passed to a method,
//    their values are copied into the method parameters.
//
// 3. Here:
//       x = 4, y = 5
//
//    When addTen(x, y) is called:
//       The method receives copies:
//       x = 4, y = 5
//
// 4. Inside addTen():
//       x = x + 10;  // local x becomes 14
//       y = y + 10;  // local y becomes 15
//
// 5. The original x and y in main() are NOT changed,
//    because the method works on copies.
//
// Output:
//       4 , 5
//       4 , 5
//
// Key Point:
//       Changes made to primitive parameters inside a method
//       do NOT affect the original variables.

public class Demo {
    public static void main(String[] args) {
        int x = 4;
        int y = 5;

        System.out.println(x + " , " + y);

        addTen(x, y);

        System.out.println(x + " , " + y);
    }

    static void addTen(int x, int y) {
        x = x + 10;
        y = y + 10;
    }
}