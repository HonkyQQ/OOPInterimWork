import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotebookImpl implements Notebook {
    private List<Note> notes = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void removeNote(Note note) {
        notes.remove(note);
    }

    @Override
    public Note getNoteByDate(String date) {
        for (Note note : notes) {
            if (note.getDate().equals(date)) {
                return note;
            }
        }
        return null;
    }

    @Override
    public List<Note> getNotesByWeek(String startDate, String endDate) {
        List<Note> weekNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getDate().compareTo(startDate) >= 0 && note.getDate().compareTo(endDate) <= 0) {
                weekNotes.add(note);
            }
        }
        return weekNotes;
    }

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public void saveNotesToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadNotesFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            notes = (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
