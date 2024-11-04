import java.util.List;

public interface Notebook {
    void addNote(Note note);
    void removeNote(Note note);
    Note getNoteByDate(String date);
    List<Note> getNotesByWeek(String startDate, String endDate);
    List<Note> getAllNotes();
    void saveNotesToFile(String filePath);
    void loadNotesFromFile(String filePath);
}
