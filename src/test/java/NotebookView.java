import java.util.List;

public interface NotebookView {
    void showMainMenu();
    void showAddNoteMenu();
    void showNotes(List<Note> notes);
    void showNote(Note note);
    void showError(String message);
    String getInput();
}
