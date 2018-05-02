package lambdasinaction.comparator;

import java.util.*;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String... args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, "green"),
                                        new Apple(155, "green"),
                                        new Apple(120, "red")));
        //Java 7
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println(inventory);

        //Java 8
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
