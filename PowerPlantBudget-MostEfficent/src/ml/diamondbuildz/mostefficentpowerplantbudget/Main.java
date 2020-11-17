package ml.diamondbuildz.mostefficentpowerplantbudget;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    // EI,Cost and MW are bumped up so i can avoid errors
    private static Solution best = new Solution(0, 0, 0, 0, 0, 100000, 100000, 100000);

    public static void main(String[] args) {
        try {
            while (true) {
                Solution solution = createSolution();
                if (solution.getMW() >= 1500 && solution.getCost() <= 2000) {
                    if (checkIfBetter(solution, best)) {
                        best = solution;
                        System.out.println("New best is: " + best.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Change the params of nextInt() to adjust min and max
     * Format is as follows
     * .nextInt(min, max + 1)
     *
     * @return the new randomly generated Solution
     */
    private static Solution createSolution() {
        int wind = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        int hydro = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        int solar = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        int coal = ThreadLocalRandom.current().nextInt(0, 30 + 1);
        int nuclear = ThreadLocalRandom.current().nextInt(0, 30 + 1);
        return new Solution(wind, hydro, solar, coal, nuclear);
    }

    private static boolean checkIfBetter(Solution current, Solution best) {
        boolean tf = false;

        // Sort by EI, if EI are the same, sort by Cost
        if (current.getEI() < best.getEI()) tf = true;
        else if (current.getEI() == best.getEI()) {
            tf = current.getCost() < best.getCost();
        }

        // Sort by Cost, if Cost are the same, sort by EI
//        if (current.getCost() < best.getCost()) tf = true;
//        else if (current.getCost() == best.getCost()) {
//            tf = current.getEI() < best.getEI();
//        }

        return tf;
    }
}