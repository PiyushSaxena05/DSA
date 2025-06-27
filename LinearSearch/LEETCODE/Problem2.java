package DSA.LinearSearch.LEETCODE;
//1672. Richest Customer Wealth
public class Problem2 {
    public static void main(String[] args){
        int[][]arr = { {1,2,3},{3,2,1}};
        int ans = maximumWealth(arr);
        System.out.println(ans);

    }
    static int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length ; i++) {
            int count = 0;

            for (int j = 0; j < accounts[i].length ; j++) {

                int num = accounts[i][j];
                count += num;
            }
            max=  Math.max(max,count);
        }
        return max;

        }



    }

