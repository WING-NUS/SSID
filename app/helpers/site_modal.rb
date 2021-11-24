class SiteModal
  def initialize(title, supporting_text)
    @title = title
    @supporting_text = supporting_text
  end
  attr_reader :title, :supporting_text
end