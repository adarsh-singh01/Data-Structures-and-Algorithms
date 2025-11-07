Operating System:

- What is a socket, kernel and monolithic kernel ? 
- What is the main purpose of an operating system? Discuss different types? 
- Difference between process and program and thread? Different types of process. 
- Define virtual memory, thrashing, threads.  
- What is RAID ? Different types. 
- What is a deadlock ? Different conditions to achieve a deadlock. 
- What is fragmentation? Types of fragmentation. 
- What is spooling ? 
- What is semaphore and mutex (Differences might be asked)? Define Binary semaphore. 
- Belady’s Anomaly
- Starving and Aging in OS
- Why does trashing occur? 
- What is paging and why do we need it? 
- Demand Paging, Segmentation 
- Real Time Operating System, types of RTOS. 
- Difference between main memory and secondary memory. 
- Dynamic Binding 
- FCFS Scheduling 
- SJF Scheduling 
- SRTF Scheduling 
- LRTF Scheduling 
- Priority Scheduling 
- Round Robin Scheduling 
- Producer Consumer Problem 
- Banker’s Algorithm 
- Explain Cache
- Diff between direct mapping and associative mapping 
- Diff between multitasking and multiprocessing 


---

## **1. What is the main purpose of an Operating System? What are its types?**

---

### **Analogy**

Imagine your laptop as a theater:

* The **hardware** is the stage.
* The **applications** are the actors.
* The **operating system** is the stage manager — ensuring everything happens in the right order, sharing resources fairly.

---

### **Definition**

An **Operating System (OS)** is system software that acts as an **interface between user and hardware**, managing resources like CPU, memory, storage, and I/O devices.

---

### **Main Functions**

1. **Process Management** — Scheduling & execution of processes.
2. **Memory Management** — Allocation, paging, segmentation.
3. **File Management** — Handling files and directories.
4. **I/O Management** — Device control and drivers.
5. **Security & Protection** — Authentication, permissions.
6. **Resource Allocation** — CPU time, memory, I/O.
7. **Error Detection & Accounting**.

---

### **Types of Operating Systems**

| Type                    | Description                                   | Example                    |
| ----------------------- | --------------------------------------------- | -------------------------- |
| **Batch OS**            | Executes jobs in batches; no user interaction | IBM Mainframes             |
| **Time-Sharing OS**     | Multitasking for multiple users               | Unix, Windows              |
| **Distributed OS**      | Manages networked computers                   | Amoeba, Hadoop YARN        |
| **Real-Time OS (RTOS)** | Immediate response to inputs                  | VxWorks, QNX               |
| **Embedded OS**         | Runs in devices                               | Android, iOS, Car firmware |
| **Network OS**          | Manages connected systems                     | Novell NetWare             |
| **Mobile OS**           | Optimized for handhelds                       | Android, iOS               |

---

### **Interview Tip**

They might ask: *"Why do we need an OS?"*
→ Without OS, user programs can’t directly communicate with hardware safely or efficiently.

---

## **2. What is a Socket, Kernel, and Monolithic Kernel?**

---

### **Socket**

* A **socket** is an endpoint for **communication between two processes** (can be on same or different machines).
* Works via **IP + Port**.

**Example:**
Browser (client) connects to web server via:

```
Client: 192.168.1.2:50423 → Server: 172.217.19.14:80
```

---

### **Kernel**

* The **core component** of the OS.
* Handles CPU scheduling, memory management, device I/O.
* Runs in **privileged (supervisor) mode**.

---

### **Monolithic Kernel**

* Entire OS (device drivers, file system, system calls) runs in **a single kernel space**.
* Faster but less secure (bug in driver can crash entire system).

**Example:** Linux, Unix.

---

### **Microkernel**

* Only essential services in kernel; others (drivers, file system) in user space.
* More secure but slightly slower (due to message passing).

**Example:** MINIX, QNX.

---

**Comparison:**

| Aspect    | Monolithic Kernel            | Microkernel |
| --------- | ---------------------------- | ----------- |
| Speed     | Fast                         | Slower      |
| Stability | Less (one crash affects all) | High        |
| Design    | Big single block             | Modular     |
| Example   | Linux                        | QNX, Mach   |

