import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TodoListApp extends JFrame {

    private JPanel titlePanel, buttonPanel, listPanel;
    private JTextField newTaskInput;
    private JButton addTaskButton;

    public TodoListApp() {
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title Panel
        titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("My To-Do List");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // List Panel
        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 1));
        add(listPanel, BorderLayout.CENTER);

        // Input and Button Panel
        buttonPanel = new JPanel();
        newTaskInput = new JTextField(20);
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = newTaskInput.getText();
                if (!newTask.isEmpty()) {
                    addTask(newTask);
                    newTaskInput.setText("");
                }
            }
        });
        buttonPanel.add(newTaskInput);
        buttonPanel.add(addTaskButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addTask(String task) {
        JLabel taskLabel = new JLabel(task);
        listPanel.add(taskLabel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TodoListApp app = new TodoListApp();
                app.setVisible(true);
            }
        });
    }
}


