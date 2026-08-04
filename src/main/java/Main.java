public class Main {
    public static void main(String[] args) {

    }
    public void displayMenu(){
        String[] menu = {"Add Student" , "Show Student" , "Search Student" , "Edit Student" , "Delete Student" , "Exit"};
        int counter = 1;
        System.out.println("====== Menu ======");
        for (String s : menu) {
            System.out.println(counter + ". " + s);
        }
        System.out.println("============");
    }
}
