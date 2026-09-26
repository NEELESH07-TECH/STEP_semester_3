class Main {
    static void analyzeInventory(int[] a, int[] b) {
        int totalA = 0, totalB = 0;

        int highest = a[0];
        char section = 'A';
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            totalA += a[i];
            totalB += b[i];

            if (a[i] > highest) {
                highest = a[i];
                section = 'A';
                index = i;
            }

            if (b[i] > highest) {
                highest = b[i];
                section = 'B';
                index = i;
            }
        }

        String status;

        if (totalA == totalB)
            status = "Balanced";
        else
            status = "Not Balanced";

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest
                + " (Section " + section
                + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};

        analyzeInventory(a, b);
    }
}