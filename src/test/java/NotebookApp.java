public class NotebookApp {
    public static void main(String[] args) {
        Notebook notebook = new NotebookImpl();
        NotebookView view = new NotebookViewImpl();
        NotebookPresenter presenter = new NotebookPresenterImpl(notebook, view);
        presenter.start();
    }
}