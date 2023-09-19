package leitura;

public class Pessoa {
    private String nome;
    private int idade;
    private String sexo;

    public Pessoa(String nome, int idade, String sexo) {
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null){
            throw new IllegalArgumentException("Nome não pode ser null ");
        }
        if(nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Nome não pode conter números ");
        }
        if(nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade <= 0) {
            throw new IllegalArgumentException("idade não pode ser <=0 ");
        }
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if(sexo == null) {
            throw new IllegalArgumentException("sexo não pode ser null ");
        }
        if(sexo.matches(".*\\d.*")) {
            throw new IllegalArgumentException("sexo não pode ter números ");
        }
        if(!sexo.equals("F") && !sexo.equals("M")) {
            throw new IllegalArgumentException("sexo recebe 'F' para feminino e 'M' para masculino ");
        }
        this.sexo = sexo;
    }
}
