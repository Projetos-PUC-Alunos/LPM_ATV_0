import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static List<Skills>habilidades;
    private static List<Candidate> candidatos;

    public void Main() {
        habilidades = new ArrayList<>();
        candidatos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main bancoDeTalentos = new Main();
        // bancoDeTalentos.carregarSkillsArquivo("skill.txt");
        // bancoDeTalentos.carregarCandidateArquivo("person.txt");

        int op = -1; // Inicialização com vor que garante a entrada no laço

        while (op != 0) {
            System.out.printf("********** BANCO DE TALENTOS **********\n1 - Dada uma habilidade, quem seria o melhor candidato?\n2 - Dadas uma habilidade obrigatória e uma importante, quem seria o melhor candidato?\n3 - Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?\n\t ESCOLHA UMA OPÇÃO: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("1 - Java\n2 - Front-End\n3 - Python\n4 - Back-End\n5 - Gerencia de projetos\n");
                    System.out.print("\t Escolha uma das habilidades: ");
                    int escolha = scanner.nextInt();
                    String name = Skills.candidato(escolha);
                    System.out.println("CANDIDATO SELECIONADO: " + name);
                    break;
                case 2: 
                    System.out.println("1 - Java\n2 - Front-End\n3 - Python\n4 - Back-End\n5 - Gerencia de projetos\n");
                    System.out.print("Escolha uma habilidade principal: ");
                    int principal = scanner.nextInt();
                    System.out.println("1 - Java\n2 - Front-End\n3 - Python\n4 - Back-End\n5 - Gerencia de projetos\n");
                    System.out.print("E uma habilidade secundária: ");
                    int secundaria = scanner.nextInt();

                    name = Candidate.CandidatePS(principal, secundaria);
                    System.out.println("CANDIDATO PARA AS HABILIDADES PRIMARIA E SECUNDARIA: " + name);
                    break;
                case 3:
                    name = Candidate.CandidateIdeal();
                    System.out.println("CANDIDATO INTERESSANTE: " + name);
                    break;
                default:
                    break;
            }
        }

    }

    // public void carregarSkillsArquivo(String nomeArquivo) {
    //     try {
    //         List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
    //         System.out.print(linhas);
    //         for (String linha : linhas) {
    //             habilidades.add(new Skills(linha));
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Erro ao ler o arquivo de habilidades: " + e.getMessage());
    //     }
    // }

    // public void carregarCandidateArquivo(String nomeArquivo) {
    //     try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
    //         String linha;
    //         while ((linha = br.readLine()) != null) {
    //             String[] dados = linha.split(";");
    //             String nomeCandidato = dados[0];
    //             int[] niveisHabilidade = new int[dados.length - 1];
    //             for (int i = 1; i < dados.length; i++) {
    //                 niveisHabilidade[i - 1] = Integer.parseInt(dados[i]);
    //             }
    //             candidatos.add(new Candidate(nomeCandidato, niveisHabilidade));
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Erro ao ler o arquivo de candidatos: " + e.getMessage());
    //     }
    // }

    // public static void imprimirHabilidades() {
    //     System.out.println("Habilidades:");
    //     for (Skills habilidade : habilidades) {
    //         System.out.println(habilidade.getNome());
    //     }
    // }
}
