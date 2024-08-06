public class No {
    private int valor;  //valor armazenado no nó
    private No esq;   //o filho esquerdo do nó (outro nó ou null se não houver filho esquerdo)
    private No dir;  //o filho direito do nó (outro nó ou null se não houver filho direito)

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}