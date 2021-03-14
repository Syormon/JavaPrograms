/**	Uses input to add to an	list and display 
 *  # of items and then # of compares
 *
 *	@author		Simon Spivey
 *	@id			
 *	@course		CSIS 252: Programming II
 *	@assignment	Advanced Storage Lab
 */

import java.util.*;

public class Storage {
    // initialzing variables
    ListInterface list;
    Person person;
    IOHandler IO;
    int itemCounter;
    boolean run;
   
    // we have these @params so that we can use the command IO to chose which
    // type of list to use and we have IOHandler so that we can do either
    // Run I/O or a text file
    public Storage(ListInterface list, IOHandler	IO)	{
	    this.list = list;
	    this.IO = IO;
	    run = true; 
        itemCounter = 0;
    }

	// main	run	file 
	public void	run() {
		while(run) {
			String tempName, tempEmail, temp1, temp2;
			int	tempSsn;
            // here were are seperating the input
            temp1 = IO.next();
            temp2 = IO.next();
            
            tempName = (temp1 + " " + temp2);
            tempSsn = IO.nextInt();
            tempEmail = IO.next();
            // if there is no input quit
            if	(!IO.hasNext())	{
    			break;
    		}
            IO.nextLine();
			// goto next line
			person = new Person(tempName, tempSsn, tempEmail);
			// create a new person object
			if (!list.find(person))	{
				list.add(person); 
			}
            // if we don't find the person in the list already, add him
            itemCounter++;
            //counts the number of items
		 
		    //	numRanges is the Amount	of Ranges we have and 
    		//	returnCompare is the amount	of compares	we do 
    		IO.println(itemCounter + "\t"	+ list.returnCompare());
    		 
    		//	only quits if we have a	text file where	we get to the end
    		if	(!IO.hasNext())	{
    		    run	= false;
    		}
	    }

    }

}