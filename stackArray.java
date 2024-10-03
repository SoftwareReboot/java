import java.util.*;

public class stackArray{
   private String[] s;
   private int counter;
   
   public stackArray(int size){
      s = new String[size];
      counter = 0;
   }
   
     public stackArray(){
      this(10);
   }
   
   private boolean isEmpty(){
      return counter == 0;
   }
   
   private boolean isFull(){
      return counter == s.length;
   }
   
   public boolean push(String value){
      if(!isFull()){
         s[counter++] = value;
         return true;
      }else
         return false;
   }
   
   public boolean pop(){
      if(!isEmpty()){
         s[counter - 1] = null;
         counter --;
         return true;
      }else
         return false;
   }

   public String peek(){
      if(!isEmpty()){
         return s[counter -1];
      }
      return null;
   }
   
   public void displayStack(){
      if(!isEmpty()){
         for(int i = counter - 1; i >= 0; i--){
            System.out.println(" [ " + s[i] + " ] ");
         }
      }
      else{
         System.out.println(" Stack is Empty.");
      }
}
}