class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            int groupSize = groupSizes[i];

            // If the group doesn't exist, create it
            if(!map.containsKey(groupSize)){
                map.put(groupSize, new ArrayList<>());
            }

            List<Integer> group = map.get(groupSize);
            group.add(i);

            // If the group is full, add it to the result and create a new group
            if(group.size() == groupSize){
                result.add(group);
                map.put(groupSize, new ArrayList<>());
            }

        }
        return result;
    }
}