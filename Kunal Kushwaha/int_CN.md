1. Network
2. Topologies
3. Bandwidth, Node, Link
4. TCP/IP Model
5. OSI Model
6. Data Link Layer
7. Gateway vs Router
8. Ping Command
9. DNS, DNS Forwarder, NIC
10. MAC Address
11. IP Address, Private/Public/APIPA
12. IPv4 vs IPv6
13. Subnet
14. Firewalls
15. Different Types of Delays
16. TCP Three-Way Handshake
17. Server-Side Load Balancer
18. RSA Algorithm
19. HTTP and HTTPS Protocol
20. SMTP Protocol
21. TCP vs UDP (Detailed Differences)
22. Hub vs Switch
23. VPN (Advantages & Disadvantages)
24. LAN
25. “What happens when you type google.com
---

# **1. Define Network**

### **Analogy**

Think of a **postal system** connecting homes, offices, and countries.
A computer network works the same way — but instead of letters, it delivers *data packets* between computers.

---

### **Definition**

A **computer network** is a system of interconnected devices (computers, servers, routers, switches, etc.) that communicate and share resources using communication links and protocols.

---

### **Why It’s Useful**

* Enables **communication** (email, chat, video calls)
* Supports **resource sharing** (files, printers, servers)
* Allows **remote access** (cloud, databases)
* Powers the **Internet**

---

### **Technical View**

A network consists of:

* **Nodes** (devices like PCs, routers, servers)
* **Links** (wired/wireless connections)
* **Protocols** (rules for communication)

ASCII View:

```
[PC]───[Switch]───[Router]───[Internet]
   │                       │
 [Laptop]                [Server]
```

---

### **Interview Tip**

Common follow-up:

* Q: “What are types of networks?”

  * **LAN** – Local Area Network
  * **MAN** – Metropolitan Area Network
  * **WAN** – Wide Area Network
  * **PAN** – Personal Area Network (Bluetooth)

---

# **2. What is Network Topology? Explain Types.**

---

### **Analogy**

The **topology** of a network is like a **city’s road layout** — it shows *how everything is connected.*

---

### **Definition**

**Network topology** defines the **physical or logical arrangement** of devices (nodes) and connections (links) in a network.

---

### **Why It Matters**

* Affects performance and fault tolerance.
* Determines ease of setup and troubleshooting.
* Impacts scalability and cost.

---

### **Types of Topologies**

| Type       | Description                                 | Diagram                  | Pros             | Cons                    |
| ---------- | ------------------------------------------- | ------------------------ | ---------------- | ----------------------- |
| **Bus**    | All nodes share one communication line      | `[A]─┬─[B]─┬─[C]`        | Easy to set up   | One fault breaks all    |
| **Star**   | All devices connect to a central switch/hub | `[A] [B] [C] → [Switch]` | Easy to manage   | Central failure = down  |
| **Ring**   | Devices form a closed loop                  | `[A]→[B]→[C]→[A]`        | Predictable flow | One failure breaks loop |
| **Mesh**   | Every node connects to every other node     | Fully interconnected     | High reliability | Costly, complex         |
| **Tree**   | Hierarchical combination of star + bus      | `Root → Branch → Leaves` | Scalable         | Failure affects subtree |
| **Hybrid** | Mix of two or more                          | —                        | Flexible         | Complex setup           |

---

### **Interview Tip**

Modern LANs and data centers mainly use **Star** or **Hybrid** topologies.

---

# **3. Define Bandwidth, Node, and Link**

---

### **Analogy**

Imagine a water pipeline:

* **Node** = Tap or junction
* **Link** = Pipe between taps
* **Bandwidth** = Width of the pipe (how much water flows per second)

---

### **Definitions**

* **Node:** Any device capable of sending or receiving data (computer, router, switch, etc.).
* **Link:** Physical or logical connection between nodes (e.g., cable or wireless signal).
* **Bandwidth:** Maximum amount of data that can be transmitted per second, measured in **bits per second (bps)**.

