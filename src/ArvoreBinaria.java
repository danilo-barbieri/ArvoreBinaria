public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) { // verificação de árvore
            this.raiz = novoNo;
        } else { // percorre a árvore para encontrar a posição de inserção
            No atual = this.raiz; // começa do nó raiz
            No pai = null; // inicia pai como null
            boolean esquerda = false; // inicia esquerda como false
            while (atual != null) { // percorre até encontrar um nó vazio
                if (novoNo.getValor() < atual.getValor()) { // se novono é menor que atual
                    pai = atual;
                    atual = atual.getEsq(); // move para esquerda
                    esquerda = true;
                } else { // novo nó maior que atual
                    pai = atual;
                    atual = atual.getDir(); // move para a direita
                    esquerda = false;
                }
            }
            if (esquerda) { //adiciona nó a esquerda
                pai.setEsq(novoNo); // add novo nó como filho esquerdo do pai
            } else {
                pai.setDir(novoNo); // add novo nó como filho direito do pai
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor()); // imprime nó
        preOrdem(no.getEsq()); // chama recursivamente esquerda
        preOrdem(no.getDir()); // chama recursivamente direita
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq()); // chama recursivamente esquerda
        System.out.println(no.getValor()); // imprime nó
        emOrdem(no.getDir()); // chama recursivamente direita
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq()); // chama recursivamente esquerda
        posOrdem(no.getDir()); // chama recursivamente direita
        System.out.println(no.getValor()); // imprime nó
    }

    void remover(int valor) {
        raiz = remover(raiz, valor); // atualiza raiz
    }

    private No remover(No no, int valor) { // recebe nó e valor a ser removido
        if (no == null) {
            return null;
        }

        if (valor < no.getValor()) {       // se o valor a ser removido é menor que o valor do nó atual, está na subárvore esquerda
            no.setEsq(remover(no.getEsq(), valor));             // chamada recursiva para remover o valor da subárvore esquerda
        } else if (valor > no.getValor()) {  // se o valor a ser removido é maior que o valor do nó atual, está na subárvore direita
            no.setDir(remover(no.getDir(), valor));             // chamada recursiva para remover o valor da subárvore direita
        } else {                                   // se o valor é igual ao valor do nó atual, este é o nó a ser removido
            // nó folha (sem filhos)
            if (no.getEsq() == null && no.getDir() == null) { // confirma que o nó não tem filhos (folha)
                return null;                                    // retorna o nó null, removendo-o
            }
            // nó com apenas um filho
            if (no.getEsq() == null) {              // se o nó não tem filho esquerdo
                return no.getDir();                 // retorna o filho direito, que substitui o nó atual
            } else if (no.getDir() == null) {       // se o nó não tem filho direito
                return no.getEsq();                 // retorna o filho esquerdo, que substituirá o nó atual
            }
            // nó com dois filhos
            No menorNo = encontrarMenorNo(no.getDir()); // encontra o nó de menor valor na subárvore direita
            no.setValor(menorNo.getValor());            // altera o valor do no atual pelo valor do sucessor encontrado
            no.setDir(remover(no.getDir(), menorNo.getValor())); // remove o nó que era sucessor da subárvore direita
        }

        return no; // retorna o nó atual após a remoção para atualizar as referências
    }

    private No encontrarMenorNo(No no) {      // encontra menor nó a partir do nó fornecido
        while (no.getEsq() != null) {         // enquanto tiver no esquerdo
            no = no.getEsq();                // move para o filho esqerdo
        }
        return no; // retorna o no mais a esquerda, que tem o menor valor
    }

    public No buscar(No no, int valor) {
        if (no == null) {    // verifica se o nó atual é nulo
            return null;     // se o nó for nulo, retorna nulo, indicando que o valor não foi encontrado
        }
        if (no.getValor() == valor) {  // verifica se o valor do nó atual é igual ao valor que estamos procurando
            return no;    // se o valor for igual, retorna o nó atual, indicando que o valor foi encontrado
        }
        No noEsquerda = buscar(no.getEsq(), valor);  // se o valor não for igual, procura o valor na subárvore esquerda
        if (noEsquerda != null) { // verifica se o valor foi encontrado na subárvore esquerda
            return noEsquerda;   // se o valor for encontrado, retorna o nó que contém o valor
        }
        return buscar(no.getDir(), valor);  // Se o valor não for encontrado na  esquerda, procura o valor na subárvore direita
    }
}