package BigTasks.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {

//Создаём новые объекты для паттерна
            Model model = new MainModel();
            UsersView usersView = new UsersView();
            EditUserView editUserView = new EditUserView();
            Controller controller = new Controller();

//Инициализация контроллера
            controller.setModel(model);
            controller.setUsersView(usersView);
            controller.setEditUserView(editUserView);

//Прописваем контроллер в наши въюшки
            usersView.setController(controller);
            editUserView.setController(controller);//метод открытия формы редактирования?

//Вызовы въюшек
            usersView.fireEventShowAllUsers();
            usersView.fireEventOpenUserEditForm(126L);
            editUserView.fireEventUserDeleted(124L);
            editUserView.fireEventUserChanged("Piter", 126L, 3);

            usersView.fireEventShowDeletedUsers();
        }
    }