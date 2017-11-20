package inter;


class googleCoding {
    public int[] solution(String A, String B) {
        // write your code in Java SE 8
        String first[] = A.split(" ");
        String second[] = B.split(" ");
        int C[] = new int[second.length];
        for(int i = 0;i<second.length;i++){
            int outerFreq = helper(second[i]);

            int innerCount = 0;
            for(int j = 0 ;j<first.length;j++){
                int innerFreq = helper(first[j]);
                if(innerFreq < outerFreq)
                    innerCount++;
            }
            C[i] = innerCount;
        }
        return C;
    }

    static int helper(String str){
        char ch = str.charAt(0);
        for(int i = 1; i< str.length();++i){
            if(str.charAt(i) < ch){
                ch = str.charAt(i);
            }
        }
        int count = 0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) == ch)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        googleCoding g = new googleCoding();
        g.solution("abcd aabc bd", "aaa aa");

    }


}