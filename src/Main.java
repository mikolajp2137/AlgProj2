import java.util.*;

public class Main {
    public static void main(String[] args) {
        BinaryTreeA binTreeA = new BinaryTreeA();
        BinaryTreeA binTreeB = new BinaryTreeA();
        TreeSet binTreeC = new TreeSet();
        Random random = new Random();
        int m = 13;
        int n = (int) (Math.pow(2, m)) - 1;
        System.out.println("Number of elements: " + ((int) (Math.pow(2, m)) - 1));
        ArrayList<Integer> val = new ArrayList<>();

        int counter = 100;
        long totalOfTimesFA, totalOfTimesFB, totalOfTimesFC, totalOfTimesA, totalOfTimesB, totalOfTimesC;
        totalOfTimesA = totalOfTimesB = totalOfTimesC = totalOfTimesFA = totalOfTimesFB = totalOfTimesFC = 0;
        long startTime, endTime, duration;

        while (counter > 0) {
            val.clear();
            binTreeA.clearTree(binTreeA.root);
            binTreeB.clearTree(binTreeB.root);
            binTreeC.clear();
            //inserting
            for (int i = 0; i < n; i++) {
                val.add(i, random.nextInt(100) + 1);
            }

            startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                binTreeA.insert(val.get(i));
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesA = totalOfTimesA + duration;

            startTime = System.nanoTime();
            binTreeB.insertBalanced(val);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesB += duration;

            startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                binTreeC.add(val.get(i));
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesC += duration;


            //finding
            startTime = System.nanoTime();
            for(int i =0;i<n;i++){
                if(!binTreeB.contains(binTreeA.root,val.get(i))){
                    System.out.println(val.get(i) + " not found");
                }
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesFA += duration;

            startTime = System.nanoTime();
            for(int i =0;i<n;i++){
                if(!binTreeB.contains(binTreeB.root,val.get(i))){
                    System.out.println(val.get(i) + " not found");
                }
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesFB += duration;

            startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                if (!binTreeC.contains(val.get(i))) {
                    System.out.println(val.get(i) + " not found");
                }
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            totalOfTimesFC += duration;

            counter--;
        }

        System.out.println("Average key insertion time for a) : " + totalOfTimesA / 100);
        System.out.println("Average key insertion time for b) : " + totalOfTimesB / 100);
        System.out.println("Average key insertion time for c) : " + totalOfTimesC / 100);
        System.out.println("\n");
        System.out.println("Average key finding time for a) : " + totalOfTimesFA / 100);
        System.out.println("Average key finding time for b) : " + totalOfTimesFB / 100);
        System.out.println("Average key finding time for c) : " + totalOfTimesFC / 100);
    }
}