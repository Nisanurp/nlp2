package nlp.packages;

import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;
import java.util.Scanner;
public class KelimeninKokunuBulma {
    public static void main(String[] args) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
    TurkishMorphology morphology1 = TurkishMorphology.createWithDefaults();
    WordAnalysis result = morphology1.analyze("muvaffakiyetsizleştirici");


     for(SingleAnalysis analysis :result)

    {
        System.out.println(analysis.formatLong());
        System.out.println("\tStems = " + analysis.getStems());
        System.out.println("\tLemmas = " + analysis.getLemmas());
    }

        Scanner input=new Scanner(System.in);
        String kelime;
        System.out.println("Kelime giriniz...");
        kelime=input.nextLine();
        WordAnalysis sonuc = morphology1.analyze(kelime);
        for(SingleAnalysis analysis :sonuc)

        {
            System.out.println(analysis.formatLong());
            System.out.println("\tStems = " + analysis.getStems());
            System.out.println("\tLemmas = " + analysis.getLemmas());
        }
    }
}