---

### **Technical Example**

```
[Node A]====(Link: 1 Gbps Ethernet)====[Node B]
```

Bandwidth = 1 Gbps
Nodes = 2 devices
Link = Ethernet cable

---

### **Interview Insight**

* High bandwidth → faster transmission but limited by latency.
* Don’t confuse *bandwidth* with *throughput* (actual achieved speed).

---

# **4. Explain TCP/IP Model**

---

### **Analogy**

If OSI is the *blueprint*, TCP/IP is the *real-world Internet*.
It’s how data actually moves online.

---

### **Definition**

**TCP/IP (Transmission Control Protocol / Internet Protocol)** is the **practical communication architecture** used by the Internet.
It defines **how data is packetized, addressed, transmitted, routed, and received**.

---

### **Layers of TCP/IP**

| Layer           | OSI Equivalent             | Description                  | Examples             |
| --------------- | -------------------------- | ---------------------------- | -------------------- |
| **Application** | App, Presentation, Session | User interaction & services  | HTTP, DNS, FTP, SMTP |
| **Transport**   | Transport                  | Reliable/unreliable delivery | TCP, UDP             |
| **Internet**    | Network                    | Routing & addressing         | IP, ICMP, ARP        |
| **Link**        | Data Link + Physical       | Local transmission           | Ethernet, Wi-Fi      |

---

### **Flow Example**

```
App → Transport → Internet → Link → Physical
```

When you open Google:

```
HTTP (App)
↓
TCP (Transport)
↓
IP (Internet)
↓
Ethernet/Wi-Fi (Link)
```

---

### **Interview Tip**

* TCP ensures **reliability**, IP ensures **addressing**, and Ethernet ensures **delivery**.

---

# **5. Layers of OSI Model**

---

### **Analogy**

Think of a courier service:

1. You write the letter (Application)
2. You translate it into a language (Presentation)
3. You manage the call (Session)
4. You split parcels (Transport)
5. You label addresses (Network)
6. You wrap packages (Data Link)
7. You send through road (Physical)

---

### **Definition**

**OSI (Open Systems Interconnection)** model is a **7-layer framework** describing how data flows between devices in a network.

---

### **Layers Overview**

| Layer               | Function                     | Example Protocols |
| ------------------- | ---------------------------- | ----------------- |
| **7. Application**  | User interface               | HTTP, FTP, SMTP   |
| **6. Presentation** | Data translation, encryption | SSL/TLS, JPEG     |
| **5. Session**      | Connection setup/teardown    | NetBIOS, RPC      |
| **4. Transport**    | Reliable delivery, ports     | TCP, UDP          |
| **3. Network**      | Routing, IP addressing       | IP, ICMP          |
| **2. Data Link**    | Framing, MAC addressing      | Ethernet, ARP     |
| **1. Physical**     | Transmission of bits         | Cables, Wi-Fi     |

---

### **Mnemonic**

**A P S T N D P → "All People Seem To Need Data Processing"**

---

### **Interview Tip**

They often ask:
“Which layer does a router/switch/hub work on?”

* Router → Network (Layer 3)
* Switch → Data Link (Layer 2)
* Hub → Physical (Layer 1)

---

# **6. Significance of Data Link Layer**

---

### **Analogy**

Like the **post office clerk** who takes your package, wraps it properly, adds address labels, and checks if it’s damaged before sending.

---

### **Definition**

The **Data Link Layer** provides **node-to-node** data transfer, **framing**, **MAC addressing**, and **error detection**.

---

### **Key Functions**

1. **Framing** – Encapsulates network-layer packets into frames.
2. **Physical addressing** – Adds source and destination MAC addresses.
3. **Error detection** – Uses CRC/parity.
4. **Flow control** – Avoids frame loss.
5. **Access control** – Prevents collision (CSMA/CD).

---

### **Frame Structure**

