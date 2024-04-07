import java.util.*;

// Interface untuk merepresentasikan makanan
interface Food {
    void display();
    int getProteinAmount();
}

// Concrete class untuk makanan protein
class ProteinFood implements Food {
    private String name;
    private int proteinAmount;

    public ProteinFood(String name, int proteinAmount) {
        this.name = name;
        this.proteinAmount = proteinAmount;
    }

    public void display() {
        System.out.println("Protein Food: " + name);
    }

    public int getProteinAmount() {
        return proteinAmount;
    }
}

// Factory class untuk menciptakan makanan protein
class FoodFactory {
    private String[] proteinFoods = {"Chicken Breast", "Salmon Fillet", "Tofu", "Eggs", "Lean Beef", "Greek Yogurt", "Quinoa"};
    private int[] proteinAmounts = {30, 25, 20, 6, 22, 10, 8}; // Jumlah protein dalam gram per porsi

    public Food createFood() {
        Random random = new Random();
        int index = random.nextInt(proteinFoods.length);
        String randomProtein = proteinFoods[index];
        int proteinAmount = proteinAmounts[index];
        return new ProteinFood(randomProtein, proteinAmount);
    }
}

// Client class
public class WeeklyMealPlan {
    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory(); // Membuat objek factory
        List<Food> weeklyMealPlan = new ArrayList<>();
        int totalProtein = 0;

        // Generate meal plan
        for (int i = 0; i < 7; i++) {
            Food food = foodFactory.createFood(); // Membuat makanan menggunakan factory
            weeklyMealPlan.add(food);
            totalProtein += food.getProteinAmount();
        }

        // Menampilkan meal plan
        System.out.println("Weekly Meal Plan (Protein):");
        for (int i = 0; i < weeklyMealPlan.size(); i++) {
            System.out.print("Day " + (i + 1) + ": ");
            weeklyMealPlan.get(i).display();
            System.out.println("Protein Amount: " + weeklyMealPlan.get(i).getProteinAmount() + "g");
        }

        // Menampilkan total protein
        System.out.println("Total Protein Consumed This Week: " + totalProtein + "g");
    }
}
