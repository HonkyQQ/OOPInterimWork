public class NoteImpl implements Note{
    private String text;
    private String date;

    public NoteImpl(String text, String date) {
        this.text = text;
        this.date = date;
    }
    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

}
