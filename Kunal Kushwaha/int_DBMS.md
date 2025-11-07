DBMS: 
- What is DBMS ? Mention advantages.. 
- What is Database? 
- What is a database system? 
- What is RDBMS ? Properties.. 
- Types of database languages 
- ACID properties (VVVVV IMP) 
- Difference between vertical and horizontal scaling 
- What is sharding 
- Keys in DBMS 
- Types of relationship 
- Data abstraction in DBMS, three levels of it 
- Indexing in DBMS 
- What is DDL (Data Definition Language) 
- What is DML (Data Manipulation Language)
- What is normalization ? Types of them .. 
- What is denormalization ? 
- What is functional dependency ? 
- E-R Model ? 
- Conflict Serializability in DBMS .. 
- Explain Normal forms in DBMS 
- What is CCP ? (Concurrency Control Protocols) 
- Entity, Entity Type, Entity Set, Weak Entity Set.. 
- What are SQL commands ? Types of them.. 
- Nested Queries in SQL ? 
- What is JOIN .. Explain types of JOINs 
- Inner and Outer Join 
- Practice sql queries from leetcode
- Diff between 2 tier and 3 tier architecture 
- Diff between TRUNCATE and DELETE command .. 
- Difference between Intension and Extension in a DataBase
- Difference between share lock and exclusive lock, definition of lock 


---

# **1. What is DBMS? Advantages**

### **Analogy**

Imagine a library where thousands of books are stored.
Without a librarian, you’d struggle to find anything.
A **DBMS** is that librarian — it organizes, manages, and secures data efficiently.

---

### **Definition**

A **Database Management System (DBMS)** is **software** that helps create, manage, and manipulate databases.
It acts as an interface between **users/applications** and the **database**.

---

### **Core Functions**

1. **Data Definition** – Create & modify database schema.
2. **Data Storage** – Store large data efficiently.
3. **Data Retrieval** – Querying (SQL).
4. **Data Control** – Security & concurrency.
5. **Data Integrity** – Maintains correctness.

---

### **Advantages**

| Advantage                   | Description                                |
| --------------------------- | ------------------------------------------ |
| **Data Redundancy Control** | Avoids duplicate data.                     |
| **Data Integrity**          | Ensures accuracy & consistency.            |
| **Security**                | Access control via authentication.         |
| **Backup & Recovery**       | Prevents data loss.                        |
| **Concurrency Control**     | Handles multiple users simultaneously.     |
| **Abstraction**             | Users view data logically, not physically. |

---

### **Interview Tip**

* A DBMS provides a **systematic** way to manage data.
* Examples: MySQL, Oracle, MongoDB, PostgreSQL.

---

# **2. What is Database?**

### **Definition**

A **database** is a **structured collection of related data** stored electronically for efficient access, management, and updating.

---

### **Analogy**

A database is like a **digital filing cabinet** — data is stored in an organized way using **tables (rows & columns)**.

---

### **Example**

```
STUDENTS TABLE
+----+--------+-------+
| ID | Name   | Marks |
+----+--------+-------+
| 1  | Ravi   | 95    |
| 2  | Neha   | 88    |
+----+--------+-------+
```

---

# **3. What is a Database System?**

### **Definition**

A **database system** includes:

* The **database** itself (data)
* The **DBMS software**
* The **users** and **applications** interacting with it

So it’s a **complete environment** for data management.

---

### **Architecture**

```
Users → Application → DBMS → Database (Storage)
```

---

### **Interview Tip**

The **database** = data
The **DBMS** = manager
The **database system** = the entire ecosystem.

---

# **4. What is RDBMS? Properties**

### **Definition**

An **RDBMS (Relational DBMS)** stores data in **tables (relations)**, where each row is a **tuple** and each column is an **attribute**.

---

### **Examples**

MySQL, Oracle, PostgreSQL, SQL Server.

---

### **Properties (E.F. Codd’s Rules)**

| Property        | Meaning                            |
| --------------- | ---------------------------------- |
| **Atomicity**   | Each cell has single atomic value. |
| **Consistency** | Data follows defined rules.        |
| **Isolation**   | Transactions independent.          |
| **Durability**  | Data saved permanently.            |

---

### **Advantages**

* Easier querying with SQL.
* Ensures data integrity via constraints (PK, FK).
* Supports relationships between entities.

---

