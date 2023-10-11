import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodoLivro = new Livro();

        System.out.println("Bem Vindo ao Sistema de Cadastro e Listagem de Livros!");

        Scanner scanner = new Scanner(System.in);

        int opcoes;

        do {

            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livro ");
            opcoes = scanner.nextInt();

            switch (opcoes) {
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();
                    Livro novoPreco = new Livro();

                    System.out.println("Digite o nome do livro: ");
                    novoLivro.titulo = scanner.next();

                    System.out.println("Digite o nome do autor do livro: ");
                    novoAutor.nome = scanner.next();

                    System.out.println("Digite o preço do livro");
                    novoPreco.preco = scanner.nextFloat();

                    System.out.println("Digite a data de lançamento do livro: ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;

                    if (periodo.getYears() >= 5) {
                        System.out.println("Este livro tem mais que 5 anos!");
                    } else {
                        System.out.println("Este livro tem menos que 5 anos de publicação. Retornando ao menu...");
                        break;
                    }
                        case 2:
                            if (listaLivro.size() > 0) {
                                for (Livro cadaLivro : listaLivro) {
                                    System.out.println();
                                    System.out.println("Livro: " + cadaLivro.titulo);
                                    System.out.println("Autor: " + cadaLivro.autor);
                                    System.out.println("Preço: " + cadaLivro.preco);
                                    System.out.println("Data de Publicação: " + cadaLivro.dataLancamento);
                                }
                                opcoes = scanner.nextInt();
                            } else {
                                System.out.println("Lista Vazia!");
                            }
                            break;
                        case 0:
                            System.out.println("Voltando ao menu anterior");
                            break;
                        default:
                            System.out.println("Opção inválida, por favor digite uma opção válida!");
                            break;
                    }
            } while (opcoes != 0);

        }
    }

