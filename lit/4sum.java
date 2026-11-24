class Solution {
    public List<List<Integer>> fourSum(int[] snums, int target) {
        if (snums.length < 4){
            return List.of();
        }
        sort(snums);
        int lastI = snums.length - 1;
        long lTarget = target;
        long maxVal = lTarget - (long) snums[0] - (long) snums[1] - (long) snums[2];
        int pos1 = 0;
        int pos2 = 0;
        int sameValCount = 0;
        while(pos2 < snums.length - 1){
            pos2++;
            if (snums[pos1] != snums[pos2]){
                sameValCount = 0;
            }
            else {
                sameValCount++;
            }
            if (sameValCount < 4){
                pos1++;
            }
            if (pos2 > pos1){
                snums[pos1] = snums[pos2];
            }
            if (snums[pos1] > maxVal) {
                break;
            }
        }
        lastI = pos1;
        if (lastI < 3){
            return List.of();
        }

        List<List<Integer>> results = new ArrayList<>();
        int i1 = 0;
        int i2 = 1;
        int i4 = lastI;
        int i3 = i4-1;
        long isum;

        while (true){
            while (true){
                // check 
                isum = (long) snums[i1] + (long) snums[i2] 
                    + (long) snums[i3] + (long) snums[i4];
                if (isum == lTarget) {
                    List oneRes = List.of(snums[i1], snums[i2],snums[i3], snums[i4]);
                    if (!results.contains(oneRes))
                        results.add(oneRes);
                }
                if ((i2 + 1) == i3){
                    break;
                }
                if (isum > lTarget){
                    int cur = snums[i3];
                    while (snums[i3] == cur && i3 > (i2+1))
                        i3--;
                }
                else {
                    int cur = snums[i2];
                    while (snums[i2] == cur && i3 > (i2+1))
                        i2++;
                }
            }
            if ((i1 + 3) == lastI){
                break;
            }
            if ((i1 + 3) < i4){
                int cur = snums[i4];
                while (snums[i4] == cur && (i1 + 3) < i4)
                    i4--;
            }
            else {
                int cur = snums[i1];
                while (snums[i1] == cur && (i1 + 3) < lastI)
                    i1++;
                i4 = lastI;
            }

            i2 = i1 + 1;
            i3 = i4 - 1;
        }

        return results;
    }

    public void sort (int [] arr) {
        doSort (arr, 0, arr.length-1);
    }

    private void doSort (int [] arr, int start, int end) {
        if (start >= end){
            return;
        }

        int mid = (start + end) / 2;
        int pivot = arr[mid];
        int pos1 = start;
        int pos2 = end;

        while (pos1 < pos2) {
        while (pos1 < mid && arr[pos1] < pivot){
            pos1++;
        }

        if (pos1 < mid){
            replace (arr, pos1, mid);
            mid = pos1;
        }

        while (pos2 > mid && arr[pos2] >= pivot){
            pos2--;
        }

        if (pos2 > mid){
            replace (arr, pos2, mid);
            mid = pos2;
        }
        }
        doSort (arr, start, mid-1);
        doSort (arr, mid+1, end);
    }

    private void replace (int [] arr, int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
/**
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

        int i1 = 0;
        int i2 = 1;
        int i4 = list.size()-1;
        int i3 = i4-1;
        long lTarget = target;
        long isum;
        while (true){
            while (true){
                // check 
                isum = (long) list.get(i1) + (long) list.get(i2) 
                    + (long) list.get(i3) + (long) list.get(i4);
                if (isum == lTarget) {
                    List oneInds = List.of(i1, i2, i3, i4);
                    if (!sumsInd.contains(oneInds)) {
                        sumsInd.add(oneInds);
                    }
                }
                if ((i2 + 1) == i3){
                    break;
                }
                if (isum > lTarget){
                    int cur = list.get(i3);
                    while (list.get(i3) == cur && i3 > (i2+1))
                        i3--;
                }
                else {
                    int cur = list.get(i2);
                    while (list.get(i2) == cur && i3 > (i2+1))
                        i2++;
                }
            }
            if ((i1 + 4) == list.size()){
                break;
            }
            if ((i1 + 3) < i4){
                int cur = list.get(i4);
                while (list.get(i4) == cur && (i1 + 3) < i4)
                    i4--;
            }
            else {
                int cur = list.get(i1);
                while (list.get(i1) == cur && (i1 + 4) < list.size())
                    i1++;
                i4 = list.size()-1;
            }

            i2 = i1 + 1;
            i3 = i4 - 1;
        }

        List<List<Integer>> results = new ArrayList<>();
        for (List<Integer> inds : sumsInd) {
            List oneRes = List.of(list.get(inds.get(0)), 
                list.get(inds.get(1)), 
                    list.get(inds.get(2)), 
                        list.get(inds.get(3)));
            if (!results.contains(oneRes)){
                results.add(oneRes);
            }
        }
        return results;
    }
}
*/
// [-2,-1,0,0,1,2]
// [-3,-1,0,2,4,5]


	/*
        Set<List<Integer>> res = new HashSet<>();
        for(int i1 = 0; i1 < nums.length-3; i1++){
            int[] tst = new int[4];
            tst[0] = i1;
            for(int i2 = i1+1; i2 < nums.length-2; i2++){
                tst[1] = i2;
                for(int i3 = i2+1; i3 < nums.length-1; i3++){
                    tst[2] = i3;
                    for(int i4 = i3+1; i4 < nums.length; i4++){
                        tst[3] = i4;
                        int tmp = 0;
                        for (int t1 = 0; t1 < 4; t1++){
                            tmp += nums[tst[t1]];
                        }
                        if (tmp != target){
                            continue;
                        }
                        List<Integer> l = new ArrayList<>();
                        l.add(tst[0]);
                        l.add(tst[1]);
                        l.add(tst[2]);
                        l.add(tst[3]);
                        if (!res.contains(l)){
                            res.add(l);
                        }
                    }
                }
            }
        }
        Set<List<Integer>> unique = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> r : res){
            List<Integer> l = new ArrayList<>();
            l.add(nums[r.get(0)]);
            l.add(nums[r.get(1)]);
            l.add(nums[r.get(2)]);
            l.add(nums[r.get(3)]);
            l.sort((l1, l2) -> l1 - l2);
            if (!unique.contains(l)){
                result.add(l);
            }
            unique.add(l);
        }
        return result;
*/        
 

