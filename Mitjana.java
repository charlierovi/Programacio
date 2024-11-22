public class Mitjana {
    public static void main(String[] args) {
        
        int nums[] = {0, 15, 2, 26, 39};

        float mja, sum = 0;

        int length = nums.length;

        for(int num : nums) {
            sum += num;
        }
        mja = sum / length;
        System.out.println("La mitana dels numeros es: " + mja);
    }
}
