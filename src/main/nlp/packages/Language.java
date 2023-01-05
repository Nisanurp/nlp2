package nlp.packages;
import zemberek.langid.LanguageIdentifier;
import java.util.Scanner;
import java.io.IOException;

public class Language {
    public static void main(String[] args) throws IOException {
        // gelen cumle hangi dil'e aittir
        LanguageIdentifier lid = LanguageIdentifier.fromInternalModels();
        String b = lid.identify("niye bu kadar guzelsin");
        System.out.println(b);
        String c = lid.identify("Érase una vez un rapazuelo a quien su madre le daba, cada tarde, una taza de leche y un bollo de pan, y con ellos se iba el niño a la era. En cuanto empezaba a merendar acudía un sapo, que salía de una rendija de la pared, y, metiendo la cabecita en la taza, merendaba con él. El pequeño se gozaba mucho con su compañía, y, una vez sentado con su tacita, si el sapo no acudía en seguida, le llamaba:");
        System.out.println(c);
        Scanner input=new Scanner(System.in);
        String metin;
        System.out.println("Herhangi bir dilde yazılmış bir metin giriniz.\n");
        metin=input.nextLine();
        String d = lid.identify(metin);
        System.out.println(d);
    }
    }
