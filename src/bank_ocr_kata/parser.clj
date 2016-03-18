(ns bank-ocr-kata.parser
  (:require [clojure.string :as str]))

(defn lines->matrix [& lines]
  "Convert a vector of lines to a 3x3 matrix of characters"
  (map seq lines))

(def zero
   (lines->matrix " _ "
                  "| |"
                  "|_|"))

(def one
   (lines->matrix "   "
                  "  |"
                  "  |"))

(def two
   (lines->matrix " _ "
                  " _|"
                  "|_ "))

(def three
   (lines->matrix " _ "
                  " _|"
                  " _|"))

(def four
   (lines->matrix "   "
                  "|_|"
                  "  |"))

(def five
   (lines->matrix " _ "
                  "|_ "
                  " _|"))

(def six
   (lines->matrix " _ "
                  "|_ "
                  "|_|"))

(def seven
   (lines->matrix " _ "
                  "  |"
                  "  |"))

(def eight
   (lines->matrix " _ "
                  "|_|"
                  "|_|"))

(def nine
   (lines->matrix " _ "
                  "|_|"
                  " _|"))

(def digits
  { zero "0", one "1", two "2", three "3", four "4", five "5", six "6", seven "7", eight "8", nine "9" })

(defn parse-single-number [input-string]
  "Takes a 4 line by 3 character string and parses to a number"
  (get digits input-string "X"))

(defn matrix->digit-string [matrix]
  "Takes a 3x3 matrix of characters and returns a string for digit lookup"
  (apply lines->matrix (map #(apply str %) matrix)))

(defn parse-account-number [input]
  "Splits an account number into digits, then parses individually"
  (let [lines (str/split-lines input)]
    (apply str
           (map parse-single-number
                ; Split each line into a list of three characters, then map through the groups
                ; and make a 3x3 matrix of characters for a single digit
                (apply map list (map (partial partition 3) lines))))))
