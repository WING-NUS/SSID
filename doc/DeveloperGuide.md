---
layout: page
title: Developer Guide
---

## Table of Contents
- [Acknowledgements](#acknowledgements)
- [Setting up, getting started](#setting-up-getting-started)
- [Architecture](#architecture)
- [Implementation](#implementation)
- [Documentation, logging, testing, configuration, dev-ops](#documentation-logging-testing-configuration-dev-ops)
- [Appendix: Requirements](#appendix-requirements)
  - [Product scope](#product-scope)
  - [User stories](#user-stories)
  - [Non-Functional Requirements](#non-functional-requirements)
  - [Glossary](#glossary)



---

## **Acknowledgements**

* Libraries used: Ruby on Rails


---

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

---


## **Design**

### **Architecture**

This program is created as a standard Ruby on Rails project following the Model Controller View (MCV) architecture.

### **Security Considerations**

### **Database Design**

### **User roles and authorizations**





---


## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](https://ay2122s1-cs2103-w14-1.github.io/tp/Documentation.html)
* [Testing guide](https://ay2122s1-cs2103-w14-1.github.io/tp/Testing.html)
* [Logging guide](https://ay2122s1-cs2103-w14-1.github.io/tp/Logging.html)
* [Configuration guide](https://ay2122s1-cs2103-w14-1.github.io/tp/Configuration.html)
* [DevOps guide](https://ay2122s1-cs2103-w14-1.github.io/tp/DevOps.html)

---

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* Course instructors for computer sciences courses.
* Teaching assistants for computer science courses.
* Course instructors that are concerned about plagiarism within their courses.
* Course instructors teaching computer science courses with large number of students submitting coding assignments.

**Value proposition**:
* Provide a centralised platform for course instructors to check for plagiarism among student submissions.
* Provide ways for teaching staff to flag out and confirm cases of plagiarism.


With the growth of student intake in computing courses, it becomes an increasingly difficult task to ensure the academic integrity of student submissions.  As such, an automated form of plagiarism detection for large student bodies is required. Student Submission Integrity Diagnosis (SSID) aims to resolve this issue by providing an easily accessible platform for course instructors to detect the presence of plagiarism.

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`


| Priority | As a …                 | I want to …                                                                              | So that I can…                                                                |
| -------- | ---------------------- | ---------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `* * *`  | course instructor      | create a new account                                                                     | gain access to SSID services                                   |
| `* * *`  | course instructor      | login to my account                                                                      | gain access to SSID services                                        |
| `* * *`  | course instructor      | create/view/update/delete my courses                                                     | manage my courses                 |
| `* * *`  | course instructor      | upload student submission data                                                           | check student submissions for plagiarism   |
| `* * *`  | course instructor      | delete student submission data                                                           | delete sensitive information once it is no longer required          |
| `* * *`  | course instructor      | view the result of plagiarism analysis                                                    | be updated on what are the potential cases of plagiarism                                      |
| `* * *`  | course instructor      | invite teaching assistants to join my course                                             | have more assistants helping me check for student plagiarism                 |
| `* * *`  | course instructor      | flag cases of student submissions for potential plagiarism                                | separate these submissions for more detailed analysis |
| `* * *`  | course instructor      | confirm cases of student submissions for plagiarism                                       | mark cases of plagiarism as closed          |
| `* * *`  | teaching assistant     | create a new account                                                                     | gain access to SSID services            |
| `* * *`  | teaching assistant     | login to my account                                                                      | gain access to SSID services                                                   |
| `* * *`  | teaching assistant     | view the result of plagiarism analysis                                                    | be updated on what are the potential cases of plagiarism                                      |
| `* * *`  | teaching assistant     | flag cases of student submissions for potential plagiarism                                | separate these submissions for more detailed analysis |
| `* *`    | new user               | go through a tutorial at the beginning                                                   | familiarise myself with how the software works and what it can do                  |


*{More to be added}*



### Non-Functional Requirements

1. Should work on any _mainstream OS_.
2. Should return the result of student submission analysis of a standard course size in a reasonable timeframe.
3. Should be secure and ensure that all sensitive information is securely stored.
8. Should be easily accessible by non-expert users.


### Glossary

| Term                | Definition                                                                                                                                |
|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| Mainstream OS       | Windows, Linux, Unix, OS-X |


---
