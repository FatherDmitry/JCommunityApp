package View;

import Department.Department;

import javax.swing.*;
import java.awt.*;

public class DepartmentView extends JFrame {
    private final DefaultListModel<Department> listModel = new DefaultListModel<>();
    private final JList<Department> departmentList = new JList<>(listModel);
    private final JButton addButton = new JButton("Добавить отдел");

    public DepartmentView() {
        setTitle("Список отделов");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(departmentList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public void addDepartmentToList(Department department) {
        listModel.addElement(department);
    }

    public JButton getAddButton() {
        return addButton;
    }
}
