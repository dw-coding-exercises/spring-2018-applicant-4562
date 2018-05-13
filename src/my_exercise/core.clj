(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-http.client :as client]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [my-exercise.home :as home]))

(defroutes app
  (GET "/" [] home/page)
  ; https://gist.github.com/zehnpaard/2071c3f55ed319aa8528d54d90f557e3#file-simple-hiccup-routes-clj-L13
  ; http://clojure-doc.org/articles/tutorials/basic_web_development.html#set-up-your-routes
  ; https://stackoverflow.com/a/32284706
  (POST "/search" [& params] (str "<h1>Hello " params "</h1>"))
  (route/resources "/")
  (route/not-found "Not found"))

(def handler
  (-> app
      (wrap-defaults site-defaults)
      wrap-reload))
