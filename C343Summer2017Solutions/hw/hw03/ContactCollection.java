package c343hello;

import java.util.*;
import java.util.regex.*;
import java.io.*;

import android.content.res.AssetManager;
import android.app.Activity;

public class ContactCollection {

    private Activity gActivity;

    // use a List for contacts
    private List<Contact> contactList;
    // constructor
    public ContactCollection(Activity pActivity) throws IOException {
        //use LinkedList
        this.contactList = new LinkedList<Contact>();

        // debug: System.out.println("ContactCollection pActivity is " + pActivity);
        this.gActivity = pActivity;
        // debug: System.out.println("ContactCollection pActivity is " + pActivity);

        readContactsFile();
    }
    //get contacts from a file
    public void readContactsFile() throws IOException {

        // debug: System.out.println("readContactsFile A");

        // use Scanner and FileReader to read file:
        AssetManager assets = this.gActivity.getAssets();
        // debug: System.out.println("readContactsFile B");
        InputStream inStream = assets.open("contacts.txt");
        // debug: System.out.println("readContactsFile C");
        Scanner in = new Scanner(new InputStreamReader(inStream));
        // debug: System.out.println("readContactsFile D");

        while (in.hasNext()) {
            String line = in.nextLine();
            // use regular expression match to extract name of the writer & contact content.
            // compile the pattern
            Pattern p = Pattern.compile("^(\\S+)\\s+(\\S+)\\s+(.*)");
            //do the match
            Matcher m = p.matcher(line);
            if (m.find()) {
                String lFirst = m.group(1);
                String lLast = m.group(2);
                String lEmail = m.group(3);
                // debug: System.out.println("first: " + lFirst + " lLast: " + lLast + " lEmail: " + lEmail);
                Contact lContact = new Contact(lFirst, lLast, lEmail);
                contactList.add(lContact);
            }
        }
        in.close();
    }
    public Contact get(int index) {
        return contactList.get(index);
    }
    // a method to display the information
    public void summary() {
        System.out.println("Total contacts: " + contactList.size());
    }
    // main method
// /*   public static void main(String[] argv) throws IOException {
//        ContactCollection tc = new ContactCollection();
//        tc.summary();
//        Contact one = tc.get(0);
//        System.out.println("the contacts include: " + one.listing() );
//    }
//*/

}
