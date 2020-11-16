import org.junit.jupiter.api.Test;


public class MyFirstHomework {

    @Test
    public void firstTask() {
        System.out.println("First task:");
        int startSum = 85000;
        double percentSumInProportion = 0.256;

        System.out.println("Start sum = " + startSum);
        double percentSum = (countPercentSum(startSum, percentSumInProportion));
        System.out.println("Percent sum = " + percentSum);
        double finalSum = (countFinalSum(startSum, percentSum));
        System.out.println("Final sum = " + finalSum);
    }

    private double countPercentSum(int a, double b) {
        double c = a * b;
        return c;
    }

    private double countFinalSum(int d, double e) {
        double f = d + e;
        return f;
    }

    @Test
    public void secondTask() {
        System.out.println("Second task:");
        String sentence = "Hello, world!";
        System.out.println("Sentence: " + sentence);
        String replaceSpaces = sentence.replace(" ", "");
        int symbolCount = replaceSpaces.length();
        System.out.println("Symbol count: " + symbolCount);
        String[] splitWords = sentence.split(" ");
        int wordCount = (splitWords.length);
        System.out.println("Word count: " + wordCount);
    }

    @Test
        public void ThirdTask() {
        System.out.println("Third task:");
        int x1 = 1;
        int x2 = 2;
        int y1 = 3;
        int y2 = 4;
        System.out.println("First point coordinates " + "(" +x1+","+y1+")");
        System.out.println("Second point coordinates " + "(" +x2+","+y2+")");

        double distanceBetweenTwoCoordinates = (countDistanceBetweenCoordinates(x1, x2, y1, y2));
        double roundDistanceBetweenTwoCoordinates = Math.round(distanceBetweenTwoCoordinates * 100.0) / 100.0;
        System.out.println("Distance between 2 coordinates: " + roundDistanceBetweenTwoCoordinates);

    }

    private double countDistanceBetweenCoordinates(int x1, int x2, int y1, int y2) {
      double  distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return distance;
    }


}