public class ArrayBasedListTest {
    public static void main( String[] args ) {
        ArrayBasedList<Object> testList = new ArrayBasedList<>();



        testList.add( 0 );
        testList.add( 1 );
        testList.add( 2 );
        testList.add( 3 );
        testList.add( 4 );
        testList.add( 5, 5 );
        testList.add( 0, -1 );
        testList.add( 4, 99 );

        System.out.println(testList);

        System.out.println( "Removing: " + testList.remove(0) );

        System.out.println(testList);
    
        System.out.println( "Removing: " + testList.remove(2) );

        System.out.println(testList);

        //System.out.println( "Removing: " + testList.remove(5) );

        Integer x = 99; // Used to access overloaded remove(T value)
        System.out.println( "Removing: " + testList.remove(x) );

        System.out.println(testList);

        testList.set( 0, -2);

        System.out.println(testList);

        System.out.println( testList.indexOf( 99 ) );
        System.out.println( testList.indexOf( 100 ) );

        System.out.println( testList.get( 0 ) );
        System.out.println( testList.size() );

        testList.add ( 0 );
        testList.add ( 1 );
        testList.add ( 2 );
        testList.add ( 3 );
        testList.add ( 4 );
        testList.add ( 5 );
        testList.add ( 6 );
        testList.add ( 7 );

        System.out.println( testList );

       System.out.println( testList.subList( 0,3 ) );

    }
}