---

## **3. Process vs Program vs Thread**

---

### **Definitions**

| Term        | Meaning                                                      |
| ----------- | ------------------------------------------------------------ |
| **Program** | Passive set of instructions (file on disk)                   |
| **Process** | Active execution of a program (running instance)             |
| **Thread**  | Lightweight subprocess sharing resources with parent process |

---

### **Analogy**

Program = recipe book
Process = cooking a recipe
Thread = multiple chefs working on same dish (shared ingredients)

---

### **Process Structure**

```
Code (text)
Data (global vars)
Heap (dynamic memory)
Stack (function calls)
Registers, PC
```

---

### **Types of Processes**

* **Foreground/Background**
* **I/O Bound / CPU Bound**
* **System / User**
* **Daemon** (background services like sshd)

---

### **Interview Tip**

Threads share memory space; processes don’t.
Context switching between threads is faster.

---

## **4. Define Virtual Memory, Thrashing, Threads**

---

### **Virtual Memory**

Allows execution of processes **larger than physical RAM** by using disk space as an extension of memory.

**Analogy:**
RAM = desk; Hard disk = cabinet.
When desk full, temporarily move papers to cabinet.

---

**Mechanism:**

* OS divides memory into **pages** (usually 4 KB).
* Stores some in RAM, rest in disk (**swap space**).
* Accessed via **paging**.

---

### **Thrashing**

When the system **spends more time swapping pages** in/out of disk than executing tasks.

**Causes:**

* Too many processes
* Insufficient RAM
* Poor page replacement

---

### **Threads**

Lightweight subprocess sharing the same memory space.

**Advantages:**

* Parallelism
* Faster context switching
* Efficient CPU utilization

---

**Interview Tip:**
Virtual memory gives illusion of infinite RAM; thrashing is the failure case of it.

---

## **5. What is RAID? Types**

---

### **Definition**

**RAID (Redundant Array of Independent Disks)** = technology to combine multiple physical disks into one logical unit for **performance and fault tolerance**.

---

### **Types**

| RAID Level  | Description                               | Advantage                         |
| ----------- | ----------------------------------------- | --------------------------------- |
| **RAID 0**  | Striping – splits data across disks       | Fast, no redundancy               |
| **RAID 1**  | Mirroring – copies data on multiple disks | Redundancy, slower writes         |
| **RAID 5**  | Striping + Parity                         | Fault tolerance (1 disk can fail) |
| **RAID 6**  | Double Parity                             | 2 disks can fail                  |
| **RAID 10** | Striping + Mirroring                      | Fast + redundant, but costly      |

---

**Diagram (RAID 1):**

```
Disk1: A1, A2
Disk2: A1, A2 (Mirror)
```

---

### **Interview Tip**

RAID ≠ Backup; it’s redundancy.
RAID 0 → performance; RAID 1 → reliability.

---

## **6. What is Deadlock? Conditions for Deadlock**

---

### **Analogy**

Two people crossing a narrow bridge from opposite sides — both stop, neither can move forward.

---

### **Definition**

A **deadlock** occurs when two or more processes are waiting indefinitely for resources held by each other.

---

### **Necessary Conditions (Coffman’s Conditions)**

1. **Mutual Exclusion** – Only one process holds resource.
2. **Hold and Wait** – A process holds one and waits for another.
3. **No Preemption** – Resources can’t be forcibly taken.
4. **Circular Wait** – Processes form a circular chain waiting for each other.

```
P1 → R1
P2 → R2
R1 → P2
R2 → P1
```

---

### **Interview Tip**

Prevent any one condition → Deadlock avoided.
Detection = Resource Allocation Graph (RAG).

---

## **7. What is Fragmentation?**

---

### **Definition**

**Fragmentation** occurs when memory is allocated and freed in a way that leaves small unusable spaces.

---

### **Types**

| Type                       | Description                             | Example                                 |
| -------------------------- | --------------------------------------- | --------------------------------------- |
| **Internal Fragmentation** | Allocated memory > requested memory     | Process requests 8 KB, gets 10 KB block |
| **External Fragmentation** | Enough total memory, but not contiguous | Free 10 KB scattered as 2+3+5 KB        |

