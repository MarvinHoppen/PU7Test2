import de.propra.dna.data.NukleotideDNA;
import de.propra.dna.data.NukleotideRNA;

public class Transkription {

    public String sequenz1;
    public String sequenz2;
    public String RNAsequenz;

    public Transkription(DNA dna) {
        this.sequenz1 = dna.eingabesequenz;
    }

    public String transkriptionsschritt() {
        if (containsOnlyNukleotide(sequenz1)) {
            berechneSequenz2(sequenz1);
            String string1 = uebersetzeInRNA(sequenz1);
            String string2 = uebersetzeInRNA(sequenz2);
            this.RNAsequenz = verbindeSequenzen(string1,string2);
            return RNAsequenz;
        }
        return "Eigabe-DNA ist ungültig";
    }

    // Schritt 1: Ist Eingabe-Sequenz eine gültige Eingabe? CHECK
    public boolean containsOnlyNukleotide(String s) {
        if (s.matches("[ATGC]+")) {
            return true;
        }
        return false;

    }

    // Schritt 2: Berechne den 2. Strang mithilfe der Eingabe-Sequenz (1. Strang)
    public void berechneSequenz2(String sequenz1) {
        String tempStr = dreheSequenz(sequenz1);
        tempStr = ersetzeCharsInEingabe(tempStr);
        this.sequenz2 = tempStr;
    }

    // Schritt 2.1 + Schritt 3.1: Drehe Eingabe-Strang um CHECK
    private String dreheSequenz(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    // Schritt 2.2: Ersetzung im 2. Strang
    private String ersetzeCharsInEingabe(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            //String eins = NukleotideDNA.A.toString();

            if (chars[i] == 'A') {
                chars[i] = 'T';
            } else if (chars[i] == 'T') {
                chars[i] = 'A';
            } else if (chars[i] == 'C') {
                chars[i] = 'G';
            } else if (chars[i] == 'G') {
                chars[i] = 'C';
            }
        }
        return String.valueOf(chars);
    }

    // Schritt 3: Übersetze in RNA-Sequenz
    public String uebersetzeInRNA(String s) {
        String tempStr = dreheSequenz(s);
        tempStr = ersetzeCharsInEingabeZuRNA(tempStr);
        return tempStr;
    }

    // Schritt 3.2: Ersetzung im Strang zu RNA-Sequenz
    private String ersetzeCharsInEingabeZuRNA(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                chars[i] = 'U';
            } else if (chars[i] == 'T') {
                chars[i] = 'A';
            } else if (chars[i] == 'C') {
                chars[i] = 'G';
            } else if (chars[i] == 'G') {
                chars[i] = 'C';
            }
        }
        return String.valueOf(chars);
    }

    // Schritt 4: Verbinde die 2 Sequenzen zu einer RNA-Sequenz
    public String verbindeSequenzen(String sequenz1, String sequenz2) {
        String tempStr = sequenz1 + sequenz2;
        return tempStr;
    }

    public static void main(String[] args) {
        DNA dna = new DNA("TTATGCATC");
        Transkription transkription2 = new Transkription(dna);
        transkription2.berechneSequenz2(transkription2.sequenz1);
        System.out.println(transkription2.sequenz1);
        System.out.println(transkription2.sequenz2);

        Transkription transkription3 = new Transkription(dna);
        System.out.println(transkription3.transkriptionsschritt());

    }
}
