package programmers_prac;
//2022 KAKAO BLIND RECRUITMENT
//주차 요금 계산
import java.util.HashMap;
import java.util.Map;

public class lessons92341 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> cars = new HashMap<>();
        Map<String, Integer> carStack = new HashMap<>();
        for (String record : records) {
            String[] recordInfo = record.split(" ");
            int time = getMinutes(recordInfo[0]);
            String carNumber = recordInfo[1];
            boolean isIn = recordInfo[2].equals("IN");

            if (isIn) {
                carStack.put(carNumber, time);
            } else {
                int enteredTime = carStack.remove(carNumber);
                cars.put(carNumber, cars.getOrDefault(carNumber, 0) + time - enteredTime);
            }
        }
        for (String carNumber : carStack.keySet()) {
            cars.put(carNumber, cars.getOrDefault(carNumber, 0) + getMinutes("23:59") - carStack.get(carNumber));
        }
        return cars.keySet().stream().sorted().mapToInt(key -> getCost(fees, cars.get(key))).toArray();
    }

    int getMinutes(String time) {
        String[] hAndM = time.split(":");
        int hour = Integer.parseInt(hAndM[0]) * 60;
        int minute = Integer.parseInt(hAndM[1]);
        return hour + minute;
    }

    int getCost(int[] fees, int minutes) {
        if (minutes <= fees[0]) {
            return fees[1];
        }
        return fees[1] + (int) Math.ceil((minutes - fees[0]) / (double) fees[2]) * fees[3];
    }
}
