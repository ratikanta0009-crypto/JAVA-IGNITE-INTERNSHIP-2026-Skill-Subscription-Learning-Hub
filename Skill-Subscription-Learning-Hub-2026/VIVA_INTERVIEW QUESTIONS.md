

Spring Boot is a Java framework built on top of the Spring Framework that simplifies the development of web applications and microservices. It provides:

* Auto-configuration
* Embedded servers (Tomcat, Jetty)
* Starter dependencies
* Minimal configuration

Example: You can create a REST API with very little setup.

---

 2. What is MVC Architecture?

MVC (Model-View-Controller) is a design pattern that separates an application into three parts:

* **Model** → Data and business logic
* **View** → User interface (JSP, HTML)
* **Controller** → Handles user requests and responses

**Flow:**
User → Controller → Service → Repository → Database → View

---

### 3. What is Service Layer?

The **Service Layer** contains the business logic of the application.

Responsibilities:

* Process data
* Validate input
* Coordinate between Controller and Repository
* Handle transactions

**Example:** Subscription validation before saving to the database.

---

### 4. What is Repository in Spring Data JPA?

A **Repository** is used to interact with the database.

It provides methods such as:

* `save()`
* `findById()`
* `findAll()`
* `deleteById()`

Example:

```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```

---

### 5. Difference Between GET and POST

| GET                          | POST                               |
| ---------------------------- | ---------------------------------- |
| Retrieves data               | Sends data                         |
| Data visible in URL          | Data sent in request body          |
| More secure for reading only | Better for sensitive data          |
| Idempotent                   | Not necessarily idempotent         |
| Used for fetching records    | Used for creating/updating records |

**Example:**

* GET `/users`
* POST `/users`

---

### 6. How Does Subscription Flow Work?

Typical flow:

1. User selects a subscription plan.
2. Controller receives the request.
3. Service validates user and plan.
4. Service creates a subscription record.
5. Repository saves it in the database.
6. Response is returned to the user.

Flow:

```
User
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
Database
```

---

### 7. How Do You Link User and SkillPack?

Using JPA relationships.

**Many users can subscribe to many skill packs:**

```java
@ManyToMany
@JoinTable(
    name = "user_skillpack",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "skillpack_id")
)
private List<SkillPack> skillPacks;
```

This creates a mapping table between User and SkillPack.

---

### 8. Why Do We Use Service Layer?

* Separates business logic from Controller.
* Makes code reusable.
* Easier testing.
* Better maintainability.
* Follows layered architecture.

**Controller:** Handles requests.
**Service:** Contains business rules.
**Repository:** Handles database operations.

---

### 9. How Does JSP Get Data from Controller?

The Controller sends data using a **Model** object.

**Controller:**

```java
@GetMapping("/profile")
public String profile(Model model) {
    model.addAttribute("name", "John");
    return "profile";
}
```

**JSP (profile.jsp):**

```jsp
<h1>${name}</h1>
```

Output:

```
John
```

The Controller places data in the Model, and JSP accesses it using Expression Language (`${}`).

---

### Interview One-Line Answers

* **Spring Boot:** Framework that simplifies Spring application development using auto-configuration.
* **MVC:** Design pattern with Model, View, and Controller.
* **Service Layer:** Contains business logic.
* **Repository:** Handles database operations using JPA.
* **GET vs POST:** GET fetches data; POST sends data.
* **Subscription Flow:** Controller → Service → Repository → Database.
* **User & SkillPack Link:** Using JPA relationships (`@ManyToMany` or `@OneToMany`).
* **Why Service Layer:** Separation of concerns and code reusability.
* **JSP Data Access:** Controller adds data to Model, JSP reads using `${attributeName}`.
