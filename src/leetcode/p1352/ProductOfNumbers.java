package leetcode.p1352;

class ProductOfNumbers {
    int[] arr = new int[40_001];

    public ProductOfNumbers() {
    }

    int i = 0;

    public void add(int num) {
        arr[i++] = num;
    }

    public int getProduct(int k) {
        if (k > i) return 0;
        int result = 1;
        for (int j = 0; j < k; j++) {
            result *= arr[i - j - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfNumbers obj = new ProductOfNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);
        System.out.println(obj.getProduct(2));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */