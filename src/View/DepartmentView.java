package View;

import Department.Department;

import javax.swing.*;
import java.awt.*;

public class DepartmentView extends JFrame {
    private final DefaultListModel<Department> listModel = new DefaultListModel<>();
    private final JList<Department> departmentList = new JList<>(listModel);

    private final JButton addButton = new JButton("Добавить отдел");
    private final JButton removeButton = new JButton("Удалить отдел"); // ← объявляем кнопку

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
        buttonPanel.add(removeButton); // ← теперь кнопка есть
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    // Добавление отдела в список
    public void addDepartmentToList(Department department) {
        listModel.addElement(department);
    }

    // Работа кнопки "Добавить"
    public JButton getAddButton() {
        return addButton;
    }

    // Удаление отдела из списка
    public void removeDepartmentFromList(Department department) {
        listModel.removeElement(department);
    }

    // Работа кнопки "Удалить"
    public JButton getRemoveButton() {
        return removeButton;
    }

    // Получить выделенный отдел
    public Department getSelectedDepartment() {
        return departmentList.getSelectedValue();
    }
}
