public class Main {
    public static void main(String[] args) {
        Passport.addNewPassport(new Passport(33333, "Зайцев", "Илья", "Анатольевич", "02.03.1990"));
        Passport.addNewPassport(new Passport(55555, "Волков", "Иван", "Николаевич", "05.10.1955"));
        Passport.addNewPassport(new Passport(33333, "Петров", "Василий", "Иванович", "12.08.1985"));


        Passport.printListOfPassports();
        System.out.println();
        System.out.println("Поиск паспорта");
        System.out.println(Passport.searchPassport(new Passport(33333, "Зайцев", "Илья", "Анатольевич", "02.03.1990")));
       System.out.println(Passport.searchPassport(new Passport(55555, "Волков", "Иван", "Николаевич", "05.10.1955")));
    }
}