# **5. Types of Database Languages**

| Type    | Full Form                    | Purpose          | Example Commands               |
| ------- | ---------------------------- | ---------------- | ------------------------------ |
| **DDL** | Data Definition Language     | Defines schema   | CREATE, ALTER, DROP            |
| **DML** | Data Manipulation Language   | Manage records   | SELECT, INSERT, UPDATE, DELETE |
| **DCL** | Data Control Language        | Permissions      | GRANT, REVOKE                  |
| **TCL** | Transaction Control Language | Transaction mgmt | COMMIT, ROLLBACK, SAVEPOINT    |
| **DQL** | Data Query Language          | Query info       | SELECT                         |

---

# **6. ACID Properties (Very Important)**

### **Definition**

ACID ensures **reliability and consistency** of transactions.

| Property        | Description                              | Example                                       |
| --------------- | ---------------------------------------- | --------------------------------------------- |
| **Atomicity**   | All or nothing.                          | If money deducted from A, must be added to B. |
| **Consistency** | Transaction leaves DB valid.             | Balance totals remain same.                   |
| **Isolation**   | Concurrent transactions don’t interfere. | Two transfers won’t mix.                      |
| **Durability**  | Once committed, changes persist.         | Power loss won’t revert commit.               |

---

### **Analogy**

Bank transfer: if ₹1000 moves from A→B
→ Either both debit & credit happen or none (Atomic).
→ Total system balance stays same (Consistent).
→ Others can’t see partial transfer (Isolated).
→ Once done, stays done (Durable).

---

### **Interview Tip**

If a DBMS doesn’t ensure ACID, data becomes inconsistent during system failures or concurrent access.

---

# **7. Difference Between Vertical and Horizontal Scaling**

| Aspect         | **Vertical Scaling (Scale-Up)**             | **Horizontal Scaling (Scale-Out)**        |
| -------------- | ------------------------------------------- | ----------------------------------------- |
| **Method**     | Add more power (CPU/RAM) to existing server | Add more servers                          |
| **Complexity** | Simple                                      | Complex (requires sharding/load balancer) |
| **Cost**       | Expensive hardware                          | Commodity hardware                        |
| **Example**    | Upgrading 8 GB → 64 GB RAM                  | Adding 4 more database nodes              |
| **Limitation** | Hardware limit                              | Near-infinite scalability                 |

---

### **Analogy**

Vertical = Bigger bucket
Horizontal = More buckets.

---

### **Interview Tip**

* SQL DBs traditionally vertical;
* NoSQL DBs (like MongoDB) support horizontal scaling better.

---

# **8. What is Sharding?**

### **Definition**

**Sharding** = horizontal partitioning of a database into smaller, faster pieces called **shards**.

Each shard holds a subset of data (like splitting a big table).

---

### **Example**

```
USERS TABLE (Sharded by Region)
Shard 1 → Asia users
Shard 2 → Europe users
Shard 3 → America users
```

---

### **Advantages**

* Faster queries (less data per shard).
* Easier scaling (add more shards).
* Fault isolation.

---

### **Disadvantages**

* Complex queries across shards.
* Rebalancing required when shards grow unevenly.

---

### **Interview Tip**

Used in distributed systems like MongoDB, Cassandra, or large-scale MySQL clusters.

---

# **9. Keys in DBMS**

| Key Type          | Definition                                           | Example                                  |
| ----------------- | ---------------------------------------------------- | ---------------------------------------- |
| **Super Key**     | Any set of attributes that uniquely identifies a row | {ID}, {ID, Name}                         |
| **Candidate Key** | Minimal super key                                    | {ID}                                     |
| **Primary Key**   | Chosen candidate key (no NULL)                       | ID                                       |
| **Alternate Key** | Remaining candidate keys                             | RollNo                                   |
| **Foreign Key**   | Refers to PK in another table                        | DeptID in Employee references Dept table |
| **Composite Key** | Multiple attributes together act as key              | {OrderID, ProductID}                     |
| **Unique Key**    | Must be unique but can have NULL                     | Email                                    |

---

### **Interview Tip**

They often ask: *“Can a table have multiple candidate keys?”* → Yes.
*Multiple primary keys?* → No, only one (but can be composite).

---

# **10. Types of Relationships**

