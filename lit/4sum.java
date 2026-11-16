class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4){
            return List.of();
        }
        List<Integer> list = new ArrayList(nums.length);
        for (int v : nums)
            list.add(v);
        list.sort(Comparator.naturalOrder());
        Set<List<Integer>> sumsInd = new HashSet<>();

        int pivot = target / 4;
        int i2 = list.size() / 2;
        if ((i2 * 2) == list.size())
            i2--;
        int i1 = i2-1;
        int i3 = i2+1;
        int i4 = i3+1;
        int isum;
        while (true){
            while (true){
                // check 
                System.out.println(" =loop=> " + i1+i2+i3+i4);
                isum = list.get(i1) + list.get(i2) + list.get(i3) + list.get(i4);
                if (isum == target) {
                    List oneInds = List.of(i1, i2, i3, i4);
                    if (!sumsInd.contains(oneInds)) {
                        sumsInd.add(oneInds);
                    }
                }
                if ((i1 == i2-1 && isum > target) 
                    || (i3+1 == i4 && isum <= target){
                    break;
                }
                if (isum > target){
                    if (i1 < i2-1){
                        i2--;
 //                       while (list.get(i2) == list.get(i2+1))
 //                           i2--;
                    }
                }
                else {
                    if (i3+1 < i4){
                        i3++;
 //                       while (list.get(i3) == list.get(i3-1))
 //                           i3++;
                    }
                }
            }
            if ((i1 == 0 && isum > target) 
                    || (list.size() == i4+1 && isum <= target){
                System.out.println(" =Break=> " + i1+i4);
                break;
            }
            // Check 3,4
            if (isum > target){
                if (0 < i1){
                    i1--;
//                    while (list.get(i1) == list.get(i1+1))
//                       i1--;
                }
            }
            else {
                if (i4+1 < list.size()){
                    i4++;
//                    while (list.get(i4) == list.get(i4-1))
//                        i4++;
                }
            }
            i2 = (i1 + i4) / 2;
            i3 = i2+1;
        }

//        Set<List<Integer>> dups = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();
        for (List<Integer> inds : sumsInd) {
            List oneRes = List.of(list.get(inds.get(0)), 
                list.get(inds.get(1)), 
                    list.get(inds.get(2)), 
                        list.get(inds.get(3)));
            if (!results.contains(oneRes)){
//                dups.add(oneRes);
                results.add(oneRes);
            }
        }
        return results;
    }
}

// [-2,-1,0,0,1,2]
// [-3,-1,0,2,4,5]
