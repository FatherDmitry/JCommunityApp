package View;

import Department.Department;

import javax.swing.*;
import java.awt.*;

public class DepartmentView extends JFrame {
    private final DefaultListModel<Department> listModel = new DefaultListModel<>();
    private final JList<Department> departmentList = new JList<>(listModel);

    private final JButton addButton = new JButton("Добавить отдел");
    private final JButton removeButton = new JButton("Удалить отдел");
    private final JButton editButton = new JButton("Редактировать отдел");

    public DepartmentView() {
        setTitle("Список отделов");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(departmentList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
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

    // Обновление названия отдела
    public void updateDepartmentInList(Department oldDept, Department newDept) {
        int index = listModel.indexOf(oldDept);
        if (index >= 0) {
            listModel.set(index, newDept);
        }
    }

    // Работа кнопки "Редактировать"
    public JButton getEditButton() {
        return editButton;
    }

    // Получить выделенный отдел
    public Department getSelectedDepartment() {
        return departmentList.getSelectedValue();
    }
}