| Type                   | Description                                | Example                |
| ---------------------- | ------------------------------------------ | ---------------------- |
| **One-to-One (1:1)**   | One record in A ↔ one in B                 | Passport ↔ Person      |
| **One-to-Many (1:N)**  | One record in A ↔ many in B                | Department ↔ Employees |
| **Many-to-Many (M:N)** | Many in A ↔ many in B (via junction table) | Student ↔ Courses      |

---

### **Diagram Example**

```
Dept (DeptID) 1 ───< Employee (EmpID, DeptID)
```

---

### **Interview Tip**

* M:N implemented via an **intermediate mapping table**.
* Relationship cardinality is key for designing ER diagrams.

---

# **11. Data Abstraction in DBMS (Three Levels)**

### **Definition**

**Data abstraction** hides complexity of data storage from users by providing multiple views.

---

### **Three Levels**

| Level                    | Description                                   | Example                        |
| ------------------------ | --------------------------------------------- | ------------------------------ |
| **Physical (Internal)**  | How data is actually stored on disk           | Blocks, indexes, storage paths |
| **Logical (Conceptual)** | Structure of database (tables, relationships) | Employee table schema          |
| **View (External)**      | User-specific subset of data                  | Employee salary view           |

---

### **Analogy**

Bank staff see different views:

* Clerk → account details
* Manager → overview
* System admin → storage locations

---

### **Interview Tip**

Data abstraction ensures **data independence**:

* *Logical Independence* → Change structure without affecting apps.
* *Physical Independence* → Change storage without changing schema.

---

# **12. Indexing in DBMS**

### **Analogy**

Like an **index in a book** — instead of reading every page, you jump directly to the topic.

---

### **Definition**

An **index** is a data structure (often B-tree or hash) that improves the **speed of data retrieval**.

---

### **How It Works**

* DB creates a small structure mapping keys to record locations.
* Search becomes O(log n) instead of O(n).

---

### **Example**

```
CREATE INDEX idx_student_name ON Students(Name);
```

---

### **Types**

| Type                    | Description                      |
| ----------------------- | -------------------------------- |
| **Primary Index**       | Built on primary key             |
| **Secondary Index**     | Built on non-primary attributes  |
| **Clustered Index**     | Rearranges actual data in order  |
| **Non-Clustered Index** | Separate structure with pointers |

---

### **Trade-offs**

* Faster reads
* Slower writes (updates require index maintenance)
* More disk usage

---

### **Interview Tip**

B-Tree indexing is default in SQL databases;
Hash indexing used in memory stores (Redis).

---

# **13. DDL (Data Definition Language)**

### **Definition**

Used to **define or modify** database schema.

| Command      | Purpose                            |
| ------------ | ---------------------------------- |
| **CREATE**   | Create tables or objects           |
| **ALTER**    | Modify schema                      |
| **DROP**     | Delete table                       |
| **TRUNCATE** | Delete all data but keep structure |

---

### **Example**

```sql
CREATE TABLE Students (
   ID INT PRIMARY KEY,
   Name VARCHAR(50),
   Marks INT
);
```

---

# **14. DML (Data Manipulation Language)**

### **Definition**

Used to **manipulate or access** data inside tables.

| Command    | Purpose        |
| ---------- | -------------- |
| **SELECT** | Retrieve data  |
| **INSERT** | Add records    |
| **UPDATE** | Modify records |
| **DELETE** | Remove records |

---

### **Example**

```sql
INSERT INTO Students VALUES (1, 'Ravi', 95);
SELECT * FROM Students;
```

---

### **Interview Tip**

DDL auto-commits changes; DML can be rolled back.

---

# **15. What is Normalization? Types**

---

### **Analogy**

Imagine a messy library where the same book appears in 10 places.
Normalization is like organizing the shelves so every book is stored once — clean, consistent, no duplication.

---

### **Definition**

**Normalization** is the process of **organizing data** to reduce redundancy and improve data integrity by dividing large tables into smaller, related ones.

---

### **Objectives**

* Eliminate redundant data
* Ensure data dependencies are logical
* Make database modification easier and consistent

---

### **Types of Normal Forms**

