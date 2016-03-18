(ns bank-ocr-kata.parser
  (:require [clojure.string :as str]))

(defn one-line [& lines]
  "Convert a vector to a newline-separated string so we can line up numbers in
   the source code"
  (str/join "\n" lines))

(def zero
   (one-line " _ "
             "| |"
             "|_|"))

(def one
   (one-line "   "
             "  |"
             "  |"))

(def two
   (one-line " _ "
             " _|"
             "|_ "))

(def three
   (one-line " _ "
             " _|"
             " _|"))

(def four
   (one-line "   "
             "|_|"
             "  |"))

(def five
   (one-line " _ "
             "|_ "
             " _|"))

(def six
   (one-line " _ "
             "|_ "
             "|_|"))

(def seven
   (one-line " _ "
             "  |"
             "  |"))

(def eight
   (one-line " _ "
             "|_|"
             "|_|"))

(def nine
   (one-line " _ "
             "|_|"
             " _|"))

(def digits
  { zero "0", one "1", two "2", three "3", four "4", five "5", six "6", seven "7", eight "8", nine "9" })

(defn parse-single-number [input-string]
  "Takes a 4 line by 3 character string and parses to a number"
  (get digits input-string "X"))

(defn matrix->digit-string [matrix]
  "Takes a 3x3 matrix of characters and returns a string for digit lookup"
  (apply one-line (map #(apply str %) matrix)))

(defn parse-account-numbers [input]
  "Splits an account number into digits, then parses individually"
  (let [lines (str/split-lines input)]
    ; String them together
    (apply str
           ; Get a list of parsed numbers
           (map parse-single-number
                (map matrix->digit-string
                     ; Split each line into a list of three characters, then map through the groups
                     ; and make a 3x3 matrix of characters for a single digit
                     (apply map list (map (partial partition 3) lines)))))))

