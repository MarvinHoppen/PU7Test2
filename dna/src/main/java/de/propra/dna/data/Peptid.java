package de.propra.dna.data;

public enum Peptid {
  ALA('A'), ARG('R'), ASN('N'), ASP('D'), ASX('B'), CYS('C'), GLU('E'), GLN('Q'), GLX('Z'),
  GLY('G'), HIS('H'), ILE('I'), LEU('L'), LYS('K'), MET('M'), PHE('F'), PRO('P'), SER('S'),
  THR('T'), TRP('W'), TYR('Y'), VAL('V'), STOP('-');
  private final char peptideCode;

  Peptid(char peptideCode) {
    this.peptideCode = peptideCode;
  }

  public char getPeptideCode() {
    return peptideCode;
  }
}
