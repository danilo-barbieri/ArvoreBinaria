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
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) { // se novoNo é menor que atual, segue a esquerda
                    pai = atual;
                    atual = atual.getEsq(); // move para esquerda
                    esquerda = true;
                } else { // novo nó maior que atual, segue para a direita
                    pai = atual;
                    atual = atual.getDir(); // move para a direita
                    esquerda = false;
                }
            }
            if (esquerda) { // true
                pai.setEsq(novoNo); // add novo nó como filho esquerdo do pai
            } else { // false
                pai.setDir(novoNo); // add novo nó como filho direito do pai
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if (no == null) {
            System.out.println("Não há elementos na árvore");
            return;

        }
        System.out.println(no.getValor()); // imprime nó
        preOrdem(no.getEsq()); // chama recursivamente esquerda
        preOrdem(no.getDir()); // chama recursivamente direita
    }

    public void emOrdem(No no) {
        if (no == null) {
            System.out.println("Não há elementos na árvore");
            return;
        }
        emOrdem(no.getEsq()); // chama recursivamente esquerda
        System.out.println(no.getValor()); // imprime nó
        emOrdem(no.getDir()); // chama recursivamente direita
    }

    public void posOrdem(No no) {
        if (no == null) {
            System.out.println("Não há elementos na árvore");
            return;
        }
        posOrdem(no.getEsq()); // chama recursivamente esquerda
        posOrdem(no.getDir()); // chama recursivamente direita
        System.out.println(no.getValor()); // imprime nó
    }

    private No encontrarMenorNo(No no) { // encontra menor nó apartir do nó fornecido
        while (no.getEsq() != null) { // enquanto tiver nó esquerdo
            no = no.getEsq(); // move para o filho esquerdo
        }
        return no; // retorna o no mais a esquerda, que tem o menor valor
    }

    private No remover(No no, int valor) { // recebe nó e valor a ser removido
        if (no == null) {
            return null;
        }

        if (valor < no.getValor()) { // se valor menor que o valor do nó atual, está a esquerda
            no.setEsq(remover(no.getEsq(), valor)); // chamada recursiva a esq, atual recebe filho a esq
        } else if (valor > no.getValor()) { // se valor maior que o valor do nó atual, está a direita
            no.setDir(remover(no.getDir(), valor)); // chamada recursiva a dir, atual recebe filho a dir
        } else { // se valor igual encontrou o nó a ser removido

            //remoção do nó sem filhos
            if (no.getEsq() == null && no.getDir() == null) { // verifica se o nó não tem filhos (folha)
                return null; // retorna o só null, removendo-o
            }

            //remoção de nó com apenas um filho a direita
            if (no.getEsq() == null) { // nó a ser removido tem apenas um filho direito
                return no.getDir(); // se sim, retorna o filho direito para substiruir o nó

            //remoção de nó com apenas um filho a esquerda
            } else if (no.getDir() == null) { // nó a ser removido tem apenas um filho esquerdo
                return no.getEsq(); // se sim, retorna o filho esquerdo para substiruir o nó
            }

            // remoção e nó com dois filhos
            No menorNo = encontrarMenorNo(no.getDir()); // encontra o nó de menor valor a direita do atual
            no.setValor(menorNo.getValor()); // altera o valor do atual pelo valor do sucessor encontrado
            no.setDir(remover(no.getDir(), menorNo.getValor())); // remove o nó que era sucessor
        }

        return no; // retorna o nó atual após a remoção, atualiza pai para o nó removido
    }

    void remover(int valor) { // encapsulamento do private remover, com todos os seus métodos de remoção
        raiz = remover(raiz, valor); // atualização raiz
    }

    public No buscar(No no, int valor) {
        if (no == null) {      // se o nó atual é nulo
            return null;    // retorna nulo, o valor não foi encontrado
        }
        if (no.getValor() == valor) {  // se o valor do nó atual é igual ao valor procurado
            return no;    //o valor foi encontrado
        }
        No noEsquerda = buscar(no.getEsq(), valor);  // se o valor não for igual, procura o valor na subárvore esquerda
        if (noEsquerda != null) { // se o valor foi encontrado na subárvore esquerda
            return noEsquerda;   // retorna o nó que contém o valor
        }
        return buscar(no.getDir(), valor);  // se o valor não for encontrado na subárvore esquerda, procura o valor na subárvore direita
    }
}