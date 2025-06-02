package my.com.app;

import java.util.AbstractList;
class Solution {
    public List<String> fizzBuzz(int n) {

        return new AbstractList<String>() {
      @Override
      public String get(int index) {
        index++;
        if (index % 3 == 0 && index % 5 == 0) return "FizzBuzz";
        else if (index % 3 == 0) return "Fizz";
        else if (index % 5 == 0) return "Buzz";
        return String.valueOf(index);
      }

      @Override
      public int size() {
        return n;
      }
    };
    }
}
/*import java.util.Arrays;
class Solution {
    public List<String> fizzBuzz(int n) {
        // 1.
        List<String> result = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                result.add("FizzBuzz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
        // 2.
        String [] result = new String[n];
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                result[i-1]="FizzBuzz";
            } else if(i % 5 == 0) {
                result[i-1]="Buzz";
            } else if(i % 3 == 0) {
                result[i-1]="Fizz";
            } else {
                result[i-1]=Integer.toString(i);
            }
        }
        return Arrays.asList(result);
        // 3.
        return IntStream.rangeClosed(1, n).parallel()
        .mapToObj(i -> {
            if (i % 15 == 0) return "FizzBuzz";
            else if (i % 3 == 0) return "Fizz";
            else if (i % 5 == 0) return "Buzz";
            else return String.valueOf(i);
        }).collect(Collectors.toList());
    }
}*/