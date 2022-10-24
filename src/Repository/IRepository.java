package Repository;

import Model.IAnimal;

public interface IRepository {
    void add(IAnimal animal);
    void remove(int index);
    IAnimal[] getAnimals();
    int getSize();
}
