
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
    public static void main(String[] args) {
        
        try{
            GenericStack Stack1=new GenericStack();
            Scanner input=new Scanner(System.in);
            System.out.print("Enter the size of the stack: ");//at initial stage take input size and values for stack
            if(input.hasNextInt())
            {
            int x=input.nextInt();
            for(int i=0;i<x;i++)
            {
                System.out.print("Enter the values to push: ");
                if(input.hasNextInt())//if input is an integer
                {
                    Stack1.push(input.nextInt());
                }
                else if(input.hasNext())//if input is a String
                {
                    Stack1.push(input.next());
                }
                else if(input.hasNextFloat())//if input is a float
                {
                    Stack1.push(input.nextFloat());
                }
            }
            }else
            {
                   throw new InvalidInputException("Invalid input exception");
            }
        
        int option=0;
        while(true)
        {
            menu();
            System.out.print("Choose an option: ");
            if(input.hasNextInt())//if the option value is eneterd except integer
            {
            option=input.nextInt();
            if(option==1)
            {
                System.out.print("Enter the value to push: ");
                if(input.hasNextInt())//if input is an integer
                {
                    Stack1.push(input.nextInt());
                }
                else if(input.hasNext())//if input is a String
                {
                    Stack1.push(input.next());
                }
                else if(input.hasNextFloat())//if input is a float
                {
                    Stack1.push(input.nextFloat());
                }
            }
            else if(option==2)
            {
                try{
                    Stack1.pop();
                    System.out.println("The element popped successfully");
                }
                catch(EmptyStackException e)
                {
                System.out.println("Exception Message: Empty Stack Exception");
                }  
            }
            else if(option==3)
            {
                if(Stack1.isEmpty())
                {
                    System.out.println("Stack is Empty");
                }
                else
                {
                    System.out.println("Stack is not empty");
                }
            }
            else if(option==4)
            {
                System.out.println("The size of the stack is: "+Stack1.size());
            }
            else if(option==5)
            {
                Stack1.display(Stack1.gettop());
            }
            else if(option==6)
            {
                System.out.println("Program Exited!");
               break;
            }
            else
            {
                throw new InvalidInputException("Invalid input exception");
            }
            }
            else
            {
                throw new InvalidInputException("Invalid input exception");
            }
        }
        }
        catch( InvalidInputException | ExceptionHandling e)
        {
            System.out.println("Exception Message: "+e.getMessage());
        }
        finally{
            System.out.println("\nExecution completed successfully");
                }
    }
}
