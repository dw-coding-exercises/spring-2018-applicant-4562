(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-http.client :as client]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [my-exercise.home :as home]))

(defroutes app
  (GET "/" [] home/page)
  (POST "/search" [] (read-string (:body (client/get "https://api.turbovote.org/elections/upcoming?district-divisions=ocd-division/country:us/state:ca/"))))
  (route/resources "/")
  (route/not-found "Not found"))

(def handler
  (-> app
      (wrap-defaults site-defaults)
      wrap-reload))
