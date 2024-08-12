public class No {
    private int valor;  //valor armazenado no nó
    private No esq;   //o filho esquerdo do nó (outro nó ou null se não houver filho esquerdo)
    private No dir;  //o filho direito do nó (outro nó ou null se não houver filho direito)

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public int getValor() {  //retorna o valor armazenado no nó
        return valor;
    }

    public void setValor(int valor) {  //define um novo valor para o nó
        this.valor = valor;
    }

    public No getEsq() {  //retorna o filho esquerdo do nó (ou null se não houver)
        return esq;
    }

    public void setEsq(No esq) {  //define um novo filho esquerdo para o nó
        this.esq = esq;
    }

    public No getDir() {  //retorna o filho direito do nó (ou null se não houver)
        return dir;
    }

    public void setDir(No dir) {  //define um novo filho direito para o nó
        this.dir = dir;
    }
}