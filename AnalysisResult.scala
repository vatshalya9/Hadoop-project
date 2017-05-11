package apriori

case class AnalysisResult(
  frequentItemSets: Map[Integer, Set[FrequentItemSet]],
  associationRules: Set[AssociationRule])
