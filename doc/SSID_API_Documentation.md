---
layout: page
title: SSID API
---

# SSID API

## Table of Contents

- [Introduction](#introduction)
- [Authentication](#authentication)
- [Functionality](#functionality)
    - [Create an assignment](#1-create-an-assignment)
    - [View pairwise submissions comparison results](#2-view-pairwise-submissions-comparison-results)
    - [View details of flagged pairwise submissions comparison results](#3-view-details-of-flagged-pairwise-submissions-comparison-results)

## Introduction

SSID API allows you to programmatically use a subset of SSID's functionalities. With SSID API, you can create assignments and submit assignment files programmatically, retrieve plagiarism detection results in machine-readable format, and integrate SSID into your applications. This document describes the usage of SSID API.

## Authentication

- **Creating API keys**: Please contact SSID team to get your developer API key.
- **Adding API key to your request**: You must include your API key with every request in the parameter `X-API-KEY` in your request header.

## Functionality

### 1. Create an assignment

**URL**: `/api/v1/courses/{course_id}/assignment/`

**Method**: `POST`

**Authentication required**: YES

**Description**: Creates a new assignment for SSID to process. The web equivalence is going to `/courses/{course_id}/assignments/new` and creating a new assignment.

The content type of the request should be `multipart/form-data`. Each parameter is a form part, with the parameter name specified in the `name` attribute in `Content-Disposition` header. In the body, any boundary delimiter for different parts to be sent is acceptable.

**JSON Parameters**:

- `title (Required) string`: The title of the assignment.
- `language (Required) string`: Programming language of submission files. Currently supported: `"java", "python3", "c", "cpp", "javascript", "r", "ocaml", "matlab", "scala"`. The parameter value must be in lowercase and match exactly one of the options.
- `useFingerprints (Optional) boolean`: If `true`, enable the optimization of preprocessing batch of submissions using winnowing fingerprinting algorithm before pairwise comparisons. If not specified, defaults to `false`.
- `minimumMatchLength (Optional) number`: The least number of contiguous identical statements required to flag a match. If not specified, defaults to 2.
- `sizeOfNGram (Optional) number`: Specifies size of n-gram to be used in SSID. An n-gram is a contiguous subsequence of n tokens of a given sequence. If not specified, defaults to 5.
- `discardAfter (Optional) number`: If specified, discard files after such duration in seconds. **[Note: Currently SSID stores all data persistently and data is manually cleared every semester. This parameter accommodates the future auto-discard functionality. This function is not yet available in both web interface and API, so we need to first build it for SSID, then allow it to be used via API]**.
- `studentSubmissions (Required) zip`: zip file of student submissions in SSID’s standard format. **[Note: The zip file should be in SSID's standard format (potentially includes skeleton codes). For more details, please refer to SSID's User's Guide. Removed file size limit as there might be users with bigger file sizes.]**.
- `mappingFile (Optional) csv`: csv map file that allows you to map between a directory name (in the uploaded zip file) and the student roster that you might be using for your modules. For more details, see SSID's User Guide.
- `references zip`: zip file of student submissions from past semesters to be used as reference. The uploaded reference zip file should contain a number of folders each for a past semester. Each of those folders contains student submissions in SSID's stardard format. Skeleton code of current semester will be used if supplied; skeleton code in past semesters' folders, if supplied, will be ignored. Students from past semesters will appear as `references_{semester name}_{student name}` in flagged matches. This function is not yet available in the web interface.

Example of structure of student submissions zip file whereby each `AXXXXXX` denote the ID of a student:
```
.
├── A013601
│   ├── CitiesDriver.java
│   └── MyTree.java
├── A136682
│   ├── CitiesDriver.java
│   └── MyTree.java
├── A374086
│   ├── CitiesDriver.java
│   └── MyTree.java
├── A791459
│   ├── CitiesDriver.java
│   └── MyTree.java
└── A902453
    ├── CitiesDriver.java
    └── MyTree.java
```


Example of structure of references zip file whereby each `AXXXXXX` denote the ID of a student and `fall_1920` and `spring_1920` are two past semesters to check against:

```
.
├── fall_1920
│   ├── A125972
│   │   ├── CitiesDriver.java
│   │   └── MyTree.java
│   ├── A268671
│   │   ├── CitiesDriver.java
│   │   └── MyTree.java
│   ├── A403618
│   │   ├── CitiesDriver.java
│   │   └── MyTree.java
│   ├── A819987
│   │   ├── CitiesDriver.java
│   │   └── MyTree.java
│   └── A940578
│       ├── CitiesDriver.java
│       └── MyTree.java
└── spring_1920
    ├── A115539
    │   ├── CitiesDriver.java
    │   └── MyTree.java
    ├── A420529
    │   ├── CitiesDriver.java
    │   └── MyTree.java
    ├── A495754
    │   ├── CitiesDriver.java
    │   └── MyTree.java
    ├── A559473
    │   ├── CitiesDriver.java
    │   └── MyTree.java
    └── A703457
        ├── CitiesDriver.java
        └── MyTree.java

```

**Request Example**:
| Header |
| --- |

```
{
  "Content-Type": "multipart/form-data; 
  \"boundary=------------------------a41c8131a72f1dad\"",
  "X-Api-Key": "YOUR_API_KEY"
}
```

| Body |
| ---- |

```
--------------------------a41c8131a72f1dad
Content-Disposition: form-data; name="title"

assignment1
--------------------------a41c8131a72f1dad
Content-Disposition: form-data; name="language"

java
--------------------------a41c8131a72f1dad
Content-Disposition: form-data; name="sizeOfNGram"

5
--------------------------a41c8131a72f1dad
Content-Disposition: form-data; name="studentSubmissions"; filename="dir.zip"
Content-Type: application/octet-stream

<file content>
--------------------------a41c8131a72f1dad–
```

**Possible responses**:

| Code | Status              | Return body                                                                                                                                                                                                                        |
| ---- | ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 200  | Successful          | `{ "assignmentID": 1168 }`                                                                                                                                                                                                         |
| 400  | Error               | `{ "error": "Value of {parameterName} is not valid. {state the constraint/ limit}" }`, `{ "error": "Missing required parameter {parameterName}" }`, or `{ "error": "Parameter {parameterName} is invalid or not yet supported." }` |
| 401  | Unauthorized        | `{ "error": "Missing or invalid API key." }` or `{ "error": "Your API key is not authorized to access this resource." }`                                                                                                           |
| 503  | Service Unavailable | `{ "error": "SSID is busy or under maintenance. Please try again later." }`                                                                                                                                                        |

---

### 2. View pairwise submissions comparison results

**URL**: `/api/v1/assignments/{assignment_id}/submission_similarities/`

***With threshold***: `/api/v1/assignments/{assignment_id}/submission_similarities?threshold={threshold value}`. For example, `/api/v1/assignments/{assignment_id}/submission_similarities?threshold=95` returns all submission similarities whose similarity is greater than or equal to 95%.

***With limit***: `/api/v1/assignments/{assignment_id}/submission_similarities?limit={limit count}`. For example, `/api/v1/assignments/{assignment_id}/submission_similarities?limit=5` returns 5 submission similarities.

**Method**: `GET`

**Authentication required**: YES

**Description**: Returns all submission similarities of an assignment. The web equivalence is going to `/assignments/{assignment_id}/submission_similarities/`.

**JSON Parameters**:


- `threshold (Optional) number`: A number between 0 and 100. If specified, returns only submission similarities whose similarity percentage is between `threshold` and 100 inclusive. Otherwise, returns all submission similarities **[Note: Currently SSID stores and displays all submission similarities on its web interface. The function to display only submission similarities whose similarity percentage is greater than or equal to `threshold` is not yet available in the web interface so we need to build it for SSID]**.
- `limit (Optional) number`: If specified, returns such number of submission similarities with highest maximum similarity percentage. Otherwise, returns all submission similarities. **[Note: Currently SSID stores and displays all submission similarities on its web interface. The function to take top N submissions is not yet available in the web interface so we need to build it for SSID]**.

**Request Example**:
| Header |
| --- |

```
{
  "Content-Type": "application/json",
  "X-Api-Key": "YOUR_API_KEY"
}
```

| Body |
| ---- |

```
<empty>
```

**Possible responses**:

| Code | Status              | Return body                                                                                                                                                                                                                                                                                                                                                                                            |
| ---- | ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 200  | Successful          | `{ "status": "empty" }` **[Note: This status, currently in SSID's web interface, is for when the user did not include a zip file when creating an assignment. To rectify this, the user must upload the file via the web interface. When submitting through API, the zip assignment file is compulsory.]**, `{ "status": "processing" }`, or `{ "status": "processed", "submissionSimilarities": [] }` |
| 400  | Error               | `{ “error”: “Submission similarities requested does not exist." }`, `{ “error”: “Assignment does not exist" }`                                                                                                                                                                                                                                                                                                                                    |
| 401  | Unauthorized        | `{ "error": "Missing or invalid API key." }` or `{ "error": "Your API key is not authorized to access this resource." }`                                                                                                                                                                                                                                                                               |
| 503  | Service Unavailable | `{ "error": "SSID is busy or under maintenance. Please try again later." }`                                                                                                                                                                                                                                                                                                                            |

---

### 3. View details of flagged pairwise submissions comparison results

**URL**: `/api/v1/assignments/{assignment_id}/submission_similarities/{submission_similarities_id}`

**Method**: `GET`

**Authentication required**: YES

**Description**: Returns details of a pair of a flagged submissions. Please use SSID's web interface to view and mark students as suspicious or guilty. The web equivalence is going to `/assignments/{assignment_id}/submission_similarities/{submission_similarity_id}`.

**JSON Parameters**:

- **No param**. Pass in the desired assignment id and submission similarity id in the URL.

**Request Example**:
| Header |
| --- |

```
{
  "Content-Type": "application/json",
  "X-Api-Key": "YOUR_API_KEY"
}
```

| Body |
| ---- |

```
<empty>
```

**Possible responses**:

| Code | Status              | Return body                                                                                                              |
| ---- | ------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| 200  | Successful          | `{ "similarity": ..., "matches": [], "pdf_link": ... }` **[Note: similarity is between 0 and 100]**                 |
| 400  | Error               | `{ “error”: “Submission similarities requested does not exist." }`                                                       |
| 401  | Unauthorized        | `{ "error": "Missing or invalid API key." }` or `{ "error": "Your API key is not authorized to access this resource." }` |
| 503  | Service Unavailable | `{ "error": "SSID is busy or under maintenance. Please try again later." }`                                              |

---

### 4. View PDF report of flagged pairwise submissions comparison results

**URL**: `/api/v1/assignments/{assignment_id}/submission_similarities/{submission_similarities_id}/view_pdf`

**Method**: `GET`

**Authentication required**: YES

**Description**: Returns details of a pair of a flagged submissions in PDF. Please use SSID's web interface to view and mark students as suspicious or guilty. The web equivalence is going to `/assignments/{assignment_id}/submission_similarities/{submission_similarity_id}`.

**JSON Parameters**:

- **No param**. Pass in the desired assignment id and submission similarity id in the URL.

**Request Example**:
| Header |
| --- |

```
{
  "Content-Type": "application/json",
  "X-Api-Key": "YOUR_API_KEY"
}
```

| Body |
| ---- |

```
<empty>
```

**Possible responses**:

| Code | Status              | Return body                                                                                                              |
| ---- | ------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| 200  | Successful          | The generated PDF Report **[Note: similarity is between 0 and 100]**                 |
| 400  | Error               | `{ “error”: “Submission similarities requested does not exist." }`                                                       |
| 401  | Unauthorized        | `{ "error": "Missing or invalid API key." }` or `{ "error": "Your API key is not authorized to access this resource." }` |
| 503  | Service Unavailable | `{ "error": "SSID is busy or under maintenance. Please try again later." }`                                              |

---