```
+-----------------------------------------------------------+
| Dest MAC | Src MAC | Type | Data | CRC |
+-----------------------------------------------------------+
```

---

### **Interview Points**

* Works on **local delivery** only.
* Uses **MAC addresses**, not IP.
* Switches operate here.

---

# **7. Define Gateway. Difference Between Gateway and Router**

---

### **Analogy**

* **Router:** Your *local courier hub* that forwards packages to nearby networks.
* **Gateway:** The *international courier office* that connects different courier systems.

---

### **Definition**

* **Router:** Connects *similar* networks using *same protocols* (e.g., IP → IP).
* **Gateway:** Connects *different* network systems or *protocols* (e.g., email → SMS, IPv4 ↔ IPv6).

---

### **Differences**

| Feature    | Router                     | Gateway                         |
| ---------- | -------------------------- | ------------------------------- |
| Layer      | Network (Layer 3)          | Up to Application (Layer 7)     |
| Function   | Routes packets based on IP | Converts data between protocols |
| Example    | LAN ↔ WAN                  | Email ↔ SMS, IPv4 ↔ IPv6        |
| Complexity | Lower                      | Higher                          |

---

### **Example in Real Life**

Your home Wi-Fi router is also a **default gateway** connecting your private LAN (192.168.x.x) to the public Internet (ISP).

---

# **8. What Does the `ping` Command Do?**

---

### **Analogy**

It’s like saying **“Are you there?”** to another computer and waiting for it to reply “Yes.”

---

### **Definition**

**Ping** (Packet Internet Groper) tests **network connectivity** between two devices using **ICMP (Internet Control Message Protocol)** echo messages.

---

### **Working**

1. Sends **ICMP Echo Request** to target IP.
2. Target replies with **ICMP Echo Reply**.
3. Measures **round-trip time (RTT)**.

---

### **Command Example**

```
ping google.com
```

Output:

```
Reply from 142.250.183.78: bytes=32 time=15ms TTL=117
```

---

### **Parameters**

* **Time:** Round-trip delay (latency)
* **TTL:** Time To Live (router hops)
* **Bytes:** Data size of packet sent

---

### **Interview Tips**

* Ping uses **ICMP** (Network Layer).
* It uses **IP**, not TCP or UDP.
* “Request timed out” = No reply (host down or blocked).

---

# **9. DNS, DNS Forwarder, NIC**

---

### **1. DNS (Domain Name System)**

#### **Analogy**

Imagine you know your friend’s *name* (google.com) but not their *address*.
You ask a phonebook (DNS) to find it.

---

#### **Definition**

DNS translates **domain names** into **IP addresses** so computers can locate each other on the Internet.

---

#### **Why It’s Useful**

* Humans remember names, not numbers.
* Converts `www.google.com` → `142.250.182.46`.
* Forms the “Internet’s address book.”

---

#### **Working Steps**

1. **Browser cache** checked.
2. If not found → asks **Local DNS Resolver (ISP)**.
3. If still not found → goes to:

   * Root DNS (.)
   * TLD DNS (.com)
   * Authoritative DNS (google.com)
4. Authoritative DNS replies with IP.

ASCII:

```
User → Local DNS → Root DNS → .com DNS → Google DNS → IP
```

---

### **2. DNS Forwarder**

#### **Definition**

A **DNS Forwarder** is a DNS server that **forwards DNS queries** it cannot resolve to another external DNS server.

**Example:**
Your company’s internal DNS server forwards external lookups (like google.com) to Google Public DNS (`8.8.8.8`).

**Purpose:**

* Reduce Internet DNS traffic.
* Cache responses locally.
* Improve speed and security.

---

### **3. NIC (Network Interface Card)**

#### **Analogy**

Like the “SIM card” of your computer that connects it to the network.

---

#### **Definition**

A **NIC** is the hardware that connects a computer to a network (wired or wireless).
It operates at **Layer 2 (Data Link)** and **Layer 1 (Physical)**.

---

#### **Functions**

