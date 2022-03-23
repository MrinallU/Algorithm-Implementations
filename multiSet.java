    public static class multiSet {
        public static TreeMap<pair, Integer> set;

        public multiSet(){
            set = new TreeMap<>();
        }
         void add(pair x, int ind) {
            if (set.containsKey(x)) {
                set.put(x, set.get(x) + 1);
            } else {
                set.put(x, 1);
            }
        }

         void remove(pair x) {
            set.put(x, set.get(x) - 1);
            if (set.get(x) == 0) {
                set.remove(x);
            }
        }
    }
