package Controller;

import Service.DepartmentService; // Импортируем сервис для работы со списком отделов
import Department.Department;     // Импортируем модель Department
import View.DepartmentView;       // Импортируем графический интерфейс

import javax.swing.*;

public class DepartmentController {

    // Ссылка на сервис для работы с данными
    private final DepartmentService service;

    // Ссылка на графический интерфейс
    private final DepartmentView view;

    // Конструктор контроллера. Связь сервиса и представления
    public DepartmentController(DepartmentService service, DepartmentView view) {
        this.service = service;
        this.view = view;

        // Настраиваем обработчики событий
        initController();
    }

    // Метод для инициализации логики обработки событий GUI
    private void initController() {
        view.getAddButton().addActionListener(e -> {
            // Открываем диалоговое окно для ввода названия нового отдела
            String name = JOptionPane.showInputDialog(
                    view,                           // Родительское окно
                    "Введите название отдела:",     // Сообщение
                    "Новый отдел",                  // Заголовок окна
                    JOptionPane.PLAIN_MESSAGE       // Тип диалогового окна
            );

            // обработчик кнопки "Удалить отдел"
            view.getRemoveButton().addActionListener(eventRemove  -> {
                Department selected = view.getSelectedDepartment();
                if (selected != null) {
                    int confirm = JOptionPane.showConfirmDialog(
                            view,
                            "Удалить отдел: " + selected.getNameCommunity() + "?",
                            "Подтверждение",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        service.removeDepartment(selected);
                        view.removeDepartmentFromList(selected);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Выберите отдел для удаления!");
                }
            });

            // Проверяем, что пользователь ввёл непустое значение
            if (name != null && !name.trim().isEmpty()) {
                // Добавляем новый отдел в сервис (бизнес-логика)
                service.addDepartment(name);

                // Отображаем новый отдел в списке на интерфейсе (View)
                view.addDepartmentToList(new Department(name));
            }
        });

        view.getEditButton().addActionListener(e -> {
            Department selected = view.getSelectedDepartment();
            if (selected != null) {
                String newName = JOptionPane.showInputDialog(
                        view,
                        "Введите новое название отдела:",
                        selected.getNameCommunity()
                );

                if (newName != null && !newName.trim().isEmpty()) {
                    Department updated = new Department(newName);

                    // Обновляем список
                    view.updateDepartmentInList(selected, updated);

                    // Обновляем данные в сервисе
                    service.getAllDepartments().remove(selected);
                    service.getAllDepartments().add(updated);
                }
            } else {
                JOptionPane.showMessageDialog(
                        view,
                        "Выберите отдел для редактирования!",
                        "Ошибка",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
    }
}
