package programmers_prac;
//2022 KAKAO BLIND RECRUITMENT
//k진수에서 소수 개수 구하기
public class lessons92335 {
    public int solution(int n, int k) {
        String convertedN = toK(n, k);
        return getNumOfPrime(convertedN);
    }

    int getNumOfPrime(String num) {
        int count = 0;
        String[] candidates = num.split("0");
        for (String candidate : candidates) {
            if (candidate.length() > 0 && isPrime(Long.parseLong(candidate))) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    String toK(int n, int k) {
        int pow = 13;
        String result = "";
        while (pow >= 0) {
            if (n / Math.pow(k, pow) < 1) {
                result += (result.length() > 0) ? "0" : "";
                pow--;
                continue;
            }
            result += (int) (n / Math.pow(k, pow));
            n = (int) (n % Math.pow(k, pow));
            if (n == 0) {
                break;
            }
            pow--;
        }
        while (pow-- > 0) {
            result += "0";
        }
        return result;
    }
}
