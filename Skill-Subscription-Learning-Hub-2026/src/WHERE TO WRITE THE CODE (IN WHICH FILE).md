# Skill Subscription Hub — Workspace Guide

##  Purpose

This file tells you EXACTLY:
- which files you must edit
- which files are already given
- how to run the project step by step

---

#  1. WHAT IS ALREADY DONE (DO NOT TOUCH)

You should NOT modify:

 Entity classes (model package)  
 Repository layer  
 Database configuration  
 pom.xml dependencies  

---

#  2. WHERE YOU MUST WRITE CODE

You will ONLY work in these areas:

---

##  A. SERVICE LAYER (MAIN WORK ⭐)

 Location:
src/main/java/com/skills/hub/service/impl/


### You will implement:

 UserServiceImpl  
 SkillPackServiceImpl  
 SubscriptionServiceImpl  

### What to write:
- business logic
- validation
- decision making

---

##  B. CONTROLLER LAYER

Location:
src/main/java/com/skills/hub/controller/


### You will complete:

 UserController  
 SkillPackController  
 SubscriptionController  

### What to write:
- request handling
- service calls
- redirect / JSP navigation

---

##  C. JSP (FRONTEND UI)

 Location: 
 webapp/WEB-INF/views/
 
 
 
### You will create/edit:

 register.jsp  
 login.jsp  
 packs.jsp  
 add-pack.jsp  
 subscriptions.jsp  

### What to write:
- HTML structure
- JSTL tags
- form submission
- display data from controller

---

#  3. WHAT YOU SHOULD NOT TOUCH

 repository package  
 model/entity package  
 configuration files  
 pom.xml  

---

#  4. HOW TO RUN THE PROJECT

## STEP 1: Run Spring Boot Application

Right click:on project title
Run As → Spring Boot App
## STEP 2: Open Browser
http://localhost:8080/register


---

## STEP 3: Follow Flow

1. Register user  
2. Login  
3. View skill packs  
4. Subscribe  
5. View subscriptions  

---

#  5. DEBUGGING GUIDE

## If page not opening:
 Check controller mapping  
 Check JSP file name  

---

## If data not showing:
 Check model.addAttribute()  
 Check service return values  

---

## If error occurs:
 Check console logs  
 Check package structure  

---

#  6. FINAL GOAL

At the end of this project, you should be able to:

 Run full application  
 Understand Spring MVC flow  
 Connect frontend + backend  
 Debug basic issues  

---

#  SIMPLE RULE

 Service = Logic  
 Controller = Flow  
 JSP = Display  
 Repository = Already done  

---

#  IMPORTANT NOTE

Do NOT search for full code.

Instead:
 Read TODOs  
 Follow hints  
 Build step by step

 
 
 
 