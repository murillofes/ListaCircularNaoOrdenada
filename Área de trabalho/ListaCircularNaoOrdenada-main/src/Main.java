import java.util.Scanner;

public class Main {

    static final String RESET  = "\u001B[0m";
    static final String BOLD   = "\u001B[1m";
    static final String CYAN   = "\u001B[36m";
    static final String GREEN  = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String RED    = "\u001B[31m";
    static final String BLUE   = "\u001B[34m";
    static final String DIM    = "\u001B[2m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistCircular playlist = new PlaylistCircular();

        while (true) {
            exibirMenu(playlist);
            System.out.print(BOLD + "  >> Escolha uma opção: " + RESET);
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.print(GREEN + "  Nome da música: " + RESET);
                    String titulo = scanner.nextLine().trim();
                    if (!titulo.isEmpty()) {
                        playlist.adicionar(titulo);
                        System.out.println(GREEN + "  \"" + titulo + "\" adicionada!" + RESET);
                    } else {
                        System.out.println(RED + "  Nome inválido." + RESET);
                    }
                    pausar(scanner);
                    break;

                case "2":
                    System.out.print(RED + "  Nome da música a remover: " + RESET);
                    String remover = scanner.nextLine().trim();
                    if (playlist.remover(remover)) {
                        System.out.println(GREEN + "  \"" + remover + "\" removida!" + RESET);
                    } else {
                        System.out.println(RED + "  Música não encontrada." + RESET);
                    }
                    pausar(scanner);
                    break;

                case "3":
                    System.out.print(YELLOW + "  Nome da música a buscar: " + RESET);
                    String busca = scanner.nextLine().trim();
                    boolean encontrou = playlist.buscar(busca);
                    if (encontrou) {
                        System.out.println(GREEN + "  \"" + busca + "\" está na playlist!" + RESET);
                    } else {
                        System.out.println(RED + "  \"" + busca + "\" não está na playlist." + RESET);
                    }
                    pausar(scanner);
                    break;

                case "4":
                    System.out.println();
                    playlist.exibir();
                    pausar(scanner);
                    break;

                case "5":
                    System.out.print(BLUE + "  Quantas voltas? " + RESET);
                    try {
                        int voltas = Integer.parseInt(scanner.nextLine().trim());
                        if (voltas <= 0) throw new NumberFormatException();
                        System.out.println(CYAN + "\n  ▶ Tocando em loop (" + voltas + " volta(s))..." + RESET);
                        playlist.tocarLoop(voltas);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "  Número inválido." + RESET);
                    }
                    pausar(scanner);
                    break;

                case "0":
                    System.out.println(DIM + "\n  Saindo... até mais!\n" + RESET);
                    scanner.close();
                    return;

                default:
                    System.out.println(RED + "  Opção inválida." + RESET);
                    pausar(scanner);
            }
        }
    }

    static void exibirMenu(PlaylistCircular playlist) {
        limparTela();
        System.out.println(CYAN + BOLD);
        System.out.println("  ╔══════════════════════════════════════╗");
        System.out.println("  ║       🎵  PLAYLIST CIRCULAR  🎵      ║");
        System.out.println("  ╚══════════════════════════════════════╝" + RESET);
        System.out.println(DIM + "  Músicas na playlist: " + playlist.getTamanho() + RESET);
        System.out.println();
        System.out.println(GREEN  + "  [1]" + RESET + " Adicionar música");
        System.out.println(RED    + "  [2]" + RESET + " Remover música");
        System.out.println(YELLOW + "  [3]" + RESET + " Buscar música");
        System.out.println(CYAN   + "  [4]" + RESET + " Exibir playlist");
        System.out.println(BLUE   + "  [5]" + RESET + " Tocar em loop");
        System.out.println(DIM    + "  [0]" + RESET + " Sair");
        System.out.println();
    }

    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausar(Scanner scanner) {
        System.out.print(DIM + "\n  Pressione Enter para continuar..." + RESET);
        scanner.nextLine();
    }
}