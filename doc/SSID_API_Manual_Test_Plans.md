This document details manual test cases used during the development of SSID API. The test cases are described using `curl` commands, but similar API clients might be used for manual testing such as Postman or HTTP libraries of different languages/ frameworks. For more details, you may trace back to PRs in which those features were developed.


## POST `/api/v1/courses/{course_id}/assignment`
This route is for creating a new assignment for SSID to process.

#### 1. Successful, should return {"assignmentID": 1168}

```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F title=assignment1 \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip
```

#### 2. {"error": "Value of {parameterName} is not valid. {state the constraint/ limit}"

```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F title=assignment2 \
 -F language=cpp17 \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip
```
Here, `cpp17` is an invalid value (but `cpp` is an allowed parameter).


#### 3. {"error" : "Missing required parameter {parameterName}"}
```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip
```
Here, `title` parameter which is required is missing.



#### 4. {"error" : "Parameter {parameterName} is invalid or not yet supported."}
```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F title=assignment4 \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip \
 -F sensitivity=100
```

Here, `sensitivity` is an invalid parameter not supported by SSID.


#### 5. {"error" : "Missing or invalid API key."}
```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: EVIL_API_KEY" \
 -F title=assignment5 \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip
```

#### 6. Successful with csv mapping, should return {"assignmentID": 1168}, csv mapping working
```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/2008/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F title=assignment6 \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip \
 -F mappingFile=@csv_mapping.csv 
```

#### 7. Successful with past semesters as references, should return {"assignmentID": 1168}, references are correctly processed
```
curl -i \
 -X POST "http://localhost:3000/api/v1/courses/3471/assignments/" \
 -H "X-API-KEY: SSID_API_KEY" \
 -F title=assignment1 \
 -F language=java \
 -F sizeOfNGram=5 \
 -F studentSubmissions=@cs1101_a1.zip \
 -F references=@references.zip
```

## GET `/api/v1/assignments/{assignment_id}/submission_similarities/`
This route is for getting all submission similarities of an assignment.

```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/" \
 -H "X-API-KEY: SSID_API_KEY"
```
#### 1. Successful
```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/" \
 -H "X-API-KEY: SSID_API_KEY"
```
#### 2. {"error":"Missing or invalid API key."}                          
```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/1540892" \
 -H "X-API-KEY: EVIL_API_KEY"
```

#### 3. With threshold
```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities?threshold=95" \
 -H "X-API-KEY: SSID_API_KEY"
```

#### 4. With limit
```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities?limit=5" \
 -H "X-API-KEY: SSID_API_KEY"
```

#### 5. With page
```
curl -i \
 -X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities?page=2" \
 -H "X-API-KEY: SSID_API_KEY"
```

## GET `/api/v1/assignments/{assignment_id}/submission_similarities/{submission_similarities_id}`

This route is for getting details of a pair of flagged submissions.

#### 1. Successful
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/1549986" \
-H "X-API-KEY: SSID_API_KEY"
```

#### 2. {"error":"Submission similarities requested do not exist."}
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/9999999" \
-H "X-API-KEY: SSID_API_KEY"
```

#### 3. {"error":"Missing or invalid API key."}
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/1549986" \
-H "X-API-KEY: EVIL_API_KEY"
```

## GET `/api/v1/assignments/{assignment_id}/submission_similarities/{submission_similarity_id}/view_pdf`
This route is for getting a minimalist PDF report for a pair of flagged student submissions.

#### 1. Successful PDF Generation
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/1549986/view_pdf" \
-H "X-API-KEY: SSID_API_KEY"
```

#### 2. {"error":"Submission similarities requested do not exist."}
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/9999999/view_pdf" \
-H "X-API-KEY: SSID_API_KEY"
```

#### 3. {"error":"Missing or invalid API key."}
```
curl -i \
-X GET "http://localhost:3000/api/v1/assignments/3018/submission_similarities/1549986/view_pdf" \
-H "X-API-KEY: EVIL_API_KEY"
```
