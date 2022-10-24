package Model;

public class Poultry implements IAnimal{
    private float weight;

    public Poultry(float weight)
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
        return "Poultry with the weight: "+ this.weight+" kg.";
    }
}