* Provides a **unique MAC address**.
* Converts **parallel data** from CPU → **serial data** for transmission.
* Handles **framing** and **error detection**.

---

#### **Interview Tip**

NICs can be physical (Ethernet port) or virtual (in cloud servers).

---

# **10. MAC Address**

---

### **Analogy**

Your home’s **permanent physical address** — unique, fixed, and used within your neighborhood.

---

### **Definition**

A **MAC (Media Access Control) address** is a **48-bit unique hardware address** assigned to every NIC by its manufacturer.

Example:
`00:1A:92:3F:B4:56`

---

### **Structure**

| Bits          | Purpose               |
| ------------- | --------------------- |
| First 24 bits | Manufacturer ID (OUI) |
| Last 24 bits  | Device serial number  |

---

### **Purpose**

* Identifies a device within a **local network (LAN)**.
* Used by **switches** to forward frames.
* Never changes (hardware burned-in).

---

### **Interview Tip**

* MAC works at **Layer 2 (Data Link)**.
* IP works at **Layer 3 (Network)**.
* ARP maps IP → MAC.

---

# **11. IP Address, Private/Public, APIPA**

---

### **Analogy**

If MAC is your *street address*, IP is your *postal address* used for long-distance delivery.

---

### **Definition**

An **IP address** uniquely identifies a device on a network.

Example:
`192.168.1.10` (IPv4), `2401:4900:1f00::1` (IPv6)

---

### **Types of IP Addresses**

| Type           | Description                      | Example               |
| -------------- | -------------------------------- | --------------------- |
| **Public IP**  | Globally unique; assigned by ISP | 8.8.8.8               |
| **Private IP** | Used in internal LAN             | 192.168.x.x, 10.x.x.x |
| **Static IP**  | Manually set; doesn’t change     | Web servers           |
| **Dynamic IP** | Assigned via DHCP; changes       | Home users            |
| **Loopback**   | Used for testing (self)          | 127.0.0.1             |
| **Broadcast**  | Message to all devices           | 255.255.255.255       |

---

### **APIPA (Automatic Private IP Addressing)**

When DHCP fails, Windows auto-assigns:

```
169.254.x.x
```

Used for temporary local communication (no Internet).

---

### **Interview Tip**

* Public IPs → Internet visible.
* Private IPs → Need NAT to access Internet.
* APIPA → “Fallback” address when no DHCP.

---

# **12. Difference Between IPv4 and IPv6**

---

| Feature                   | IPv4                           | IPv6                        |
| ------------------------- | ------------------------------ | --------------------------- |
| **Address Size**          | 32-bit                         | 128-bit                     |
| **Format**                | Dotted Decimal (`192.168.1.1`) | Hexadecimal (`2001:db8::1`) |
| **Total Addresses**       | ~4.3 billion                   | ~3.4 × 10³⁸                 |
| **Header Size**           | 20 bytes                       | 40 bytes                    |
| **Checksum**              | Present                        | Not used                    |
| **Security**              | Optional                       | Built-in IPSec              |
| **Address Configuration** | Manual / DHCP                  | Auto / DHCPv6               |
| **Backward Compatible**   | Yes                            | No                          |
| **Fragmentation**         | Routers & Hosts                | Only by Hosts               |

---

### **Interview Tip**

* IPv6 solves IPv4 exhaustion.
* Uses “::” to shorten zeroes.
* Doesn’t need NAT due to huge address space.

---

# **13. What is a Subnet?**

---

### **Analogy**

Think of a company building divided into floors.
Each floor (subnet) is a smaller part of the whole building (network).

---

### **Definition**

A **subnet (subnetwork)** divides a large IP network into smaller logical networks.

---

### **Purpose**

* Improve performance.
* Reduce broadcast traffic.
* Enhance security and organization.

---

### **Example**

Network: `192.168.1.0/24`
→ 256 IPs (0–255)

Split into 2 subnets (`/25`):