---

### **Solutions**

* **Compaction** – Rearrange processes to make contiguous space.
* **Paging** – Divide memory into fixed-size pages.

---

### **Interview Tip**

Internal = waste *inside* blocks.
External = waste *between* blocks.

---

## **8. What is Spooling?**

---

### **Analogy**

Printing multiple documents → temporarily stored in a queue before printing.
That’s **spooling**.

---

### **Definition**

**Spooling (Simultaneous Peripheral Operation On-Line)** is buffering data for slower devices like printers.

---

### **Purpose**

* Asynchronous I/O.
* CPU doesn’t wait for slow device.
* Improves performance.

---

### **Example**

```
CPU → Disk (spool) → Printer
```

---

### **Interview Tip**

Used in print queues, email systems, and batch processing.

---

## **9. Semaphore and Mutex**

---

### **Definition**

Both are synchronization primitives to manage access to shared resources in concurrent systems.

---

| Feature        | **Semaphore**                       | **Mutex**                              |
| -------------- | ----------------------------------- | -------------------------------------- |
| **Definition** | Integer variable used for signaling | Locking mechanism for exclusive access |
| **Value**      | Can be >1                           | Binary (0 or 1)                        |
| **Owner**      | No concept                          | Has owner                              |
| **Used for**   | Signaling                           | Mutual exclusion                       |
| **Type**       | Binary, Counting                    | Binary only                            |

---

### **Binary Semaphore**

* Values: 0 (locked) or 1 (unlocked).
* Used for mutual exclusion, like a Mutex.

---

### **Analogy**

Semaphore = Traffic light (controls flow).
Mutex = Room key (only one person can enter).

---

### **Interview Tip**

* Semaphore allows multiple processes (counting).
* Mutex allows only one (binary).

---

## **10. Belady’s Anomaly**

---

### **Definition**

In some page replacement algorithms, **increasing number of frames increases page faults** — counterintuitive behavior.

---

### **Occurs In**

FIFO (First In First Out) algorithm.

---

### **Example**

Reference string: 1,2,3,4,1,2,5,1,2,3,4,5
With 3 frames → 9 page faults
With 4 frames → 10 page faults

---

### **Interview Tip**

Belady’s Anomaly occurs only in **non-stack algorithms** (like FIFO).
**LRU, Optimal** do not suffer from it.

---

## **11. Starvation and Aging**

---

### **Starvation**

A process never gets CPU or resource due to continuous preference for others (low-priority process always postponed).

---

### **Aging**

Gradual increase in priority of waiting processes to **prevent starvation**.

---

### **Interview Tip**

Starvation often in **priority scheduling**.
Aging is the **solution**.

---

## **12. Why Does Thrashing Occur?**

---

### **Definition**

Thrashing = excessive paging activity causing CPU to spend time swapping pages instead of executing processes.

---

### **Causes**

* Too many active processes
* Not enough memory
* Poor replacement policy

---

### **Fixes**

* Increase RAM
* Reduce degree of multiprogramming
* Use working set model

---

### **Interview Tip**

Thrashing = “system busy but doing no useful work.”

---

## **13. What is Paging? Why Do We Need It?**

---

### **Analogy**

Imagine dividing a book into equal-sized pages — you can bring only a few pages to your desk at once instead of the whole book.

---

### **Definition**

**Paging** divides physical memory and logical memory into **fixed-size blocks**:

* Logical memory → **pages**
* Physical memory → **frames**

---

### **How It Works**

1. Process divided into pages.
2. Loaded into any available frames.
3. Page table maps logical → physical addresses.

---

**Diagram**

```
Logical: 0 1 2 3 → Page Table → Physical: 5 8 2 1
```

---

### **Need**

* Avoid external fragmentation.
* Allow non-contiguous allocation.
* Efficient use of memory.

---

### **Interview Tip**

Each process has its **own page table**; each access involves **address translation** using **MMU (Memory Management Unit).**

---

## **14. Demand Paging**

---

### **Definition**

Only load pages **when they’re needed** (on-demand), not the whole process.

---

### **Advantages**

