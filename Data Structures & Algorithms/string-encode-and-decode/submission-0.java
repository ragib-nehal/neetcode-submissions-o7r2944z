class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) { 
            result.append(str.length()).append("#").append(str); // notice we use append instead of +
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;

            result.add(str.substring(i, j));
            i = j;
        }
        
        return result; 
    }
}

