    package org.angel.uni.task.task3;
    
    import org.angel.uni.task.mapper.GsonConverter;
    
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    
    public class Performance {
    
        private static final int SIZE = 10_000_0000;
        private static List<Integer> list = generateBigArray(SIZE);
        private static final double NANO_IN_SECONDS = 1_000_000_000.0;
    
        public static List<Integer> generateBigArray(int size) {
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            return list;
        }
    
        public static long loopWithFor() {
    
            long startTime = System.nanoTime();
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
            }
            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    
        public static long loopWithWhile() {
            long startTime = System.nanoTime();
            int index = 0;
            while (index <= list.size() - 1) {
                int num = list.get(index);
                index++;
            }
            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    
        public static long loopWithIterator() {
            long startTime = System.nanoTime();
            Iterator<Integer> iterator = list.iterator();
    
            while (iterator.hasNext()) {
                int num = iterator.next();
            }
            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    
        private static void printInConsoleFormated(double duration) {
            System.out.println("Duration: " + duration + " seconds");
        }
    
        public static void main(String[] args) {
            long duration = Performance.loopWithFor();
            double durationInSeconds = duration / NANO_IN_SECONDS;
            printInConsoleFormated(durationInSeconds);
    
            long durationWhile = Performance.loopWithWhile();
            double durationWhileInSeconds = durationWhile / NANO_IN_SECONDS;
            printInConsoleFormated(durationWhileInSeconds);
    
            long durationForIterator = Performance.loopWithIterator();
            double durationIteratorInSeconds =  durationForIterator / NANO_IN_SECONDS;
            printInConsoleFormated(durationIteratorInSeconds);
        }
    }
