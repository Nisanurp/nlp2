package nlp.packages;

import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;
public class KelimeDuzeltme {
    public static void main(String[] args) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);
        String[] words = {"okuyabileceğimden","okuyablirim", "Ankara", "Ankar'ada", "3'de", "3'te"};
        for (String word : words) {
            System.out.println(word + " = " + spellChecker.check(word));
        }
        System.out.println(".................................................................................................");

        String[] words1 = {"okuyablirim", "tartısıyor", "Ankar'ada", "knlıca"};
        for (String word : words1) {
            System.out.println(word + " = " + spellChecker.suggestForWord(word));
        }
        Scanner input=new Scanner(System.in);
        String kelime;
        System.out.println("Kelime giriniz...");
        kelime=input.nextLine();
        System.out.println(spellChecker.suggestForWord(kelime));

        }
    }




