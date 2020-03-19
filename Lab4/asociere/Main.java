package asociere;

public class Main {
    public static void main(String[] args) {

        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");
        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfoSiMate = new Profesor(5, "Andrei");

        Departament departamentInfo = new Departament("info");
        departamentInfo.setProfesori(new Profesor[]{profesorInfo, profesorMateSiInfo, profesorInfoSiMate});

        Departament departamentMate = new Departament("mate");
        departamentMate.setProfesori(new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorMateSiInfo, profesorInfoSiMate});

        Universitate unibuc = new Universitate("UNIBUC", new Departament[]{departamentInfo, departamentMate});

        System.out.println(unibuc);
        departamentInfo = null; //il distrug, dar nu se modifica obiectul de tip universitate pt ca in constructor se copiaza
        System.out.println(unibuc);

        System.out.println(departamentMate);
        //profesorSecundarMate = null;
        departamentMate.getProfesori()[1] = null; //la colectii e mai fancy
        System.out.println(departamentMate); //este sters profesorul 1
        System.out.println(profesorSecundarMate); //exista in cadrul programului

        
    }
}
