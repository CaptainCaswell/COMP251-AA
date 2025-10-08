import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class ArrayBasedListRecord {
    public static void main( String[] args ) {
        try {
            PrintStream output = new PrintStream( new File( "ArrayBasedList.csv" ) );
            
            int maxTest = 1000000;

            String[] tests = { "add(value)",
                               "add(index+value)head", "add(index+value)", "add(index+value)tail",
                               "remove(index)head", "remove(index)", "remove(index)tail",
                               "remove(value)head", "remove(value)", "remove(value)tail",
                               "set(index+value)head", "set(index+value)", "set(index+value)tail",
                               "indexOf(value)head", "indexOf(value)", "indexOf(value)tail",
                               "get(index)head", "get(index)", "get(index)tail",
                               "contains(value)head", "contains(value)", "contains(value)tail",
                               "subList(fromIndex+toIndex)head", "subList(fromIndex+toIndex)", "subList(fromIndex+toIndex)tail" };

            // Generate header
            output.print( "List Size" );

            for (String test : tests) {
                output.print( "," + test );
            }

            // Iterate through test sizes
            for ( int n = 10; n <=maxTest; n *= 10 ) {

                output.print("\n" + n);

                for ( String test : tests ) {
                    output.print( "," + runTest(test, n) );
                }
            }

            output.close();
            System.out.println("Test complete!");

        } catch ( FileNotFoundException e) {
            System.out.println( "Error accessing file" );
        }
    }

    private static long runTest(String test, int n) {
        Random rand = new Random();
        
        long startTime, endTime, timeTaken;
        long timeAvg = 0;

        int runs = 20;
        
        // Do test 3 times
        for ( int i = 1; i <= runs; i++ ) {

            // Create test array with n entries for each run
            ArrayBasedList<Object> testList = new ArrayBasedList<>( n );
            
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
				testList.remove( n / 2 );
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

            else if (test.equals( "remove(value)head" ) ) {
                testList.set( 0, n + 100 );

                startTime = System.nanoTime();
                testList.remove( (Integer)( n + 100 ) );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "remove(value)" ) ) {
                testList.set( n / 2, n + 100 );

                startTime = System.nanoTime();
                testList.remove( (Integer)( n + 100 ) );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "remove(value)tail" ) ) {
                testList.set( tail, n + 100 );

                startTime = System.nanoTime();
                testList.remove( (Object)( n + 100 ) );
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
				testList.set( n / 2, num );
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


            else if (test.equals( "indexOf(value)head" ) ) {
                testList.set( 0, n + 100 );

                startTime = System.nanoTime();
				testList.indexOf( n + 100 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "indexOf(value)" ) ) {
                testList.set( n / 2, n + 100 );

                startTime = System.nanoTime();
				testList.indexOf( n + 100 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "indexOf(value)tail" ) ) {
                testList.set( tail, n + 100 );

                startTime = System.nanoTime();
				testList.indexOf( n + 100 );
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

            else if (test.equals( "contains(value)head" ) ) {
                testList.set( 0, n + 100 );

                startTime = System.nanoTime();
				testList.contains( n + 100 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "contains(value)" ) ) {
                testList.set( n/2, n + 100 );

                startTime = System.nanoTime();
				testList.contains( n + 100 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if (test.equals( "contains(value)tail" ) ) {
                testList.set( tail, n + 100 );

                startTime = System.nanoTime();
				testList.contains( n + 100 );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "subList(fromIndex+toIndex)head" ) ) {
                startTime = System.nanoTime();
				testList.subList( 0,num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "subList(fromIndex+toIndex)" ) ) {
                startTime = System.nanoTime();
				testList.subList( num / 2, num );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }

            else if ( test.equals( "subList(fromIndex+toIndex)tail" ) ) {
                startTime = System.nanoTime();
				testList.subList( num, tail );
				endTime = System.nanoTime();

				timeTaken = endTime - startTime;
				timeAvg += timeTaken;
            }
        }

        timeAvg = timeAvg / runs;
        
        return timeAvg;
    }
}
