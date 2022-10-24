package Repository;

import Model.IAnimal;

public class Repository implements IRepository{
    private IAnimal[] animals;
    private int animalsCount;

    public Repository(int size)
    {
        if(size<=0){
            throw new ArithmeticException("The capacity of the repository cannot be 0 or less");
        }
        this.animals=new IAnimal[size];
        this.animalsCount=0;
    }
    public void resize(){
        IAnimal[] newAnimals=new IAnimal[this.animalsCount*2];
        System.arraycopy(this.animals,0,newAnimals,0,this.animals.length);
        this.animals=newAnimals;
    }

    @Override
    public void add(IAnimal animal)
    {
        if(this.animalsCount==this.animals.length){
            this.resize();
        }
        this.animals[this.animalsCount]=animal;
        this.animalsCount++;
    }

    @Override
    public void remove(int index){
        IAnimal[] animalCopy=new IAnimal[this.animalsCount-1];
        for (int i=0, j=0;i<this.animalsCount;i++){
            if(i!=index){
                animalCopy[j]=this.animals[i];
                j++;
            }
        }
        this.animals=animalCopy;
        this.animalsCount--;
    }

    @Override
    public IAnimal[] getAnimals(){
        return this.animals;
    }

    @Override
    public int getSize(){
        return this.animalsCount;
    }


}
