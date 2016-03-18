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

(def two-matrix [[\space \_ \space]
                 [\space \_ \|]
                 [\|     \_ \space]])

(deftest test-matrix->digit-string
  (testing "converts from matrix of characters to digit"
    (is (= two (matrix->digit-string two-matrix)))))

(def single-account-number (one-line "    _  _     _  _  _  _  _ "
                                     "  | _| _||_||_ |_   ||_||_|"
                                     "  ||_  _|  | _||_|  ||_| _|"))

(deftest test-parsing-account-numbers
  (testing "Parses a single account number"
    (is (= "123456789" (parse-account-numbers single-account-number)))))

