# DAY 2 — Subscription System (CORE LOGIC DAY)

##  Goal
Build real-world subscription flow

---

##  TASK 1: Subscribe User

Implement:

- subscribe(userId, packId)

### Steps:
- Fetch user from DB
- Fetch skill pack
- Validate both exist
- Create Subscription object
- Set:
  - startDate = today
  - endDate = today + 30 days
  - status = "ACTIVE"
- Save subscription

---

##  TASK 2: Get User Subscriptions

Implement:

- getUserSubscriptions(userId)

---

##  Focus Areas

- Entity relationships
- Business logic design
- Date handling