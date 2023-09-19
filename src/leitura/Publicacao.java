package leitura;

public interface Publicacao {
    public void abrir();
    public void fechar();
    public void folhear() throws LivroFechadoException;
    public void avancarPagina() throws LivroFechadoException;
    public void voltarPagina() throws LivroFechadoException;
    public void mudarPagina(int pagina) throws LivroFechadoException;
}
