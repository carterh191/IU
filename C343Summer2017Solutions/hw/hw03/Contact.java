package c343hello;

/**
 * Created by mitja on 2017-05-20.
 */

public class Contact {

    private String first;
    private String last;
    private String email;
    public Contact(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
    }
    public String listing() {
        return first + " " + last + " " + email;
    }
    public boolean contains(String query) {
        return email.contains(query);
    }
///*    public static void main(String[] argv) {
//        Contact t = new Contact("Elena", "Rodriguez", "yoyo@shield.not");
//        System.out.println("contact created: " + t.listing());
//        String q = ".com";
//        System.out.println("the contact " + t.listing() + " is of type " + q + "? " + t.contains(q));
//        q = "shield";
//        System.out.println("the contact " + t.listing() + " is an agent of " + q + "? " + t.contains(q));
//    }*/


}
