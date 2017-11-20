package inter;

class googleCoding2 {
    public int[] solution(int[] A, int K) {
        // 2 modules 1.gen sub arrays 2.find the largest
        int result[] = new int[K];
        int arr[][] = new int [A.length - K + 1][K];
        for(int i = 0;i<A.length-K+1;i++){
            for(int j = 0;j<K;j++){
                arr[i][j] = A[i+j];
            }
        }

        int lar = Integer.MIN_VALUE;
        for (int i = 0; i < A.length-K; i++) {
            if(A[i]>lar){
                lar = A[i];
            }
        }

        int[] larIndex = new int[A.length - K + 1];
        for (int i = 0; i < A.length - K + 1; i++) {
            larIndex[i] = Integer.MIN_VALUE;
        }

        int indCount = 0;
        for (int i = 0; i < A.length; i++) {
            if(lar == A[i]){
                larIndex[indCount] = i;
                indCount++;
            }
        }
        int larIndLength = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            if(larIndex[i] != Integer.MIN_VALUE){
                larIndLength++;
            }
            else{
                break;
            }
        }
        int maxIndex = larIndex[0];
        for (int i = 0; i < larIndLength; i++) {

        }
        return result;
    }

    public static void main(String[] args) {
        googleCoding2 g = new googleCoding2();
        int A[] = {1,4,3,2,5};
        g.solution(A,4);
    }
}