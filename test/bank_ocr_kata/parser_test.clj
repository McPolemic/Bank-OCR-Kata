(ns bank-ocr-kata.parser-test
  (:require [clojure.test :refer :all]
            [bank-ocr-kata.parser :refer :all]))

(def one
   (one-line "   "
             "  |"
             "  |"))

(deftest test-parse-single-number
  (testing "parses 1"
    (is (= 1 (parse-single-number one)))))

