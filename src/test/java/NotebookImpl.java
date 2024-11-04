import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Формат даты

        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);

        for (Note note : notes) {
            LocalDate noteDate = LocalDate.parse(note.getDate(), formatter);

            if (noteDate.isAfter(startLocalDate.minusDays(1)) && noteDate.isBefore(endLocalDate.plusDays(1))) {
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
