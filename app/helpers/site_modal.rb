class SiteModal
  def initialize(title, supporting_text, primary_action)
    @title = title
    @supporting_text = supporting_text
    @primary_action = primary_action
  end
  attr_reader :title, :supporting_text, :primary_action
end