| Normal Form                       | Condition                                                      | Example                              |
| --------------------------------- | -------------------------------------------------------------- | ------------------------------------ |
| **1NF (First Normal Form)**       | Atomic values only (no repeating groups)                       | Avoid arrays or lists inside a field |
| **2NF (Second Normal Form)**      | 1NF + no partial dependency (no non-key depends on part of PK) | In composite keys                    |
| **3NF (Third Normal Form)**       | 2NF + no transitive dependency                                 | Non-key depends only on PK           |
| **BCNF (Boyce-Codd Normal Form)** | Stronger 3NF (every determinant is a candidate key)            | Fix anomalies left in 3NF            |
| **4NF (Fourth Normal Form)**      | 3NF + no multi-valued dependency                               | One-to-many relationships separated  |
| **5NF (Fifth Normal Form)**       | No join dependency                                             | Further decomposed if needed         |

---

### **Example**

**Unnormalized Table**

```
Student(ID, Name, Course1, Course2)
```

→ **1NF:**

```
Student(ID, Name, Course)
```

→ **2NF (if composite key):**

```
Student(ID, Name)
Course(ID, Course)
```

→ **3NF:**

```
Student(ID, Name, DeptID)
Department(DeptID, DeptName)
```

---

### **Interview Tip**

* Always state **goal:** remove redundancy & anomalies.
* Mention **update, insert, delete anomalies**.
* BCNF is *ideal* form but not always practical (joins can slow).

---

# **16. What is Denormalization?**

---

### **Analogy**

If normalization is splitting data into smaller pieces, **denormalization** is *merging some of them back* for performance.

---

### **Definition**

**Denormalization** adds redundancy intentionally to **improve read performance**, especially in analytical or large-scale systems.

---

### **Example**

Instead of separate `Orders` and `Customers` tables:

```
Orders(OrderID, CustomerName, City, Product)
```

→ No joins needed for quick queries.

---

### **Trade-Off**

| Advantage           | Disadvantage          |
| ------------------- | --------------------- |
| Faster read queries | More redundancy       |
| Fewer joins         | Risk of inconsistency |

---

### **Interview Tip**

Used in **data warehouses** or **NoSQL systems** where performance outweighs normalization rules.

---

# **17. What is Functional Dependency?**

---

### **Definition**

A **functional dependency (FD)** is a relationship between two attributes where **one attribute uniquely determines another.**

Notation:
`A → B` (A determines B)

---

### **Example**

```
RollNo → Name, Dept
```

Means: If RollNo is known, you can find Name and Dept.

---

### **Types**

| Type               | Meaning                    | Example                            |
| ------------------ | -------------------------- | ---------------------------------- |
| **Trivial FD**     | Right side ⊆ Left side     | {A,B} → A                          |
| **Non-Trivial FD** | Right side not ⊆ Left side | A → B                              |
| **Transitive FD**  | A → B and B → C ⇒ A → C    | RollNo → DeptID, DeptID → DeptName |

---

### **Interview Tip**

Functional dependencies form the basis for **normalization**.
BCNF is derived from **violations of FDs**.

---

# **18. E-R Model (Entity-Relationship Model)**

---

### **Analogy**

Like a blueprint of your database before building it — identifies entities, their attributes, and how they’re related.

---

### **Definition**

An **E-R model** visually represents entities (tables), attributes (columns), and relationships among them.

---

### **Components**

| Concept          | Description                  | Symbol               |
| ---------------- | ---------------------------- | -------------------- |
| **Entity**       | Real-world object            | Rectangle            |
| **Attribute**    | Property of entity           | Oval                 |
| **Relationship** | Association between entities | Diamond              |
| **Primary Key**  | Uniquely identifies entity   | Underlined attribute |

---

### **Example**

```
STUDENT (ID, Name)
COURSE (CID, Title)
ENROLLS (Date)
```

**Relationships:**

```
STUDENT ───< ENROLLS >─── COURSE
```

(Many-to-Many)

---

### **Interview Tip**

They may ask you to draw an ER diagram for a mini scenario (like Library DB, Hospital DB).

---

# **19. Conflict Serializability in DBMS**

---

### **Analogy**

Imagine two cashiers updating the same account — the order of operations matters.
Conflict serializability ensures **result is same as if transactions ran one by one**.

---

### **Definition**

A schedule (sequence of operations) is **conflict-serializable** if it can be converted into a **serial schedule** by swapping non-conflicting operations.

---

### **Conflicting Operations**

Two operations conflict if:

1. Belong to different transactions.
2. Access the same data item.
3. At least one is a **write**.

---

### **Example**

