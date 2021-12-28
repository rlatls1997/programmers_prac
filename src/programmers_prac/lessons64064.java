package programmers_prac;

import java.util.*;
//2019 카카오 개발자 겨울 인턴십
//불량 사용자

public class lessons64064 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        List<String>[] bannedUser = new ArrayList[banned_id.length];
        List<Set<String>> bannedUserSetList = new ArrayList<>();
        Set<String> bannedUserSet = new HashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            List<String> bannedUserTmp = new ArrayList<>();
            setBannedUser(user_id, banned_id[i], bannedUserTmp);
            bannedUser[i] = bannedUserTmp;
        }

        getKindOfBannedUser(bannedUser, bannedUserSetList, bannedUserSet, 0);

        answer = bannedUserSetList.size();
        return answer;
    }

    public void getKindOfBannedUser(List<String>[] bannedUser, List<Set<String>> bannedUserSetList, Set<String> bannedUserSet,
                                    int depth) {
        if (depth == bannedUser.length) {
            if (bannedUserSet.size() != bannedUser.length) {
                return;
            }
            boolean isAlreadyContained = false;
            for (int i = 0; i < bannedUserSetList.size(); i++) {
                if (bannedUserSetList.get(i).containsAll(bannedUserSet) &&
                        bannedUserSet.containsAll(bannedUserSetList.get(i))) {
                    isAlreadyContained = true;
                }
            }
            if (!isAlreadyContained) {
                Set<String> newBannedUserSet = new HashSet<>();
                for (String user : bannedUserSet) {
                    newBannedUserSet.add(user);
                }
                bannedUserSetList.add(newBannedUserSet);
            }
            return;
        }
        for (int i = 0; i < bannedUser[depth].size(); i++) {
            String user = bannedUser[depth].get(i);
            if (bannedUserSet.contains(user)) {
                continue;
            }
            bannedUserSet.add(user);
            getKindOfBannedUser(bannedUser, bannedUserSetList, bannedUserSet, depth + 1);
            bannedUserSet.remove(user);
        }
    }

    public void setBannedUser(String[] user_id, String banned_id, List<String> bannedUser) {
        for (int i = 0; i < user_id.length; i++) {
            if (isBannedUser(user_id[i], banned_id)) {
                bannedUser.add(user_id[i]);
            }
        }
    }

    public boolean isBannedUser(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        }

        for (int i = 0; i < banned_id.length(); i++) {
            char bannedIdChar = banned_id.charAt(i);
            char userIdChar = user_id.charAt(i);

            if (bannedIdChar == '*') {
                continue;
            }
            if (bannedIdChar != userIdChar) {
                return false;
            }
        }
        return true;
    }
}
