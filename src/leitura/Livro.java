package leitura;

public class Livro implements Publicacao {
    private String titulo;
    private String autor;
    private int totalPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totalPaginas, Pessoa leitor) {
        setTitulo(titulo);
        setAutor(autor);
        setTotalPaginas(totalPaginas);
        this.aberto = false;
        this.leitor = leitor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo == null){
            throw new IllegalArgumentException("título não pode ser null ");
        }
        if(titulo.isEmpty()) {
            throw new IllegalArgumentException("título não pode ser vazio");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null) {
            throw new IllegalArgumentException("autor não pode ser null ");
        }
        if (autor.matches(".*\\d.*")) {
            throw new IllegalArgumentException("autor não pode conter números ");
        }
        if (autor.isEmpty()) {
            throw new IllegalArgumentException("autor não pode ser vazio");
        }
        this.autor = autor;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        if(totalPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas não pode ser <= 0 ");
        }
        this.totalPaginas = totalPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        if(pagAtual < 0) {
            throw new IllegalArgumentException("Página atual não pode ser < 0");
        }
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public String detalhes() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", totalPaginas=" + totalPaginas +
                ", leitor=" + leitor.getNome() +
                '}';
    }

    @Override
    public void abrir() {
        setAberto(true);
    }

    @Override
    public void fechar() {
        setAberto(false);
    }

    @Override
    public void folhear() throws LivroFechadoException {
        if(!aberto) {
            throw new LivroFechadoException();
        }
        for(int i = 1;i <= totalPaginas;i++) {
            System.out.println("Página " + i);
        }
    }

    @Override
    public void avancarPagina() throws LivroFechadoException {
        if(!aberto) {
            throw new LivroFechadoException();
        }
        setPagAtual(getPagAtual() + 1);
    }

    @Override
    public void voltarPagina() throws LivroFechadoException {
        if(!aberto) {
            throw new LivroFechadoException();
        }
        setPagAtual(getPagAtual() - 1);
    }

    @Override
    public void mudarPagina(int pagina) throws LivroFechadoException {
        if(!aberto) {
            throw new LivroFechadoException();
        }
        if(pagina > totalPaginas) {
            throw new IllegalArgumentException("Página inválida ");
        }
        setPagAtual(pagina);
    }
}