* `192.168.1.0 – 192.168.1.127`
* `192.168.1.128 – 192.168.1.255`

---

### **Subnet Mask**

Defines network vs host bits.
Example:

```
IP: 192.168.1.10
Subnet: 255.255.255.0 (/24)
Network: 192.168.1.0
Host Range: 192.168.1.1 – 192.168.1.254
```

---

### **Interview Tip**

* `/24` → 256 addresses.
* `/30` → 4 addresses (2 usable).
* CIDR (Classless Inter-Domain Routing) is used to define subnets.

---

# **14. Firewalls**

---

### **Analogy**

A **security guard** standing at the network gate — checks who’s entering or leaving.

---

### **Definition**

A **Firewall** is a security device (hardware or software) that filters incoming and outgoing network traffic based on **rules**.

---

### **Functions**

* Block unauthorized access.
* Allow legitimate traffic.
* Monitor and log network events.
* Prevent malware or intrusions.

---

### **Types of Firewalls**

| Type                    | Description                                            | OSI Layer   |
| ----------------------- | ------------------------------------------------------ | ----------- |
| **Packet Filtering**    | Checks headers only (IP, port, protocol)               | Network     |
| **Stateful Inspection** | Tracks connection states                               | Transport   |
| **Proxy Firewall**      | Acts as intermediary                                   | Application |
| **Next-Gen Firewall**   | Includes intrusion prevention & deep packet inspection | Multiple    |

---

### **Example Rule**

```
Allow: TCP Port 80, 443 (HTTP, HTTPS)
Block: TCP Port 23 (Telnet)
```

---

### **Interview Tip**

* Firewalls are **stateful** or **stateless**.
* Can filter by **source IP, destination IP, port, or protocol**.
* Default gateway may include a built-in firewall.

---

# **15. Types of Network Delays**

---

### **Analogy**

Delays are like travel time for a parcel — sometimes due to distance, sometimes due to queue, sometimes due to packaging.

---

### **Definition**

**Network delay (latency)** is the time taken for data to travel from source to destination.

---

### **Types of Delays**

| Type                   | Description                              | Example                    |
| ---------------------- | ---------------------------------------- | -------------------------- |
| **Propagation Delay**  | Time for signal to travel through medium | Distance / Speed of signal |
| **Transmission Delay** | Time to push all bits into the link      | Packet size / Bandwidth    |
| **Queuing Delay**      | Waiting time in router/switch queues     | Router congestion          |
| **Processing Delay**   | Time routers take to inspect headers     | Routing lookup time        |

---

### **Formula Example**

If:

* Distance = 2000 km
* Propagation speed = 2×10⁸ m/s
  → Propagation Delay = 2000×1000 / (2×10⁸) = **10 ms**

---

### **Interview Tip**

* Total Delay = Propagation + Transmission + Queuing + Processing
* Measured by **ping time (RTT)**.

---

# **16. TCP Three-Way Handshake**

---

### **Analogy**

Before two people start talking on the phone:

1. Caller says “Hello, can you hear me?”
2. Receiver says “Yes, I can hear you. Can you hear me?”
3. Caller says “Yes, loud and clear.”
   Now, the conversation can begin.

That’s exactly how **TCP establishes a connection**.

---

### **Definition**

**TCP (Transmission Control Protocol)** uses a **three-way handshake** to establish a **reliable connection** before transmitting data.

---

### **Steps**

1. **SYN (Synchronize):**

   * Client → Server: “I want to start a connection.”
   * Contains client’s **Initial Sequence Number (ISN)**.

2. **SYN + ACK:**

   * Server → Client: “Okay, I acknowledge your request and here’s my sequence number.”
   * Server sets its own ISN and acknowledges the client’s.

3. **ACK:**

   * Client → Server: “Got it. Let’s start data transfer.”

ASCII Diagram:

```
Client                               Server
  |------ SYN ---------------------->|
  |<----- SYN + ACK ----------------|
  |------ ACK ---------------------->|
Connection Established
```

---

