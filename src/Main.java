import Controller.DepartmentController;
import Service.DepartmentService;
import View.DepartmentView;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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