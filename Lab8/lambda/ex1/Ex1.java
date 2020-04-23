package lambda.ex1;

public class Ex1 {

    public static void main(String[] args) {

        Instrument guitar = new Guitar();
        guitar.play();

        // constructor clasa anonima
        Instrument piano = new Instrument() {
            @Override
            public void play() {
                System.out.println("Playing piano");
            }
        };
        piano.play();

        // cu expresie lambda; trebuie folosite interfete functionale (au doar o metoda abstracta)
        // () parametrii din metoda de implementat (play in cazul acesta)
        // dupa -> corpul functiei (comportamentul)
        Instrument i1 = () -> System.out.println("New instrument playing"); // comportament declarativ
        i1.play();

        Instrument i2 = () -> System.out.println("Stop playing");
        i2.play();
    }
}
