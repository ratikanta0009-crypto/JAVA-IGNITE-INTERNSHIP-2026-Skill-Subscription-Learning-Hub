# Skill Subscription Hub — Coding Conventions

##  Purpose

This file defines strict coding rules for this project.  
Follow these rules exactly — they simulate real industry standards.

---

#  1. ARCHITECTURE RULE (VERY IMPORTANT)

Follow this flow ONLY:

Browser ->Controller ->Service ->Repository -> Database

 Controller = Request handling only  
 Service = Business logic only  
 Repository = Database access only  
 JSP = UI display only  

---

#  2. PACKAGE STRUCTURE (DO NOT CHANGE)

Do NOT create random packages  
Do NOT move classes outside structure  

---

#  3. SERVICE LAYER RULES

 All business logic must be inside ServiceImpl  
 Controllers must NOT contain logic  
 No database calls in controller  

Example:

 GOOD:
- validation in service
- subscription logic in service

 BAD:
- calling repository inside controller

---

#  4. REPOSITORY RULES

 Use Spring Data JPA only  
 Do NOT write SQL manually  
 Do NOT add business logic here  

Allowed:
- findById
- findByEmail
- save
- deleteById

---

#  5. CONTROLLER RULES

 Only handle:
- request mapping
- calling service
- returning JSP/view name

 NO:
- calculations
- validations
- database logic

---

#  6. JSP RULES

 Use JSTL for loops and conditions  
 Display only data from controller  
 No Java logic inside JSP  

---

#  7. DATA RULES

 No float for money (if used)  
 Use proper types (Long, String, LocalDate)  
 Handle null checks in service layer  

---

#  8. FLOW RULE

Always follow:

1. Controller receives request  
2. Calls service method  
3. Service processes logic  
4. Repository interacts with DB  
5. Controller sends data to JSP  

---

#  9. COMMON MISTAKES TO AVOID

 Writing logic in controller  
 Skipping service layer  
 Direct DB access from controller  
 Wrong JSP names  
Not handling null values  

---

#  10. PROJECT GOAL

This project is designed to help you learn:

Real backend structure  
Service layer thinking  
MVC architecture  
Full-stack integration  

---

#  FINAL NOTE

If you follow these conventions strictly,  
your project will look like a **real industry application**.
