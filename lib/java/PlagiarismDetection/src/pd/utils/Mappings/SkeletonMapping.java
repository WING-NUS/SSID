package pd.utils.Mappings;

public class SkeletonMapping {
  private int startLine1, endLine1, startLine2, endLine2;
  private long submissionSimilarityMappingId;

  public SkeletonMapping() {
  }

  public SkeletonMapping(int startLine1, int endLine1, int startLine2, int endLine2) {
    this.startLine1 = startLine1;
    this.endLine1 = endLine1;
    this.startLine2 = startLine2;
    this.endLine2 = endLine2;
  }

  public int getStartLine1() {
    return startLine1;
  }

  public void setStartLine1(int startLine1) {
    this.startLine1 = startLine1;
  }

  public int getEndLine1() {
    return endLine1;
  }

  public void setEndLine1(int endLine1) {
    this.endLine1 = endLine1;
  }

  public int getStartLine2() {
    return startLine2;
  }

  public void setStartLine2(int startLine2) {
    this.startLine2 = startLine2;
  }

  public int getEndLine2() {
    return endLine2;
  }

  public void setEndLine2(int endLine2) {
    this.endLine2 = endLine2;
  }

  public long getSubmissionSimilarityMappingId() {
    return submissionSimilarityMappingId;
  }

  public void setSubmissionSimilarityMappingId(long submissionSimilarityMappingId) {
    this.submissionSimilarityMappingId = submissionSimilarityMappingId;
  }

  
}
