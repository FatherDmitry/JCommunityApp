package Department;

// Модель для хранения информации отделов
public class Department {
    private String nameCommunity;

    public Department(String nameCommunity){
        this.nameCommunity = nameCommunity;
    }

    public String getNameCommunity(){
        return nameCommunity;
    }

    // toString для отображались названия отделов в списке
    @Override
    public String toString(){
        return nameCommunity;
    }
}
