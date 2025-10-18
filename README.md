# 🧰 Damage Tracking and Repair System & Stock Tracking

**A database-driven management system designed to streamline inventory control, damage tracking, and repair lifecycle processes.**  
Built for **Database System Design** using **SQL** with role-based access for Admins, Employees, and Dealers.



---

## 📘 Project Overview

The **Damage Tracking and Repair System with Stock Tracking** integrates two major functions:

1. **Stock Management** — Monitoring and controlling inventory across multiple locations.  
2. **Damage & Repair Tracking** — Logging damaged items, repair workflows, and lifecycle updates.

It ensures real-time tracking, accountability, and ease of management through role-based interfaces and structured SQL database design.

---

## 🎯 Objectives

- ✅ Enable seamless and accurate **inventory management**  
- ✅ Provide transparent **damage and repair process tracking**  
- ✅ Support **role-based user access**:
  - **Admin:** Full control of users, stock, and reports  
  - **Employee:** Handles repair operations and stock transitions  
  - **Dealer:** Adds items, creates bills, manages suppliers

---

## 🧩 Database Design

The system's database contains **15+ normalized tables** designed for scalability and relational integrity.



### 🗃️ Key Tables Overview

| Table | Description | Notes |
|-------|-------------|-------|
| **Users** | Stores all user data (name, email, role, location) | Linked to `Roles` & `Locations` |
| **Roles** | Defines permissions for Admin, Employee, Dealer | Referenced by `Users` |
| **Conditions** | Tracks condition states (New, Used, Damaged) | Referenced in `Items` & `Damage` |
| **Categories** | Organizes items/parts by type | Linked to `Items` and `Parts` |
| **Items** | Central entity storing item data, price, warranty | References `Categories` & `Conditions` |
| **Stock** | Tracks inventory per location | Unique `(ItemID, LocationID)` constraint |
| **Damage** | Logs damaged items with descriptions | Links to `Items` and `Conditions` |
| **DamageHistory** | Stores repair details, cost, and dates | References `Damage` and `Users` |
| **Reports** | Logs all actions (who, what, when) | Linked to `Users` & `Items` |
| **Bills** | Main table for sales records | Parent to `BillDetails` |
| **BillDetails** | Contains bill line items | Links to `Bills` and `Items` |
| **Suppliers** | Supplier records with contacts | References `Locations` |
| **Parts** | Tracks parts and quantities | Linked to `Categories` and `Suppliers` |
| **Locations** | Physical warehouse or branch locations | Used by `Suppliers` & `Stock` |
| **ReportTypes** | Defines types of logged system events | Used by `Reports` |

---

## 🧭 System Logic & Workflows

### 💳 Bills and BillDetails Workflow



1. Dealer creates a **Bill** record  
2. Adds **BillDetails** for items, quantity, and price  
3. Totals are automatically computed  

**Example:**  
> A dealer generates a new bill, adds 10 laptops at $500 each, and stores the customer info and total.

---

### ⚙️ Damage & Repair Workflow


1. Damaged items are reported into the **Damage** table  
2. Employees record repair details and costs in **DamageHistory**  
3. Once repaired, items are re-evaluated for return to stock or scrapping

**Example:**  
> A monitor is logged as damaged, fixed by an employee, cost recorded, and added back to inventory.

---

### 📊 Reports Table (Audit Logging)

Every action (add stock, delete item, log repair, create bill) is stored in **Reports** for full traceability.

| Field | Example |
|-------|---------|
| **Action** | Item Added to Stock |
| **PerformedBy** | Dealer UserID |
| **Timestamp** | 2025-01-02 14:30:00 |
| **Notes** | "Added 10 units of Laptops" |

---

## 🧠 SQL Components

### 🧾 Stored Procedure – `GetBillDetails`

**Purpose:** Retrieve full bill data including customer, items, and location.

**Features:**  
- Joins `BillDetails`, `Bills`, `Items`, and `Locations`
- Returns a consolidated transaction view

