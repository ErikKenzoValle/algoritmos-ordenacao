import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MedicaoTempoAlgoritmosOrdenacao {

    // Gerador de array aleatório
    private static int[] gerarArrayAleatorio(int tamanho) {
        Set<Integer> set = new HashSet<>();  // Foi usado um Set para garantir a unicidade dos elementos
        Random random = new Random();

        // Preenche o Set até atingir o tamanho desejado
        while (set.size() < tamanho) {
            // Gerando números no intervalo de -9.999.999 a 9.999.999
            set.add(random.nextInt(19_999_999) - 9_999_999);
        }

        // Converte o Set para um array
        int[] array = new int[tamanho];
        int index = 0;
        for (Integer numero : set) {
            array[index++] = numero;
        }

        return array;
    }

    // Função para printar os tempos de cada algoritmo de ordenação
    private static void printarDuracao(String algoritmo, long inicio, long fim) {
        long duracaoNano = fim - inicio;
        double duracaoMili = duracaoNano / 1_000_000.0;
        double duracaoSeg = duracaoNano / 1_000_000_000.0;

        System.out.printf("%s - Tempo de execução em nanosegundos: %d%n", algoritmo, duracaoNano);
        System.out.printf("%s - Tempo de execução em milissegundos: %.5f%n", algoritmo, duracaoMili);
        System.out.printf("%s - Tempo de execução em segundos: %.8f%n", algoritmo, duracaoSeg);
    }

    public static void main(String[] args) {
        // Tamanhos de array a serem testados: 100, 1000, 10000, 50000 e 100000
        int[] tamanhos = {100, 1_000, 10_000, 50_000, 100_000};

        for (int tamanho : tamanhos) {
            int[] array = gerarArrayAleatorio(tamanho);
            System.out.println("\nTestando com array de tamanho: " + tamanho);

            // Teste Selection Sort
            //Está sendo realizada a cópia do array antes de realizar todos os algoritmos, pois o array original ficará ordenado
            int[] arraySelection = Arrays.copyOf(array, array.length);
            long inicio = System.nanoTime();
            AlgoritmosOrdenacao.selectionSort(arraySelection);
            long fim = System.nanoTime();
            printarDuracao("Selection Sort", inicio, fim);

            // Teste Insertion Sort
            int[] arrayInsertion = Arrays.copyOf(array, array.length);
            inicio = System.nanoTime();
            AlgoritmosOrdenacao.insertionSort(arrayInsertion);
            fim = System.nanoTime();
            printarDuracao("Insertion Sort", inicio, fim);

            // Teste Bubble Sort
            int[] arrayBubble = Arrays.copyOf(array, array.length);
            inicio = System.nanoTime();
            AlgoritmosOrdenacao.bubbleSort(arrayBubble);
            fim = System.nanoTime();
            printarDuracao("Bubble Sort", inicio, fim);

            // Teste Merge Sort
            int[] arrayMerge = Arrays.copyOf(array, array.length);
            inicio = System.nanoTime();
            AlgoritmosOrdenacao.mergeSort(arrayMerge);
            fim = System.nanoTime();
            printarDuracao("Merge Sort", inicio, fim);

            // Teste Quick Sort
            int[] arrayQuick = Arrays.copyOf(array, array.length);
            inicio = System.nanoTime();
            AlgoritmosOrdenacao.quickSort(arrayQuick, 0, arrayQuick.length - 1);
            fim = System.nanoTime();
            printarDuracao("Quick Sort", inicio, fim);

            // Teste Heap Sort
            int[] arrayHeap = Arrays.copyOf(array, array.length);
            inicio = System.nanoTime();
            AlgoritmosOrdenacao.heapSort(arrayHeap);
            fim = System.nanoTime();
            printarDuracao("Heap Sort", inicio, fim);
        }
    }
}
