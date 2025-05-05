/* 
    * 문제 번호: 11659
    * 문제 링크: https://www.acmicpc.net/problem/11659
    * 문제 이름: 구간 합 구하기
    * 알고리즘 분류: 누적 합
    
    * 문제 설명: 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.

    * 입력: 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
           수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다
           1 ≤ N ≤ 100,000
           1 ≤ M ≤ 100,000
           1 ≤ i ≤ j ≤ N


    * 출력: 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

    * 풀이 방법:
        핵심: 

    * 시간 복잡도: 
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄씩 입력 받고 공백 기준으로 나누기
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫 번째 줄에서 N과 M을 입력 받기
        int dataNum = Integer.parseInt(st.nextToken());
        int qNum = Integer.parseInt(st.nextToken());

        // 두 번째 줄에서 N개의 수를 입력 받기
        long[] sum = new long[dataNum + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= dataNum; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < qNum; q++) {
            // M개의 줄에서 i와 j를 입력 받기
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sum[j] - sum[i - 1]);
        }
    }
}
