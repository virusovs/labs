import java.util.*;

public class StringChecker {

    public String[] findLessThanAverage(String[] array) {
        int avg = findAverage(array);

         ArrayList<String> strList = new ArrayList<>();
        for (String s : array) {
            if(s.length() < avg){
                strList.add(s);
            }
        }
        String[] result = strList.toArray(String[]::new);
        return result;
        return arrayAvg;
    }

    public int findAverage(String[] array) {
        int sum = 0;

        for (String string : array) {
            sum += string.length();
        }
        int avg = sum / array.length;
        return avg;
    }


}
