package ie.cct.fastfoodstorage;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FoodStorageGUI extends JFrame {

    FoodStack storage = new FoodStack();

    JTextField weight = new JTextField();
    JTextField date = new JTextField();
    JTextArea output = new JTextArea(10, 25);

    JComboBox<FoodType> type = new JComboBox<>(FoodType.values());

    public FoodStorageGUI() {

        setTitle("Fast Food Storage");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel input = new JPanel(new GridLayout(3, 2, 5, 5));

        input.add(new JLabel("Food:"));
        input.add(type);

        input.add(new JLabel("Weight (grams):"));
        input.add(weight);

        input.add(new JLabel("Best before (DD/MM/YYYY):"));
        input.add(date);

        add(input, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(2, 3, 5, 5));

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton display = new JButton("Display");
        JButton peek = new JButton("Peek");
        JButton search = new JButton("Search");
        JButton exit = new JButton("Exit");

        buttons.add(add);
        buttons.add(remove);
        buttons.add(display);
        buttons.add(peek);
        buttons.add(search);
        buttons.add(exit);

        add(buttons, BorderLayout.SOUTH);

        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        add.addActionListener(e -> addFood());
        remove.addActionListener(e -> removeFood());
        display.addActionListener(e -> displayFood());
        peek.addActionListener(e -> peekFood());
        search.addActionListener(e -> searchFood());
        exit.addActionListener(e -> System.exit(0));

        displayFood();
        setLocationRelativeTo(null);
    }

    void addFood() {
        try {
            FoodItem item = new FoodItem(
                    (FoodType) type.getSelectedItem(),
                    Integer.parseInt(weight.getText()),
                    java.time.LocalDate.parse(
    date.getText(),
    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
)
            );

            storage.add(item);

            JOptionPane.showMessageDialog(this, "Food added.");

            weight.setText("");
            date.setText("");

            displayFood();

        } catch (Exception e) {
    JOptionPane.showMessageDialog(
            this,
            "Invalid input. Check the weight and date."
    );
}
    }

    void removeFood() {
        try {
            storage.remove();
            displayFood();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void displayFood() {
        output.setText("Storage: " + storage.size() + "/8\n\n");

        if (storage.isEmpty()) {
            output.append("Storage is empty.");
        } else {
            storage.displayTo(output);
        }
    }

    void peekFood() {
        try {
            JOptionPane.showMessageDialog(this, storage.peek());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void searchFood() {
        FoodType selected = (FoodType) JOptionPane.showInputDialog(
                this,
                "Select food:",
                "Search",
                JOptionPane.QUESTION_MESSAGE,
                null,
                FoodType.values(),
                FoodType.BURGER
        );

        if (selected != null) {
            FoodItem item = storage.search(selected);

            if (item == null) {
                JOptionPane.showMessageDialog(this, "Food not found.");
            } else {
                JOptionPane.showMessageDialog(this, item);
            }
        }
    }

    public static void main(String[] args) {
        new FoodStorageGUI().setVisible(true);
    }
}