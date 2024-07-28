# EI_CODING

## 1. Design Patterns
   
## i) Behavioral Design Patterns

Use Case: Observer Pattern 
* Scenario: Live Cricket Match Commentary System
* Description:
Implement a live cricket match commentary system where multiple clients (observers) subscribe to updates on match commentaries. Whenever the commentary updates, the system notifies all subscribed clients.
![image](https://github.com/user-attachments/assets/9a2a00b7-ffd3-4798-877e-57589c483ebb)


Use Case: Visitor Pattern
* Scenario: Online Shopping Cart Pricing
* Description:
Implement a system where different items (books, fruits) in a shopping cart are visited by a pricing visitor to calculate the total cost. This allows the pricing logic to be easily extended for new item types without modifying existing item classes.
![image](https://github.com/user-attachments/assets/09b0bfb2-ebe6-424c-b1cd-b0842de65a1b)


## ii) Creational Pattern
Use Case: Factory Pattern
* Scenario: Cricket Academy Player Creation
* Description:
Create a system where different types of cricket players (Batsman, Bowler, AllRounder) are created using factory classes, allowing easy extension without modifying existing creation logic.
![image](https://github.com/user-attachments/assets/48342154-2bbc-450d-a9b2-b6ddde22727a)

Use Case: Singleton Pattern
* Scenario: Food Delivery System 
* Description:
Create a system where a single instance of the order management system manages food delivery orders, ensuring centralized control and preventing multiple instances.
![image](https://github.com/user-attachments/assets/00b71fd9-1b4e-4d62-9f85-f727ab55e846)


## iii) Structural Pattern
Use Case: Adapter Pattern
* Scenario: Database Connection Adapter
* Description:
Create a system where a new application needs to interact with different types of databases (e.g., MySQL, MongoDB). Each database has its own connection and query interface, but the application expects a uniform interface to interact with these databases.
![image](https://github.com/user-attachments/assets/e30b5ad1-ab27-4fb2-b2ed-db9cb8da5f2c)

Use Case: Decorator Pattern
* Scenario: Coffee Shop Beverage Customization
* Description:
Create a system where different types of coffee drinks can be customized with various add-ons (like Milk, Sugar, Whipped Cream) using decorators. This allows for dynamically adding new features to the coffee without altering the existing code structure.
![image](https://github.com/user-attachments/assets/c29faf2d-7d54-472e-89da-9640ff96f4fd)



## 2. Mini-project
*Scenario: Virtual Classroom Manager
*Description:
The Virtual Classroom Manager is an application designed to help educators manage their classrooms, students, and assignments efficiently. 
It allows educators to perform tasks such as adding classrooms, adding students with their IDs and names to specific classrooms, scheduling assignments, submitting assignments, listing students in a classroom, and fetching student details by ID. 
The application employs various design patterns to ensure it is scalable, maintainable, and robust, with comprehensive logging of all actions and errors.

* The application is launched, and the main menu is displayed to the user.
![image](https://github.com/user-attachments/assets/3b55b504-5649-4977-aad4-cb4efb50c4f8)

* Adding a Classroom:
![image](https://github.com/user-attachments/assets/8702b53f-bc0d-40ca-8414-72c88a7d4c3f)

* Adding Students to a Classroom:
![image](https://github.com/user-attachments/assets/0b0b653b-ddd9-4d21-8d4f-d7c5e3ec6597)

* Scheduling an Assignment:
![image](https://github.com/user-attachments/assets/6c3065c4-0164-4660-aef5-4f128adb5072)

* Submitting an Assignment:
![image](https://github.com/user-attachments/assets/ea1daf07-5563-42fd-b00a-2e247fd26f02)

* Listing Students in a Classroom:
![image](https://github.com/user-attachments/assets/ed91d18e-5dbb-4e98-bf5b-113a470e4860)

* Listing Classrooms and removal of classroom:
![image](https://github.com/user-attachments/assets/a4a227b6-00e3-41f3-a112-b943c962e060)












