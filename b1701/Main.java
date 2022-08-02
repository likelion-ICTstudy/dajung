package Gold.b1701.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String input;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for(int len = input.length(); len >= 2; len--) {
            for(int i = 0; i < input.length() - len + 1; i++) {
                kmp(input.substring(i, i+len));
            }
        }
        if(max <= 1)
            System.out.println("0");
        else
            System.out.println(max);
    }

    public static void kmp(String pattern) {
        //최대길이 테이블 구하기
        int j = 0, i = 1;
        int[] arr = new int[pattern.length()];
        for(i =  1; i < arr.length; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                //일치하지 않았을때 j에서 1을뺀 값만큼을 이동한다.
                j = arr[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                arr[i] = ++j;
                if(arr[i] > max) max = arr[i];
            }
        }

    }
}
