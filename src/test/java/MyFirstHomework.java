import org.junit.jupiter.api.Test;

public class MyFirstHomework {

    @Test
    public void firstTask() {
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

        String sentence = "Hello, world!";
        System.out.println("Sentence: " + sentence);
        String replaceSpaces = sentence.replace(" ", "");
        int symbolCount = replaceSpaces.length();
        System.out.println("Symbol count: " + symbolCount);
        String[] splitWords = sentence.split(" ");
        int wordCount = (splitWords.length);
        System.out.println("Word count: " + wordCount);
    }

}