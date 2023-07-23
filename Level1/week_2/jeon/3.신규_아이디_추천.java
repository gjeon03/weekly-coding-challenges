class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase()
        .replaceAll("[^\\w-_.]", "")
        .replaceAll("\\.{2,}", ".")
        .replaceAll("^\\.|\\.$", "");
        if(answer.equals("")) answer = "a";
        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        while(answer.length() < 3){
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}

// class Solution {
//     public String solution(String new_id) {
//         String answer = padEnd(new_id.toLowerCase()
//         .replaceAll("[^\\w-_.]", "")
//         .replaceAll("\\.{2,}", ".")
//         .replaceAll("^\\.|\\.$", ""), 1, 'a');
        
//         answer = answer.substring(0, Math.min(answer.length(), 15))
//         .replaceAll("\\.$", "");
        
//         return padEnd(answer, 3, answer.charAt(answer.length() - 1));
//     }
    
//     public String padEnd(String str, int length, char padChar) {
//         StringBuilder paddedStr = new StringBuilder(str);
        
//         for (int i = str.length(); i < length; i++) {
//             paddedStr.append(padChar);
//         }
        
//         return paddedStr.toString();
//     }
// }