* Less memory usage.
* Faster start-up time.

---

### **Disadvantages**

* Page fault when page not found in memory → disk access required.

---

### **Interview Tip**

Paging + On-demand loading = **Demand Paging**
Key idea in **virtual memory**.

---

## **15. Segmentation**

---

### **Definition**

Memory management technique where memory is divided into **variable-sized logical segments** like:

* Code
* Stack
* Heap
* Data

---

**Address = Segment Number + Offset**

---

### **Comparison:**

| Aspect        | Paging               | Segmentation            |
| ------------- | -------------------- | ----------------------- |
| Division      | Fixed-size           | Variable-size           |
| Basis         | Physical             | Logical                 |
| Fragmentation | Internal             | External                |
| Addressing    | Page number + offset | Segment number + offset |

---

### **Interview Tip**

Segmentation provides **logical view**; paging provides **physical view**.

---

## **16. Real-Time Operating System (RTOS)**

---

### **Definition**

An **RTOS** guarantees **task completion within a defined time** — critical in embedded, medical, or control systems.

---

### **Types**

| Type          | Description                                  | Example           |
| ------------- | -------------------------------------------- | ----------------- |
| **Hard RTOS** | Deadlines must be met                        | Airbag controller |
| **Soft RTOS** | Occasional delay acceptable                  | Video streaming   |
| **Firm RTOS** | Occasional miss okay, but too many = failure | Telecom switches  |

---

### **Interview Tip**

Used in robotics, automotive, avionics — where **deterministic timing** is vital.

---

## **17. Difference between Main Memory and Secondary Memory**

| Feature        | Main Memory (RAM) | Secondary Memory (Disk) |
| -------------- | ----------------- | ----------------------- |
| **Volatility** | Volatile          | Non-volatile            |
| **Speed**      | Fast              | Slow                    |
| **Access**     | CPU direct        | Through I/O             |
| **Usage**      | Temporary storage | Permanent storage       |
| **Cost**       | Expensive         | Cheap                   |

---

### **Analogy**

RAM = desk (temporary workspace)
Disk = cabinet (permanent archive)

---

## **18. Dynamic Binding**

---

### **Definition**

**Dynamic binding** refers to the process where the address of a function or variable is determined **at runtime** rather than compile time.

---

### **Example**

In OS context, dynamic binding links **process to memory addresses** when loaded (not during compilation).

---

### **Interview Tip**

Key difference:

* Static Binding → at compile time
* Dynamic Binding → at runtime (e.g., virtual memory address translation)

---

## **19. FCFS Scheduling (First Come First Serve)**

---

### **Analogy**

Imagine a queue at a ticket counter — whoever arrives first, gets served first.
That’s FCFS scheduling.

---

### **Definition**

**FCFS** is the simplest CPU scheduling algorithm — processes are executed **in the order they arrive**.

---

### **How It Works**

* Non-preemptive.
* CPU assigned to the process that requests first.

---

### **Example**

| Process | Arrival Time | Burst Time |
| ------- | ------------ | ---------- |
| P1      | 0            | 4          |
| P2      | 1            | 3          |
| P3      | 2            | 1          |

**Gantt Chart:**

```
| P1 | P2 | P3 |
0    4    7    8
```

**Average Waiting Time:**
WT = (0 + 3 + 5) / 3 = **2.67 ms**

---

### **Advantages**

* Simple, easy to implement.
* Fair (first come first serve).

---

### **Disadvantages**

* **Convoy effect:** Small processes wait behind large ones.
* Poor average waiting time.

---

### **Interview Tip**

* Non-preemptive
* Used in batch systems
* Not efficient for time-sharing systems

---

## **20. SJF Scheduling (Shortest Job First)**

---

### **Analogy**

If you’re at a barbershop, and a person with a 2-minute haircut arrives — it’s logical to finish that before a 30-minute haircut. That’s **SJF**.

---

### **Definition**

Selects process with **smallest CPU burst time** next.

---

### **Example**

| Process | Burst Time |
| ------- | ---------- |
| P1      | 6          |
| P2      | 8          |
| P3      | 7          |
| P4      | 3          |