### **Purpose**

* Synchronizes sequence numbers for both sides.
* Confirms both devices are ready.
* Prevents half-open connections.

---

### **Interview Tip**

* Occurs before any data transfer.
* If connection is closed: **4-way handshake (FIN, ACK, FIN, ACK)**.
* TCP is **connection-oriented**, unlike UDP.

---

# **17. Server-Side Load Balancer**

---

### **Analogy**

Imagine you have 5 cash counters in a bank. A manager directs each new customer to the counter with the shortest line — that’s **load balancing**.

---

### **Definition**

A **load balancer** distributes network traffic across multiple servers to ensure **no single server** is overloaded, improving **performance, reliability, and availability**.

---

### **Why It’s Used**

* Prevent server overload.
* Reduce latency.
* Improve fault tolerance.
* Enable horizontal scaling.

---

### **Types**

| Type                             | Description                        |
| -------------------------------- | ---------------------------------- |
| **Hardware Load Balancer**       | Dedicated appliances (F5, Citrix)  |
| **Software Load Balancer**       | Software (NGINX, HAProxy, AWS ELB) |
| **DNS Load Balancing**           | Multiple IPs per domain            |
| **Reverse Proxy Load Balancing** | Distributes HTTP/S requests        |

---

### **Load Balancing Algorithms**

| Algorithm             | Logic                                             |
| --------------------- | ------------------------------------------------- |
| **Round Robin**       | Each request goes to next server in order         |
| **Least Connections** | Chooses server with fewest active connections     |
| **IP Hash**           | Same client IP always goes to same server         |
| **Weighted**          | Some servers get more traffic (based on capacity) |

---

### **ASCII Diagram**

```
             +-----------+
User →──────→| Load Balancer |──────→ [Server 1]
             +-----------+──────→ [Server 2]
                             └────→ [Server 3]
```

---

### **Interview Tip**

* Usually works at **Layer 4 (Transport)** or **Layer 7 (Application)**.
* Reverse proxies like **NGINX** or **AWS ALB** are examples.

---

# **18. RSA Algorithm**

---

### **Analogy**

Think of sending a message in a **lockbox** that only the receiver’s *private key* can open — even though everyone can see the box, only one can unlock it.

---

### **Definition**

**RSA (Rivest–Shamir–Adleman)** is an **asymmetric encryption algorithm** that uses **two keys**:

* **Public key** (used for encryption)
* **Private key** (used for decryption)

---

### **Working Steps**

1. **Key Generation**

   * Choose two large primes `p` and `q`.
   * Compute `n = p × q`.
   * Compute `φ(n) = (p−1)(q−1)`.
   * Choose `e` (encryption key) such that `1 < e < φ(n)` and `gcd(e, φ(n)) = 1`.
   * Compute `d = e⁻¹ mod φ(n)` (decryption key).

2. **Encryption**

   ```
   Ciphertext = (Plaintext^e) mod n
   ```

3. **Decryption**

   ```
   Plaintext = (Ciphertext^d) mod n
   ```

---

### **Example (Simplified)**

```
p = 3, q = 11
n = 33, φ(n) = 20
e = 7, d = 3
Encrypt: (4^7 mod 33) = 16
Decrypt: (16^3 mod 33) = 4
```

---

### **Use Cases**

* SSL/TLS (HTTPS certificates)
* Digital signatures
* Key exchange

---

### **Interview Tip**

* RSA is **asymmetric** → two keys.
* **Slower** than symmetric (like AES).
* Security depends on difficulty of **factoring large primes**.

---

# **19. HTTP & HTTPS Protocols**

---

### **Analogy**

HTTP is like sending a postcard (anyone can read it).
HTTPS is like sending a sealed envelope (encrypted and secure).

---

### **Definition**

**HTTP (Hypertext Transfer Protocol):**

* Application layer protocol for transferring web data.

**HTTPS (HTTP Secure):**

* HTTP over **SSL/TLS encryption** (secure).

