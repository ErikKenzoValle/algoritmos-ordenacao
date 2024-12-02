public class AlgoritmosOrdenacao {

    /**
     * 1. Selection Sort
     * Algoritmo que encontra o menor elemento e o posiciona no início da lista.
     * Complexidade: O(n^2)
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Índice do menor elemento
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Atualiza o índice do menor elemento
                }
            }
            // Troca o menor elemento encontrado com o elemento na posição i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 2. Insertion Sort
     * Algoritmo que constrói o array final um elemento por vez.
     * Complexidade: O(n^2)
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i]; // Elemento a ser inserido na posição correta
            int j = i - 1;
            // Move elementos maiores que a chave para uma posição à frente
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key; // Insere a chave na posição correta
        }
    }

    /**
     * 3. Bubble Sort
     * Algoritmo que compara elementos adjacentes e os troca se estiverem fora de ordem.
     * Complexidade: O(n^2)
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Troca elementos adjacentes fora de ordem
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            n--; // Reduz o número de elementos a serem verificados
        } while (swapped); // Continua enquanto houver trocas
    }

    /**
     * 4. Merge Sort
     * Algoritmo que divide o array em partes menores, ordena-as e as mescla.
     * Complexidade: O(n log n)
     */
    public static void mergeSort(int[] array) {
        if (array.length < 2) return; // Caso base: array com 1 elemento já está ordenado
        int mid = array.length / 2; // Encontra o meio do array
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Copia elementos para os subarrays esquerdo e direito
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left); // Ordena o subarray esquerdo
        mergeSort(right); // Ordena o subarray direito

        merge(array, left, right); // Mescla os subarrays ordenados
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        // Mescla elementos dos subarrays esquerdo e direito em ordem crescente
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        // Copia os elementos restantes, se houver, do subarray esquerdo
        while (i < left.length) {
            array[k++] = left[i++];
        }
        // Copia os elementos restantes, se houver, do subarray direito
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    /**
     * 5. Quick Sort
     * Algoritmo que divide o array em torno de um pivô e ordena recursivamente.
     * Complexidade: O(n log n) em média
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high); // Encontra o índice de partição
            quickSort(array, low, pi - 1); // Ordena a parte à esquerda do pivô
            quickSort(array, pi + 1, high); // Ordena a parte à direita do pivô
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Escolhe o último elemento como pivô
        int i = low - 1; // Índice do menor elemento
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Troca elementos menores que o pivô
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Troca o pivô com o elemento na posição correta
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1; // Retorna o índice de partição
    }

    /**
     * 6. Heap Sort
     * Algoritmo que utiliza um heap para ordenar os elementos.
     * Complexidade: O(n log n)
     */
    public static void heapSort(int[] array) {
        int n = array.length;

        // Constrói o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move o maior elemento (raiz) para o final do array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0); // Reconstroi o heap com os elementos restantes
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Inicializa o maior elemento como raiz
        int left = 2 * i + 1; // Índice do filho esquerdo
        int right = 2 * i + 2; // Índice do filho direito

        if (left < n && array[left] > array[largest]) {
            largest = left; // Atualiza o maior elemento se necessário
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            // Troca a raiz com o maior elemento
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Reconstroi o heap para o nó afetado
            heapify(array, n, largest);
        }
    }
}
