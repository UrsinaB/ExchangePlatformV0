![](RackMultipart20230702-1-ghnpa5_html_6c26281631587fbe.jpg)

**Project**  **Website**

Ursina Berther and Sherdel Käppler

FHNW University of Applied Sciences and Arts Northwestern Switzerland

S.23 IT Project

Devid Montecchiari, Charuta Pande

June 25, 2023


# 1 Analysis

## 1.1 Scenario Ideation

A user wants to trade items with others via the internet. She requires that the website allows her to register, add items, comment on items, and create transactions.

We have created the Exchange Service as a digital marketplace for the tradeof goods. To offer items for trade, a user must add a new item to the exchange platform. Goods can be exchanged immediately after completingregistration.

## 1.2 Use Case Analysis

A requirements analysis was conducted to determine the goals of the website. To do so, we first brainstormed ideas for how a user may interact with the site based on our own prior experiences with web shops. Next, we analysed competitor websites, such as the Swiss e-commerce websites galaxus.ch and Ricardo.ch, forrealistic design and functionality ideas. We used the gathered information to create various user stories, which we later developed into a stakeholder analysis.

After considering constraints to the project, such as the project's requirements as well as the time and technical skills needed to bring our ideas into fruition, we conducted a feasibility analysis, and determined that our project was both technically feasible and realistic with our project's deadline.

Our requirements analysis concluded in the development of Use Cases which are shown in section 1.3 User Story Writing, 1.4 Acceptance Criteria, 1.5 Stakeholder Analysis, and 1.6 Requirements.

## 1.3 User Stories

### 1.3.1 Client/User (Module Suggestions)

1. As a user, I want to have a Web app so that I can use it on different mobile devices and on desktop computers.
2. As a user, I want to see a consistent visual appearance so that I can navigate easily, and it looks consistent.
3. As a user, I want to use list views so that I can view all data available on the site.
4. As a user, I want to create an account so that I can get access to the Exchange Service.
5. As a user, I want to edit my profile so that my data is up to date.

### 1.3.2 Client/User (Our Suggestions)

6. As a user, I want to receive/send messages, so that I can communicate with others on the site.
7. As a user, I want to add items for exchange, so that my goods are available for other users to see.
8. As a user, I want to edit the items I have posted for exchange, so that the current condition of my goods are available for other users to see.
9. As a user, I want to view items for exchange, so that I can see what is available on the site.
10. As a user, I want to search for items that are available for exchange, so that I can see what is available on the site based on my own criteria.
11. As a user, I want to exchange my old items for other items that are available for exchange, so that I can complete a transaction.

### 1.3.3 Website Administrator

12. As a Website Administrator, I want to have full stack development authorization access so that I can develop and maintain the website, and database.

## 1.4 Acceptance Criteria

### 1.4.1 Scenario-Oriented (the Given/When/Then template)

| User Story | As a user, I want to register and log-in so that I can join the website |
| --- | --- |
| Use Case ID | UC 101 Register |
| Scenario | Create a profile by registering a username and email |
| Given   | The user navigates to the log-in page |
| When | The user selects \<Register\> option |
| And | The user enters registration data: username, email and email (2nd entry) |
| And | The user selects \<submit\> button |
| Then | The system creates an entry in the clients table of the database by inserting the form inputs, name and email |
| Then | The system re-directs the user to the log-in page |
| When  | The user selects \<log-in\> option |
| And | The user enters login data: username and email   |

_Table 1. Given/When/Then Acceptance Criteria_

  1. **Stakeholder Analysis**

| Stakeholder | Administrator | Member |
| --- | --- | --- |
| Position | Website Administrator | Member who uses the site |
| Role | User, developer and maintainer of website, server, and database | User, who add/trades items and views items for exchange |
| Goals | Efficient process with few data input redundancies, and a centralized software solution | User-friendly graphical user interface (GUI) and positive user experience (UX) |
| Knowledge | Full stack developer | Previous experience using websites |
| Importance | - Develops software and implement user's requirements | Uses website to make exchanges |
| - Has access to all website pages |
| Influence | High | High |
| Motivation | High; wants to meet the owner's requirements | High; Wants an easy to use and fun website |

_Table 2. Stakeholder Analysis_

## 1.6 Requirements

### 1.6.1 Overview of Functional Requirements Register

| UC | Requirement | Description |
| --- | --- | --- |
| 100 | Client/User | A user who interacts with the website |
| 200 | Admin | A user who maintains the website |
| 300 | Website | The Exchange website |
| 400 | UI/UX | The visual components of the User Interface (UI) and User Experience (UX) of the Exchange website |
| 500 | Backend | The business logic and database of the Exchange Service |

