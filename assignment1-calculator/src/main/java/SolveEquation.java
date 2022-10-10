import java.util.*;

public class SolveEquation {

    public static String solve(String equation) {
        ArrayList<String> ansArray = new ArrayList<String>();
        int ans = 0;
        int count = -1;
        int startOfNum = 0;
        for (int i = 0; i < equation.length(); i++) { // for loop to separate values into an array list
            if (!Character.isDigit(equation.charAt(i))) {
                ansArray.add(equation.substring(startOfNum, i)); // add number to array list
                count++;

                if (ansArray.size() > 2 && ansArray.get(count - 1).equals("*")) { // if numbers need to be multiplied
                    int product = Integer.parseInt(ansArray.get(count - 2)) *
                            Integer.parseInt(ansArray.get(count));
                    ansArray.remove(count);
                    ansArray.remove(count - 1);
                    ansArray.remove(count - 2);
                    ansArray.add(String.valueOf(product));
                    count = count - 2;
                }

                ansArray.add(String.valueOf(equation.charAt(i))); // add operator to array list
                count++;
                startOfNum = i + 1;
            }

            if (i == equation.length() - 1) {
                ansArray.add(equation.substring(startOfNum));
                count++;
            }
        }
        if (ansArray.get(count - 1).equals("*")) { // if numbers need to be multiplied
            int product = Integer.parseInt(ansArray.get(count - 2)) *
                    Integer.parseInt(ansArray.get(count));
            ansArray.remove(count);
            ansArray.remove(count - 1);
            ansArray.remove(count - 2);
            ansArray.add(String.valueOf(product));
        }

        if (ansArray.size() == 1) { // if only 2 numbers need to be multiplied, return
            return ansArray.get(0);
        }

        else if (ansArray.size() == 3) { // if only 2 numbers in the sum, return
            if (ansArray.get(1).equals("+")) {
                ans = Integer.parseInt(ansArray.get(0)) +
                        Integer.parseInt(ansArray.get(2));
            }

            else if (ansArray.get(1).equals("-")) {
                ans = Integer.parseInt(ansArray.get(0)) -
                        Integer.parseInt(ansArray.get(2));
            }

            return String.valueOf(ans);
        }

        for (int i = 0; i < ansArray.size(); i++) { // for loop to calculate more than 2 numbers

            if (i <= 2) {
                if (ansArray.get(i).equals("+")) {
                    ans = Integer.parseInt(ansArray.get(0)) +
                            Integer.parseInt(ansArray.get(2));
                } else if (ansArray.get(i).equals("-")) {
                    ans = Integer.parseInt(ansArray.get(0)) -
                            Integer.parseInt(ansArray.get(2));
                }
            }

            else {
                if (ansArray.get(i).equals("+")) {
                    ans = ans + Integer.parseInt(ansArray.get(i + 1));
                }

                if (ansArray.get(i).equals("-")) {
                    ans = ans - Integer.parseInt(ansArray.get(i + 1));
                }
            }

        }
        return String.valueOf(ans);
    }
}