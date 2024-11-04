import java.util.List;
import java.util.Scanner;

public class NotebookViewImpl implements NotebookView{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMainMenu() {
        System.out.println("----- Записная книжка -----");
        System.out.println("1. Добавить запись");
        System.out.println("2. Просмотреть записи");
        System.out.println("3. Сохранить записи");
        System.out.println("4. Загрузить записи");
        System.out.println("5. Выход");
        System.out.print("Введите номер действия: ");
    }

    @Override
    public void showAddNoteMenu() {
        System.out.println("----- Добавление записи -----");
        System.out.print("Введите текст записи: ");
    }

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записей нет.");
            return;
        }
        System.out.println("----- Записи -----");
        for (Note note : notes) {
            System.out.println("Дата: " + note.getDate() + ", Текст: " + note.getText());
        }
    }

    @Override
    public void showNote(Note note) {
        System.out.println("----- Запись -----");
        System.out.println("Дата: " + note.getDate() + ", Текст: " + note.getText());
    }

    @Override
    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
