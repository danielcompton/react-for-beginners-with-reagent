(ns reagent-for-beginners.components.header)

(defn component [tagline]
  [:header.top
   [:h1 "Catch"
    [:span.ofThe
     [:span.of "of"]
     [:span.the "the"]]
    "Day"]
   [:h3.tagline
    [:span tagline]]])
