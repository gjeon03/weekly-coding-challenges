import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> count = new HashMap<>();
        Map<String, Integer> results = new HashMap<>();

        for (String v : id_list) {
            count.put(v, new HashSet<>());
            results.put(v, 0);
        }

        for (String v : report) {
            String[] split = v.split(" ");
            String user = split[0];
            String re = split[1];
            count.get(re).add(user);
        }

        for (String user : count.keySet()) {
            Set<String> reportedUsers = count.get(user);
            if (reportedUsers.size() >= k) {
                for (String re : reportedUsers) {
                    results.put(re, results.get(re) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = results.get(id_list[i]);
        }

        return answer;
    }
}