```
T1: Read(A), Write(A)
T2: Read(A), Write(A)
```

→ These conflict.
If reordered to produce same result as serial order, schedule is **conflict-serializable**.

---

### **Graph Method**

Use a **Precedence Graph**:

* Nodes = transactions
* Edge Ti → Tj if Ti’s action precedes and conflicts with Tj’s
* If graph has no cycle → serializable.

---

### **Interview Tip**

Conflict serializability ensures correctness of concurrent schedules.
It’s the **gold standard** for transaction ordering.

---

# **20. Normal Forms (Detailed)**

---

| Normal Form | Rule                                 | Example Violation                          |
| ----------- | ------------------------------------ | ------------------------------------------ |
| **1NF**     | Atomic values only                   | Storing multiple phones in one field       |
| **2NF**     | 1NF + No partial dependency          | Attribute depends on part of composite key |
| **3NF**     | 2NF + No transitive dependency       | Non-key depends on another non-key         |
| **BCNF**    | Every determinant is a candidate key | One candidate key depends on another       |
| **4NF**     | No multi-valued dependency           | Course ↔ Teacher ↔ Student anomaly         |
| **5NF**     | No join dependency                   | Redundant decomposition                    |

---

### **Interview Tip**

BCNF = “strong 3NF.”
Most practical designs use **3NF or BCNF**.

---

# **21. CCP (Concurrency Control Protocols)**

---

### **Definition**

Concurrency Control ensures **multiple transactions execute safely and consistently** without interference.

---

### **Common Protocols**

| Protocol             | Mechanism                              | Example                              |
| -------------------- | -------------------------------------- | ------------------------------------ |
| **Lock-based**       | Uses shared/exclusive locks            | Two-Phase Locking (2PL)              |
| **Timestamp-based**  | Assigns timestamp; older gets priority | Thomas Write Rule                    |
| **Validation-based** | Check conflicts at commit time         | OCC (Optimistic Concurrency Control) |

---

### **1. Two-Phase Locking (2PL)**

* **Growing Phase:** Acquire locks, no release.
* **Shrinking Phase:** Release locks, no acquire.
  Ensures **conflict serializability**.

ASCII:

```
Acquire → Use → Release
```

---

### **Interview Tip**

If asked “how does DBMS prevent data corruption during concurrent access?”
→ Mention **2PL and ACID isolation**.

---

# **22. Entity, Entity Type, Entity Set, Weak Entity Set**

| Term                | Definition                                            | Example                         |
| ------------------- | ----------------------------------------------------- | ------------------------------- |
| **Entity**          | Real-world object                                     | Student                         |
| **Entity Type**     | Collection of similar entities                        | STUDENT table                   |
| **Entity Set**      | All instances of entity type                          | All student records             |
| **Weak Entity Set** | Cannot be identified without another (no primary key) | DEPENDENT (related to EMPLOYEE) |

---

**Diagram Example:**

```
EMPLOYEE ───< DEPENDENT
   (PK)          (Partial Key)
```

Weak entities depend on strong ones via **foreign keys**.

---

### **Interview Tip**

Weak entity sets have:

* No own primary key.
* Depend on **owner entity** via **identifying relationship**.

---

# **23. SQL Commands – Types**

| Type    | Purpose        | Examples               |
| ------- | -------------- | ---------------------- |
| **DDL** | Define schema  | CREATE, ALTER, DROP    |
| **DML** | Manage records | SELECT, INSERT, UPDATE |
| **DCL** | Permissions    | GRANT, REVOKE          |
| **TCL** | Transactions   | COMMIT, ROLLBACK       |
| **DQL** | Query data     | SELECT                 |

---

### **Example**

```sql
CREATE TABLE Employee(
  ID INT PRIMARY KEY,
  Name VARCHAR(50),
  Dept VARCHAR(50)
);

INSERT INTO Employee VALUES (1, 'Amit', 'IT');
SELECT * FROM Employee;
```

---

# **24. Nested Queries**

### **Definition**

A **nested query** (subquery) is a query inside another query.

---

### **Example**

Find students with marks above class average:

```sql
SELECT Name FROM Students
WHERE Marks > (SELECT AVG(Marks) FROM Students);
```

---

### **Interview Tip**

* Subqueries can appear in WHERE, FROM, or SELECT clauses.
* Can be **correlated** (depends on outer query) or **non-correlated**.

---

