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

            // Проверяем, что пользователь ввёл непустое значение
            if (name != null && !name.trim().isEmpty()) {
                // Добавляем новый отдел в сервис (бизнес-логика)
                service.addDepartment(name);

                // Отображаем новый отдел в списке на интерфейсе (View)
                view.addDepartmentToList(new Department(name));
            }
        });
    }
}
