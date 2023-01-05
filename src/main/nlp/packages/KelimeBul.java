package nlp.packages;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;
import java.util.ArrayList.*;
import afu.org.checkerframework.checker.oigj.qual.I;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.generator.WordGenerator.Result;
import zemberek.morphology.generator.*;
import zemberek.morphology.lexicon.DictionaryItem;
import zemberek.tokenization.TurkishSentenceExtractor;
import zemberek.morphology.TurkishMorphology;
public class KelimeBul{
    static ArrayList<String> myArrayList= new ArrayList<>();
    static List<Result> results;
    public static void main(String[] args)  throws IndexOutOfBoundsException {

        Scanner input = new Scanner(System.in);
        String[] kelimeler = {"yıldız gemisi", "yapay zeka", "bir şey", "ağır siklet", "misafir odası", "kömür sobası", "ev terliği", "çiçek saksısı", "masa örtüsü",
                "otobüs bileti", "coğrafya kitabı", "kök boyası", "biber dolması", "gül kurusu", "pirinç pilâvı", "peynir tatlısı", "Bursa şeftalisi", "Amasya elması",
                "İzmir üzümü", "Bağdat hurması", "yer elması", "ağaç mantarı", "su yılanı", "dağ keçisi", "Sokak çocuğu", "dil peyniri", "parmak üzümü", "dil balığı",
                "kayıt memuru", "temizlik işçisi", "fizik öğretmeni", "ev kadını", "okul müdürü", "daire başkanı", "sel felâketi", "deprem yıkıntısı", "kaza kurbanı",
                "yaz yağmuru", "sabah kahvaltısı", "telefon görüşmesi", "çöp kebabı", "Konya Ovası", "Topkapı Garajı", "Taksim Meydanı", "Boğaziçi Köprüsü", "Çanakkale Köprüsü",
                "Ankara Kalesi", "İstanbul şehri", "Türk Dili", "Tuz Gölü", "öğretmenler odası", "erkekler hamamı", "kadınlar hamamı", "karılar koğuşu",
                "çamaşır makinesi", "şiir dünyası"};
        TurkishSentenceExtractor extractor = TurkishSentenceExtractor.DEFAULT;
        String[] number = {"A3sg", "A3pl"};
        String[] possessives = {"P1sg", "P2sg", "P3sg"};
        String[] cases = {"Dat", "Loc", "Abl"};


        System.out.println("Cümle giriniz...");
        String cumle;
        cumle = input.nextLine();
        String[] bol = cumle.split(" ");
        //  for (int i = 0; i < bol.length; i++) {
        //     System.out.println(bol[i]);
        // }

        for (int k = 0; k < kelimeler.length; k++) {

            String  ser[] = kelimeler[k].split(" ");
            String yeni = ser[1];

            TurkishMorphology morphology =
                    TurkishMorphology.builder().setLexicon(yeni).disableUnidentifiedTokenAnalyzer().build();

            DictionaryItem item;
            item = morphology.getLexicon().getMatchingItems(yeni).get(0);

            for (String numberM : number) {
                for (String possessiveM : possessives) {
                    for (String caseM : cases) {
                        results = morphology.getWordGenerator().generate(item, numberM, possessiveM, caseM);
                        //   results.forEach(s -> System.out.println(ser[0]+" "+ s.surface));
                        Result[] myArray =new Result[results.size()];
                        results.toArray(myArray);
                        for(int y=0; y< myArray.length; y++)
                        {
                            String m=ser[0] +" "+ myArray[y].surface;
                            myArrayList.add(m);
                        }
                    }
                }
            }
        }
        String[] A= myArrayList.toArray(String[]::new);//misafir odasılarında
        compare(bol,kelimeler);
        compare(bol,A);
    }

    public  static  void compare(String A[], String B[]){
        //  String mm=Arrays.toString(A);
        //System.out.println("my new String ......"+mm);
        //System.out.println();
        String m="";
        for(String i: A){
            m+=i+" ";
        }
        for (int k=0; k<B.length; k++){
            if(m.indexOf(B[k])>=0){
                System.out.println("Cümle içinde bulunan kelime=>"+ B[k]);
            }

        }

    }
}