_Table 3. Overview Of Functional Requirements Register_

#### 1.6.1.1 100 Client/User

| UC | Requirement | Description |
| --- | --- | --- |
| 101 | Add Client/Register | Enables a user to create a profile by registering a username and email |
| 102 | Login | Enables a user to login to the website |
| 103 | Add item | Enables a user to add an item to the website |
| 104 | Add comment | Enables a user to add a comment to the website |
| 105 | Add transaction | Enables a user to add a transaction to the website |
| 106 | View client | Enables a user to view clients on the website |
| 107 | View comment | Enables a user to view comments on the website |
| 108 | View transaction | Enables a user to view transactions on the website |
| 109 | View item | Enables a user to view items on the website |

_Table 4. Use Case 100 Client/User_

#### 1.6.1.2 200 Admin Requirements

| UC | Requirement | Description |
| --- | --- | --- |
| 201 | Delete clients | Enables an admin to delete clients on the website |
| 202 | Delete items | Enables an admin to delete items on the website |
| 203 | Delete comments | Enables an admin to delete comment son the website |
| 204 | Delete transactions | Enables an admin to delete transactions on the website |

_Table 5. Use Case 200 Admin Requirements_

#### 1.6.1.3 300 Website Page Requirements

| UC | Requirement | Description |
| --- | --- | --- |
| 301 | Landing | The first page viewed when entering the website |
| 302 | Login | Enables a user to enter a user name and email |
| 303 | Add Client/Register | Enables a user to register a username and email |
| 304 | User Profile | Enables a user to input item data, send/receive messages and view their items' status |
| 305 | Exchange | Enables a user to search and view items |
| 306 | Admin | Enables the admin to delete all use cases |
| 307 | Add item | Enables a user to add an item to the website |
| 308 | Add comment | Enables a user to add a comment to the website |
| 309 | Add transaction | Enables a user to add a transaction to the website |

_Table 6. Use Case 300 Website Requirements_

#### 1.6.1.4 400 UI/UX Requirements

| UC | Requirement | Description |
| --- | --- | --- |
| 401 | Image | Image is always displayed on the left side of the page except on the landing page |
| 402 | Page Links | Links to the next useful page are displayed near the submission buttons |
| 403 | Error Dialog | Error warning such as, "Are you sure you want to delete this item." are shown to assist the user |

_Table 7. Use Case 400 UI/UX Requirements_

#### 1.6.1.5 500 Server Requirements

| UC | Requirement | Description |
| --- | --- | --- |
| 501 | Github Repository | User installation instructions:
https://github.com/UrsinaB/ExchangePlatformV0 |

_Table 8. 500 Server Requirements_

### 1.6.2 Overview of Non-Functional Requirements Register

| UC | Requirement | Description |
| --- | --- | --- |
| 600 | Availability | The website is only available locally after running the server |
| 700 | Capacity | The website can handle multiple users at a time |

_Table 9. Overview Of Non-Functional Requirements Register_

# 2 Domain Design:

## 2.1 Package 100 - Client/User Use Cases

### 2.1. 1UC 101 Add Client/ Register

| Use Case ID  | UC 101 Add Client/Register |
| --- | --- |
| Description  | The website enables a user to create a profile by registering a username and email |
| --- | --- |
| Responsible Actor   | User  |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to exchange an item   |
| --- | --- |
| Preconditions  | -  |
| --- | --- |
| Input   | Login data: name, firstName, lastName,email |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User clicks "Register" button  | 1.a User clicks "Login" button   |
| --- | --- |
| 1.b User leaves the website |
| 2. User enters required data | 2.a User leaves the website |
| --- | --- |
| - username |
| - email |
| - email (2nd entry) |
| 3. User clicks "Submit" button  | 3.a Registration fails, User is prompted to re-enter email |
| --- | --- |
| 3.b User leaves the website  |
| Results  | User is registered in the database |
| --- | --- |
| Postconditions  | User is re-directed to the login page |
| --- | --- |

_Table 10. UC 101 Add Client/ Register_

### 2.1.2 UC 102 Login

