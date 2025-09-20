import Controller.DepartmentController;
import Service.DepartmentService;
import View.DepartmentView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartmentService service = new DepartmentService();
            DepartmentView view = new DepartmentView();
            new DepartmentController(service, view);

            view.setVisible(true);
        });
    }
}