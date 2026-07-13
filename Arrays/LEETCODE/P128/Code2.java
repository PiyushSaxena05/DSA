HashSet<Integer>hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        int l = 0;
        for(int i : hs){
            if(!hs.contains(i-1)){
                int current =i;
                int count = 1;
                while(hs.contains(current+1)){
                    current++;
                    count++;
                }
                l = Math.max(l,count);
            }
        }
        return l;
