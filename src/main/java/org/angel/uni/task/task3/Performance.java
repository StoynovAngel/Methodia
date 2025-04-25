    package org.angel.uni.task.task3;
    
    import org.angel.uni.task.mapper.GsonConverter;
    
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    
    public class Performance {
    
        private static final int SIZE = 10_000_0000;
        private static List<Integer> list = generateBigArray(SIZE);

        public static void displayAll() {
            long duration = Performance.loopWithFor();
            printInConsoleFormated(duration);

            long durationWhile = Performance.loopWithWhile();
            printInConsoleFormated(durationWhile);

            long durationForIterator = Performance.loopWithIterator();
            printInConsoleFormated(durationForIterator);
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

        private static List<Integer> generateBigArray(int size) {
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            return list;
        }

        private static void printInConsoleFormated(double duration) {
            System.out.println("It takes time. Loading...");
            System.out.println("Duration: " + duration);
        }
    }
