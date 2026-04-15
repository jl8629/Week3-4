import java.util.*;
class Problem1 {
 static class Transaction {
 String id;
 double fee;
 String ts;
 Transaction(String id, double fee, String ts) {
 this.id = id;
 this.fee = fee;
 this.ts = ts;
 }
 public String toString() {
 return id + ":" + fee + "@" + ts;
 }
 }
 static void bubbleSortByFee(Transaction[] a) {
 int n = a.length;
 for (int i = 0; i < n - 1; i++) {
 boolean swapped = false;
 for (int j = 0; j < n - i - 1; j++) {
 if (a[j].fee > a[j + 1].fee) {
 Transaction t = a[j];
 a[j] = a[j + 1];
 a[j + 1] = t;
 swapped = true;
 }
 }
 if (!swapped) {
 break;
 }
 }
 }
 static void insertionSortByFeeAndTime(Transaction[] a) {
 for (int i = 1; i < a.length; i++) {
 Transaction key = a[i];
 int j = i - 1;
 while (j >= 0 && (a[j].fee > key.fee || (a[j].fee == key.fee &&
a[j].ts.compareTo(key.ts) > 0))) {
 a[j + 1] = a[j];
 j--;
 }
 a[j + 1] = key;
 }
 }
 static List<Transaction> highFeeOutliers(Transaction[] a) {
 List<Transaction> out = new ArrayList<>();
 for (Transaction t : a) {
 if (t.fee > 50) {
 out.add(t);
 }
 }
 return out;
 }
 public static void main(String[] args) {
 Transaction[] arr = {
 new Transaction("id1", 10.5, "10:00"),
 new Transaction("id2", 25.0, "09:30"),
 new Transaction("id3", 5.0, "10:15"),
 new Transaction("id4", 60.0, "09:10")
 };
 Transaction[] a1 = Arrays.copyOf(arr, arr.length);
 Transaction[] a2 = Arrays.copyOf(arr, arr.length);
 bubbleSortByFee(a1);
 insertionSortByFeeAndTime(a2);
 System.out.println("Bubble Sort by Fee:");
 System.out.println(Arrays.toString(a1));
 System.out.println("Insertion Sort by Fee and Time:");
 System.out.println(Arrays.toString(a2));
 System.out.println("High Fee Outliers:");
 System.out.println(highFeeOutliers(a2));
 }
}