| Use Case ID  | UC 102 Login |
| --- | --- |
| Description  | The website enables a user to log in to the website |
| --- | --- |
| Responsible Actor   | User  |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to make an exchange or view their profile |
| --- | --- |
| Preconditions  | The User is registered and exists in the database |
| --- | --- |
| Input   | Login data: username, email |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User clicks "Login" button  | 1.a User leaves the website |
| --- | --- |
| 2. User enters required data |   |
| --- | --- |
| - username |
| - User leaves the website |
| 3. User clicks "Submit" button  | 3.a User leaves the website  |
| --- | --- |
| Results  | User is re-directed to their profile page |
| Postconditions  |
 |
| --- | --- |

_Table 11. UC 102 Login_

### 2.1.3 UC 103 Add Item

| Use Case ID  | UC 103Add an Item |
| --- | --- |
| Description  | The website enables a user to add an Item |
| --- | --- |
| Responsible Actor   | User |
| --- | --- |
| ParticipatingActor  | - |
| --- | --- |
| Trigger  | The User wants to add an Item |
| --- | --- |
| Preconditions  | The User isregistered with the website |
| --- | --- |
| Input   | Item data: clientId, itemTitle, itemDescription, itemStatus, itemCategory |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User clicks "Add Item" button  | 1.a User leaves the website |
| 2. User adds an item From the dropdown menus a user selects:- client, status, category- inputs: Title, Description |
| 3. User clicks "Submit" button  | 3.a User leaves the website  |
| --- | --- | --- |
| Results  | User add an item |
| Postconditions  | The item is successfully added to the database  |
| --- | --- |
| The User is re-directed to the View All Items page |
| --- |

_Table 12__. UC 103 Add item_

### 2.1.4 UC 104 Add Comment

| Use Case ID  | UC 104 Add an comment |
| --- | --- |
| Description  | The website enables a user to add a comment |
| --- | --- |
| Responsible Actor   | User |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to add a comment |
| --- | --- |
| Preconditions  | The User isregistered with the website |
| --- | --- |
| Aitem exists within the database |
| Input   | Comment data: clientId, itemId, text |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User clicks "Add comment" button  | 1.a User leaves the website |
| 2. User adds a comment From the dropdown menus a user selects: - client, item- inputs: text |
| 3. User clicks "Submit" button  | 3.a User leaves the website  |
| Results  | User add a comment |
| --- | --- |
| Postconditions  | The comment is successfully added to the database  |
| --- | --- |
| The User is re-directed to the View All Comments page |
| --- |

_Table 13__. UC 104 Add Comment_

### 2.1.5 UC 105 Add Transaction

| Use Case ID  | UC 105 Exchange Item |
| --- | --- |
| Description  | The website enables a user to perform an exchange |
| --- | --- |
| Responsible Actor   | User (seller) |
| --- | --- |
| Participating Actor  | User (buyer) |
| --- | --- |
| Trigger  | The User wants to perform an exchange |
| --- | --- |
| Preconditions  | The Users (buyers and seller)areregistered with the website |
| --- | --- |
| Anitem exists within the database |
| Comments linked to thetradeableitem exists within the database |
| Input   | Transaction data: itemId, offeringUserId, receivingUserId, status, rating |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User clicks "Add Transaction" button  | 1.a User leaves the website |
| 2. User creates a transaction From the dropdown menus a user selects:- anitem, seller, buyer, status, rating |
 |
| 3. User clicks "Submit" button  | 3.a User leaves the website  |
| Results  | User completesan exchange |
| --- | --- |
| Postconditions  | The exchange is successfully added to the database  |
| --- | --- |
| The User is re-directed to the View All Transactions page |
| --- |

_Table 14__. UC 105 Add Transaction_

### 2.1.6 UC 106 View Clients

| Use Case ID  | UC 106 View Clients  |
| --- | --- |
| Description  | The website enables a user to view all clients |
| --- | --- |
| Responsible Actor   | User  |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to view other clients of the Exchange Service   |
| --- | --- |
| Preconditions  | The User is logged in to the website |
| --- | --- |
| Other clients exist within the database |
| --- |
| Input   |  - |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User is re-directed to the View All Clients page after clicking "View All Clients" | 1.a User leaves the website  |
| --- | --- |
| Results  | User views clients |
| Postconditions  | -  |
| --- | --- |

_Table 15__. UC 10 View Clients_

### 2.1.7 UC 107 View Comments

| Use Case ID  | UC 107 View Comments |
| --- | --- |
| Description  | The website enables a user to view all comments |
| --- | --- |
| Responsible Actor   | User  |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to view other comments of the Exchange Service   |
| --- | --- |
| Preconditions  | The User is logged in to the website |
| --- | --- |
| Other comments exist within the database |
| --- |
| Input   |  - |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User is re-directed to the View All Comments page after adding/updating an item | 1.a User leaves the website  |
| --- | --- |
| Results  | User views comments |
| Postconditions  | -  |
| --- | --- |

