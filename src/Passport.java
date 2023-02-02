import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passport {

    private int number;
    private String surname;
    private String name;
    private String patronymic;
    private String dataOfBirth;
    private static List<Passport> listOfPassports = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public static List<Passport> getListOfPassports() {
        return listOfPassports;
    }

    public static void setListOfPassports(List<Passport> listOfPassports) {
        Passport.listOfPassports = listOfPassports;
    }

    public Passport(int number, String surname, String name, String patronymic, String dataOfBirth) {
        if (number <= 0) {
            throw new RuntimeException("Номер пасспорта должен быть больше нуля!");
        } else {
            this.number = number;
        }
        if (surname == null && surname.isEmpty() && surname.isBlank()) {
            throw new RuntimeException("ВВедите корректную фамилию!");
        } else {
            this.surname = surname;
        }
        if (name == null && surname.isEmpty() && surname.isBlank()) {
            throw new RuntimeException("ВВедите корректное имя!");
        } else {
            this.name = name;
        }
        this.patronymic = patronymic;

        if (parseDate(dataOfBirth) == null) {
            System.out.println("ВВедите дату рождения в формате \"dd.MM.yy\"");
        }else{
            this.dataOfBirth = dataOfBirth;
        }

    }
public static Date parseDate(String date){
   try{
       return new SimpleDateFormat("dd.MM.yy").parse(date);
   }catch(ParseException e){
       return null;
   }

}
    public static void addNewPassport(Passport newPassport) {
        boolean checkNewPassport = true;// false - паспорт с таким именем уже есть
        for (Passport passport : listOfPassports) {
            if (passport.getNumber() == newPassport.getNumber()) {
                passport.setName(newPassport.getName());
                passport.setSurname(newPassport.getSurname());
                passport.setPatronymic(newPassport.getPatronymic());
                passport.setDataOfBirth(newPassport.getDataOfBirth());
                checkNewPassport = false;
                break;
            }
        }
        if (checkNewPassport) {
            listOfPassports.add(newPassport);
        }
    }
        public static Passport searchPassport(Passport searchPassport){
            for (Passport passport : listOfPassports){
                if(passport.getNumber() == searchPassport.getNumber()){
                    return searchPassport;
                }
            }
            return null;
    }
    public static void printListOfPassports() {
        System.out.println("Полный перечень паспортов:");
        for (Passport passport : listOfPassports){
            System.out.println(passport);
        }
    }



}
