package Controller;

import Model.IAnimal;
import Model.Poultry;
import Model.Pig;
import Model.Cow;
import Repository.IRepository;

import java.util.Objects;

public class Controller {
    private IRepository repository;

    public Controller(IRepository repository){
        this.repository=repository;
    }
    public void add(IAnimal animal){
        this.repository.add(animal);
    }

    public void remove(int index){
        this.repository.remove(index);
    }

    public IAnimal[] getAnimals(){
        return this.repository.getAnimals();
    }

    public int getSize(){
        return this.repository.getSize();
    }

    public IAnimal[] filteredAnimals(float weight){
        IAnimal[] copy=new IAnimal[this.repository.getSize()];
        int size=0;
        for (IAnimal animal: this.repository.getAnimals())
            if(animal!=null)
                if (animal.getWeight()>weight)
                    copy[size++]=animal;
        IAnimal[] toBeReturned=new IAnimal[size];
        System.arraycopy(copy, 0, toBeReturned,0,size);
        return toBeReturned;
    }
}
