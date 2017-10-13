(ns reagent-for-beginners.state
  (:require [reagent.core :as r :refer [atom]]))

(def fishes (r/atom {}))

(def orders (r/atom {}))
