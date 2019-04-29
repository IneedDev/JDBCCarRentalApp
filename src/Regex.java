import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

    public static void main(String[] args) {

        String reges = "re";
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
    }
}
