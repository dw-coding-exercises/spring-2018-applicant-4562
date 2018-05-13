(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-http.client :as client]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [my-exercise.home :as home]))

(defroutes app
  (GET "/" [] home/page)
  (GET "/search" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not found"))

(def handler
  (-> app
      (wrap-defaults site-defaults)
      wrap-reload))
