/* 
    * 문제 번호: 11660
    * 문제 링크: https://www.acmicpc.net/problem/11660
    * 문제 이름: 구간 합 구하기 2
    * 알고리즘 분류: 다이나믹 프로그래밍, 누적 합
    
    * 문제 설명: N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

                예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.

                1	2	3	4
                2	3	4	5
                3	4	5	6
                4	5	6	7
                여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
                표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

    * 입력: 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 
            둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
            다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 
            표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)


    * 출력: 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.

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
        // 한 줄씩 입력받고 공백 기준으로 나누기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int qNum = Integer.parseInt(st.nextToken());
        // 배열 생성
        int arr[][] = new int[arrSize + 1][arrSize + 1];

        // 각 행별로 배열 입력받기
        for (int x = 1; x <= arrSize; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= arrSize; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 구간합 구하기
        int arrSum[][] = new int[arrSize + 1][arrSize + 1];
        for (int x = 1; x <= arrSize; x++) {
            for (int y = 1; y <= arrSize; y++) {
                // 배열 구간합 공식
                arrSum[x][y] = arrSum[x][y - 1] + arrSum[x - 1][y] - arrSum[x - 1][y - 1] + arr[x][y];
            }
        }

        // 질의 개수만큼의 줄에 구간합 출력
        for (int i = 1; i <= qNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = arrSum[x2][y2] - arrSum[x1 - 1][y2] - arrSum[x2][y1 - 1] + arrSum[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
