package main;

import exception.LivroFechadoException;
import leitura.Livro;
import leitura.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LivroFechadoException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome abaixo: ");
        String nome = sc.nextLine();
        System.out.println("Digite a idade abaixo: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o sexo abaixo: 'M' para masculino e 'F' para feminino ");
        String sexo = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome,idade,sexo);

        System.out.println("Digite o título do livro abaixo: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o nome do autor abaixo: ");
        String autor = sc.nextLine();
        System.out.println("Digite o número total de páginas abaixo : ");
        int totalPaginas = sc.nextInt();

        Livro livro = new Livro(titulo,autor,totalPaginas,pessoa);

        int escolha;
        do {
            System.out.println("""
                    Digite abaixo o número que corresponde ao que você deseja fazer com o livro:
                    1 = abrir livro
                    2 = detalhes do livro
                    3 = folhear livro
                    4 = avançar página
                    5 = voltar página
                    6 = mudar página
                    7 = fechar livro""");

            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    livro.abrir();
                    break;

                case 2:
                    System.out.println(livro.detalhes());
                    break;

                case 3:
                    livro.folhear();
                    break;

                case 4:
                    livro.avancarPagina();
                    System.out.println("Número da Página: " + livro.getPagAtual());
                    break;

                case 5:
                    livro.voltarPagina();
                    System.out.println("Número da Página: " + livro.getPagAtual());
                    break;

                case 6:
                    System.out.println("Digite o número da página que você deseja ver: ");
                    int pagina = sc.nextInt();
                    livro.mudarPagina(pagina);
                    break;

                case 7:
                    livro.fechar();
                    break;

                default:
                    throw new RuntimeException("Número inválida! ");
            }
        } while (escolha != 7);
        sc.close();
    }
}