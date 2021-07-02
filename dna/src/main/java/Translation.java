import de.propra.dna.data.Codon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Translation {

    public String rna;
    public ArrayList<String> ausgabe;
    public ArrayList<String> moeglich;

    public Translation(String rna) {
        this.rna = rna;
        this.moeglich = new ArrayList<>();
        this.ausgabe = new ArrayList<>();
    }

    public String translation() {
        checkeMoeglicheSequenzen(rna);
        //checkeGueltigeSequenzen(List < String > liste);
        return rna;
    }

    // Schritt 1: Suche allee möglichen Sequenzen aus der RNA-Sequenz
    public ArrayList<String> checkeMoeglicheSequenzen(String rna) {
        char[] chars = rna.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A' && chars[i + 1] == 'U' && chars[i + 2] == 'G') {
                String moeglicheSequenz ="";
                for (int j = i; j < chars.length; j++) {
                    moeglicheSequenz += chars[j];
                }
                moeglich.add(moeglicheSequenz);
            }
        }
        System.out.println(moeglich);
        return moeglich;
    }

    // Schritt 2: Kontrolliere, ob mögliche Sequenzen gültige Sequenzen sind

    // Schritt 3: Übersetze in Aminosäuren
    public ArrayList<String> uebersetzeInAmino(ArrayList<String> moeglich) {
        Codon[] codons = Codon.values();
        for (String s : moeglich) {
            String seq ="";
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String tempStr = "" + chars[i] + chars[i+1] + chars[i+2];
                for (Codon codon : codons) {
                    if (codon.name().equals(tempStr)) {
                        seq += codon.getPeptid().toString();
                    } else {
                        seq += tempStr;
                    }
                }
                i += 3;
            }
            ausgabe.add(seq);
        }
        System.out.println(ausgabe);
        return ausgabe;
    }
    public static void main(String[] args) {
        DNA dna = new DNA("TTATGCATC");
        Transkription transkription= new Transkription(dna);
        Translation translation = new Translation(transkription.transkriptionsschritt());
        translation.uebersetzeInAmino(translation.checkeMoeglicheSequenzen(translation.rna));
        //translation.checkeGueltigeSequenzen(translation.checkeMoeglicheSequenzen(translation.rna));
        //translation.ausgabe = translation.checkeMoeglicheSequenzen(translation.rna);
        //for (String string : translation.ausgabe) {
            //System.out.println(string);
        //}
        //System.out.println(translation.checkeMoeglicheSequenzen(translation.rna));
    }
}
