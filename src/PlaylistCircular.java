public class PlaylistCircular {
    private Musica head;
    private int tamanho;

    public PlaylistCircular() {
        head = null;
        tamanho = 0;
    }


    public void adicionar(String titulo) {
        Musica nova = new Musica(titulo);

        if (head == null) {
            head = nova;
            nova.proxima = head;
        } else {
            Musica atual = head;
            while (atual.proxima != head) {
                atual = atual.proxima;
            }
            atual.proxima = nova;
            nova.proxima = head;
        }
        tamanho++;
    }

    public boolean remover(String titulo) {
        if (head == null) {
            return false;
        }
        Musica anterior = head;
        while (anterior.proxima != head) {
            anterior = anterior.proxima;
        }

        Musica atual = head;
        for (int i = 0; i < tamanho; i++) {
            if (atual.titulo.equals(titulo)) {
                if (atual == head) {
                    head = (tamanho == 1) ? null : head.proxima;
                }
                anterior.proxima = atual.proxima;
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proxima;
        }

        return false;
    }

    public boolean buscar(String titulo) {
        Musica atual = head;
        for (int i = 0; i < tamanho; i++) {
            if (atual.titulo.equals(titulo)) {
                return true;
            }
            atual = atual.proxima;
        }
        return false;
    }

    public void exibir() {
        if (head == null) {
            System.out.println("Playlist vazia.");
            return;
        }
        Musica atual = head;
        StringBuilder sb = new StringBuilder("Playlist: ");
        do {
            sb.append(atual.titulo);
            atual = atual.proxima;
            if (atual != head) {
                sb.append(" -> ");
            }
        } while (atual != head);
        sb.append(" -> (volta pra \"" + head.titulo + "\")");

        System.out.println(sb.toString());
    }

    public void tocarLoop(int voltas) {
        if (head == null) {
            System.out.println("Playlist vazia, nada pra tocar.");
            return;
        }
        Musica atual = head;
        int totalReproducoes = voltas * tamanho;
        for (int i = 0; i < totalReproducoes; i++) {
            System.out.println("  Tocando: " + atual.titulo);
            atual = atual.proxima;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}