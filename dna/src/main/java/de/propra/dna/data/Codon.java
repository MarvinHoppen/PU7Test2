package de.propra.dna.data;

import static de.propra.dna.data.Peptid.ALA;
import static de.propra.dna.data.Peptid.ARG;
import static de.propra.dna.data.Peptid.ASN;
import static de.propra.dna.data.Peptid.ASP;
import static de.propra.dna.data.Peptid.CYS;
import static de.propra.dna.data.Peptid.GLN;
import static de.propra.dna.data.Peptid.GLU;
import static de.propra.dna.data.Peptid.GLY;
import static de.propra.dna.data.Peptid.HIS;
import static de.propra.dna.data.Peptid.ILE;
import static de.propra.dna.data.Peptid.LEU;
import static de.propra.dna.data.Peptid.LYS;
import static de.propra.dna.data.Peptid.MET;
import static de.propra.dna.data.Peptid.PHE;
import static de.propra.dna.data.Peptid.PRO;
import static de.propra.dna.data.Peptid.SER;
import static de.propra.dna.data.Peptid.STOP;
import static de.propra.dna.data.Peptid.THR;
import static de.propra.dna.data.Peptid.TRP;
import static de.propra.dna.data.Peptid.TYR;
import static de.propra.dna.data.Peptid.VAL;

public enum Codon {
  UUU(PHE), UCU(SER), UAU(TYR), UGU(CYS), UUC(PHE), UCC(SER), UAC(TYR), UGC(CYS), UUA(LEU),
  UCA(SER), UAA(STOP), UGA(STOP), UUG(LEU), UCG(SER), UAG(STOP), UGG(TRP), CUU(LEU), CCU(PRO),
  CAU(HIS), CGU(ARG), CUC(LEU), CCC(PRO), CAC(HIS), CGC(ARG), CUA(LEU), CCA(PRO), CAA(GLN),
  CGA(ARG), CUG(LEU), CCG(PRO), CAG(GLN), CGG(ARG), AUU(ILE), ACU(THR), AAU(ASN), AGU(SER),
  AUC(ILE), ACC(THR), AAC(ASN), AGC(SER), AUA(ILE), ACA(THR), AAA(LYS), AGA(ARG), AUG(MET),
  ACG(THR), AAG(LYS), AGG(ARG), GUU(VAL), GCU(ALA), GAU(ASP), GGU(GLY), GUC(VAL), GCC(ALA),
  GAC(ASP), GGC(GLY), GUA(VAL), GCA(ALA), GAA(GLU), GGA(GLY), GUG(VAL), GCG(ALA), GAG(GLU),
  GGG(GLY);

  private final Peptid peptid;

  Codon(Peptid peptid) {
    this.peptid = peptid;
  }

  public Peptid getPeptid() {
    return peptid;
  }
}
