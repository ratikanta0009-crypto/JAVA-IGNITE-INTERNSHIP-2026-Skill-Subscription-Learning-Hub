ER DIAGRAM (ENTITY RELATIONSHIP)
USER ────────────────< SUBSCRIPTION >─────────────── SKILL_PACK
  |                                                       |
  |                                                       |
  └────────────── (registers)                            (contains)
  
  
  
  Detailed ER Structure
  USER
- id (PK)
- name
- email
- password

        1
        |
        | places
        |
        M

SUBSCRIPTION
- id (PK)
- user_id (FK)
- skill_pack_id (FK)
- start_date
- end_date
- status

        M
        |
        | belongs to
        |
        1

SKILL_PACK
- id (PK)
- title
- description
- price


RELATIONSHIP EXPLANATION
One USER can have many SUBSCRIPTIONS
One SKILL_PACK can be subscribed by many USERS
SUBSCRIPTION is the linking table


ARCHITECTURE DIAGRAM (SPRING BOOT FLOW)
SIMPLE FLOW
[ Browser / JSP ]
        |
[ Controller Layer ]
        |
[ Service Layer ]
        |
[ Repository Layer ]
        |
[ Database (MySQL) ]


REAL PROJECT FLOW

 USER ACTION FLOW (Example: Login)
JSP (login.jsp)
    ↓ submit form
UserController
    ↓
UserService
    ↓
UserRepository
    ↓
Database
    ↓
Response → Controller → JSP (dashboard)


 SKILL PACK FLOW (View Packs)
packs.jsp
    ↓ request
SkillPackController
    ↓
SkillPackService
    ↓
SkillPackRepository
    ↓
Database
    ↓
List returned → JSP displays


SUBSCRIPTION FLOW
packs.jsp (click Subscribe)
    ↓
SubscriptionController
    ↓
SubscriptionService
    ↓
UserRepository + SkillPackRepository
    ↓
Subscription saved in DB
    ↓
subscriptions.jsp displayed



Just remember this 

JSP → Controller → Service → Repository → DB
DB → Repository → Service → Controller → JSP
