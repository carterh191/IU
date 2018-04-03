interface Iterator {
  int get();
  Iterator advance();
  boolean equals(Iterator other);
}

interface Sequence {
  Iterator begin();
  Iterator end();
}

interface BidirectionalIterator extends Iterator {
  BidirectionalIterator retreat();
}