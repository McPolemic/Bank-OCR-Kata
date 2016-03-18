(ns bank-ocr-kata.parser-test
  (:require [clojure.test :refer :all]
            [bank-ocr-kata.parser :refer :all]))

(def invalid-digit
   (one-line "/o/"
             " / "
             "/ /"))

(deftest test-parse-single-number
  (testing "parses a single account digit"
    (are [x y] (= x (parse-single-number y))
      "0" zero
      "1" one
      "2" two
      "3" three
      "4" four
      "5" five
      "6" six
      "7" seven
      "8" eight
      "9" nine
      "X" invalid-digit)))

