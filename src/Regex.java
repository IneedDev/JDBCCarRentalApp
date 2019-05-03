import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

    public static void main(String[] args) {

        String reges = "\\d5";
        String word = "c";

        System.out.println("Dopasowanie " + Pattern.matches(reges,word));

        System.out.println("--------------------------------");

        Pattern compiledPattern = Pattern.compile("Marcin");
        Matcher matcher = compiledPattern.matcher("Nazywam sie Marcin Pietraszek");

        //oda zwraca true jeśli w łańcuchu znaków znajduje się coś co pasuje do wyrażenia regularnego,
        System.out.println(matcher.find());

        //metoda zwraca true jeśli łańcuch znaków pasuje w całości do wyrażenia regularnego.
        System.out.println(matcher.matches());

        // popularne kwantyfikatory +,*,?

        //walidacja numeru telefonu
        //walidacja kodu-pocztowegop
        //email
        //Scanner scanner = new Scanner(System.in);
        String regPhone = "\\d{3}-\\d{3}-\\d{3}";
        String phone = "127-123-123";
        System.out.println("Dopasowanie " + Pattern.matches(regPhone,phone));

        String regZip = "\\d{2}-\\d{3}";
        String zip = "44-888";
        System.out.println("Dopasowanie " + Pattern.matches(regZip,zip));

        // dopasowac maxymalna liczbe znakow do < X
        String regEmail = "[a-zA-Z]@[a-zA-Z]\\.[a-zA-Z]";
        String email = "e@e.p";
        System.out.println("Dopasowanie " + Pattern.matches(regEmail,email));

        // data
        String regData = "\\d{4}-\\d{2}-\\d{2} [a-zA-Z]{2,3}";
        String date= "2012-05-25 pon";
        System.out.println("Dopasowanie " + Pattern.matches(regData,date));

        // kod kraju pl-Poland
        String regCountryCode = "[a-zA-Z]{2}-[A-Z][a-z]{2}";
        String countrCode= "pl-Pol";
        System.out.println("Dopasowanie " + Pattern.matches(regCountryCode,countrCode));
    }
}