_Table 18. UC 107 View Comments_

### 2.1.8 UC 108 View Transactions

| Use Case ID  | UC 108 View Transactions |
| --- | --- |
| Description  | The website enables a user to view all transactions |
| --- | --- |
| Responsible Actor   | User  |
| --- | --- |
| Participating Actor  | - |
| --- | --- |
| Trigger  | The User wants to view other transactions of the Exchange Service   |
| --- | --- |
| Preconditions  | The User is logged in to the website |
| --- | --- |
| Other transactions exist within the database |
| --- |
| Input   |  - |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User is re-directed to the View All Transactions page after adding/updating a Transaction | 1.a User leaves the website  |
| --- | --- |
| Results  | User views transactions |
| Postconditions  | -  |
| --- | --- |

_Table 19. UC 108 View Transactions_

### 2.1.9 UC 109 View Items

| Use Case ID  | UC 106 View Items |
| Description  | The website enables a user to view all items |
| Responsible Actor   | User  |
| Participating Actor  | - |
| Trigger  | The User wants to view other items of the Exchange Service   |
| Preconditions  | The User is logged in to the website |
| Other items exist within the database |
| --- | --- |
| Other items exist within the database |
| --- |
| Input   |   |
| --- | --- |
| Scenario  | Main  | Alternative  |
| --- | --- | --- |
| 1. User is re-directed to the View All Items page after adding/updating an item | 1.a User leaves the website  |
| Results  | User views items |
| Postconditions  | -  |



_Table 17. UC 109 View Items_

# 3 Business Logic and API design and Implementation

## 3.1 Data access