```sql
CALL GetBillDetails(123);
```

### 🏭 Stored Procedure – `GetSupplierDetails`

**Purpose:** Fetch supplier and associated location info.

**Features:**  
- Input: `SupplierID`  
- Output: Contact, region, and item linkage data

```sql
CALL GetSupplierDetails(45);
```

### 🔒 Unique Constraint – Stock Table

Ensures each item–location pair appears only once.

```sql
ALTER TABLE Stock
ADD CONSTRAINT unique_item_location UNIQUE (ItemID, LocationID);
```

---

## 💻 User Interfaces

The system provides separate interfaces for each user role:

### 👑 Admin Interface

<p align="center">
  <img src="./images/admin-dashboard.png" alt="Admin Dashboard" width="700">
</p>

- Manage users, permissions, and system reports
- View audit logs
- Full access to CRUD operations

### 👷 Employee Interface

<p align="center">
  <img src="./images/employee-dashboard.png" alt="Employee Dashboard" width="700">
</p>

- Manage damaged item lifecycle
- Update repairs and move items to stock

### 💼 Dealer Interface

<p align="center">
  <img src="./images/dealer-dashboard.png" alt="Dealer Dashboard" width="700">
</p>

- Add new items and suppliers
- Create and manage bills
- Handle stock updates

> **Note:** If an action is not related to an item (e.g., adding a supplier), the ItemID is recorded as `NULL` or `0`.

---

## 📈 Key Functionalities

- 🔹 Real-time inventory tracking across locations
- 🔹 End-to-end damage reporting and repair documentation
- 🔹 Transparent audit trail in `Reports`
- 🔹 Modular and scalable relational schema
- 🔹 Role-specific dashboards for streamlined workflows

---

## 🧱 Technologies Used

| Category | Stack |
|----------|-------|
| **Database** | MySQL / SQL Server |
| **Backend Logic** | SQL Procedures & Functions |
| **Frontend (UI)** | HTML / PHP / Desktop (Role-based) |
| **User Roles** | Admin, Employee, Dealer |
| **Documentation** | Markdown, PDF (with diagrams) |

---

## ⚙️ How to Run

### 🧩 Setup


---

## 📸 Screenshots

---

## 📚 Documentation

Comprehensive documentation is available including:

- 📄 **Database Design Document** - Complete schema and relationships
- 📊 **Flow Diagrams** - Workflow visualizations
- 🔧 **API Documentation** - Stored procedures and functions
- 👥 **User Manual** - Role-based guides



---

## 🎓 Learning Outcomes

Through this project, we gained expertise in:

- ✅ Advanced SQL database design and normalization
- ✅ Creating complex stored procedures and triggers
- ✅ Implementing role-based access control (RBAC)
- ✅ Building audit logging systems
- ✅ Designing scalable relational schemas
- ✅ Handling real-world business logic in databases
- ✅ Team collaboration and project management

---


---

## 👥 Team Members

| Name | ID | Role |
|------|-----|------|
| **Mhd Alhabeb Alshalah** | 2221251360 | Database Developer |
| **Ahmad Al-Ali** | 2221251365 | System Designer / Backend Developer |
| **Mohamed Ragab Abdelfattah** | 2221251356 | Frontend Developer |

---

## 🤝 Contributing

We welcome contributions and suggestions!

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/NewFeature`)
3. Commit your changes (`git commit -m 'Add NewFeature'`)
4. Push to the branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Thanks to our Database Systems professor for guidance
- Inspired by real-world inventory management systems
- Built as part of our Database System Design course

---

<p align="center">
  <strong>⭐ If this project helped you, please give it a star on GitHub!</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/PHP-777BB4?style=for-the-badge&logo=php&logoColor=white" alt="PHP">
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5">
  <img src="https://img.shields.io/badge/SQL-4479A1?style=for-the-badge&logo=postgresql&logoColor=white" alt="SQL">
</p>

<p align="center">
  <em>Developed with 💙 for efficient inventory and repair management</em>
</p>
