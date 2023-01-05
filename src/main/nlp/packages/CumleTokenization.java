package nlp.packages;
import java.util.List;
import zemberek.tokenization.Token;
import zemberek.tokenization.TurkishTokenizer;
import java.util.Scanner;
import com.google.common.base.Joiner;
import java.util.Iterator;
import java.lang.String;
public class CumleTokenization {
    static TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;

    /*   public static String tokenIterator() {
            System.out.println("Low level tokenization iterator using Ant-lr Lexer.");
            String input = "İstanbul'a, merhaba!";
            System.out.println("Input = " + input);
            Iterator<Token> tokenIterator = tokenizer.getTokenIterator(input);
            while (tokenIterator.hasNext()) {
                Token token = tokenIterator.next();
                System.out.println(token);
            }
            return input;
        }
    */
    public static void simpleTokenization() {
        System.out.println("Simple tokenization returns a list of token strings.");
        TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
        String input = "İstanbul'a, merhaba!";
        System.out.println("Input = " + input);
        System.out.println("Tokenization list = " +
                Joiner.on("|").join(tokenizer.tokenizeToStrings("İstanbul'a, merhaba!")));
    }

    public static void customTokenizer() {
        TurkishTokenizer tokenizer = TurkishTokenizer
                .builder()
                .ignoreTypes(Token.Type.Punctuation, Token.Type.NewLine, Token.Type.SpaceTab)
                .build();
        List<Token> tokens = tokenizer.tokenize("Saat, 12:00.");
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String cumle;
        System.out.println("Cümle giriniz...");
        cumle = input.nextLine();

        String [] bol=cumle.split(" ");

        for(int i=0; i<bol.length; i++)
        {
            System.out.println(bol[i]);
        }
    }
}



