(ns cipher)

(defn cipher [words shift]
  (let [alpha-chars (map char "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" ) ;define alphabet to use "abcdefghijklmnopqrstuvwxyz"
        alpha-shift (->>
                      (cycle alpha-chars)
                      (take 60)
                      (drop shift)) ;->> thread last: drop the number of items specified in shift, take 60 characters, cycle through said chars
        alpha-shift-map (->
                          (zipmap alpha-chars alpha-shift) ;-> thread first: form key-value relationship between character and shifted equivalent
                          (assoc \space \space))]           ; account for spaces by associating spaces
    (apply str (map alpha-shift-map (map char words)))))

(println (cipher "emily is my name" 7))

