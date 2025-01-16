 ArrayList<Integer> res = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0;

        // This is similar to merge of merge sort
        while (i < n && j < m) {

            // select and add the smaller element 
            // from the current elements and move accordingly
            if (a[i] < b[j]) {
                res.add(a[i++]);
            } 
            else if (a[i] > b[j]) {
                res.add(b[j++]);
            }

            // If equal, then add to result and move both 
            else {
                res.add(a[i++]);
                j++;
            }
        }

        // Add the remaining elements of a[]
        while (i < n)
            res.add(a[i++]);

        // Add the remaining elements of b[]
        while (j < m)
            res.add(b[j++]);

        return res;