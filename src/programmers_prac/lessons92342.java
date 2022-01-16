package programmers_prac;
//2022 KAKAO BLIND RECRUITMENT
//양궁대회
public class lessons92342 {
    int maxDiff = -1;
    int[] ans = {-1};

    public int[] solution(int n, int[] info) {
        int[] lionInfo = new int[11];
        dfs(0, n, lionInfo, info);
        return ans;
    }

    void dfs(int index, int arrows, int[] lionInfo, int[] peachInfo) {
        if (arrows == 0) {
            int lionScore = 0;
            int peachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (lionInfo[i] == 0 && peachInfo[i] == 0) {
                    continue;
                }
                if (lionInfo[i] > peachInfo[i]) {
                    lionScore += 10 - i;
                } else {
                    peachScore += 10 - i;
                }
            }
            if (lionScore > peachScore) {
                if (lionScore - peachScore == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (ans[i] != lionInfo[i]) {
                            if (lionInfo[i] > ans[i]) {
                                ans = lionInfo.clone();
                            }
                            return;
                        }
                    }
                }
                if (lionScore - peachScore > maxDiff) {
                    maxDiff = lionScore - peachScore;
                    ans = lionInfo.clone();
                }
            }
            return;
        }
        if (index == lionInfo.length) {
            return;
        }
        for (int i = 0; i <= arrows; i++) {
            lionInfo[index] = i;
            dfs(index + 1, arrows - i, lionInfo, peachInfo);
            lionInfo[index] = 0;
        }
    }
}
