/* 
    * 문제 번호: 11720
    * 문제 링크: https://www.acmicpc.net/problem/11720
    * 문제 이름: 숫자의 합
    * 알고리즘 분류: 수학, 구현, 문자열
    
    * 문제 설명: N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.

    * 입력: 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100), 둘째 줄에 숫자 N개가 공백 없이 주어진다.

    * 출력: 입력으로 주어진 숫자 N개의 합을 출력한다.

    * 풀이 방법:
        핵심: 배열, 형 변환
        
        1. Scanner를 사용하여 입력을 받는다.
        2. 첫 번째 줄에서 숫자의 개수 N을 입력받는다.
        3. 두 번째 줄에서 N개의 숫자를 문자열로 입력받는다.
        4. 문자열을 char 배열로 변환한다.
        5. 각 자리의 숫자를 정수로 변환하여 합을 구한다.
        6. 결과를 출력한다.

    * 시간 복잡도: O(N)
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cNum[i] - '0';
        }
        System.out.print(sum);
    }
}
