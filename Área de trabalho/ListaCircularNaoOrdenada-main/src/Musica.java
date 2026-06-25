public class Musica {
    String titulo;
    Musica proxima;

    Musica(String titulo) {
        this.titulo = titulo;
        this.proxima = null;
    }
}