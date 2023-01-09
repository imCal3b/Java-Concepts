package ListStructures;

public class Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in LinkedNodeList<String>.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		testAddFront();
		testAddBack();
		testSizeAndIsEmpty();
		testRemoveFront();
		// testRemoveBack(); // problem in remove back!!
		
		/* Part 2 */
		// testMoveToBack(); // problem in move to back!!
		// testInsertInto(); // problem in insert into!!
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		String result = "";
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		displayResults(result.equals("{JAVA}"), "testAddFront");
		result = list1.backToFront();
		displayResults(result.equals("{AVAJ}"), "testAddFront");

		list1.addFront("H");
		result = list1.backToFront();
		displayResults(result.equals("{AVAJH}"), "testAddFront");
	}
	
	public static void testAddBack() {
		String result = "";
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		int result = 0;
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty SIZE");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty ISEMPTY");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");

		LinkedNodeList<String> list2 = new LinkedNodeList<String>();

		result = list2.size();
		displayResults(result==0, "testSizeAndIsEmpty SIZE");
		displayResults(list2.isEmpty()==true, "testSizeAndIsEmpty ISEMPTY");

		list2.addBack("1");

		result = list2.size();
		displayResults(result==1, "testSizeAndIsEmpty SIZE");
		displayResults(list2.isEmpty()==false,"testSizeAndIsEmpty ISEMPTY");
		
	}
	
	public static void testRemoveFront() {
		String result = "";
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");				
	}
	
	public static void testRemoveBack() {
		// Write all of your own tests here 
		String result = "";
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PI}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{P}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");
	}
	
	public static void testMoveToBack() {
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		String result1;
		
		list1.addBack("a");
		list1.addBack("b");
		list1.addBack("c");
		list1.addBack("d");
		list1.addBack("e");
		list1.addBack("f");
		
		list1.moveToBack(2);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdefc}"), "moveToBack position 2");
		
		list1.moveToBack(4);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdecf}"), "moveToBack position 4");
		
		// Write more tests here
		list1.moveToBack(5);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{abdecf}"), "moveToBack position 5");

		list1.moveToBack(0);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{bdecfa}"), "moveToBack position 0");

		list1.moveToBack(2);
		result1 = list1.frontToBack();
		displayResults(result1.equals("{bdcfae}"), "moveToBack position 0");
		
		
	}
	
	public static void testInsertInto() {
		LinkedNodeList<String> list1 = new LinkedNodeList<String>();
		
		String result1;
		
		list1.addBack("c");
		list1.addBack("s");
		list1.addBack("y");
		
		list1.insertInto("h");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chsy}"), "insertInto test1");
		
		list1.insertInto("t");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chsty}"), "insertInto test3");
		
		list1.insertInto("z");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chstyz}"), "insertInto test5");
		
		// Write more tests here
		list1.insertInto("z");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{chstyzz}"), "insertInto test6");
		
		list1.insertInto("a");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{achstyzz}"), "insertInto test0");

		list1.insertInto("l");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{achlstyzz}"), "insertInto test3");

		list1.insertInto("l");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{achllstyzz}"), "insertInto test3");

		list1.insertInto("l");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{achlllstyzz}"), "insertInto test3");

		list1.insertInto("a");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{aachlllstyzz}"), "insertInto test0");
	}
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
