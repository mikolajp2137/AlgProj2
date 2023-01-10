import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTreeA binTreeA = new BinaryTreeA();
        Random random = new Random();
        int n = 10;
        ArrayList<Integer> val = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            val.add(i, random.nextInt(100) + 1);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            binTreeA.insert(val.get(i));
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + duration);

        //binTreeA.print(binTreeA.root);
    }
}