package View;

import Controller.Controller;
import Exceptions.MyException;
import Model.IAnimal;
import Model.Poultry;
import Model.Pig;
import Model.Cow;

import java.util.Objects;
import java.util.Scanner;

public class View {
    private final Controller controller;

    public View(Controller controller)
    {
        this.controller=controller;
    }

    private static void printMenu(){
        System.out.println("---Menu--- \n Choose any option from below: ");
        System.out.println("1. Display all animals");
        System.out.println("2. Add an animal");
        System.out.println("3. Remove an animal");
        System.out.println("4. Display all animals that are heavier than a given amount of kgs.");
        System.out.println("5. Exit");
        System.out.println("Option: ");
    }

    private void displayAnimals(){
        IAnimal[] animals=this.controller.getAnimals();
        if (this.controller.getSize()==0){
            System.out.println("There are no animals!");
        }
        else{
            int index;
            for(index=0;index<this.controller.getSize();index++){
                System.out.println((index+1)+". "+animals[index].toString());
            }
        }
    }

    private void addAnimals() throws MyException{
        System.out.println("Enter type: ");
        Scanner readType=new Scanner(System.in);
        String type=readType.nextLine();
        if(Objects.equals(type, "poultry")||Objects.equals(type,"pig")||Objects.equals(type, "cow")){
            System.out.println("Enter weight: ");
            Scanner readWeight=new Scanner(System.in);
            float weight=readWeight.nextFloat();

            if(weight<=0){
                throw new MyException("Invalid weight, it has to be higher than 0");
            }
            else
            {
                if(Objects.equals(type, "poultry")){
                    Poultry poultry=new Poultry(weight);
                    this.controller.add(poultry);
                }
                else if(Objects.equals(type, "pig")){
                    Pig pig=new Pig(weight);
                    this.controller.add(pig);
                }
                else if(Objects.equals(type, "cow")){
                    Cow cow=new Cow(weight);
                    this.controller.add(cow);
                }
            }
        }
        else{
            throw new MyException("It has to be a poultry, cow or pig");
        }
    }

    private void removeAnimals() throws MyException{
        if(this.controller.getSize()!=0){
            System.out.println("Enter index: ");
            Scanner readIndex=new Scanner(System.in);
            int index=readIndex.nextInt();
            if (index-1>=0&&index-1<this.controller.getSize()){
                this.controller.remove(index-1);
            }
            else{
                throw new MyException("There is no animal at this index");
            }
        }
        else{
            throw new MyException("There are no animals, so you can not remove");
        }
    }

    private void displayFilteredAnimals() throws MyException{
        System.out.println("Enter weight: ");
        Scanner readWeight=new Scanner(System.in);
        float weight=readWeight.nextFloat();
        if(weight<=0){
            throw new MyException("Weight can not be lower than 0");
        }
        else{
            if(this.controller.getSize()!=0){
                IAnimal[] filteredSAnimals=this.controller.filteredAnimals(weight);
                if(filteredSAnimals.length==0){
                    System.out.println("There are no animals heavier than "+weight+" kg");
                }
                else{
                    int index;
                    for (index=0;index<filteredSAnimals.length;index++)
                    {
                        System.out.println((index+1)+". "+filteredSAnimals[index].toString());
                    }
                }
            }else{
                throw new MyException("The list is empty, there are no animals at all");
            }
        }
    }
    public void start(){
        boolean done=false;
        while(!done){
            try{
                printMenu();
                Scanner readOption=new Scanner(System.in);
                int option= readOption.nextInt();
                if (option==1)
                    this.displayAnimals();
                else if (option==2)
                    this.addAnimals();
                else if (option==3)
                    this.removeAnimals();
                else if (option==4)
                    this.displayFilteredAnimals();
                else if (option==5)
                    done=true;
                else
                    System.out.println("Choose an option from 1 to 5");
            }
            catch(Exception myException){
                System.out.println(myException.getMessage());
            }
        }
    }
}

