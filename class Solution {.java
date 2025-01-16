class Solution {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<List<List<Integer>>> storeQueries = new ArrayList<>(
            heights.length
        );
        for (int i = 0; i < heights.length; i++) storeQueries.add(
            new ArrayList<>()
        );
        PriorityQueue<List<Integer>> maxIndex = new PriorityQueue<>(
            (a, b) -> a.get(0) - b.get(0)
        );
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        for (int currQuery = 0; currQuery < queries.length; currQuery++) {
            int a = queries[currQuery][0], b = queries[currQuery][1];
            if (a < b && heights[a] < heights[b]) {
                result[currQuery] = b;
            } else if (a > b && heights[a] > heights[b]) {
                result[currQuery] = a;
            } else if (a == b) {
                result[currQuery] = a;
            } else {
                storeQueries
                    .get(Math.max(a, b))
                    .add(
                        Arrays.asList(
                            Math.max(heights[a], heights[b]),
                            currQuery
                        )
                    );
            }
        }
        for (int index = 0; index < heights.length; index++) {
            while (
                !maxIndex.isEmpty() && maxIndex.peek().get(0) < heights[index]
            ) {
                result[maxIndex.peek().get(1)] = index;
                maxIndex.poll();
            }
            for (List<Integer> element : storeQueries.get(index)) {
                maxIndex.offer(element);
            }
        }
        return result;
    }
}