**Execution Order:** P4 → P1 → P3 → P2

---

### **Advantages**

* Minimum average waiting time (optimal).

---

### **Disadvantages**

* Hard to know burst time in advance.
* **Starvation** possible for long processes.

---

### **Interview Tip**

SJF is optimal **if all jobs arrive together**.
If preemption allowed → **SRTF** (next topic).

---

## **21. SRTF (Shortest Remaining Time First)**

---

### **Definition**

Preemptive version of SJF — CPU always assigned to process with **least remaining time**.

---

### **Example**

```
P1: Arrival=0, Burst=8
P2: Arrival=1, Burst=4
```

At time 1, P2 arrives (shorter), so P1 preempted.

---

### **Advantages**

* Faster average turnaround time.
* Responsive for short processes.

---

### **Disadvantages**

* Context switching overhead.
* Requires knowledge of remaining time.

---

### **Interview Tip**

SRTF = SJF + Preemption.
High scheduling overhead.

---

## **22. LRTF (Longest Remaining Time First)**

---

### **Definition**

Opposite of SRTF — CPU given to process with **longest remaining time**.

---

### **Use Case**

Rare in real systems; used for **theoretical comparisons** or in background/low-priority tasks.

---

### **Interview Tip**

May cause heavy **starvation** for short jobs.

---

## **23. Priority Scheduling**

---

### **Definition**

Each process has a **priority**; CPU assigned to process with **highest priority**.

---

### **Example**

| Process | Priority | Burst |
| ------- | -------- | ----- |
| P1      | 3        | 10    |
| P2      | 1        | 5     |
| P3      | 2        | 2     |

Execution: P2 → P3 → P1 (1 = highest)

---

### **Problems**

* **Starvation:** Low priority may never execute.
* **Solution:** **Aging** (increase priority over time).

---

### **Preemptive or Non-preemptive?**

Can be either.

---

### **Interview Tip**

Common in real-time systems where priority = importance.

---

## **24. Round Robin Scheduling**

---

### **Analogy**

In a classroom Q&A, each student gets 1 minute to speak; after that, the next student speaks — that’s **Round Robin (RR)**.

---

### **Definition**

Each process gets a **fixed time quantum**; after it expires, CPU switches to next process in queue.

---

### **Example**

| Process | Burst Time |
| ------- | ---------- |
| P1      | 10         |
| P2      | 5          |
| P3      | 8          |

Time Quantum = 3

**Execution Order:**

```
P1 → P2 → P3 → P1 → P3 → P1
```

---

### **Advantages**

* Fair (each process gets equal CPU time).
* Good for time-sharing systems.

---

### **Disadvantages**

* High context switching if time quantum too small.
* Poor throughput if too large.

---

### **Interview Tip**

RR is **preemptive FCFS**.
Time quantum tuning = key factor.

---

## **25. Producer–Consumer Problem**

---

### **Analogy**

Producer = Chef
Consumer = Waiter
Table = Buffer.
If table is full, chef waits; if empty, waiter waits.

---

### **Definition**

A classic synchronization problem using shared buffer and semaphores.

---

### **Solution Using Semaphores**

```c
Semaphore full = 0, empty = n, mutex = 1;

Producer:
while (true) {
    wait(empty);
    wait(mutex);
    produce_item();
    signal(mutex);
    signal(full);
}

Consumer:
while (true) {
    wait(full);
    wait(mutex);
    consume_item();
    signal(mutex);
    signal(empty);
}
```

---

### **Interview Tip**

Tests **understanding of semaphores and synchronization**.
Use of **mutex** ensures only one accesses buffer.

---

## **26. Banker’s Algorithm**

---

### **Analogy**

Bank gives loans only if it can still satisfy all customers with remaining resources — avoids bankruptcy (deadlock).

---

### **Definition**

**Banker’s algorithm** avoids deadlock by ensuring that the system never enters an unsafe state.

---

### **Data Structures**

1. **Available** – Available resources.
2. **Max** – Maximum demand per process.
3. **Allocation** – Current allocation.
4. **Need = Max - Allocation.**

---

### **Working Steps**

