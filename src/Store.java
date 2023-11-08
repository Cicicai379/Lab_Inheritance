import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;



public class Store {


    private ArrayList<CISItem> items = new ArrayList<CISItem>();
    public void addBook(Book book) {
        items.add(book);
    }
    public ArrayList<CISItem> getItems() {
        return items;
    }

    public void addPhone(Phone phone){
        items.add(phone);
    }
    public void updatePhonesLocation(String location){
        for(CISItem e:items){
            if(e.getClass() == Phone.class){
               e.setLocation(location);
            }
        }

    }
    public ArrayList<CISItem> getAllPhones() {
        ArrayList<CISItem> phones = new ArrayList<CISItem>();
        for(CISItem e:items){
            if(e.getClass() == Phone.class){
                phones.add(e);
            }
        }
        return phones;
    }
    public ArrayList<CISItem> getTypeItems(String itemType){
        ArrayList<CISItem> filteredItems = new ArrayList<>();

        for (CISItem e : items) {
            if (itemType.equalsIgnoreCase(String.valueOf(e.getClass()))) {
                filteredItems.add(e);
            }
        }
        return filteredItems;
    }

    public void updateItems(String itemType, String property, String value) {
        itemType = capitalize(itemType);
        property = capitalize(property);
        value = capitalize(value);
        for (CISItem e : items) {
            if (itemType.equalsIgnoreCase(e.getClass().getSimpleName())) {
                try {
                    Method setterMethod = e.getClass().getMethod("set" + (property), String.class);
                    setterMethod.invoke(e, value);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }
    public void showAllInfo(){
        for (CISItem e : items) {
            System.out.println("location: "+ e.getLocation()+" name: "+e.getName()
            +" price: "+e.getPrice()+" description: "+e.getDescription());
        }
    }

}


//TODO 13: Write a test to ensure that getItems() works correctly. Test it with more than one type of CISItem.
//        TODO 15: Make a test for updateItems that ensures it works correctly. Try a variety of combinations.
//

