(ns reagent-for-beginners.app
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent-for-beginners.components.header :as header]))

(defn catch-of-the-day []
  [:div.catch-of-the-day
   [:div.menu
    [header/component "Fresh seafood"]]])

(defn init []
  (reagent/render-component [catch-of-the-day]
                            (.getElementById js/document "main")))