# **25. JOINs (Very Important)**

### **Definition**

A **JOIN** combines rows from two or more tables based on related columns.

---

### **Types**

| Type           | Description                        | Example                            |
| -------------- | ---------------------------------- | ---------------------------------- |
| **INNER JOIN** | Only matching records              | Students with matching Courses     |
| **LEFT JOIN**  | All from left, matching from right | All students, even without course  |
| **RIGHT JOIN** | All from right, matching from left | All courses, even with no students |
| **FULL JOIN**  | All records (matched or not)       | Union of both sides                |
| **CROSS JOIN** | Cartesian product                  | All combinations                   |

---

### **Example**

```sql
SELECT s.Name, c.CourseName
FROM Student s
INNER JOIN Course c ON s.CourseID = c.CourseID;
```

---

### **Diagram**

```
INNER:  A ∩ B
LEFT:   A + A∩B
RIGHT:  B + A∩B
FULL:   A ∪ B
```

---

### **Interview Tip**

INNER JOIN = intersection
LEFT JOIN = left side complete
FULL JOIN = union of both.

---

# **26. 2-Tier vs 3-Tier Architecture**

| Tier       | Description                          | Example                       |
| ---------- | ------------------------------------ | ----------------------------- |
| **2-Tier** | Client communicates directly with DB | Desktop apps (JDBC)           |
| **3-Tier** | Client → Application Server → DB     | Web apps (Browser → API → DB) |

---

### **Diagram**

```
2-Tier: Client ↔ DB
3-Tier: Client ↔ Server ↔ DB
```

---

### **Interview Tip**

3-tier is more secure, scalable, and used in enterprise systems.

---

# **27. TRUNCATE vs DELETE**

| Feature   | **DELETE**    | **TRUNCATE**           |
| --------- | ------------- | ---------------------- |
| Type      | DML           | DDL                    |
| Condition | Can use WHERE | Removes all rows       |
| Rollback  | Yes           | No (auto-commit)       |
| Speed     | Slower        | Faster                 |
| Log       | Logs each row | Logs deallocation only |

---

### **Example**

```sql
DELETE FROM Students WHERE Marks < 40;
TRUNCATE TABLE Students;
```

---

# **28. Intension vs Extension**

| Concept       | Definition                | Example          |
| ------------- | ------------------------- | ---------------- |
| **Intension** | Schema or structure of DB | Table definition |
| **Extension** | Actual data stored        | Table rows       |

---

**Analogy:**
Blueprint = Intension
Actual building = Extension

---

# **29. Locks (Shared vs Exclusive)**

### **Definition**

Locks ensure **safe concurrent access** to data by transactions.

---

| Type                        | Access                                     | Example        |
| --------------------------- | ------------------------------------------ | -------------- |
| **Shared Lock (S-Lock)**    | Read-only; multiple transactions can share | SELECT queries |
| **Exclusive Lock (X-Lock)** | Write; only one transaction allowed        | UPDATE, DELETE |

---

### **Locking Example**

```
T1: SELECT * FROM Account (S-Lock)
T2: UPDATE Account SET Balance=... (Waits for X-Lock)
```

---

### **Interview Tip**

Shared → Multiple readers
Exclusive → One writer
Used by **2PL** (Two-Phase Locking) for serializability.

---

That completes **DBMS Part 2 and 3 together** — your entire syllabus.

---

### **Summary Table (Quick Revision)**

| Topic                  | Key Idea                                      |
| ---------------------- | --------------------------------------------- |
| DBMS                   | Software for managing data                    |
| Database               | Structured data                               |
| RDBMS                  | Table-based DB                                |
| ACID                   | Atomicity, Consistency, Isolation, Durability |
| Keys                   | Uniqueness and relationships                  |
| Normalization          | Remove redundancy                             |
| Denormalization        | Add redundancy for performance                |
| FD                     | A→B means A determines B                      |
| ER Model               | Database blueprint                            |
| Concurrency            | Safe multi-user access                        |
| SQL                    | DDL, DML, DCL, TCL                            |
| Joins                  | Combine tables                                |
| Locks                  | Control concurrent access                     |
| CCP                    | Prevent anomalies in transactions             |
| 2/3-Tier               | Architecture layers                           |
| Delete vs Truncate     | DML vs DDL                                    |
| Intension vs Extension | Schema vs Data                                |


