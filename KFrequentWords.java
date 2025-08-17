import java.util.*;


public class Main {

    public static List<String> topKFrequentWords(List<String> words, int k) {
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int freqCompare = freqMap.get(a) - freqMap.get(b);
            return freqCompare == 0 ? b.compareTo(a) : freqCompare;
        });

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); 
            }
        }

       
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "java", "code", "java", "chatgpt", "code", "java", "openai", "code"
        );
        int k = 2;
        List<String> topWords = topKFrequentWords(words, k);

        System.out.println("Top " + k + " frequent words:");
        for (String word : topWords) {
            System.out.println(word);
        }
    }
}
