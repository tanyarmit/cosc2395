/** this is the class you can use to test some methods before you create a menu*/
public class TestShoppingList{
  public static void main(String[] args){
    ShoppingList sl = new ShoppingList();
    Item it = new Item("jeans", 120.0, 1);
    System.out.println(it);  
    System.out.println("price is " + it.getPrice());
    it.setPrice(200.0);
   System.out.println("price now " + it.getPrice() + " is too big" );
    //test method addItem
    //sl.addItem();
    //sl.listItems();
    //show the whole array list 
    System.out.println(sl.list);
    sl.addItems();
    System.out.println(sl.list);
    
  }
}