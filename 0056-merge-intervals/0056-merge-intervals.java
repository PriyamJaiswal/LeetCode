class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0],y[0]));
        int[][] a = intervals;

        int[][] res = new int[n][2];
        int index = 0;

        int start1 = a[0][0];
        int end1 = a[0][1];

        for(int i=1; i <a.length; i++){

            int start2 = a[i][0];
            int end2 = a[i][1];

            if( end1 >= start2 ){            //overlap, merge honge
                end1 = Math.max(end1, end2);
            } else{                          //no overlap
                res[index][0] = start1;
                res[index][1] = end1;
                index++;

                start1 = start2;
                end1 = end2;
            }
        }

        res[index][0] = start1;              //print last interval 
        res[index][1] = end1;
        index++;

        return Arrays.copyOf(res, index);
    }
}