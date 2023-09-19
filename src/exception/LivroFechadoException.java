package exception;

public class LivroFechadoException extends Exception {
    public LivroFechadoException() {
        super("O livro está fechado ");
    }
}
