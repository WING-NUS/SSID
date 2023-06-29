package pd.utils.Mappings;

import pd.utils.NGrams.FingerPrint;

public class MatchingDocument {
  private String submissionId;
  private FingerPrint fingerPrint;

  public MatchingDocument(String submissionId, FingerPrint fingerPrint) {
    this.submissionId = submissionId;
    this.fingerPrint = fingerPrint;
  }

  public String getSubmissionId() {
    return submissionId;
  }

  public void setSubmissionId(String submissionId) {
    this.submissionId = submissionId;
  }

  public FingerPrint getFingerPrint() {
    return fingerPrint;
  }

  public void setFingerPrint(FingerPrint fingerPrint) {
    this.fingerPrint = fingerPrint;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MatchingDocument matchingDocument = (MatchingDocument) obj;
    return this.submissionId.equals(matchingDocument.getSubmissionId()) && this.fingerPrint.equals(matchingDocument.getFingerPrint());

  }

  @Override
  public String toString() {
    return this.submissionId + "_" + this.fingerPrint.getnGram().nGramValue() + "_" + this.fingerPrint.getWindow() + "_" + this.fingerPrint.getIndexWithinWindow();
  }
  
}
