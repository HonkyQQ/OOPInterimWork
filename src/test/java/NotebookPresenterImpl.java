public class NotebookPresenterImpl implements NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;

    public NotebookPresenterImpl(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    @Override
    public void start() {
        while (true) {
            view.showMainMenu();
            String choice = view.getInput();
            switch (choice) {
                case "1":
                    addNote();
                    break;
                case "2":
                    showNotes();
                    break;
                case "3":
                    saveNotes();
                    break;
                case "4":
                    loadNotes();
                    break;
                case "5":
                    return;
                default:
                    view.showError("Неверный выбор.");
            }
        }
    }

    @Override
    public void addNote() {
        view.showAddNoteMenu();
        String text = view.getInput();
        System.out.print("Введите дату записи (формат: YYYY-MM-DD): ");
        String date = view.getInput();
        notebook.addNote(new NoteImpl(text, date));
    }

    @Override
    public void showNotes() {
        System.out.println("----- Выберите режим просмотра -----");
        System.out.println("1. Все записи");
        System.out.println("2. Записи по дате");
        System.out.println("3. Записи по неделе");
        String choice = view.getInput();
        switch (choice) {
            case "1":
                view.showNotes(notebook.getAllNotes());
                break;
            case "2":
                showNoteByDate();
                break;
            case "3":
                showNotesByWeek();
                break;
            default:
                view.showError("Неверный выбор.");
        }
    }

    @Override
    public void showNoteByDate() {
        System.out.print("Введите дату (формат: YYYY-MM-DD): ");
        String date = view.getInput();
        Note note = notebook.getNoteByDate(date);
        if (note != null) {
            view.showNote(note);
        } else {
            view.showError("Записи на эту дату нет.");
        }
    }

    @Override
    public void showNotesByWeek() {
        System.out.print("Введите начальную дату (формат: YYYY-MM-DD): ");
        String startDate = view.getInput();
        System.out.print("Введите конечную дату (формат: YYYY-MM-DD): ");
        String endDate = view.getInput();
        view.showNotes(notebook.getNotesByWeek(startDate, endDate));
    }

    @Override
    public void saveNotes() {
        System.out.print("Введите путь к файлу: ");
        String filePath = view.getInput();
        notebook.saveNotesToFile(filePath);
    }

    @Override
    public void loadNotes() {
        System.out.print("Введите путь к файлу: ");
        String filePath = view.getInput();
        notebook.loadNotesFromFile(filePath);
    }
}