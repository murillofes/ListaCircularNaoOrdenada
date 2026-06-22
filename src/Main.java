public class Main {
    public static void main(String[] args) {
        PlaylistCircular playlist = new PlaylistCircular();

        System.out.println("=== Montando a playlist ===");
        playlist.adicionar("Música 1");
        playlist.adicionar("Música 2");
        playlist.adicionar("Música 3");
        playlist.adicionar("Música 4");
        playlist.adicionar("Música 5");
        playlist.adicionar("Música 6");
        playlist.exibir();

        System.out.println("\n=== Buscando músicas ===");
        System.out.println("Tem Música 3? " + playlist.buscar("Música 3"));
        System.out.println("Tem Música 9? " + playlist.buscar("Música 9"));

        System.out.printf("\n=== Exibir playlist === \n");
        playlist.exibir();

        System.out.println("\n=== Removendo 'Música 4' ===");
        playlist.remover("Música 4");
        playlist.exibir();

        System.out.println("\n=== Tocando a playlist em loop (2 voltas completas) ===");
        playlist.tocarLoop(2);
    }
}