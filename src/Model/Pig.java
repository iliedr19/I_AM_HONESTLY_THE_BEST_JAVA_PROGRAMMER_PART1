package Model;

public class Pig implements IAnimal{
    private float weight;

    public Pig(float weight)
    {
        this.weight=weight;
    }

    @Override
    public float getWeight()
    {
        return this.weight;
    }

    @Override
    public void setWeight(float weight){
        this.weight=weight;
    }

    @Override
    public String toString(){
        return "Pig with the weight: "+ this.weight+" kg.";
    }
}