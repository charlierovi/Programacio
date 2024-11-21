
public class Ex1 {

    public static void main(String[] args) {

        int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};

        float avg, sum = 0;

        int length = ages.length;

        int lowestAge = ages[0];
        
        int highestAge = ages[7];

        int resultat = highestAge-lowestAge;

        for (int age : ages) {

            if (highestAge < age) {
                highestAge = age;
            }
        }
        System.out.println("El numero mes gran es " +highestAge);

        for (int age : ages) {

            if (lowestAge > age) {
                lowestAge = age;
            }
        }
        System.out.println("El numero mes petit es " +lowestAge);
        System.out.println("La diferencia entre " +highestAge+ " i " +lowestAge+ " es = " +resultat);

        for (int age : ages) {
            sum += age;
        }
        avg = sum / length;

        System.out.println("La mitjana es " + avg);
    }
}
