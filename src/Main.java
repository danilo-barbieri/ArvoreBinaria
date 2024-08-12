import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) { // loop continua até que o usuário escolha a op 5
            System.out.println("\nMenu:");
            System.out.println("1. Inserir valor");
            System.out.println("2. Remover valor");
            System.out.println("3. Exibir árvore em ordem");
            System.out.println("4. Exibir árvore em pré-ordem");
            System.out.println("5. Exibir árvore em pós-ordem");
            System.out.println("6. Buscar valor");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    System.out.println("Valor inserido com Sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.remover(valorRemover);
                    System.out.println("Valor removido com Sucesso!");
                    break;

                case 3:
                    System.out.println("Árvore em ordem:");
                    arvore.emOrdem(arvore.getRaiz());
                    break;

                case 4:
                    System.out.println("Árvore em pré-ordem:");
                    arvore.preOrdem(arvore.getRaiz());
                    break;

                case 5:
                    System.out.println("Árvore em pós-ordem:");
                    arvore.posOrdem(arvore.getRaiz());
                    break;

                case 6:
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBuscar = scanner.nextInt();
                    No no = arvore.buscar(arvore.getRaiz(), valorBuscar);  // busca o valor na árvore, começando pela raiz
                    if (no != null) {                                      // se o valor foi encontrado
                        System.out.println("Valor encontrado!");
                        if (no.getEsq() == null && no.getDir() == null) {  // se o nó é uma folha (não tem filhos)
                            System.out.println("O nó é uma folha.");
                        } else if (no == arvore.getRaiz()) {                      // se o nó é a raiz da árvore
                            System.out.println("O nó é a raiz da árvore.");
                        } else {                                            // se o nó não é a raiz
                            System.out.println("O nó é um filho.");
                        }
                    } else {
                        System.out.println("Valor não encontrado!");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            Thread.sleep(2000);
            limparConsole();
        }

        scanner.close();
    }

    public static void limparConsole() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}