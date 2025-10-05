# 📘 Assignment 2 — Selection Sort (with Early Termination Optimization)

## 🧠 Overview
This project implements an optimized version of the **Selection Sort** algorithm in Java.  
The optimization introduces **early termination**, stopping the algorithm if the remaining portion of the array is already sorted — improving performance on *nearly-sorted data*.

The program also collects **metrics** for educational and benchmarking purposes.

---

## ⚙️ Features
- 📊 **Metrics tracking:** comparisons, swaps, and array accesses
- 🧾 **CSV export** for performance data
- 🧮 **CLI interface** for configurable input sizes
- 🧠 **Optimization:** early termination detection
- ✅ **Unit tests** using JUnit 5
- 💾 **Memory-efficient in-place sorting**

---

## 🚀 Usage

### ▶️ Run from terminal (Maven)
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="1000"
```

> Replace `1000` with your desired array size.

### 📈 Example Output
```
✅ Array sorted successfully.
Comparisons: 499500
Swaps: 999
Array accesses: 2000000
Time: 2.314 ms
```

A `metrics.csv` file will also be generated with columns:
```
size,comparisons,swaps,arrayAccesses,time(ms)
```

---

## 🧩 Optimization: Early Termination

**Idea:**  
Normally, selection sort always performs `n²/2` comparisons even if the array is already sorted.  
This version detects sorted sequences and stops early:

```java
if (minIndex == i) {
    boolean sorted = true;
    for (int k = i; k < n - 1; k++) {
        if (array[k] > array[k + 1]) {
            sorted = false;
            break;
        }
    }
    if (sorted) break;
}
```

This significantly improves performance on nearly-sorted arrays.

---

## 📊 Complexity Analysis

| Case | Time Complexity | Space Complexity | Notes |
|------|------------------|------------------|--------|
| Best (sorted input) | **O(n)** | O(1) | Early termination triggers |
| Average | **O(n²)** | O(1) | Standard selection sort behavior |
| Worst | **O(n²)** | O(1) | Fully reversed input |
| Stable | ❌ | — | Selection sort is not stable |

---

## 🧪 Testing

Run unit tests:
```bash
mvn test
```

Covers:
- Empty array
- Single element
- Randomized input
- Already sorted array
- Reverse-sorted array

---

## 🧾 CSV Metrics Example
| size | comparisons | swaps | arrayAccesses | time(ms) |
|------|--------------|--------|----------------|-----------|
| 1000 | 499500 | 999 | 2000000 | 2.314 |

---

## 📦 Project Structure
```
Assignment2/
 ├── pom.xml
 ├── README.md
 ├── src/
 │   ├── main/java/org/example/Main.java
 │   ├── main/java/org/example/MetricsExporter.java
 │   └── test/java/org/example/MainTest.java
 └── metrics.csv
```

---

## 🧑‍💻 Author
**Heazytt** — Astana IT University  
Assignment 2 — Design and Analysis of Algorithms  
