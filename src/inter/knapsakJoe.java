package inter;

/**
 * Created by joetomjob on 4/8/18.
 */
public class knapsakJoe {
    public static int knapSack(int W, int[] ingredients, int[] servings, int n){
        int[][] result = new int[n+1][W+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if(i==0 || j==0){
                    result[0][0] = 0;
                }
                else if (j>=ingredients[i-1]){
                    result[i][j] = Math.max(result[i-1][j-ingredients[i-1]]+servings[i - 1], result[i-1][j]);
                }
                else{
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[n][W];
    }

    public static void main(String args[]) {
        int ingredients[] = new int[]{2,3,4,5,7};
        int servings[] = new int[]{4,8,9,10,17};
        int W = 7;
        int n = ingredients.length;
        System.out.println(knapSack(W, ingredients, servings, n));
    }
}
