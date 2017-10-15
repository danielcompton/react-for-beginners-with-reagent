(ns reagent-for-beginners.helpers)

(defn format-price [price]
  (str "$"(/ price 100)))

(defn get-fun-name []
 (let [adjectives ["adorable", "beautiful", "clean", "drab", "elegant", "fancy", "glamorous", "handsome", "long", "magnificent", "old-fashioned", "plain", "quaint", "sparkling", "ugliest", "unsightly", "angry", "bewildered", "clumsy", "defeated", "embarrassed", "fierce", "grumpy", "helpless", "itchy", "jealous", "lazy", "mysterious", "nervous", "obnoxious", "panicky", "repulsive", "scary", "thoughtless", "uptight", "worried"]
       nouns ["women", "men", "children", "teeth", "feet", "people", "leaves", "mice", "geese", "halves", "knives", "wives", "lives", "elves", "loaves", "potatoes", "tomatoes", "cacti", "foci", "fungi", "nuclei", "syllabuses", "analyses", "diagnoses", "oases", "theses", "crises", "phenomena", "criteria", "data"]]
  (str  (rand-nth adjectives) "-" (rand-nth adjectives) "-" (rand-nth nouns))))
