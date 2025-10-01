import javax.swing.*;
import java.awt.*;

public class TodoApp {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("To-Do App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text field
        JTextField taskField = new JTextField(15);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton delBtn = new JButton("Delete");

        // Task list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        // Panel for input + buttons (grid for neat alignment)
        JPanel panel = new JPanel(new GridLayout(1, 3, 5, 5));
        panel.add(taskField);
        panel.add(addBtn);
        panel.add(delBtn);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        // Add button action
        addBtn.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        // Delete button action
        delBtn.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });

        frame.setVisible(true);
    }
}
