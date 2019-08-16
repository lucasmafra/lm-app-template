(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clojure.java-time "0.3.2"]
                 [prismatic/schema "1.1.11"]]
  :main ^:skip-aot {{namespace}}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev     {:dependencies [[midje "1.9.8"]
                                      [nubank/matcher-combinators "1.0.0"]
                                      [lm-app/lein-template "0.1.0-SNAPSHOT"]]
                       :source-paths ["src/dev"]
                       :main user}})
