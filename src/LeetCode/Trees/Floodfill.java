package LeetCode.Trees;

public class Floodfill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
    dfs(image, sr, sc, newColor);
    return image;
  }

  public void dfs(int[][] image, int sr, int sc, int newColor){
    int[] r = {0,1,0,-1}, c = {1,0,-1,0};
    int m = image.length, n = image[0].length;

    int cur = image[sr][sc];
    image[sr][sc] = 65536;
    for(int i = 0; i < 4; i++){
      if(sr+r[i] >= 0 && sc+c[i] >= 0 && sr+r[i] < m && sc+c[i] < n && image[sr+r[i]][sc+c[i]] == cur){
        dfs(image, sr+r[i], sc+c[i], newColor);
      }
    }
    image[sr][sc] = newColor;
  }

  public static void main(String[] args){
    int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    Floodfill f = new Floodfill();
    f.floodFill(image, 1,1,2);
  }
}