---

### **Ports**

* HTTP → Port **80**
* HTTPS → Port **443**

---

### **Working**

1. **HTTP:**

   * Client sends requests (GET, POST, PUT, DELETE).
   * Server responds with HTML, JSON, etc.

2. **HTTPS:**

   * Uses **SSL/TLS handshake** to encrypt data.
   * Validates **digital certificate**.

---

### **HTTP Methods**

| Method     | Purpose          |
| ---------- | ---------------- |
| **GET**    | Retrieve data    |
| **POST**   | Submit data      |
| **PUT**    | Update data      |
| **DELETE** | Delete data      |
| **HEAD**   | Get headers only |

---

### **Status Codes**

| Code | Category      | Example                   |
| ---- | ------------- | ------------------------- |
| 1xx  | Informational | 100 Continue              |
| 2xx  | Success       | 200 OK                    |
| 3xx  | Redirection   | 301 Moved Permanently     |
| 4xx  | Client Error  | 404 Not Found             |
| 5xx  | Server Error  | 500 Internal Server Error |

---

### **Interview Tip**

* HTTPS uses **TLS Handshake** (asymmetric + symmetric keys).
* Certificates are signed by **CA (Certificate Authorities)**.
* HTTP is **stateless**; cookies/session tokens maintain state.

---

# **20. SMTP Protocol**

---

### **Analogy**

The **postal service** of email systems.

---

### **Definition**

**SMTP (Simple Mail Transfer Protocol)** is used to **send emails** between mail servers.

---

### **Working**

1. Sender’s email client → **SMTP server**.
2. SMTP server → Recipient’s SMTP server.
3. Recipient → retrieves mail using **POP3** or **IMAP**.

---

### **Ports**

* **Port 25** – Standard SMTP
* **Port 587** – Secure SMTP (TLS)

---

### **ASCII Flow**

```
[Sender] → [SMTP Server] → [Receiver’s SMTP Server]
                          ↓
                       [POP3/IMAP] → [Receiver]
```

---

### **Interview Tip**

* SMTP = Sending.
* POP3/IMAP = Receiving.
* Uses **TCP**, not UDP.

---

# **21. TCP vs UDP (Detailed Differences)**

---

| Feature            | **TCP**                        | **UDP**                  |
| ------------------ | ------------------------------ | ------------------------ |
| Type               | Connection-oriented            | Connectionless           |
| Reliability        | Reliable (ACK, retransmission) | Unreliable               |
| Ordering           | In-order delivery              | No order guarantee       |
| Overhead           | High (header = 20 bytes)       | Low (8 bytes)            |
| Speed              | Slower                         | Faster                   |
| Error Control      | Yes                            | Only checksum            |
| Flow Control       | Yes                            | No                       |
| Congestion Control | Yes                            | No                       |
| Example Use        | HTTP, FTP, Email               | DNS, VoIP, Video, Gaming |

---

### **Diagram**

```
TCP:
[Connect] → [Send] → [ACK] → [Close]

UDP:
[Send → Forget]
```

---

### **Interview Tip**

* TCP ensures **reliability**, UDP ensures **speed**.
* UDP used for **real-time** applications where packet loss is acceptable.

---

# **22. Hub vs Switch**

---

| Feature          | **Hub**          | **Switch**              |
| ---------------- | ---------------- | ----------------------- |
| OSI Layer        | Physical (1)     | Data Link (2)           |
| Data Forwarding  | Broadcast to all | Forward to specific MAC |
| Collision Domain | Single           | Separate per port       |
| Speed            | Slow             | Fast                    |
| Intelligence     | None             | MAC address table       |
| Security         | Low              | High                    |
| Use              | Small networks   | Modern LANs             |

---

### **Diagram**

```
Hub: [A]↔[Hub]↔[B]↔[C]  (Broadcast)
Switch: [A]↔[Switch]↔[B]↔[C]  (Selective)
```

---

### **Interview Tip**

