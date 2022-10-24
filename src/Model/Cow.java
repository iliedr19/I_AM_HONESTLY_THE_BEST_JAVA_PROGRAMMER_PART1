package Model;

public class Cow implements IAnimal{
    private float weight;

    public Cow(float weight)
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
        return "Cow with the weight: "+ this.weight+" kg.";
    }

}