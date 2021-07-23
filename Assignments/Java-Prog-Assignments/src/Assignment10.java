import java.util.*;

public class Assignment10 {
    public static void main(String[] args) {
        SList<String> slist = new SList<String>();

        Scanner scanner = new Scanner(System.in);

        SListIterator<String> iterator = slist.iterator();
        int flag=0;
        while (true) {
            System.out.println("Select from the options mentioned below:\n1. Insert\n2. Delete\n3. Display\n4.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: iterator.insert(scanner.nextLine()); break;
                case 2: iterator.remove(); break;
                case 3: System.out.println(slist); break;
                case 4: flag=1; break;
                default: System.out.println("Invalid Choice"); break;
            }
            if(flag==1){
                break;
            }
        }

    }
}

//Node base
class Node<T>{
    T data;
    Node<T> next;
    Node(T data, Node<T> next){
        this.data=data;
        this.next=next;
    }
    Node(T data){
        this(data,null);
    }
    @Override
    public String toString(){
        if(data == null)
            return "null";
        return data.toString();
    }
}

//SList operations
class SListIterator<T> {
    Node<T> head;
    Node<T> curr;
    SListIterator(Node<T> next){
        curr = next;
        head = next;
    }
    public boolean hasNext(){
        return curr.next!=null;
    }
    public Node<T> next(){
        curr = curr.next;
        return curr;
    }
    public void insert(T data){
        curr.next = new Node<T>(data, curr.next);
        curr = curr.next;
    }
    public void remove(){
        Node temp =head;
        while(temp.next!=curr){
            temp = temp.next;
        }
        temp.next=null;
        curr=temp;
    }
}

//Singly linked list implementation
class SList<T> {
    Node<T> head = new Node<T>(null);
    public SListIterator<T> iterator(){
        return new SListIterator<T>(head);
    }
    public String toString(){
        if(head.next == null)
            return "Empty List";
        SListIterator <T> it = this.iterator();
        String result = new String();
        while (it.hasNext()){
            result = result.concat(it.next() + (it.hasNext()?", ":""));
        }
        return result;
    }
}