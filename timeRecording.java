import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class timeRecording {
    public static void main( String[] args ) {
        try {
            PrintStream output = new PrintStream( new File( "timeData.csv" ) );
            

            //int[] testSize = { 10, 100, 1000, 10000, 100000, 250000 };
            int[] testSize = { 10, 100 , 1000 , 10000, 100000, 1000000 };
            String[] tests = { "add(value)", "add(index+value)", "remove(index)", "remove(value)", "set(index+value)", "indexOf(value)", "get(index)", "contains(value)", "subList(fromIndex+toIndex)" };

            // Generate header
            output.print( "List Size" );

            for (String test : tests) {
                output.print( "," + test );
            }

            // Iterate through test sizes
            for ( int n : testSize ) {

                output.print("\n" + n);

                for ( String test : tests ) {
                    System.out.println( test );
                    output.print( "," + runTest(test, n) );
                }
            }


        } catch ( FileNotFoundException e) {
            System.out.println( "Error accessing timeData.txt" );
        }
    }

    private static long runTest(String test, int n) {
        Random rand = new Random();
        
        long startTime, endTime, timeTaken;
        long timeAvg = 0;

        int runs = 10;
        
        // Do test 3 times
        for ( int i = 1; i <= runs; i++ ) {

            // Create test array with n entries for each run
            SinglyLinkedList<Object> testList = new SinglyLinkedList<>();
            for ( int j = 0; j < n; j++ ) {
                testList.add( rand.nextInt( n ) );
            }

            int num = rand.nextInt( n );

        
            if (test.equals( "add(value)" ) ) {
                startTime = System.nanoTime();
				testList.add( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;

                System.out.println( "Start: " + startTime + ", End: " + endTime + ", Taken: " + timeTaken + ", Average: " + timeAvg );
            }

            else if ( test.equals( "add(index+value)" ) ) {
                startTime = System.nanoTime();
				testList.add( n / 2, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals ( "remove(index)" ) ) {
                startTime = System.nanoTime();
				testList.remove( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "remove(value)" ) ) {
                startTime = System.nanoTime();
				testList.remove( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "set(index+value)" ) ) {
                startTime = System.nanoTime();
				testList.set( num, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }


            else if (test.equals( "indexOf(value)" ) ) {
                startTime = System.nanoTime();
				testList.indexOf( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "get(index)" ) ) {
                startTime = System.nanoTime();
				testList.get( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "contains(value)" ) ) {
                startTime = System.nanoTime();
				testList.contains( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "subList(fromIndex+toIndex)" ) ) {
                startTime = System.nanoTime();
				testList.subList( n / 4, ( 3 * n ) / 4 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }
        }

        timeAvg = timeAvg / runs;
        
        return timeAvg;
    }
}
