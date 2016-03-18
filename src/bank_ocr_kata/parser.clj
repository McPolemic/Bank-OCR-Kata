(ns bank-ocr-kata.parser
  (:require [clojure.string :as str]))

(defn one-line [& lines]
  "Convert a vector to a newline-separated string so we can line up numbers in
   the source code"
  (clojure.string/join "\n" lines))

(def digits
  {
   (one-line "   "
             "  |"
             "  |") 1
   })

(defn parse-single-number [input-string]
  "Takes a 4 line by 3 character string and parses to a number"
  (digits input-string))

