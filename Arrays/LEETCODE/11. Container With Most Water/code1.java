int left = 0;
int right = height.length - 1;
int maxArea = 0;

while (left < right) {

    int width = right - left;

    int hheight = Math.(height[left], height[right]);

    maxArea = Math.max(maxArea, width * hheight);

    if (height[left] < height[right]) {
        left++;
    } else {
        right--;
    }
}

return maxArea;
