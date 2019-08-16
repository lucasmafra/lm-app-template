(ns leiningen.new.lm-app
  (:require [leiningen.new.templates :refer [renderer year date project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))

(defn lm-app
  "FIXME: write documentation"
  [name]
  (let [render (renderer "lm-app")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)
              :date (date)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' lm-app project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["src/dev/user.clj" (render "user.clj" data)]
             ["resources/data_readers.clj" (render "data_readers.clj" data)]
             "src/{{sanitized}}/schemata"
             "src/{{sanitized}}/controllers"
             "src/{{sanitized}}/adapters"
             "src/{{sanitized}}/ports"
             "src/{{sanitized}}/domain")))