1. Check if a process’s need ≤ available.
2. If yes, assume it executes → release its resources.
3. Repeat until all can finish.
4. If all can finish → safe state.

---

### **Interview Tip**

This is a **deadlock avoidance** algorithm (not prevention).
Often asked to calculate safe sequence.

---

## **27. Cache Memory**

---

### **Analogy**

You keep your most-used items on your desk instead of your cupboard — that’s cache.

---

### **Definition**

A **small, fast memory** that stores frequently used data/instructions to reduce average access time to main memory.

---

### **Types**

| Type   | Description                       |
| ------ | --------------------------------- |
| **L1** | Closest to CPU, smallest, fastest |
| **L2** | Between CPU & RAM                 |
| **L3** | Shared between cores              |

---

### **Locality Principles**

* **Temporal Locality:** Recently accessed data likely reused soon.
* **Spatial Locality:** Nearby data likely accessed next.

---

### **Interview Tip**

Cache hit ratio = hits / (hits + misses).
Higher ratio → better performance.

---

## **28. Direct vs Associative Mapping (Cache)**

| Aspect          | **Direct Mapping**               | **Associative Mapping** |
| --------------- | -------------------------------- | ----------------------- |
| **Definition**  | Each block maps to only one line | Block can go anywhere   |
| **Speed**       | Fast                             | Slower                  |
| **Flexibility** | Limited                          | High                    |
| **Collision**   | Frequent                         | Reduced                 |
| **Hardware**    | Simple                           | Complex                 |

---

**Example:**

* Direct → fixed position like “row 3 always to cache line 3.”
* Associative → “any free line can be used.”

---

### **Interview Tip**

Hybrid = **Set-Associative Mapping** — used in modern CPUs.

---

## **29. Multitasking vs Multiprocessing**

| Aspect          | **Multitasking**                                | **Multiprocessing**                        |
| --------------- | ----------------------------------------------- | ------------------------------------------ |
| **Definition**  | Single CPU runs multiple tasks via time-sharing | Multiple CPUs execute tasks simultaneously |
| **Concurrency** | Logical (via scheduling)                        | True parallelism                           |
| **Example**     | Windows running Chrome + Word                   | Multi-core servers                         |
| **Speed**       | CPU time divided                                | Faster with more CPUs                      |
| **Failure**     | If CPU fails, all stop                          | Redundant CPUs available                   |

---

### **Analogy**

Multitasking = one chef cooking multiple dishes sequentially.
Multiprocessing = multiple chefs cooking different dishes simultaneously.

---

### **Interview Tip**

Modern systems are **multiprocessing + multitasking** both.
(Each CPU core runs multiple threads.)

---

## **30. BONUS: Quick Recap Table**

| Concept                 | Definition                     | Example/Hint             |
| ----------------------- | ------------------------------ | ------------------------ |
| **OS Purpose**          | Interface & resource manager   | Windows, Linux           |
| **Kernel**              | Core of OS                     | Monolithic (Linux)       |
| **Process vs Thread**   | Independent vs shared memory   | Thread faster            |
| **Virtual Memory**      | Uses disk as RAM extension     | Paging                   |
| **Deadlock**            | Circular resource wait         | Coffman’s 4 conditions   |
| **Fragmentation**       | Memory gaps                    | Internal vs External     |
| **Spooling**            | Queue for I/O devices          | Printer queue            |
| **Semaphore/Mutex**     | Synchronization                | Binary Semaphore = Mutex |
| **Belady’s Anomaly**    | More frames → more page faults | FIFO only                |
| **Paging/Segmentation** | Memory management              | Logical vs Physical      |
| **RTOS**                | Time-critical system           | VxWorks                  |
| **Scheduling**          | CPU allocation                 | SJF, RR, Priority        |
| **Producer–Consumer**   | Shared buffer problem          | Semaphores               |
| **Banker’s Algorithm**  | Deadlock avoidance             | Safe sequence            |
| **Cache**               | Fast small memory              | L1, L2, L3               |
| **Mapping**             | Cache placement                | Direct vs Associative    |
| **Multitasking**        | One CPU, many tasks            | OS switching             |
| **Multiprocessing**     | Many CPUs                      | Parallelism              |

---