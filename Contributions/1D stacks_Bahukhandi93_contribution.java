/*
Program to declare stack, push, pop elements from stack, and sort the stack using Bubble sort [Last In First Out]
Bahukhandi93
*/

import java.util.Scanner;

public class StackS {
    static Scanner sc=new Scanner(System.in);
    static int n,ctr=-1;  //n=size of array, ctr= counter to record
    static int[] arr; //stack to be declared
    public static void main(String[] args) {
        System.out.println("Enter the size of stack:");
        n=sc.nextInt();
        arr=new int[n]; //Declaring the stack in the form of an array of size n

        options(); //Calling options method
    }

    private static void options() //method to choose what action to take on the stack
    {
        System.out.println("\n\nChoose an option (END to stop):\n1.Push an element\n2.Pop an element\n3.Display the stack\n4.Sort the stack\n5.End");
        int a=sc.nextInt(); //The user's choice
        switch(a)  //switch case for the options
        {
            case 1: push();
                    options();
                    break;
            case 2: pop();
                    options();
                    break;
            case 3: display();
                    options();
                    break;
            case 4: sort();
                    options();
                    break;
            case 5: break;
            default:System.out.println("Invalid option!"); //In the case of an invalid input by the user
                    options();
        }
    }

    private static void display() //Method to display the stack array
    {
        System.out.println("The stack:");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+"\t");
    }

    private static void pop() //Method to pop an element from the stack
    {
        if(ctr<0)
            System.out.println("\nStack Underflow!!  :(");
        else
        {
            for(int i=0;i<n-1;i++) //Shifting all the elements by 1 index
                arr[i]=arr[i+1];
            arr[ctr]= 0;   //
            ctr--;
        }
    }

    private static void push() //method to push an element into the stack
    {
        if(ctr==n-1)
        {
            System.out.println("\nStack Overflow!!  :(");
        }
        else
        {
            ctr++;
            for(int i=n-2;i>=0;i--)
                arr[i+1]=arr[i];
            System.out.println("Enter the element (NOT 0) you want to insert:");
            arr[0]=sc.nextInt();
        }
    }

    private static void sort() //Method to sort the array using Bubble sort
    {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
