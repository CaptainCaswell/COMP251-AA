import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class ArrayBasedListRecord {
    public static void main( String[] args ) {
        try {
            PrintStream output = new PrintStream( new File( "ArrayBasedList.csv" ) );
            
            //int[] testSize = { 10, 100 , 1000 , 10000, 100000, 1000000 };
            int[] testSize = { 10, 100 , 1000 , 10000 };

            String[] tests = { "add(value)",
                               "add(index+value)head", "add(index+value)", "add(index+value)tail",
                               "remove(index)head", "remove(index)", "remove(index)tail",
                               "remove(value)",
                               "set(index+value)head", "set(index+value)", "set(index+value)tail",
                               "indexOf(value)",
                               "get(index)head", "get(index)", "get(index)tail",
                               "contains(value)",
                               "subList(fromIndex+toIndex)head", "subList(fromIndex+toIndex)", "subList(fromIndex+toIndex)big", "subList(fromIndex+toIndex)tail" };

            // Generate header
            output.print( "List Size" );

            for (String test : tests) {
                output.print( "," + test );
            }

            // Iterate through test sizes
            for ( int n : testSize ) {

                output.print("\n" + n);

                for ( String test : tests ) {
                    output.print( "," + runTest(test, n) );
                }
            }

            output.close();
            System.out.println("Test complete!");

        } catch ( FileNotFoundException e) {
            System.out.println( "Error accessing timeData.txt" );
        }
    }

    private static long runTest(String test, int n) {
        Random rand = new Random();
        
        long startTime, endTime, timeTaken;
        long timeAvg = 0;

        int runs = 5;
        
        // Do test 3 times
        for ( int i = 1; i <= runs; i++ ) {

            // Create test array with n entries for each run
            ArrayBasedList<Object> testList = new ArrayBasedList<>();
            for ( int j = 0; j < n; j++ ) {
                testList.add( rand.nextInt( n ) );
            }

            System.out.println( "Running test " + test + " for size " + n );

            int num = rand.nextInt( n );
            int tail = n - 1;

            if (test.equals( "add(value)" ) ) {
                startTime = System.nanoTime();
				testList.add( num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }
            
            else if ( test.equals( "add(index+value)head" ) ) {
                startTime = System.nanoTime();
				testList.add( 0, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "add(index+value)" ) ) {
                startTime = System.nanoTime();
				testList.add( n / 2, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "add(index+value)tail" ) ) {
                startTime = System.nanoTime();
				testList.add( tail + 1, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals ( "remove(index)head" ) ) {
                startTime = System.nanoTime();
				testList.remove( 0 );
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

            else if (test.equals ( "remove(index)tail" ) ) {
                startTime = System.nanoTime();
				testList.remove( tail );
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

            else if (test.equals( "set(index+value)head" ) ) {
                startTime = System.nanoTime();
				testList.set( 0, num );
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

            else if (test.equals( "set(index+value)tail" ) ) {
                startTime = System.nanoTime();
				testList.set( tail, num );
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

            else if (test.equals( "get(index)head" ) ) {
                startTime = System.nanoTime();
				testList.get( 0 );
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

            else if (test.equals( "get(index)tail" ) ) {
                startTime = System.nanoTime();
				testList.get( tail );
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

            else if ( test.equals( "subList(fromIndex+toIndex)head" ) ) {
                startTime = System.nanoTime();
				testList.subList( 0, 0 );
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

            else if ( test.equals( "subList(fromIndex+toIndex)big" ) ) {
                startTime = System.nanoTime();
				testList.subList( 1, tail - 1 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "subList(fromIndex+toIndex)tail" ) ) {
                startTime = System.nanoTime();
				testList.subList( tail, tail );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }
        }

        timeAvg = timeAvg / runs;
        
        return timeAvg;
    }
}
