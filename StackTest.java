public class StackTest {
    public static void main(String[] args) {
        Stack<Double> s1 = new DoubleStack();
        Stack<Double> s2 = new DoubleStack();

        System.out.println("sl empty? " + s1.isEmpty());
        System.out.println("s2 empty? " + s2.isEmpty());

        s1.push(1.2);
        s1.push(3.4);
        s1.push(5.6);
        s1.push(7.8);

        System.out.println(s1.peek());

        System.out.println("sl empty? " + s1.isEmpty());
        System.out.println("s2 empty? " + s2.isEmpty());

        while(!s1.isEmpty()) {
            double val = s1.pop();
            System.out.println(val);
            s2.push(val);
        }
        System.out.println("sl empty? " + s1.isEmpty());
        System.out.println("s2 empty? " + s2.isEmpty());
        while(!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
}