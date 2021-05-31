package at.ac.univie.team17.mariaDB.mariaDBmodels;

public class Pet
{
    private int petId;
    private String petName;
    private int goldPrice;

    public Pet(int petId, String petName, int goldPrice)
    {
        this.petId = petId;
        this.petName = petName;
        this.goldPrice = goldPrice;
    }

    public int getPetId()
    {
        return petId;
    }

    public String getPetName()
    {
        return petName;
    }

    public int getGoldPrice()
    {
        return goldPrice;
    }
}
