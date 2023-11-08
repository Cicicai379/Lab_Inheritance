import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class StoreTester {




    @org.junit.jupiter.api.Test
    public void addBookTest() {
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(store.getItems().size()==1);
    }
    @org.junit.jupiter.api.Test
    public void  addBookAndAddPhoneTest() {
        Store store = new Store();
        Book book = new Book();
        Phone phone = new Phone();

        store.addBook(book);
        store.addPhone(phone);

        assertTrue(store.getItems().size()==2);
    }
    @org.junit.jupiter.api.Test
    public void  updatePhonesLocationTest() {
        Store store = new Store();
        Phone a = new Phone();
        Phone b = new Phone();
        Phone c = new Phone();

        store.addPhone(a);
        store.addPhone(b);
        store.addPhone(c);

        store.updatePhonesLocation("Room 514");
        ArrayList<CISItem> phones = store.getAllPhones();
        for(CISItem somePhone: phones){
            assertEquals(somePhone.getLocation(), "Room 514");
        }
    }

    @org.junit.jupiter.api.Test
    public void  getItemsTest() {
        Store store = new Store();
        Phone a = new Phone();
        Phone b = new Phone();
        Book c = new Book();

        store.addPhone(a);
        store.addPhone(b);
        store.addBook(c);

        store.updatePhonesLocation("Room 514");
        ArrayList<CISItem> phones = store.getTypeItems("phone");

        for(CISItem e: phones){
            assertTrue(e.getClass().getSimpleName().equals("Phone"));
        }
    }


    @org.junit.jupiter.api.Test
    public void  updateItems() {
        Store store = new Store();
        Phone a = new Phone();
        Phone b = new Phone();
        Book c = new Book();

        store.addPhone(a);
        store.addPhone(b);
        store.addBook(c);

        store.updateItems("phone","location","Room 514");

        for(CISItem e: store.getItems()){
            if(e.getClass().getSimpleName().equals("Phone")){
                assertTrue(e.getLocation().equals("Room 514"));
            }
        }
    }

//            TODO 15: Make a test for updateItems that ensures it works correctly. Try a variety of combinations.



}
