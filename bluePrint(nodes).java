package nodePrac;
public class stackList {
    // define sa una ang stackNode
    private class stackNode{
        String data;
        stackNode tail;

        //constructor dayun
        public stackNode(String data){
            this.data = data;
            this.tail = tail;
        }
    }

    private  stackNode top;
    private int counter;

    public stackList(){
        top = null;
        counter = 0;
    }

    private boolean isEmpty(){
        return counter == 0;
    }

    public boolean push(String data){
        stackNode node = new stackNode(data);
        node.tail = top;// reference ni para mo Point the new node's tail to the current top
        top = node;// para mo  Update top to be the new node
        counter ++;// increment
        return true;
    }

    public boolean pop(){
        if (!isEmpty()) { // kong dili siya empty
            top = top.tail;// para ma move ang top  sa item na ubos niya
            counter --;// decrement
            return true; // if ni meet sa condition then true
        }else{
            return false; //kong wala false
        }
    }

    public String peek(){
        if (!isEmpty()) {//mo get siya sa top kong nay sud 
            return top.data;// gi return ang value sa top
        }else{
            return null; // return null(way sud) kong wala 
        }
    }

    public int getCounter(){
        return counter;// return ra counter lahos
    }

    public void display(){
        if (!isEmpty()) {// mo display basta dili empty
            stackNode temp = top;// para mo start tas top
            while (temp != null) {// while loop to go through items
                System.out.println(temp.data);//para ma print ang value sa mga item;
                temp = temp.tail;// para ma move to the next item
            }
            System.out.println();// wala rani
        }else{
            System.out.println(" Stack is Empty!");// mo display kong walay sud 
        }
    }
    
}
