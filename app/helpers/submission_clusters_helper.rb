module SubmissionClustersHelper
  LEGEND_SIMILARITY_VALUES = (40..90).step(10).to_a.reverse
  LEGEND_COLORS_FOR_SIMILARITY_VALUES = Hash[
    LEGEND_SIMILARITY_VALUES.zip(
      %w{#CB0034 #FF6501 #F5D800 #377FC7 #00ECEC #01A64D}
    )
  ]
  LEGEND_WEIGHTS_FOR_SIMILARITY_VALUES = Hash[
    LEGEND_SIMILARITY_VALUES.zip(
      %w{11 9 7 5 3 1}
    )
  ]

  private

  def self.color_for_similarity(val)
    val = val.to_f
    legend_index = LEGEND_SIMILARITY_VALUES.index { |legend_value|
      val >= legend_value
    }
    legend_index = LEGEND_SIMILARITY_VALUES.size - 1 unless legend_index
    legend_value = LEGEND_SIMILARITY_VALUES[legend_index]
    LEGEND_COLORS_FOR_SIMILARITY_VALUES[legend_value]
  end

  def self.weight_for_similarity(val)
    val = val.to_f
    legend_index = LEGEND_SIMILARITY_VALUES.index { |legend_value|
      val >= legend_value
    }
    legend_index = LEGEND_SIMILARITY_VALUES.size - 1 unless legend_index
    legend_value = LEGEND_SIMILARITY_VALUES[legend_index]
    LEGEND_WEIGHTS_FOR_SIMILARITY_VALUES[legend_value]
  end
end
