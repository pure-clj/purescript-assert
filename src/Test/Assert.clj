(ns Test.Assert._foreign)

(defn assert' [message]
  (fn [success]
    (fn []
      (if-not success
        (throw (RuntimeException. message))
        {}))))

(defn checkThrows [f]
  (fn []
    (try (f)
         false
         (catch Exception e
           true)
         (catch Throwable t
           (throw (RuntimeException. "Threw something other than an Error" t))))))
