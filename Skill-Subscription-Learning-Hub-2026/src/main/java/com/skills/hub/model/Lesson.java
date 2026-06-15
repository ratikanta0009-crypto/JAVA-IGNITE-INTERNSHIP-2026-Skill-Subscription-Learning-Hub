package com.skills.hub.model;

import jakarta.persistence.*;

/*
=========================================================
WHAT IS THIS CLASS?
=========================================================

Lesson represents individual topics inside a SkillPack.

 Example:
SkillPack = Java Basics
Lessons:
- Variables
- Loops
- OOP Concepts

=========================================================

RELATIONSHIP:
SkillPack -> has many Lessons
=========================================================
*/

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // Many lessons belong to one skill pack
    @ManyToOne
    private SkillPack skillPack;

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // store lesson title
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        //  store lesson content
        this.content = content;
    }

    public SkillPack getSkillPack() {
        return skillPack;
    }

    public void setSkillPack(SkillPack skillPack) {
        // link lesson to skill pack
        this.skillPack = skillPack;
    }
}