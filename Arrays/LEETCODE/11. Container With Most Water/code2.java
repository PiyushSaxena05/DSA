int srt = 0;
        int end = height.length - 1;
        int maxWater = 0;

        while (srt < end) {

           
            int minH = Math.min(height[srt], height[end]);

            
            int area = minH * (end - srt);

            maxWater = Math.max(maxWater, area);

            while (srt < end && height[srt] <= minH) {
                srt++;
            }

            while (srt < end && height[end] <= minH) {
                end--;
            }
        }

        return maxWater;
    
       
