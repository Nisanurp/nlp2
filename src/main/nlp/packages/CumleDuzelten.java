package nlp.packages;

import Corpus.Sentence;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import SpellChecker.*;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.tokenization.TurkishSentenceExtractor;

import java.util.List;
import java.util.Scanner;

public class CumleDuzelten {
    public static void main(String[] args) {
        FsmMorphologicalAnalyzer fsm = new FsmMorphologicalAnalyzer();
        SpellChecker spellChecker = new SimpleSpellChecker(fsm);

        // bu cumlede doktor yanlis yazilmis
        Sentence sentence = new Sentence("Dıktor olaç yazdi");
        Sentence corrected = spellChecker.spellCheck(sentence);
        System.out.println(corrected);

       Scanner input=new Scanner(System.in);
       String cumle;
       System.out.println("Cümle giriniz...");
       cumle=input.nextLine();
       Sentence cumlegirme=new Sentence(cumle);
       Sentence c=spellChecker.spellCheck(cumlegirme);
        System.out.println(c);



    }
}