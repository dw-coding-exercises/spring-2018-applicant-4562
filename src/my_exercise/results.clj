(ns my-exercise.results
  (:require [hiccup.page :refer [html5]]
            [clj-http.client :as client]))

(def base-uri
  "https://api.turbovote.org/elections/upcoming?district-divisions=ocd-division/country:us/state:ca")

(defn parse-form-params [params]
  (let [{:keys [street street-2 state city zip]} params
        m {:street   street
           :street-2 street-2
           :state    state
           :city     city
           :zip      zip}]
    (->> (remove (fn [[_ v]] (empty? v)) m)
         (map (fn [[k v]] [k (clojure.string/lower-case v)]))
         (into {}))))