import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        //Livro metodoLivro = new Livro();

        System.out.println("Bem Vindo ao Sistema de Cadastro e Listagem de Livros!");

        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerFloat = new Scanner(System.in);

        int opcoes;

        do {

            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livro / 0 - Sair ");
            opcoes = scannerInt.nextInt();

            switch (opcoes) {
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();
                    //Livro novoPreco = new Livro();

                    System.out.println("Digite o nome do livro: ");
                    novoLivro.titulo = scanner.nextLine();

                    System.out.println("Digite o nome do autor do livro: ");
                    novoAutor.nome = scanner.nextLine();

                    System.out.println("Digite o local de nascimento do autor do livro: ");
                    novoAutor.localNasc = scanner.nextLine();

                    System.out.println("Digite o preço do livro (Digite somente números): ");
                    novoLivro.preco = scannerFloat.nextFloat();

                    System.out.println("Digite a data de lançamento do livro (dd/MM/yyyy): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;

                    if (periodo.getYears() >= 5) {
                        System.out.println();
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println();
                        System.out.println("Este livro tem mais que 5 anos!\nLivro cadastrado com sucesso!");
                        System.out.println();
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println();
                        System.out.println("Este livro tem menos que 5 anos de publicação. Retornando ao menu...\nCadastro Não Realizado.");
                        System.out.println();
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println();
                        break;
                    }

                    novoLivro.autor = novoAutor;
                    listaLivro.add(novoLivro);

                    break;

                case 2:
                    if (listaLivro.size() > 0) {
                        for (Livro cadaLivro : listaLivro) {
                            System.out.println();
                            System.out.println("Livro: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local de Nascimento: " + cadaLivro.autor.localNasc);
                            System.out.println("Preço: R$ " + cadaLivro.preco);
                            System.out.println("Data de Publicação: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                            System.out.println();

                            //opcoes = scanner.nextInt();
                        }

                    } else {
                        System.out.println("Lista Vazia!");
                    }
                    break;

                default:
                    System.out.println("Obrigado por utilizar o sistema!");
                    break;
            }


        }while (opcoes != 0) ;
    }
}

