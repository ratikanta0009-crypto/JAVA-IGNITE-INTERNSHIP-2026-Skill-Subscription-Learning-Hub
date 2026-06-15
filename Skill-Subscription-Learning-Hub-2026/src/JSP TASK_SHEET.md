# Skill Subscription Hub — JSP UI Tasks

##  Goal

Build the frontend UI using JSP and connect it with Spring Boot controllers.

You will NOT write backend logic here — only UI + data display.

---

#  JSP LOCATION

Place all JSP files here:
src/main/webapp/WEB-INF/views/


---

#  JSP RULES

 Use JSTL for loops and conditions  
 No Java code inside JSP  
 Only display data coming from Controller  
 Use forms for input submission  

---

#  TASK 1: register.jsp

## Purpose
User registration page

---

## UI Requirements:

Create a form with:

- Name input
- Email input
- Password input
- Submit button

---

## FORM ACTION:

POST /register

---

## STUDENT TASKS:

- Create HTML form
- Bind input fields using `name=""`
- Ensure form submits to controller

---

#  TASK 2: login.jsp

##  Purpose
User authentication page

---

## UI Requirements:

- Email input
- Password input
- Login button

---

## FORM ACTION:
POST /login

---

## STUDENT TASKS:

- Build login form
- Send data to controller
- Show simple error message if login fails

---

#  TASK 3: packs.jsp

##  Purpose
Display all skill packs

---

## DATA COMING FROM CONTROLLER:
model.addAttribute("packs", list);

---

## STUDENT TASKS:

- Use JSTL loop:
<c:forEach var="pack" items="${packs}">

- Display:
  - Title
  - Description
  - Price

- Add button:

Subscribe → /subscribe?userId=&packId=

---

#  TASK 4: add-pack.jsp

##  Purpose
Admin adds skill pack

---

## FORM FIELDS:

- Title
- Description
- Price

---

## FORM ACTION:
Subscribe → /subscribe?userId=&packId=

---

#  TASK 4: add-pack.jsp

##  Purpose
Admin adds skill pack

---

## FORM FIELDS:

- Title
- Description
- Price

---

## FORM ACTION:
POST /add-pack

---

## STUDENT TASKS:

- Create form
- Bind SkillPack model fields
- Submit to controller

---

#  TASK 5: subscriptions.jsp

##  Purpose
Show user subscriptions

---

## DATA:
model.addAttribute("subs", list);

---

## STUDENT TASKS:

- Loop subscriptions using JSTL:

<c:forEach var="s" items="${subs}">

- Display:
  - SkillPack name
  - Start date
  - End date
  - Status

---

#  FLOW UNDERSTANDING
Controller -> sends data -> JSP displays data


---

#  COMMON MISTAKES

 Writing Java code inside JSP  
 Wrong model attribute names  
 Not matching controller URL  
 Missing JSTL taglib  

---

#  FINAL GOAL

By completing JSP tasks, students should be able to:

 Build UI pages  
 Display dynamic data  
 Connect frontend to backend  
 Understand full MVC flow  

---

#  SIMPLE RULE

JSP = DISPLAY ONLY  
 Controller = SEND DATA  
 Service = PROCESS DATA  
 Repository = STORE DATA

