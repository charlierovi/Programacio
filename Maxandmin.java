public class Maxandmin {
    public static void main(String[] args) {
    
        int nums[] = {12, 3, 45, -3, 65, -5, 88, 99, 2, 23, 54, 33, 27, 53, 96, 0};
    
        int length = nums.length;

        int lowestNum = nums[0];

        int maxNum = nums[15];

        for (int num : nums) {
          if (lowestNum > num) {
            lowestNum = num;
          }
        }
        System.out.println("El numero mes petit es: " + lowestNum);

        for (int num : nums) {
            if (maxNum < num) {
                maxNum = num;
            }
        }
        System.out.println("El numero mes gran es: " + maxNum);
      }
    }