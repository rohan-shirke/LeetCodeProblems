class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1; // The target gene is not in the bank, so it's impossible to reach it.
        }

        char[] geneChars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }
                char[] geneArray = currentGene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    for (char c : geneChars) {
                        if (c != originalChar) {
                            geneArray[j] = c;
                            String mutatedGene = new String(geneArray);
                            if (bankSet.contains(mutatedGene)) {
                                bankSet.remove(mutatedGene);
                                queue.offer(mutatedGene);
                            }
                        }
                    }
                    geneArray[j] = originalChar; // Reset the character for the next mutation.
                }
            }
            mutations++;
        }

        return -1; // If we reach here, there is no valid mutation path.
    }
}