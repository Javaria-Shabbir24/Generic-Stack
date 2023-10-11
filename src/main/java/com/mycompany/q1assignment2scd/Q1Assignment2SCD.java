
package com.mycompany.q1assignment2scd;
import java.util.EmptyStackException;
import java.util.Scanner;
//node class
class Node<T>
{
    T data;
    Node<T> next;
    //constructor
    public Node(T data)
    {
        this.data=data;
        this.next=null;
    }
}
//generic class
class GenericStack<T>
{
    private Node<T> top;//top of node type
    private int sizeOfStack;
    public GenericStack()
    {
        sizeOfStack=0;
        top=null;//top pointing to null in very stack 
    }
    //push function
    public void push(T item)
    {
        //create a new node 
        Node<T> newnode=new Node<>(item);
        //as it is stack will point new node to previous node
        newnode.next=top;
        //top will point to this new node
        top=newnode;
        //increment size of stack
        sizeOfStack++;
        System.out.println(item+" pushed in the stack successfully");
    }
    //pop function
    public T pop()
    {
        if(this.isEmpty())
        {
          throw new EmptyStackException();
        }
        T item=top.data;
        top=top.next;//delete that node
        sizeOfStack--;//reduce size 
        return item;//return top most element
    }
    //get top funtion 
    Node<T> gettop()
    {
        return this.top;
    }
    //isempty function
    public boolean isEmpty()
    {
        if(sizeOfStack==0)
        {
            return true;
        }
        return false;
    }
    //size function returns number of elements
    public int size()
    {
        return sizeOfStack;
    }
    //display function
    public void display(Node<T> top)
    {
        System.out.print("Stack is: ");
        if(top!=null)
        {
        Node<T> Iterator=top;
        while(Iterator.next!=null)
        {
            System.out.print(Iterator.data+" ");
            Iterator=Iterator.next;
        }
            System.out.println(Iterator.data);
        }
        else
        {
            System.out.println("Stack is empty");
        }
    }
}
//exception handling class extends built in run time exception
class ExceptionHandling extends RuntimeException
{
    public ExceptionHandling(String Message)
    {
        super(Message);
    }
}
//invalid input exception
class InvalidInputException extends Exception { //explicitly declared
    public InvalidInputException(String message) {
        super(message);
    }
}
//main class
public class Q1Assignment2SCD {
    
       
        static void menu()
        {
            System.out.println("1.Push an element\n2.Pop an element\n3.Check if stack is empty");
            System.out.println("4.Get size of stack\n5.Display stack\n6.Exit");
        }
}