* Switch = “smart hub.”
* Routers connect networks; switches connect devices within a LAN.

---

# **23. VPN (Virtual Private Network)**

---

### **Analogy**

Like driving inside a **secret tunnel** — you go through the same roads, but no one can see inside.

---

### **Definition**

A **VPN** creates a **secure, encrypted tunnel** between your device and a remote server, allowing you to access the Internet **privately** and **anonymously**.

---

### **How It Works**

1. Data encrypted before leaving your device.
2. Travels through ISP → VPN Server → Internet.
3. Websites see VPN’s IP, not yours.

---

### **Advantages**

* Privacy and anonymity.
* Bypasses geo-restrictions.
* Secure data on public Wi-Fi.
* Hides IP address.

---

### **Disadvantages**

* Slower speed (due to encryption).
* May cost money.
* Some websites block VPNs.
* Trust depends on VPN provider.

---

### **Interview Tip**

* Works at **Layer 3 (Network Layer)** using **IPSec**, or **Layer 7** using **SSL VPNs**.

---

# **24. LAN (Local Area Network)**

---

### **Definition**

A **LAN** connects computers within a limited area (office, building, home).

---

### **Characteristics**

* High speed (1–10 Gbps).
* Owned privately.
* Typically uses **Ethernet** or **Wi-Fi**.
* Devices identified by **MAC & IP**.

---

### **Components**

* Switches, Routers, Cables, NICs, Access Points.

---

### **Diagram**

```
[PC1]---\
[PC2]----[Switch]----[Router]----[Internet]
[PC3]---/
```

---

### **Interview Tip**

LANs use **Star topology** and **Ethernet protocols** (IEEE 802.3).

---

# **25. What Happens When You Type “google.com”**

---

### **Short Recap**

1. **Browser checks cache.**
2. **DNS resolution** – find Google’s IP.
3. **ARP** – find local MAC of gateway.
4. **TCP Handshake** – SYN, SYN+ACK, ACK.
5. **TLS Handshake** – encryption keys exchanged.
6. **HTTP Request** – “GET /”.
7. **Routers forward packets** using IP routing.
8. **Google’s server responds** with HTML.
9. **Browser renders the page.**
10. **TCP connection closed.**

---

### **ASCII Summary**

```
Browser → DNS → TCP → HTTPS → IP → MAC → Physical
↓
You → Wi-Fi → Router → ISP → Google Server → Response Back
```

---

### **Interview Tips**

* This question tests your understanding of **all 7 OSI layers**.
* Mention DNS, ARP, TCP handshake, HTTPS/TLS, and routing clearly.
* Bonus points if you describe encapsulation and headers.

---

## **Final Summary Table**

| Topic             | Key Point                        |
| ----------------- | -------------------------------- |
| Network           | Interconnection of devices       |
| Topology          | Structure of connections         |
| Bandwidth         | Data rate of link                |
| TCP/IP            | Real Internet architecture       |
| OSI Layers        | Conceptual model                 |
| Data Link Layer   | MAC addressing, framing          |
| Gateway vs Router | Protocol translation vs routing  |
| Ping              | ICMP echo test                   |
| DNS               | Converts name to IP              |
| NIC               | Connects device to network       |
| MAC               | Hardware address                 |
| IP                | Logical address                  |
| Subnet            | Logical division of network      |
| Firewall          | Traffic filter                   |
| Delay             | Propagation, transmission, queue |
| TCP Handshake     | SYN, SYN-ACK, ACK                |
| Load Balancer     | Distributes traffic              |
| RSA               | Asymmetric encryption            |
| HTTP/HTTPS        | Web transfer (secure/insecure)   |
| SMTP              | Email transfer                   |
| TCP vs UDP        | Reliable vs fast                 |
| Hub vs Switch     | Broadcast vs selective           |
| VPN               | Encrypted private tunnel         |
| LAN               | Local private network            |
| “google.com”      | DNS → TCP → HTTPS → Rendering    |

---
