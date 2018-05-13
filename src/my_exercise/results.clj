(ns my-exercise.results
  (:require [hiccup.page :refer [html5]]
            [clj-http.client :as client]))

(def base-uri
  "https://api.turbovote.org/elections/upcoming?district-divisions=")

(defn state-ocd-id [state]
  (str "ocd-division/country:us/state:" state))

(defn parse-form-params [params]
  (let [{:keys [street street-2 state city zip]} params
        m {:street   street
           :street-2 street-2
           :state    state
           :city     city
           :zip      zip}]
    ; there are cleaner ways to do this, haven't
    ; practiced destructing in a while :(
    (->> (remove (fn [[_ v]] (empty? v)) m)
         (map (fn [[k v]] [k (clojure.string/lower-case v)]))
         (map (fn [[k v]] [k (clojure.string/replace v #"\s+" "_")]))
         (into {}))))

(defn compose-uri
  ([state]
   (str base-uri (state-ocd-id state)))
  ([state place]
   (str base-uri (state-ocd-id state) "," (state-ocd-id state) "/place:" place)))

(defn make-the-call [params]
  (let [{:keys [state city]} params]
    (if city
      (read-string (:body (client/get (compose-uri state city))))
      (read-string (:body (client/get (compose-uri state)))))))

;(defn page [request]
;  (html5
;    (header request)
;    (instructions request)
;    (address-form request)))

; how to read a call
; (read-string (:body (client/get (str base-uri (state-ocd-id "ca")))))