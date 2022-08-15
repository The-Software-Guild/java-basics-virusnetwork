import java.util.*;

public class DogGenetics {

    static ArrayList<String> dogBreeds = new ArrayList<>(
            Arrays.asList("Affenpinscher", "African Hunting Dog", "Bulldog", "German Shepherd", "Labrador Retriever",
                    "Golden Retriever", "Poodle", "Siberian Husky", "French Bulldog", "Pomeranian", "Airedale ",
                    "Terrier", "Pug", "Great Dane", "Yorkshire Terrier", "Chihuahua", "Doberman"));

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your dog's name?");
        String dogName = scan.next();

        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.\n");

        System.out.println(dogName + " is:\n");
        printDogGenes();

        System.out.println("Wow, that's QUITE the dog!");
        scan.close();
    }

    /**
     * Prints dogs genetics
     */
    private static void printDogGenes() {
        var percentArray = workOutPercent();

        Collections.shuffle(dogBreeds);

        for (int i = 0; i < 5; i++) {
            System.out.println(percentArray.get(i) + "%\t" + dogBreeds.get(i));
        }
    }

    /**
     * Creates a five element array list to be used for percentages
     * Array list is used instead of array because we can shuffle an array list
     * 
     * @return array list of five ints, adding up to 100
     */
    private static ArrayList<Integer> workOutPercent() {
        ArrayList<Integer> percentArray = new ArrayList<>();
        Random rand = new Random();

        percentArray.add(rand.nextInt(20));
        int lastPercent = percentArray.get(0);
        
        for (int i = 0; i < 3; i++) {
            int nextNum = rand.nextInt(20) + 1;
            lastPercent += nextNum;
            percentArray.add(nextNum);
        }
        percentArray.add(100 - lastPercent);

        Collections.shuffle(percentArray);
        return percentArray;

    }

}
