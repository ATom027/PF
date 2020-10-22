(ns fp.db)

(defonce persons-atom (atom {}))

(defn add-person
  [email first-name last-name city street street_nr postcode]
  (swap! persons-atom assoc
    email {
            :first-name first-name
            :last-name last-name
            :city city
            :ul street
            :street_nr street_nr
            :postcode postcode }))

(defn first-name
  [email]
  (:first-name (@persons-atom email)))

(defn last-name
  [email]
  (:last-name (@persons-atom email)))

(defn adress
  [email]
  (str ( "ul. "
    (:street (@persons-atom email)) " "
    (:street_nr (@persons-atom email)) ", "
    (:postcode (@persons-atom email)) " "
    (:city (@persons-atom email))
  )
))