Data for the Exchange Service is accessible on the private Github repository, [https://github.com/UrsinaB/ExchangePlatformV0](https://github.com/UrsinaB/ExchangePlatformV0). Persistent database data is located on the uploaded file, "crm.mv.db". Frontend views were created on and are hosted by Budibase.

There is no security authorization required for the frontend to access the backend. We chose to disable security functions to aid in the technical feasibility of the project's development. We do acknowledge, that without token/session access client authentication after registration is not possible.

## 3.2 Business logic layers

The business logic for the Exchange Service was created using Spring Data JPA. We created four classes: Client, Item, Comment, and Transaction. Below is a brief explanation of what information was included in each of the layers in the Spring Boot repository.

### 3.2.1 Data Layer

The data layer consists of domains and repositories for each class, along with an Enum class.

**Domain:** The database structure and variables are declared.

**Repository:** Instructions for foreign keys and database table joins.

### 3.2.2 Service Layer

The logic for how queries are to be carried out (CRUD operations) when received from the client and data access objects are stored within the service layer.

### 3.2.3 Controller

The Controller allows for the creation of endpoints for the website's views, and the processing of REST API requests. This layer also receives and sends HTTP requests and includes JSON data in the body.

## 3.3 API

When HTTP requests and responses are sent between the web browser and the webserver an API is used. REST is a widely used standard for facilitating computer-to-computer communication over the internet. REST includes guidelines for a consistent user interface, client-server communication, stateless data transmission, cacheable data, layered systems, and optional code-on-demand. RESTful APIs are those that adhere to the aforementioned standards.

# 4 Frontend implementation

## 4.1 Design

The front-end design of the Exchange Service was created on the low code website, Budibase. Our goal was to developpage views based on our users' requirements. In doing so we created an Add and view page for each of our use cases: Client, Item, Comment, Transaction. Additionally, we created landing, login, and profile pages to make the user experience feel more authentic. The admin page was created for the deletion of each use case.

The colour scheme of the Exchange Service is based on a 1980s Synthwave colour palette. We chose this fun theme to stand out from the professional pages normally made for school assignments.

Our Front end can be found with this link: https://inttech.budibase.app/app/exchangeservice

**Landing Page**

![](RackMultipart20230702-1-ghnpa5_html_1415f61998993c7e.png)

_Figure 1. Landing Page_

## 4.2 Prototyping

The structure of the website and the form fields were created directly from our UML model specifications. Inspirations for the layout and navigation came from our own experiences with developing websites in the past. To increase functionality, we had a beta tester review the site and make suggestions.

## 4.3 Realization of frontend functionality

To interface with the internet, a client is used. Front-end development is used to render web applications on the client. An interface is used to convey server requests and responses.

Resources are organized into unique sets of URIs i.e., [http://localhost:8080/clients/register](http://localhost:8080/clients/register), which allows the differentiation of the resources on a server. If a client sends an HTTP request for the endpoint "clients/register" to the server, the request is further routed to the "clients" table of the database while "/clients/comments" would go to the "comments" table of the database. Between the client and the server, the HTTP request can be written as, "POST/clients HTTP/1.1", where POST is the HTTP method for "CREATE" and "clients" is the resource to be accessed.

The body of the HTTP request could include an optional request for a custom payload of JSON-encoded data, i.e., "Accept: application/Json".

After receiving and processing the request, the server formats the result into a response, such as "HTTP/1.1 200 OK." "200 OK" is an HTTP status code; if the web browser returns a 500-level code, a request for a custom payload may be sent back to the server to retry the request.

# 5 Demonstrator

## 5.1 Integration of frontend and backend

The backend communicates data from the database to the client-side browser. It contains the server and connections to the database.

**Server:** Hosted on Github

**Database** : Used to structure collected data, stored in the programs DBI file

**Endpoints:** Locations of URI/URL resources used by APIs for accessing those resources

## 5.2 consuming REST APIs from the web service

Below is an example oftwo endpoint locations of the URI/URL resources used by our APIs (routes) for accessing resources.

| **Backend Communication Endpoints** |
 |
| --- | --- |
| **HTTP Request** | **Endpoints** | **Purpose** | **Descriptions** |
| **GET** | /api/items/all | View all clients | Returns all items from the database |
| **POST** | /api/comments/create/{itemId}/{clientId} | Add a comment | Receives requested data from the Add Comment form and creates a new entry in the comments table of the database |

_Table 20. API Endpoint Reference List_

# 6 REFLECTION

Following the rubric of the project's documentation was made easier by having prior experience in website design. Our first few deliverables as a team, such as building a business case, requirements list, and so on, received great feedback. The second stage of the project, creating a usable website structure, proved to be more difficult. First, we had to learn how to program in Java, then we had to learn how to use Github Codespaces, set up version control with a Git repository, and learn how to structure a software architecture into the Spring Boot format.

We are proud of the work that we have done but, if given more time, we would add additional features, such as the creation of session tokens that can be stored long-term in the database and allowing users to delete and modify items, comments, and transactions by ID.

We also regret that we found some aspects of Budibase to be too complicated. Unfortunately, most of the endpoints that were created were not implemented in the front end.

# 7 List of Figures

[Figure 1. Landing Page 13](#_Toc137828663)

# 8 List of Tables

[Table 1. Given/When/Then Acceptance Criteria 3](#_Toc137831689)

[_Table 2. Stakeholder Analysis_ 4](#_Toc137831690)

[Table 3. Overview Of Functional Requirements Register 4](#_Toc137831691)

[Table 4. Use Case 100 Client/User 4](#_Toc137831692)

[Table 5. Use Case 200 Admin Requirements 4](#_Toc137831693)

[Table 6. Use Case 300 Website Requirements 5](#_Toc137831694)

[Table 7. Use Case 400 UI/UX Requirements 6](#_Toc137831695)

[Table 8. 500 Server Requirements 6](#_Toc137831696)

[Table 9. Overview Of Non-Functional Requirements Register 6](#_Toc137831697)

[Table 10. UC 101 Add Client/ Register 7](#_Toc137831698)

[Table 11. UC 102 Login 7](#_Toc137831699)

[_Table 12__. UC 103 Add item_ 8](#_Toc137831700)

[_Table 13__. UC 104 Add Comment_ 8](#_Toc137831701)

[_Table 14__. UC 105 Add Transaction_ 9](#_Toc137831702)

[_Table 15__. UC 10 View Clients_ 10](#_Toc137831703)

[Table 18. UC 107 View Comments 10](#_Toc137831704)

[Table 19. UC 108 View Transactions 10](#_Toc137831705)

[Table 17. UC 109 View Items 11](#_Toc137831706)

[Table 20. API Endpoint Reference List 14](#_Toc137831707)

# 9 References

Moormann, J., & Palvölgyi, E. Z. (2013). Customer centric business modelling: setting a research agenda. 2013 IEEE 15th Conference on Business Informatics (pp. 173-179). IEEE.

n.d. (n.d.). How to Write a Reflection Paper - Academic Skills. Retrieved 7 2022, from Trent University: https://www.trentu.ca/academicskills/howguides/how-write-university/how-approachany-assignment/how-write-reflection-paper
