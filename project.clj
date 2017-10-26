(defproject todomvc-re-frame "0.9.0"
  :dependencies [[adzerk/boot-cljs "2.0.0" :scope "test"]
                 [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                 [adzerk/boot-reload "0.5.1" :scope "test"]
                 [pandeiro/boot-http "0.8.3" :scope "test"]
                 [com.cemerick/piggieback "0.2.1" :scope "test"]
                 [org.clojure/tools.nrepl "0.2.13" :scope "test"]
                 [weasel "0.7.0" :scope "test"]
                 [org.clojure/clojurescript "1.9.562"]
                 [reagent "0.6.0"]
                 [reagent-utils "0.2.1"]
                 [bidi "2.1.2"]
                 [secretary "1.2.3"]
                 [venantius/accountant "0.2.0"]
                 [binaryage/devtools "0.9.4" :scope "test"]
                 [powerlaces/boot-cljs-devtools "0.2.0" :scope "test"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.6"]]

  :hooks [leiningen.cljsbuild]

  :profiles {:dev  {:cljsbuild
                    {:builds {:client {:compiler {:asset-path           "js"
                                                  :optimizations        :none
                                                  :source-map           true
                                                  :source-map-timestamp true
                                                  :main                 "todomvc.core"}
                                       :figwheel {:on-jsload "todomvc.core/main"}}}}}

             :prod {:cljsbuild
                    {:builds {:client {:compiler {:optimizations :advanced
                                                  :elide-asserts true
                                                  :pretty-print  false}}}}}}

  :figwheel {:server-port 3450
             :repl        true}


  :clean-targets ^{:protect false} ["resources/public/js" "target"]

  :cljsbuild {:builds {:client {:source-paths ["src" "../../src"]
                                :compiler     {:output-dir "resources/public/js"
                                               :output-to  "resources/public/js/client.js"}}}})
